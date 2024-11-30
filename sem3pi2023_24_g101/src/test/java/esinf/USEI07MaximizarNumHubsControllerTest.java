package esinf;

import controller.LerHorariosController;
import controller.USEI07MaximizarNumHubsController;
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

import static org.junit.jupiter.api.Assertions.*;

public class USEI07MaximizarNumHubsControllerTest {
    private final File locaisSmall = new File("docs/Sprint3/ESINF/Data/locais_small.csv");
    private final File locaisBig = new File("docs/Sprint3/ESINF/Data/locais_big.csv");
    private final File distanciasSmall = new File("docs/Sprint3/ESINF/Data/distancias_small.csv");
    private final File distanciasBig = new File("docs/Sprint3/ESINF/Data/distancias_big.csv");
    private final File horariosSmall = new File("docs/Sprint3/ESINF/USEI11/files/USEI11 small.txt");
    private final File horariosBig = new File("docs/Sprint3/ESINF/USEI11/files/USEI11.txt");
    private Graph<Localidade, Integer> grafoSmall = FileAnalyzer.createMapGraph(locaisSmall, distanciasSmall);
    private Graph<Localidade, Integer> grafoBig = FileAnalyzer.createMapGraph(locaisBig, distanciasBig);

    public USEI07MaximizarNumHubsControllerTest() throws FileNotFoundException {
    }

    @Test
    void assertThatSmallGraphPercurso1HasCorrectValues() throws FileNotFoundException {
        LerHorariosController.lerHorariosDeLocalidades(grafoSmall, horariosSmall);
        PercursoHubs percurso = USEI07MaximizarNumHubsController.obterPercursoComMaxNumHubs(grafoSmall,5,
                LocalTime.parse("10:15"), Utils.getLocalidadeById("CT1", grafoSmall.vertices()),
                new Veiculo(1000000, 240, 15, 10));
        assertEquals(percurso.getLocalFinal(), Utils.getLocalidadeById("CT8", grafoSmall.vertices()));
        assertEquals(percurso.getHoraFinal(), LocalTime.parse("13:12"));
        assertEquals(percurso.getTempoTotalDeViagem(), 137);
        assertEquals(percurso.getTempoTotalDeCarregamento(), 40);
        assertEquals(obterRatioDeHubsDentroDoPercurso(percurso, grafoSmall.vertices()), (float)4/5);
    }
    @Test
    void assertThatSmallGraphPercurso2HasCorrectValues() throws FileNotFoundException {
        LerHorariosController.lerHorariosDeLocalidades(grafoSmall, horariosSmall);
        PercursoHubs percurso = USEI07MaximizarNumHubsController.obterPercursoComMaxNumHubs(grafoSmall,5,
                LocalTime.parse("10:15"), Utils.getLocalidadeById("CT1", grafoSmall.vertices()),
                new Veiculo(500000, 240, 15, 10));
        assertEquals(percurso.getLocalFinal(), Utils.getLocalidadeById("CT8", grafoSmall.vertices()));
        assertEquals(percurso.getHoraFinal(), LocalTime.parse("13:27"));
        assertEquals(percurso.getTempoTotalDeViagem(), 137);
        assertEquals(percurso.getTempoTotalDeCarregamento(), 55);
        assertEquals(obterRatioDeHubsDentroDoPercurso(percurso, grafoSmall.vertices()), (float)4/5);
    }
    @Test
    void assertThatBigGraphPercurso1HasCorrectValues() throws FileNotFoundException {
        LerHorariosController.lerHorariosDeLocalidades(grafoBig, horariosBig);
        PercursoHubs percurso = USEI07MaximizarNumHubsController.obterPercursoComMaxNumHubs(grafoBig,10,
                LocalTime.parse("09:30"), Utils.getLocalidadeById("CT4", grafoBig.vertices()),
                new Veiculo(200000, 200, 15, 10));
        assertEquals(percurso.getLocalFinal(), Utils.getLocalidadeById("CT85", grafoBig.vertices()));
        assertEquals(percurso.getHoraFinal(), LocalTime.parse("09:37"));
        assertEquals(percurso.getTempoTotalDeViagem(), 7);
        assertEquals(percurso.getTempoTotalDeCarregamento(), 0);
        assertEquals(obterRatioDeHubsDentroDoPercurso(percurso, grafoBig.vertices()), 0);
    }
    @Test
    void assertThatBigGraphPercurso2HasCorrectValues() throws FileNotFoundException {
        LerHorariosController.lerHorariosDeLocalidades(grafoBig, horariosBig);
        PercursoHubs percurso = USEI07MaximizarNumHubsController.obterPercursoComMaxNumHubs(grafoBig,8,
                LocalTime.parse("13:30"), Utils.getLocalidadeById("CT10", grafoBig.vertices()),
                new Veiculo(200000, 200, 15, 10));
        assertEquals(percurso.getLocalFinal(), Utils.getLocalidadeById("CT118", grafoBig.vertices()));
        assertEquals(percurso.getHoraFinal(), LocalTime.parse("14:22"));
        assertEquals(percurso.getTempoTotalDeViagem(), 32);
        assertEquals(percurso.getTempoTotalDeCarregamento(), 20);
        assertEquals(obterRatioDeHubsDentroDoPercurso(percurso, grafoBig.vertices()), (float)2/8);
    }
    private float obterRatioDeHubsDentroDoPercurso(PercursoHubs percursoHubs, List<Localidade> localidades){
        return (float) Utils.getHubs(Utils.getLocalidadesFromPontosDePercurso(percursoHubs.getPontosDoPercurso())).size() / Utils.getHubs(localidades).size();
    }
}
