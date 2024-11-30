package ui;

import controller.ObterHubsController;
import domain.CriteriosLocalidade;
import domain.Localidade;
import domain.graph.Graph;
import utils.Utils;

import java.util.Map;

public class ObterHubsUI {
    public static void run(Graph<Localidade, Integer> grafo){
        int n = Utils.readIntegerFromConsole("Selecione o nº de hubs que quer");
        Map<CriteriosLocalidade, Localidade> map = ObterHubsController.obterTopNLocalidades(grafo, n);
        for(Map.Entry<CriteriosLocalidade, Localidade> entry : map.entrySet())
            System.out.printf("Localidade: %s%n Influência: %d%n    Proximidade: %d%n   Centralidade: %d%n", entry.getValue().getId(), entry.getKey().getInfluencia(),
                    entry.getKey().getProximidade(), entry.getKey().getCentralidade());
    }
}
