package controller;

import domain.CriteriosLocalidade;
import domain.Localidade;
import domain.graph.Graph;
import org.junit.jupiter.api.Test;
import utils.FileAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ObterHubsControllerTest {
    private final File locaisSmall = new File("docs/Sprint2/ESINF/Data/locais_small.csv");
    private final File locaisBig = new File("docs/Sprint2/ESINF/Data/locais_big.csv");
    private final File distanciasSmall = new File("docs/Sprint2/ESINF/Data/distancias_small.csv");
    private final File distanciasBig = new File("docs/Sprint2/ESINF/Data/distancias_big.csv");
    private Graph<Localidade, Integer> grafoSmall = FileAnalyzer.createMapGraph(locaisSmall, distanciasSmall);

    public ObterHubsControllerTest() throws FileNotFoundException {
    }

    @Test void assertTop5HubsAreCorrectForSmallFiles() {
        Map<CriteriosLocalidade, Localidade> map = ObterHubsController.obterTopNLocalidades(grafoSmall, 5);
        List<String> locais = new ArrayList<>(Arrays.asList("CT10", "CT13", "CT1", "CT17", "CT6"));
        int i = 0;
        for(Map.Entry<CriteriosLocalidade, Localidade> entry : map.entrySet()) {
            assertTrue(entry.getValue().getId().equalsIgnoreCase(locais.get(i)));
            i++;
        }
    }
    @Test void assertTop10HubsAreCorrectForSmallFiles() {
        Map<CriteriosLocalidade, Localidade> map = ObterHubsController.obterTopNLocalidades(grafoSmall, 10);
        List<String> locais = new ArrayList<>(Arrays.asList("CT10", "CT13", "CT1", "CT17", "CT6", "CT12", "CT5", "CT16", "CT11", "CT2"));
        int i = 0;
        for(Map.Entry<CriteriosLocalidade, Localidade> entry : map.entrySet()) {
            assertTrue(entry.getValue().getId().equalsIgnoreCase(locais.get(i)));
            i++;
        }
    }
}
