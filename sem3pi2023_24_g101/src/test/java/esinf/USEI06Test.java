package esinf;

import domain.Localidade;
import domain.graph.Graph;
import domain.graph.map.MapGraph;
import domain.percurso.PercursosLimite;
import org.junit.jupiter.api.Test;
import utils.FileAnalyzer;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class USEI06Test {

    private final File locaisBig = new File("docs/Sprint3/ESINF/Data/locais_big.csv");
    private final File distanciasBig = new File("docs/Sprint3/ESINF/Data/distancias_big.csv");
    private Graph<Localidade, Integer> rede = FileAnalyzer.createMapGraph(locaisBig, distanciasBig);

    USEI06Test() throws FileNotFoundException {

    }

    private static MapGraph<Localidade, Integer> obterRedeTeste() {
        MapGraph<Localidade, Integer> rede = new MapGraph<>(false);
        Localidade l1 = new Localidade("Porto", new Point2D.Double(1, 1));
        Localidade l2 = new Localidade("Aveiro", new Point2D.Double(1, -1));
        Localidade l3 = new Localidade("Coimbra", new Point2D.Double(0, 1));
        Localidade l4 = new Localidade("Lisboa", new Point2D.Double(0, 0));
        Localidade l5 = new Localidade("Braga", new Point2D.Double(-1, 1));
        rede.addVertex(l1);
        rede.addVertex(l2);
        rede.addVertex(l3);
        rede.addVertex(l4);
        rede.addVertex(l5);
        rede.addEdge(l1, l2, 10);
        rede.addEdge(l1, l3, 20);
        rede.addEdge(l1, l4, 25);
        rede.addEdge(l1, l5, 30);
        rede.addEdge(l2, l3, 15);
        rede.addEdge(l2, l5, 45);
        rede.addEdge(l3, l4, 17);
        rede.addEdge(l4, l5, 19);
        return rede;
    }

    private static void printPercursosLimite(List<LinkedList<Localidade>> percursosLimite, Localidade destino) {
        for (LinkedList<Localidade> percurso : percursosLimite) {
            for (Localidade atual : percurso) {
                if (atual.getId().equalsIgnoreCase(destino.getId())) {
                    System.out.println(atual.getId());
                } else {
                    System.out.print(atual.getId() + " -> ");
                }

            }
        }
    }

    @Test
    void autonomiaElevada() {
        MapGraph<Localidade, Integer> rede = obterRedeTeste();
        Localidade origem = rede.vertex(0); // Porto
        Localidade destino = rede.vertex(4); // Braga
        double autonomia = 500;
        List<LinkedList<Localidade>> percursosLimite = PercursosLimite.calcularPercursosLimite(rede, origem, destino, autonomia);
        printPercursosLimite(percursosLimite, destino);
    }

    @Test
    void autonomiaPequena() {
        MapGraph<Localidade, Integer> rede = obterRedeTeste();
        Localidade origem = rede.vertex(0); // Porto
        Localidade destino = rede.vertex(4); // Braga
        double autonomia = 50;
        List<LinkedList<Localidade>> percursosLimite = PercursosLimite.calcularPercursosLimite(rede, origem, destino, autonomia);
        printPercursosLimite(percursosLimite, destino);
    }

    @Test
    void autonomiaNula() {
        MapGraph<Localidade, Integer> rede = obterRedeTeste();
        Localidade origem = rede.vertex(0); // Porto
        Localidade destino = rede.vertex(4); // Braga
        double autonomia = 0;
        List<LinkedList<Localidade>> percursosLimite = PercursosLimite.calcularPercursosLimite(rede, origem, destino, autonomia);
        printPercursosLimite(percursosLimite, destino);
    }

    @Test
    void autonomiaNegativa() {
        MapGraph<Localidade, Integer> rede = obterRedeTeste();
        Localidade origem = rede.vertex(0); // Porto
        Localidade destino = rede.vertex(4); // Braga
        double autonomia = -50;
        List<LinkedList<Localidade>> percursosLimite = PercursosLimite.calcularPercursosLimite(rede, origem, destino, autonomia);
        printPercursosLimite(percursosLimite, destino);
    }

    @Test
    void testarRedeGrande() {
        Localidade origem = rede.vertex(0); // CT43
        Localidade destino = rede.vertex(5); // CT156
        double autonomia = 500000;
        List<LinkedList<Localidade>> percursosLimite = PercursosLimite.calcularPercursosLimite((MapGraph<Localidade, Integer>) rede, origem, destino, autonomia);
        printPercursosLimite(percursosLimite, destino);
    }

}
