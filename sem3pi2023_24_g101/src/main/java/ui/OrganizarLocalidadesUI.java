package ui;

import controller.USEI09OrganizarLocalidadesController;
import domain.Localidade;
import domain.graph.Graph;

import java.util.Collection;
import java.util.Map;

public class OrganizarLocalidadesUI {
    public static void run(Graph<Localidade, Integer> grafo){
        Map<Localidade, Collection<Localidade>> map = USEI09OrganizarLocalidadesController.isolateGraph(grafo);

        for (Map.Entry<Localidade, Collection<Localidade>> entry : map.entrySet()) {
            System.out.println("Vertex: " + entry.getKey());
            System.out.println("Adjacent vertices: " + entry.getValue());
        }
    }
}

