package domain.percurso;

import domain.Localidade;
import domain.graph.map.MapGraph;

import java.util.*;

public final class PercursosLimite {

    private PercursosLimite() {

    }


    public static List<LinkedList<Localidade>> calcularPercursosLimite(MapGraph<Localidade, Integer> rede, Localidade origem, Localidade destino, double autonomia) {
        List<LinkedList<Localidade>> percursos = new ArrayList<>();
        Map<Localidade, Boolean> visitadas = new HashMap<>();
        for (Localidade vertex : rede.vertices()) {
            visitadas.put(vertex, false);
        }
        LinkedList<Localidade> currentPath = new LinkedList<>();
        depthFirstSearch(rede, origem, destino, visitadas, currentPath, percursos, autonomia, 0.0);
        return percursos;
    }

    private static void depthFirstSearch(MapGraph<Localidade, Integer> rede, Localidade atual, Localidade destino, Map<Localidade, Boolean> visitadas,
                                         LinkedList<Localidade> percursoAtual, List<LinkedList<Localidade>> percursos, double autonomia, double distanciaAtual) {
        visitadas.put(atual, true);
        percursoAtual.addLast(atual);
        if (atual.equals(destino)) {
            if (distanciaAtual <= autonomia) {
                percursos.add(new LinkedList<>(percursoAtual));
            }
        } else {
            for (Localidade adjacente : rede.adjVertices(atual)) {
                int distancia = rede.edge(atual, adjacente).getWeight();
                if (!visitadas.get(adjacente) && distanciaAtual + distancia <= autonomia) {
                    depthFirstSearch(rede, adjacente, destino, visitadas, percursoAtual, percursos, autonomia, distanciaAtual + distancia);
                }
            }
        }
        visitadas.put(atual, false);
        percursoAtual.removeLast();
    }

}
