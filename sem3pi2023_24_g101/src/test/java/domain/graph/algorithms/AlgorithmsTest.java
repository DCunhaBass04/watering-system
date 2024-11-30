package domain.graph.algorithms;

import domain.Localidade;
import domain.graph.map.MapGraph;
import org.junit.jupiter.api.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {

    @Test
    void allPaths() {
        MapGraph<Localidade, Integer> rede = new MapGraph<>(false);
        Localidade l1 = new Localidade("1", new Point2D.Double(1, 1));
        Localidade l2 = new Localidade("2", new Point2D.Double(1, -1));
        Localidade l3 = new Localidade("3", new Point2D.Double(-1, 1));
        Localidade l4 = new Localidade("4", new Point2D.Double(0, 1));
        Localidade l5 = new Localidade("5", new Point2D.Double(1, 0));
        rede.addEdge(l1, l4, 20);
        rede.addEdge(l1, l5, 10);
        rede.addEdge(l2, l3, 12);
        rede.addEdge(l2, l4, 18);
        rede.addEdge(l2, l5, 30);
        rede.addEdge(l3, l5, 15);
        ArrayList<LinkedList<Localidade>> allPaths = Algorithms.allPaths(rede, l5, l3);
        allPaths.forEach(System.out::println);

    }
}