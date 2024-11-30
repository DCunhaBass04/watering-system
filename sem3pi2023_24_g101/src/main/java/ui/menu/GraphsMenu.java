package ui.menu;

import domain.Localidade;
import domain.graph.Graph;
import domain.graph.map.MapGraph;
import ui.*;
import utils.FileAnalyzer;
import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class GraphsMenu implements Runnable {
    private final Scanner ler = new Scanner(System.in);

    private MapGraph<Localidade, Integer> grafoMapa = null;
    @Override
    public void run() {
        File fileLocation = new File(Objects.requireNonNull(Utils.readLineFromConsole("Insira um ficheiro com as localidades a usar:")));
        File fileDistance = new File(Objects.requireNonNull(Utils.readLineFromConsole("Insira um ficheiro com as distâncias entre localidades:")));
        try{
            Graph<Localidade, Integer> grafo = FileAnalyzer.createMatrixGraph(fileLocation, fileDistance);
            grafoMapa = FileAnalyzer.createMapGraph(fileLocation, fileDistance);
            graphUi(grafo);
        } catch (FileNotFoundException e){
            System.out.printf("Estes ficheiros não são compatíveis ou não existem, por favor insira ficheiros válidos. %nPressione ENTER para continuar.%n");
            ler.nextLine();
        }
    }
    private void graphUi(Graph<Localidade, Integer> grafo){
        int n;
        do {
            n = Utils.readIntegerFromConsole("\nMenu de Localidades:\n1 - Obter Hubs\n2 - Obter Rede de Localidades com Menor Distância\n3 - Calcular percurso mínimo entre pontos mais afastados para um veículo\n4 - Calcular percurso com número máximo de hubs\n5 - Calcular circuito com maior número de colaboradores\n6 - Atualizar Horários das Localidades\n7 - Organizar Localidades\n0 - Sair\n");
            try {
                switch (n){
                    case 1:
                        ObterHubsUI.run(grafo);
                        break;
                    case 2:
                        ObterRedeComMenorCustoUI.run(grafo);
                        break;
                    case 3:
                        CalcularPercursoUI.run(grafoMapa);
                        break;
                    case 4:
                        MaximizarNumHubsUI.run(grafo.clone());
                        break;
                    case 5:
                        ObterCircuitoUI.run(grafo.clone());
                        break;
                    case 6:
                        LerHorariosUI.run(grafo);
                        break;
                    case 7:
                        OrganizarLocalidadesUI.run(grafo);
                        break;
                }
            } catch (InputMismatchException e){
                System.out.printf("Por favor insira um número válido.%nPressione ENTER para continuar.%n");
                ler.nextLine();
            }
        }while(n != 0);
    }
}
