package controller;
import domain.Localidade;
import domain.graph.Graph;
import org.junit.jupiter.api.Test;
import utils.FileAnalyzer;
import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class ObterRedeComMenorCustoControllerTest {
    private final File locaisSmallFilePath = new File("docs/Sprint2/ESINF/Data/locais_small.csv");
    private final File distanciasSmallFilePath = new File("docs/Sprint2/ESINF/Data/distancias_small.csv");

    private final File locaisBigFilePath = new File("docs/Sprint3/ESINF/Data/locais_big.csv");
    private final File distanciasBigFilePath  = new File("docs/Sprint3/ESINF/Data/distancias_big.csv");





    /**
 * Verificar que o custo obtido é positivo 
 */

    @Test
    void verificarCustoMinimoSmall() throws  FileNotFoundException {
    Graph<Localidade, Integer> grafoObtido = FileAnalyzer.createMapGraph(locaisSmallFilePath, distanciasSmallFilePath);
    int menorCusto = ObterRedeComMenorCustoController.obterCustoTotalDaRedeComMenorCusto(ObterRedeComMenorCustoController.obterRedeComMenorCusto(grafoObtido));

    assertNotNull(menorCusto);
    assertTrue(menorCusto > 0);
}

    @Test
    void verificarCustoMinimoBig() throws  FileNotFoundException {
        Graph<Localidade, Integer> grafoObtido = FileAnalyzer.createMapGraph(locaisBigFilePath, distanciasBigFilePath);
        int menorCusto = ObterRedeComMenorCustoController.obterCustoTotalDaRedeComMenorCusto(ObterRedeComMenorCustoController.obterRedeComMenorCusto(grafoObtido));

        assertNotNull(menorCusto);
        assertTrue(menorCusto > 0);
    }


    /**
     * Verificar a condiçao do algoritmo Kruskal |E’| = |V|-1
     * Nota: A forma de implementação adiciona o dobro de arestas para cada vertice desta forma: numEdges/2
     */
    @Test
    void verificarNumArestasMSTCorretasSmall() throws FileNotFoundException {
        Graph<Localidade, Integer> grafoObtido = FileAnalyzer.createMapGraph(locaisSmallFilePath, distanciasSmallFilePath);
        Graph<Localidade, Integer> redeComMenorCusto = ObterRedeComMenorCustoController.obterRedeComMenorCusto(grafoObtido);
        assertEquals(redeComMenorCusto.numEdges()/2,grafoObtido.numVertices()-1);
    }


    @Test
    void verificarNumArestasMSTCorretasBig() throws FileNotFoundException {
        Graph<Localidade, Integer> grafoObtido = FileAnalyzer.createMapGraph(locaisBigFilePath,distanciasBigFilePath);
        Graph<Localidade, Integer> redeComMenorCusto = ObterRedeComMenorCustoController.obterRedeComMenorCusto(grafoObtido);
        assertEquals(redeComMenorCusto.numEdges()/2,grafoObtido.numVertices()-1);
    }


    /**
     * Verifica se a rede mínima contém todos os vértices do grafo original.
     */

    @Test
    void verificarContemVerticesGrafoOriginalSmall() throws FileNotFoundException {
        Graph<Localidade, Integer> grafoObtido = FileAnalyzer.createMapGraph(locaisSmallFilePath, distanciasSmallFilePath);
        Graph<Localidade, Integer> redeComMenorCusto = ObterRedeComMenorCustoController.obterRedeComMenorCusto(grafoObtido);
        assertTrue(redeComMenorCusto.vertices().containsAll(grafoObtido.vertices()));
    }
    @Test
    void verificarContemVerticesGrafoOriginalBig() throws FileNotFoundException {
        Graph<Localidade, Integer> grafoObtido = FileAnalyzer.createMapGraph(locaisBigFilePath, distanciasSmallFilePath);
        Graph<Localidade, Integer> redeComMenorCusto = ObterRedeComMenorCustoController.obterRedeComMenorCusto(grafoObtido);
        assertTrue(redeComMenorCusto.vertices().containsAll(grafoObtido.vertices()));
    }

}


