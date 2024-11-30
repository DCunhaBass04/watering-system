package utils;

import domain.*;
import domain.graph.Graph;
import domain.graph.map.MapGraph;
import domain.graph.matrix.MatrixGraph;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

public final class FileAnalyzer {

    /**
     * Método feito para ler o ficheiro USLP02.txt ou semelhantes, retornando o plano de rega com as várias regas lidas
     * @param filePath caminho até o ficheiro a ser lido, dado pelo utilizador
     * @param dia dia inicial do plano
     * @return plano de rega
     * @throws FileNotFoundException erro dado se o ficheiro inserido pelo utilizador não for encontrado
     */
    public static PlanoDeRega criarPlanoRega(File filePath, LocalDate dia) throws FileNotFoundException {
        Scanner fileReader = new Scanner(filePath);
        String line = fileReader.nextLine();
        String[] itemsPerLine = line.split(", ");
        List<LocalTime> times = new ArrayList<>();
        for(String item : itemsPerLine) {
            times.add(Utils.createLocalTime(item));
        }
        List<Rega> regas = new ArrayList<>();
        while(fileReader.hasNext()){
            line = fileReader.nextLine();
            itemsPerLine = line.split(",");
            try{
                createFertirregas(new Setor(itemsPerLine[0]), Integer.parseInt(itemsPerLine[1]), itemsPerLine[2].charAt(0), regas, dia, times, Integer.parseInt(itemsPerLine[4]), itemsPerLine[3]);
            } catch (ArrayIndexOutOfBoundsException e){
                createRegas(new Setor(itemsPerLine[0]), Integer.parseInt(itemsPerLine[1]), itemsPerLine[2].charAt(0), regas, times, dia);
            }
        }
        regas.sort(null);
        return new PlanoDeRega(dia, dia.plusDays(30), regas);
    }

    /**
     * Este método cria todas as regas para cada linha do ficheiro original
     * @param setor sector que vai ser regada nas regas criadas
     * @param duration duração de todas essas regas
     * @param regularity 'T' para todos os dias, 'P' para dias pares, 'I' para dias ímpares, '3' para ser de 3 em 3 dias
     * @param regas a lista de regas
     * @param times a lista de tempos em que cada dia vai ter uma sequência de regas
     * @param dia dia inicial do plano
     */
    private static void createRegas(Setor setor, int duration, char regularity, List<Rega> regas, List<LocalTime> times, LocalDate dia){
        int i = 0;
        while(i < 30){
            LocalDate novoDia = dia.plusDays(i);
            if(verSeRegaEstaAtiva(novoDia, regularity, dia)) {
                int minsToAdd = getTotalTimeOnADay(regas, novoDia, times.size());
                for (LocalTime time : times)
                    regas.add(new Rega(novoDia, setor, duration, time.plusMinutes(minsToAdd)));
            }
            i++;
        }
    }
    private static void createFertirregas(Setor setor, int duration, char regularity, List<Rega> regas, LocalDate dia, List<LocalTime> times, int dayInterval, String receita){
        int i = 0;
        while(i < 30){
            LocalDate novoDia = dia.plusDays(i);
            if(verSeRegaEstaAtiva(novoDia, regularity, dia)) {
                int minsToAdd = getTotalTimeOnADay(regas, novoDia, times.size());
                if (i % dayInterval == 0) {
                    for (LocalTime time : times)
                        regas.add(new Rega(novoDia, setor, duration, time.plusMinutes(minsToAdd), receita));
                } else
                    for (LocalTime time : times)
                        regas.add(new Rega(novoDia, setor, duration, time.plusMinutes(minsToAdd)));
            }
            i++;
        }
    }

    /**
     * Este método verifica se uma determinada rega está ativa num dado momento
     * @param dateProcurada data em que queremos ver se há uma rega ativa
     * @param regularity regularidade da rega dada, 'T' é todos os dias, 'P' é só dias pares, 'I' é só dias ímpares e '3' é de 3 em 3 dias
     * @param dateInicial primeiro dia do plano de rega
     * @return verdadeiro se tiver ativa, falsa se não
     */
    private static boolean verSeRegaEstaAtiva(LocalDate dateProcurada, char regularity, LocalDate dateInicial){
        switch (regularity) {
            case 'T' -> { return true; }
            case 'P' -> {
                if (dateProcurada.getDayOfMonth() % 2 == 0)
                    return true;
            }
            case 'I' -> {
                if (dateProcurada.getDayOfMonth() % 2 != 0)
                    return true;
            }
            case '3' -> {
                if((int) DAYS.between(dateProcurada, dateInicial) % 3 == 0)
                    return true;
            }
        }
        return false;
    }

    /**
     * Este método verifica o tempo total em regas anteriores num determinado dia
     * @param regas lista de regas
     * @param dia dia que queremos o tempo total
     * @param noOfTimes nº de regas por dia
     * @return tempo total ocupado pelas regas naquele dia
     */
    private static int getTotalTimeOnADay(List<Rega> regas, LocalDate dia, int noOfTimes){
        int sum = 0;
        if(!regas.isEmpty()){
            for(Rega rega : regas)
                if(rega.getDia().equals(dia))
                    sum += rega.getDuration();
        }
        return sum/noOfTimes;
    }

