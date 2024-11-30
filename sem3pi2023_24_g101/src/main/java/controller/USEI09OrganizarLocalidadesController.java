package controller;

import java.util.*;

import domain.Localidade;
import domain.graph.Graph;

public class USEI09OrganizarLocalidadesController {
    
    public static Map<Localidade, Collection<Localidade>> isolateGraph(Graph<Localidade, Integer> graph) {
        Map<Localidade, Collection<Localidade>> map = new HashMap<>();
        ArrayList<Localidade> vertices = graph.vertices();
        while (graph.numEdges() > 0) {
            for (Localidade vertex : vertices) {
                Collection<Localidade> adjVertices = graph.adjVertices(vertex);
                map.put(vertex, new ArrayList<>(adjVertices)); // Store the adjacent vertices before removing the edges
                for (Localidade adjVertex : adjVertices) {
                    graph.removeEdge(vertex, adjVertex);
                }
            }
        }
        return map;
    }
}

