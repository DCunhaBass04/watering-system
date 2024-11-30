package utils;

import domain.Localidade;
import domain.PontoCircuitoHubs;
import domain.PontoPercursoHubs;
import domain.graph.Graph;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {
    private static final Scanner ler = new Scanner(System.in);
    static public int showAndSelectIndex(List list, String header) {
        showList(list,header);
        return selectsIndex(list);
    }

    static public void showList(List list, String header) {
        System.out.println(header);
        int index = 0;
        for (Object o : list) {
            index++;
            System.out.println(index + ". " + o.toString());
        }
        System.out.println();
        System.out.println("0. Terminar o Programa");
    }

    static public int selectsIndex(List list) {
        String input;
        int value;
        do {
            input = Utils.readLineFromConsole("Type your option: ");
            assert input != null;
            value = Integer.parseInt(input);
        } while (value < 0 || value > list.size());
        return value - 1;
    }

    static public String readLineFromConsole(String prompt) {
        try {
            System.out.println("\n" + prompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static public int readIntegerFromConsole(String prompt) {
        boolean valid = false;
        int value = 0;
        do {
            try {
                String input = readLineFromConsole(prompt);
                value = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Por favor insira o número num formato válido");
            }
        } while (!valid);
        return value;
    }

    static public float readFloatFromConsole(String prompt) {
        boolean valid = false;
        float value = 0;
        do {
            try {
                String input = readLineFromConsole(prompt);
                value = Float.parseFloat(input);
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.println("Por favor insira o número num formato válido");
            }
        } while (!valid);
        return value;
    }

    /**
     * Método que retorna um objeto Localidade através do seu id
     * @param id id da Localidade procurada
     * @param localidades lista de localidades
     * @return o objeto Localidade procurado
     */
    public static Localidade getLocalidadeById(String id, List<Localidade> localidades) {
        for(Localidade localidade : localidades)
            if (localidade.getId().equals(id))
                return localidade;
        return null;
    }

    /**
     * Para cada data (hora e minutos) no ficheiro, ver em que formato está e retornar o objeto data
     * @param item String com a data
     * @return objeto com a data
     */
    public static LocalTime createLocalTime(String item) {
        String[] formatPatterns = {"H:mm", "hh:mm"};
        LocalTime parsedTime = null;
        for(String formatPattern : formatPatterns) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
            try {
                parsedTime = LocalTime.parse(item, formatter);
                break;
            } catch (DateTimeParseException e){
                //oops, let's go to the next one
            }
        }
        return parsedTime;
    }

    /**
     * Lê um dia do utilizador, verificando se este dia é válido
     * @return objeto dia
     */
    public static LocalDate getParsedDate() {
        boolean valid = false;
        LocalDate date = null;
        do {
            System.out.println("Insira um dia no formato dd/mm/yyyy");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                date = LocalDate.parse(ler.nextLine(), formatter);
                valid = true;
            } catch (DateTimeParseException e){
                System.out.println("Por valor insira o dia no formato válido");
            }
        } while (!valid);
        return date;
    }

    public static double haversineDistance(Point2D.Double coords1, Point2D.Double coords2) {
        final int earthRadius = 6371; //kilometers
        double x1Rad = Math.toRadians(coords1.getX()), x2Rad = Math.toRadians(coords2.getX()),
                y1Rad = Math.toRadians(coords1.getY()), y2Rad = Math.toRadians(coords2.getY());
        double xDistance = (y2Rad - y1Rad) * Math.cos((x1Rad + x2Rad)/2),
                yDistance = (x2Rad - x1Rad);
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance,2)*earthRadius);
    }

    public static Point2D.Double[] findFurthestPoints(List<Point2D.Double> points) {
        if (points == null || points.size() < 2) {
            throw new IllegalArgumentException("List should contain at least two points");
        }
        Point2D.Double firstPoint = points.get(0);
        Point2D.Double secondPoint = points.get(1);
        double maxDistance = firstPoint.distance(secondPoint);
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Point2D.Double point1 = points.get(i);
                Point2D.Double point2 = points.get(j);
                double distance = point1.distance(point2);

                if (distance > maxDistance) {
                    maxDistance = distance;
                    firstPoint = point1;
                    secondPoint = point2;
                }
            }
        }
        return new Point2D.Double[]{firstPoint, secondPoint};
    }
    public static int subtract(int a, int b){
        return a - b;
    }

    public static LocalTime inputTime(Scanner in) {
        LocalTime time = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Introduza as horas e minutos no formato hh:mm - ");
        String input = in.nextLine();
        boolean passed = false;
        do {
            try {
                time = LocalTime.parse(input, formatter);
                if (time.compareTo(LocalTime.now()) > 0) {
                    passed = true;
                } else {
                    System.out.println("A hora tem de ser maior que a hora atual");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido por favor use hh:mm.");
            } catch (InputMismatchException e) {
                System.out.println("Input inválido tente de novo.");
            }
        } while (!passed);
        return time;
    }
    public static Set<Localidade> getHubs(List<Localidade> localidades) {
        Set<Localidade> hubs = new HashSet<>();
        for (Localidade vertex : localidades) {
            if (vertex.isHub()) {
                hubs.add(vertex);
            }
        }
        return hubs;
    }
    public static List<Localidade> getLocalidadesFromPontosDePercurso(List<PontoPercursoHubs> pontosDoPercurso) {
        List<Localidade> localidades = new ArrayList<>();
        for (PontoPercursoHubs vertex : pontosDoPercurso) {
            localidades.add(vertex.getLocal());
        }
        return localidades;
    }
    public static List<Localidade> getLocalidadesFromPontosDeCircuito(List<PontoCircuitoHubs> pontosDoPercurso) {
        List<Localidade> localidades = new ArrayList<>();
        for (PontoCircuitoHubs vertex : pontosDoPercurso) {
            localidades.add(vertex.getLocal());
        }
        return localidades;
    }
    public static boolean isBetween(LocalTime time, LocalTime left, LocalTime right){
        return (time.isAfter(left) && time.isBefore(right)) || time.equals(left) || time.equals(right);
    }
    public static int getBiggestDistance(Localidade localidade, List<Localidade> locaisVisitados, Graph<Localidade, Integer> graph) {
        int maiorDistancia = Integer.MIN_VALUE;
        for(Localidade outraLocalidade : graph.adjVertices(localidade)) {
            int outraDistancia = graph.edge(localidade, outraLocalidade).getWeight();
            if (outraDistancia > maiorDistancia && !locaisVisitados.contains(localidade))
                maiorDistancia = outraDistancia;
        }
        return maiorDistancia;
    }
}
