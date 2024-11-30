package ui;
import domain.Setor;
import utils.FileCreater;
import controller.CriarPlanoDeRegaController;
import domain.PlanoDeRega;
import utils.FileAnalyzer;
import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.Scanner;

public class CriarPlanoDeRegaUI implements Runnable {
    private CriarPlanoDeRegaController ctrl = new CriarPlanoDeRegaController();
    private Scanner ler = new Scanner(System.in);

    /**
     * Método run()
     */
    @Override
    public void run() {
        System.out.println("Insira o caminho até o ficheiro de texto com o conjunto de instruções");
        File fileToRead = new File(ler.nextLine());
        try{
            PlanoDeRega planoDeRega = FileAnalyzer.criarPlanoRega(fileToRead, LocalDate.now());
            FileCreater.createPlan(planoDeRega);
            System.out.println("Plano de rega criado.");
            pesquisaDeRega(planoDeRega);
        }catch(IllegalArgumentException e){
            System.out.println("O ficheiro dado não tem o formato correto.");
        }catch(FileNotFoundException e){
            System.out.println("O caminho dado para o ficheiro não existe");
        } catch (IOException e) {
            System.out.println("Houve um erro a criar o ficheiro .csv do plano");
        }
    }

    /**
     * Método feito para dizer ao utilizador se há alguma rega ativa num dia e data inseridos pelo mesmo
     * Também diz quanto tempo falta para essa rega encontrar
     * Avisa o utilizador se não houver nenhuma rega ativa naquele momento
     * @param planoDeRega plano de rega inteiro
     */
    private void pesquisaDeRega(PlanoDeRega planoDeRega) {
        LocalDate date = Utils.getParsedDate();
        LocalTime parsedTime = getParsedTime();
        Map.Entry<Setor, Integer> parcelaRegada = ctrl.verSeHaRegasNoMomento(date, parsedTime, planoDeRega);
        if(parcelaRegada != null)
            System.out.printf("O %s está a ser regado, faltam %d minutos para essa rega acabar%n", parcelaRegada.getKey(), parcelaRegada.getValue());
        else System.out.println("Não há nenhuma rega ativa nesse momento.");
    }

    /**
     * Lê uma data do utilizador, verificando se esta é válida
     * @return objeto data (horas e minutos)
     */
    private LocalTime getParsedTime(){
        boolean valid = false;
        LocalTime parsedTime = null;
        do {
            int errorCount = 0;
            System.out.println("Insira uma data no formato hh:mm");
            String[] formatPatterns = {"H:mm", "hh:mm"};
            String valueToBeParsed = ler.nextLine();
            for (String formatPattern : formatPatterns) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
                try {
                    parsedTime = LocalTime.parse(valueToBeParsed, formatter);
                    valid = true;
                    break;
                } catch (DateTimeParseException e) {
                    errorCount++;
                    if(errorCount == 2){
                        System.out.println("Por favor insira a data no formato válido");
                    }
                    //oops, let's go to the next one
                }
            }
        } while(!valid);
        return parsedTime;
    }
}
