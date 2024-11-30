package esinf;

import controller.LerHorariosController;
import controller.USEI07MaximizarNumHubsController;
import controller.USEI08ObterCircuitoController;
import domain.CircuitoHubs;
import domain.Localidade;
import domain.PercursoHubs;
import domain.Veiculo;
import domain.graph.Graph;
import org.junit.jupiter.api.Test;
import utils.FileAnalyzer;
import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class USEI08ObterCircuitoControllerTest {
    private final File locaisSmall = new File("docs/Sprint3/ESINF/Data/locais_small.csv");
    private final File locaisBig = new File("docs/Sprint3/ESINF/Data/locais_big.csv");
    private final File distanciasSmall = new File("docs/Sprint3/ESINF/Data/distancias_small.csv");
    private final File distanciasBig = new File("docs/Sprint3/ESINF/Data/distancias_big.csv");
    private final File horariosSmall = new File("docs/Sprint3/ESINF/USEI11/files/USEI11 small.txt");
    private final File horariosBig = new File("docs/Sprint3/ESINF/USEI11/files/USEI11.txt");
    private Graph<Localidade, Integer> grafoSmall = FileAnalyzer.createMapGraph(locaisSmall, distanciasSmall);
    private Graph<Localidade, Integer> grafoBig = FileAnalyzer.createMapGraph(locaisBig, distanciasBig);

    public USEI08ObterCircuitoControllerTest() throws FileNotFoundException {
    }
    @Test
    void assertThatSmallGraphCircuitoHasCorrectValues() {
        CircuitoHubs circuito = USEI08ObterCircuitoController.obtainCircuit(grafoSmall, Utils.getLocalidadeById("CT4",grafoSmall.vertices()),
                new Veiculo(500000, 240, 15, 10), 5);
        assertEquals(circuito.getTempoTotalDeViagem(), 345);
        assertEquals(circuito.getTempoTotalDeCarregamento(), 30);
        assertEquals(circuito.getTempoTotalDeDescarregamento(), 40);
        assertEquals(obterRatioDeHubsDentroDoCircuito(circuito, grafoSmall.vertices()), (float)4/5);
    }
    @Test
    void assertThatBigGraphCircuitoHasCorrectValues(){
        CircuitoHubs circuito = USEI08ObterCircuitoController.obtainCircuit(grafoBig, Utils.getLocalidadeById("CT6",grafoBig.vertices()),
                new Veiculo(500000, 240, 20, 15), 5);
        assertEquals(circuito.getTempoTotalDeViagem(), 58);
        assertEquals(circuito.getTempoTotalDeCarregamento(), 20);
        assertEquals(circuito.getTempoTotalDeDescarregamento(), 135);
        assertEquals(obterRatioDeHubsDentroDoCircuito(circuito, grafoBig.vertices()), 1);
    }
    private float obterRatioDeHubsDentroDoCircuito(CircuitoHubs percursoHubs, List<Localidade> localidades){
        return (float) Utils.getHubs(Utils.getLocalidadesFromPontosDeCircuito(percursoHubs.getPontosDoPercurso())).size() / Utils.getHubs(localidades).size();
    }
}
