package ui;

import controller.USEI07MaximizarNumHubsController;
import controller.USEI08ObterCircuitoController;
import domain.CircuitoHubs;
import domain.Localidade;
import domain.PercursoHubs;
import domain.Veiculo;
import domain.graph.Graph;
import utils.Utils;

import java.time.LocalTime;

public class ObterCircuitoUI {
    public static void run(Graph<Localidade, Integer> grafo){
        Veiculo veiculo = criarVeiculo();
        Localidade local = obterLocalidade(grafo);
        int num = Utils.readIntegerFromConsole("Insira o nº de hubs");
        CircuitoHubs percuso = USEI08ObterCircuitoController.obtainCircuit(grafo, local, veiculo, num);
        System.out.println("Hubs:");
        for(Localidade localidadeHub : Utils.getHubs(grafo.vertices()))
            System.out.printf("%s ",localidadeHub.getId());
        System.out.printf("%n%s%n",percuso);
        System.out.printf("Nº de hubs: %d/%d%n",
                Utils.getHubs(Utils.getLocalidadesFromPontosDeCircuito(percuso.getPontosDoPercurso())).size(),
                Utils.getHubs(grafo.vertices()).size());
    }
    private static Veiculo criarVeiculo(){
        double autonomia = Utils.readFloatFromConsole("Insira a autonomia do veículo (metro)"),
                velocidade = Utils.readFloatFromConsole("Insira a velocidade média do veículo (km/h)"),
                tempoCarregamento = Utils.readFloatFromConsole("Insira o tempo médio de carregamento da bateria do veículo (minutos)"),
                tempoDescarga = Utils.readFloatFromConsole("Insira o tempo médio de descarga dos cabazes do veículo (minutos)");
        return new Veiculo(autonomia, velocidade, tempoCarregamento, tempoDescarga);
    }
    private static Localidade obterLocalidade(Graph<Localidade, Integer> grafo){
        boolean valid = false;
        Localidade localInicial;
        do{
            localInicial = Utils.getLocalidadeById(
                    Utils.readLineFromConsole("Insira o id do local inicial do percurso"),
                    grafo.vertices());
            if(localInicial != null)
                valid = true;
        }while(!valid);
        return localInicial;
    }
}
