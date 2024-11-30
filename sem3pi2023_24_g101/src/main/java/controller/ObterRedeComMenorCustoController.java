package controller;

import domain.Localidade;
import domain.graph.Edge;
import domain.graph.Graph;
import domain.graph.algorithms.Kruskal;

import java.util.*;

/**
 * Este é o ObterRedeComMenorCustoController, ele comunica com a sua UI: ObterdeComMenorCustoUi
 * Obtem a árvore geradora de Menor Custo juntamente com o seu custo Total
 */
public class ObterRedeComMenorCustoController {

  public static Graph <Localidade,Integer> obterRedeComMenorCusto(Graph<Localidade,Integer> grafoObtido){
     Comparator <Edge <Localidade,Integer>> comparator = Comparator.comparingInt(Edge::getWeight);
     // comparator instancia -se e compara os pesos ( distancia (M)) entre eles )

     return Kruskal.kruskall(grafoObtido,comparator);
    }
    public static int obterCustoTotalDaRedeComMenorCusto(Graph <Localidade,Integer> grafoObtido) {
        int custoTotal = 0;
        for (Edge <Localidade,Integer> aresta : grafoObtido.edges())
            custoTotal += aresta.getWeight();


        return  custoTotal/2;
    }
}
