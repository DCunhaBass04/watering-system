package ui;

import domain.Localidade;
import domain.graph.map.MapGraph;
import domain.percurso.PercursosLimite;

import java.awt.geom.Point2D;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public final class CalcularPercursosLimiteUI {

    public static void run() {
        MapGraph<Localidade, Integer> rede = obterRedeCliente();
        printPercursosDisponiveis(rede);
        System.out.println("-".repeat(50));
        System.out.println("Insira o nome da localidade origem: ");
        Localidade origem = obterLocalidade(rede);
        System.out.println("Insira o nome da localidade destino: ");
        Localidade destino = obterLocalidade(rede);
        System.out.println("Insira a autonomia do veículo: ");
        double autonomia = inserirAutonomia();
        List<LinkedList<Localidade>> percursosLimite = PercursosLimite.calcularPercursosLimite(rede, origem, destino, autonomia);
        System.out.println("-".repeat(50));
        System.out.println("Percursos limite: ");
        printPercursosLimite(percursosLimite, destino);
    }

    private static MapGraph<Localidade, Integer> obterRedeCliente() {
        MapGraph<Localidade, Integer> rede = new MapGraph<>(false);
        Localidade l1 = new Localidade("Porto", new Point2D.Double(1, 1));
        Localidade l2 = new Localidade("Aveiro", new Point2D.Double(1, -1));
        Localidade l3 = new Localidade("Coimbra", new Point2D.Double(0, 1));
        Localidade l4 = new Localidade("Lisboa", new Point2D.Double(0, 0));
        Localidade l5 = new Localidade("Braga", new Point2D.Double(-1, 1));
        rede.addVertex(l1);
        rede.addVertex(l2);
        rede.addVertex(l3);
        rede.addVertex(l4);
        rede.addVertex(l5);
        rede.addEdge(l1, l2, 10);
        rede.addEdge(l1, l3, 20);
        rede.addEdge(l1, l4, 25);
        rede.addEdge(l1, l5, 30);
        rede.addEdge(l2, l3, 15);
        rede.addEdge(l2, l5, 45);
        rede.addEdge(l3, l4, 17);
        rede.addEdge(l4, l5, 19);
        return rede;
    }

    private static void printPercursosLimite(List<LinkedList<Localidade>> percursosLimite, Localidade destino) {
        for (LinkedList<Localidade> percurso : percursosLimite) {
            for (Localidade atual : percurso) {
                if (atual.getId().equalsIgnoreCase(destino.getId())) {
                    System.out.println(atual.getId());
                } else {
                    System.out.print(atual.getId() + " -> ");
                }

            }
        }
    }

    private static void printPercursosDisponiveis(MapGraph<Localidade, Integer> rede) {
        System.out.println("Localidades disponíveis: ");
        for (Localidade atual : rede.vertices()) {
            System.out.println(atual.getId());
        }
    }

    private static Localidade obterLocalidade(MapGraph<Localidade, Integer> rede) {
        Scanner in = new Scanner(System.in);
        boolean isValid = false;
        String nomeLocalidade = null;
        do {
            try {
                nomeLocalidade = in.next();
                if (validarLocalidadeRede(rede, nomeLocalidade)) {
                    isValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Nome de localidade inválido, tente de novo.");
                in.next();
            }
        } while (!isValid);
        return obterLocalidadeDeRede(rede, nomeLocalidade);
    }

    private static boolean validarLocalidadeRede(MapGraph<Localidade, Integer> rede, String nomeLocalidade) {
        for (Localidade atual : rede.vertices()) {
            if (atual.getId().equalsIgnoreCase(nomeLocalidade)) {
                return true;
            }
        }
        return false;
    }

    private static Localidade obterLocalidadeDeRede(MapGraph<Localidade, Integer> rede, String nomeLocalidade) {
        for (Localidade atual : rede.vertices()) {
            if (atual.getId().equalsIgnoreCase(nomeLocalidade)) {
                return atual;
            }
        }
        return null;
    }

    private static double inserirAutonomia() {
        Scanner ler = new Scanner(System.in);
        double quantidade = 0;
        boolean valid = false;
        do {
            try {
                quantidade = ler.nextDouble();
                if (quantidade > 0) {
                    valid = true;
                } else {
                    System.out.println("Autonomia tem de ser maior que zero!");
                    ler.nextLine();
                }

            } catch (InputMismatchException e) {
                System.out.println("Autonomia inválida insira um valor válido!");
                ler.nextLine();
            }
        } while (!valid);
        return quantidade;
    }
}
