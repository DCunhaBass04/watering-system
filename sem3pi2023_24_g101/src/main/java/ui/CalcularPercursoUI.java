package ui;

import domain.Localidade;
import domain.Percurso;
import domain.Veiculo;
import domain.graph.map.MapGraph;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcularPercursoUI {



    public static void run(MapGraph<Localidade, Integer> redeDistribuicao) {
        System.out.println("Insira a autonomia do veículo");
        double autonomia = inserirAutonomia();
        Veiculo veiculo = new Veiculo(autonomia);
        Percurso percursoVeiculo = veiculo.calcularPercursoMinimo(redeDistribuicao);
        printarInfoPercurso(percursoVeiculo);
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

    private static void printarInfoPercurso(Percurso percurso) {
        System.out.println("Locais carregamento: ");
        System.out.println(percurso.getLocaisCarregamento());
        System.out.println("Distancia total: ");
        System.out.println(percurso.getDistanciaTotal());
    }
}
