package graph.algorithms;

import domain.Localidade;
import domain.graph.Graph;
import domain.graph.algorithms.CriteriaAlgorithm;
import domain.graph.algorithms.ShortestPathMapGraph;
import org.junit.jupiter.api.Test;
import utils.FileAnalyzer;
import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriteriaAlgorithmTest {
    private final File locaisSmall = new File("docs/Sprint2/ESINF/Data/locais_small.csv");
    private final File locaisBig = new File("docs/Sprint2/ESINF/Data/locais_big.csv");
    private final File distanciasSmall = new File("docs/Sprint2/ESINF/Data/distancias_small.csv");
    private final File distanciasBig = new File("docs/Sprint2/ESINF/Data/distancias_big.csv");
    private Graph<Localidade, Integer> grafoSmall = FileAnalyzer.createMapGraph(locaisSmall, distanciasSmall);
    private Graph<Localidade, Integer> grafoBig = FileAnalyzer.createMapGraph(locaisBig, distanciasBig);

    public CriteriaAlgorithmTest() throws FileNotFoundException {
    }

    @Test
    void assertCriteriosAreCorrectForSmallCT12AreCorrectForSmallFiles() {
        Localidade local = Utils.getLocalidadeById("CT12", grafoSmall.vertices());
        ShortestPathMapGraph<Localidade, Integer> spmg = new ShortestPathMapGraph<>();
        LinkedList<Localidade>[][] listaDeCaminhosCurtos = spmg.giveListOfShortestPaths(grafoSmall);
        assertEquals(CriteriaAlgorithm.getInfluencia(grafoSmall, local), 8);
        assertEquals(CriteriaAlgorithm.getProximidade(grafoSmall, local), 1);
        assertEquals(CriteriaAlgorithm.getCentralidade(local, listaDeCaminhosCurtos), 36);
    }
    @Test
    void assertCriteriosAreCorrectForSmallCT17AreCorrectForSmallFiles() {
        Localidade local = Utils.getLocalidadeById("CT17", grafoSmall.vertices());
        ShortestPathMapGraph<Localidade, Integer> spmg = new ShortestPathMapGraph<>();
        LinkedList<Localidade>[][] listaDeCaminhosCurtos = spmg.giveListOfShortestPaths(grafoSmall);
        assertEquals(CriteriaAlgorithm.getInfluencia(grafoSmall, local), 10);
        assertEquals(CriteriaAlgorithm.getProximidade(grafoSmall, local), 4);
        assertEquals(CriteriaAlgorithm.getCentralidade(local, listaDeCaminhosCurtos), 38);
    }
    @Test
    void assertCriteriosAreCorrectForBigCT285AreCorrectForBigFiles() {
        Localidade local = Utils.getLocalidadeById("CT285", grafoBig.vertices());
        ShortestPathMapGraph<Localidade, Integer> spmg = new ShortestPathMapGraph<>();
        LinkedList<Localidade>[][] listaDeCaminhosCurtos = spmg.giveListOfShortestPaths(grafoBig);
        assertEquals(CriteriaAlgorithm.getInfluencia(grafoBig, local), 14);
        assertEquals(CriteriaAlgorithm.getProximidade(grafoBig, local), 1);
        assertEquals(CriteriaAlgorithm.getCentralidade(local, listaDeCaminhosCurtos), 3383);
    }
    @Test
    void assertCriteriosAreCorrectForBigCT100AreCorrectForBigFiles() {
        Localidade local = Utils.getLocalidadeById("CT100", grafoBig.vertices());
        ShortestPathMapGraph<Localidade, Integer> spmg = new ShortestPathMapGraph<>();
        LinkedList<Localidade>[][] listaDeCaminhosCurtos = spmg.giveListOfShortestPaths(grafoBig);
        assertEquals(CriteriaAlgorithm.getInfluencia(grafoBig, local), 12);
        assertEquals(CriteriaAlgorithm.getProximidade(grafoBig, local), 1);
        assertEquals(CriteriaAlgorithm.getCentralidade(local, listaDeCaminhosCurtos), 4010);
    }
}
