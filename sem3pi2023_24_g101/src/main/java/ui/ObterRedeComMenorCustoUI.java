package ui;

import controller.ObterRedeComMenorCustoController;
import domain.Localidade;
import domain.graph.Edge;
import domain.graph.Graph;

public class ObterRedeComMenorCustoUI {




    public static void run (Graph <Localidade,Integer> grafo)  {
        Graph <Localidade,Integer> grafoDeMenorCusto = ObterRedeComMenorCustoController.obterRedeComMenorCusto(grafo);
        printEdges(grafoDeMenorCusto);
        System.out.println( "Custo de Total de rede: " + ObterRedeComMenorCustoController.obterCustoTotalDaRedeComMenorCusto(grafo));
    }

    private static void printEdges (Graph <Localidade,Integer> grafoRecebido){
        for (Edge <Localidade,Integer> aresta: grafoRecebido.edges()) {
            System.out.printf("Aresta:%n    Vértice Origem: %s%n    Vértice Destino: %s%n   Distância:  %d%n",
                    aresta.getVOrig().getId(), aresta.getVDest().getId(), aresta.getWeight());
        }
}

}
