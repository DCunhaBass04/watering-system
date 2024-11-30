package domain;

import domain.graph.map.MapGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.FileAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;

class VeiculoTest {
    private final File locaisSmallFilePath = new File("docs/Sprint2/ESINF/Data/locais_big.csv");
    private final File distanciasSmallFilePath = new File("docs/Sprint2/ESINF/Data/distancias_big.csv");
    private final MapGraph<Localidade, Integer> redeDistribuicao = FileAnalyzer.createMapGraph(locaisSmallFilePath, distanciasSmallFilePath);
    private final Veiculo fordFiesta = new Veiculo(150);
    private final Veiculo renaultClio = new Veiculo(1000000);
    private final Veiculo fordTransit = new Veiculo(50);

    VeiculoTest() throws FileNotFoundException {

    }


}