    public static List<Rega> consumirPlanoDeRega(String nomeFicheiro) throws FileNotFoundException {
        List<Rega> regas = new ArrayList<>();
        File planoDeRega = new File(nomeFicheiro);
        Scanner lerPlano = new Scanner(planoDeRega);
        lerPlano.nextLine();
        while (lerPlano.hasNext()) {
            String[] currentLine = lerPlano.nextLine().split(";");
            LocalDate diaRega = LocalDate.parse(currentLine[0], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Setor setorRega = new Setor(currentLine[1]);
            LocalTime inicio = LocalTime.parse(currentLine[3], DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime fim = LocalTime.parse(currentLine[4], DateTimeFormatter.ofPattern("HH:mm"));
            int duracaoRega = Integer.parseInt(currentLine[2]);
            Rega rega = new Rega(diaRega, setorRega, inicio, fim, duracaoRega);
            regas.add(rega);
        }
        return regas;
    }

    /**
     * Método que cria um Matrix Graph a partir da leitura de dois ficheiros
     * @param localidadesPath ficheiro com os locais
     * @param distanciasPath ficheiro com as distâncias entre locais
     * @return Matrix Graph preenchido com os locais (vértices) e distâncias (edges)
     * @throws FileNotFoundException caso haja algum erro a ler um dos ficheiros
     */
    public static MatrixGraph<Localidade, Integer> createMatrixGraph(File localidadesPath, File distanciasPath) throws FileNotFoundException{
        MatrixGraph<Localidade, Integer> graph = new MatrixGraph<>(false);
        List<Localidade> localidades = readLocalidades(localidadesPath);
        for(Localidade localidade : localidades)
            graph.addVertex(localidade);
        Scanner fileReader = new Scanner(distanciasPath);
        fileReader.nextLine(); //ignore Header
        while(fileReader.hasNext()){
            String[] itemsPerLine = fileReader.nextLine().split(",");
            graph.addEdge(Utils.getLocalidadeById(itemsPerLine[0], localidades), Utils.getLocalidadeById(itemsPerLine[1], localidades), Integer.parseInt(itemsPerLine[2]));
        }
        return graph;
    }

    /**
     * Método que cria um Map Graph a partir da leitura de dois ficheiros
     * @param localidadesPath ficheiro com os locais
     * @param distanciasPath ficheiro com as distâncias entre locais
     * @return Map Graph preenchido com os locais (vértices) e distâncias (edges)
     * @throws FileNotFoundException caso haja algum erro a ler um dos ficheiros
     */
    public static MapGraph<Localidade, Integer> createMapGraph(File localidadesPath, File distanciasPath) throws FileNotFoundException{
        MapGraph<Localidade, Integer> graph = new MapGraph<>(false);
        List<Localidade> localidades = readLocalidades(localidadesPath);
        for(Localidade localidade : localidades)
            graph.addVertex(localidade);
        Scanner fileReader = new Scanner(distanciasPath);
        fileReader.nextLine(); //ignore Header
        while(fileReader.hasNext()){
            String[] itemsPerLine = fileReader.nextLine().split(",");
            graph.addEdge(Utils.getLocalidadeById(itemsPerLine[0], localidades), Utils.getLocalidadeById(itemsPerLine[1], localidades), Integer.parseInt(itemsPerLine[2]));
        }
        return graph;
    }

    /**
     * Método criado para a leitura do ficheiro de localidades
     * @param localidadesPath ficheiro com os locais
     * @return lista de localidades
     * @throws FileNotFoundException caso haja algum erro a ler o ficheiro
     */
    private static List<Localidade> readLocalidades(File localidadesPath) throws FileNotFoundException {
        Scanner fileReader = new Scanner(localidadesPath);
        fileReader.nextLine(); //ignore header
        List<Localidade> localidades = new ArrayList<>();
        while(fileReader.hasNext()){
            String[] itemsPerLine = fileReader.nextLine().split(",");
            localidades.add(new Localidade(itemsPerLine[0], new Point2D.Double(Double.parseDouble(itemsPerLine[1]), Double.parseDouble(itemsPerLine[2]))));
        }
        return localidades;
    }
    public static void readHorarios(Graph<Localidade, Integer> graph, File horarioPath) throws FileNotFoundException {
        Scanner fileReader = new Scanner(horarioPath);
        while(fileReader.hasNext()){
            String[] itemsPerLine = fileReader.nextLine().split(",");
            Localidade local = Utils.getLocalidadeById(itemsPerLine[0], graph.vertices());
            if(local != null){
                local.setTempoInicial(Utils.createLocalTime(itemsPerLine[1]));
                local.setTempoFinal(Utils.createLocalTime(itemsPerLine[2]));
            }
            else
                throw new IllegalArgumentException("Localidade não existe");
        }
        //for(Localidade local : graph.vertices())
        //    System.out.println(local);
        fileReader.close();
    }
}
