package controller;

import domain.CriteriosLocalidade;
import domain.Localidade;
import domain.graph.Graph;
import org.junit.jupiter.api.Test;
import utils.FileAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class USEI09OrganizarLocalidadesControllerTest {
    private final File locaisSmall = new File("docs/Sprint2/ESINF/Data/locais_small.csv");
    private final File locaisBig = new File("docs/Sprint2/ESINF/Data/locais_big.csv");
    private final File distanciasSmall = new File("docs/Sprint2/ESINF/Data/distancias_small.csv");
    private final File distanciasBig = new File("docs/Sprint2/ESINF/Data/distancias_big.csv");
    private final Graph<Localidade, Integer> grafo = FileAnalyzer.createMatrixGraph(locaisSmall, locaisSmall);


    public USEI09OrganizarLocalidadesControllerTest() throws FileNotFoundException {
    }

    @Test
void testIsolateGraph() {
    Map<Localidade, Collection<Localidade>> map = USEI09OrganizarLocalidadesController.isolateGraph(grafo);

    for (Map.Entry<Localidade, Collection<Localidade>> entry : map.entrySet()) {
        Localidade vertex = entry.getKey();
        Collection<Localidade> adjVertices = entry.getValue();

        System.out.println("Vertex: " + vertex);
        System.out.println("Adjacent vertices: " + adjVertices);

        assertTrue(adjVertices.isEmpty());
    }
}
}
