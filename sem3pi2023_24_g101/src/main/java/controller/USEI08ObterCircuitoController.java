package controller;

import domain.*;
import domain.graph.Edge;
import domain.graph.Graph;
import domain.graph.algorithms.ShortestPathMapGraph;
import utils.Utils;

import java.util.*;

public class USEI08ObterCircuitoController {
    private static Graph<Localidade, Integer> graph = null;
    private static Localidade currentVertex = null;
    private final static Comparator<Localidade> cmp = (o1, o2) -> {
        if(o1.isHub() && !o2.isHub())
            return -1;
        else if (!o1.isHub() && o2.isHub())
            return 1;
        else if (o1.isHub() && o2.isHub())
            return o1.getId().compareTo(o2.getId());
        else
            return Double.compare(graph.edge(currentVertex, o1).getWeight(),
                    graph.edge(currentVertex, o2).getWeight());
    };

    private static LinkedList<PontoCircuitoHubs> maximizeHubPath(Graph<Localidade, Integer> receivedGraph,
                                                                 Localidade vOrig, Veiculo veiculo) {
        LinkedList<PontoCircuitoHubs> visitedVertices = new LinkedList<>();
        graph = receivedGraph.clone();
        Set<Localidade> hubs = Utils.getHubs(graph.vertices());  // Obtém todos os hubs
        maximizeHubs(vOrig, visitedVertices, hubs, veiculo,(int)veiculo.getAutonomia());
        return visitedVertices;
    }

    private static void maximizeHubs(Localidade vertex, List<PontoCircuitoHubs> visitedVertices,
                                     Set<Localidade> remainingHubs, Veiculo veiculo, int autonomiaRestante) {
        if (remainingHubs.isEmpty()) {
            return;  // Já atingiu o número máximo de hubs ou não há mais hubs restantes
        }
        if (wasVertexAlreadyVisited(visitedVertices, vertex)) {
            return;  // Evita ciclos
        }
        if (!visitedVertices.isEmpty()) {
            Edge<Localidade, Integer> edge = graph.edge(visitedVertices.get(visitedVertices.size() - 1).getLocal(), vertex);
            if (edge != null) {
                int distancia = edge.getWeight();
                if (distancia > veiculo.getAutonomia())
                    return;
                addVertexToList(vertex, visitedVertices, remainingHubs, veiculo, distancia, autonomiaRestante - distancia);
            }
        } else {
            addVertexToList(vertex, visitedVertices, remainingHubs, veiculo, 0, autonomiaRestante);
        }
    }
    private static boolean wasVertexAlreadyVisited(List<PontoCircuitoHubs> pontos, Localidade localidade){
        for(PontoCircuitoHubs ponto : pontos)
            if(ponto.getLocal().equals(localidade))
                return true;
        return false;
    }
    private static void addVertexToList(Localidade vertex, List<PontoCircuitoHubs> visitedVertices, Set<Localidade> remainingHubs,
                                        Veiculo veiculo, int distancia, int autonomiaRestante) {
        boolean carregar = false;
        if (vertex.isHub() && remainingHubs.contains(vertex)) {
            remainingHubs.remove(vertex);
        }
        if(autonomiaRestante < Utils.getBiggestDistance(vertex, Utils.getLocalidadesFromPontosDeCircuito(visitedVertices), graph)) {
            autonomiaRestante = (int) veiculo.getAutonomia();
            carregar = true;
        }
        int duracaoChegada = (int) (distancia / (veiculo.getVelocidadeMedia() * 1000 / 60));
        if(vertex.isHub() && carregar)
            visitedVertices.add(new PontoCircuitoHubs((int)veiculo.getTempoMediaCarregamentoBateria(), vertex, duracaoChegada,
                    (int)veiculo.getTempoMediaDescargaCabazes(), distancia));
        else if(vertex.isHub() && !carregar)
            visitedVertices.add(new PontoCircuitoHubs(vertex, duracaoChegada, (int)veiculo.getTempoMediaDescargaCabazes(), distancia));
        else if(!vertex.isHub() && carregar)
            visitedVertices.add(new PontoCircuitoHubs((int)veiculo.getTempoMediaCarregamentoBateria(), vertex, duracaoChegada, distancia));
        else
            visitedVertices.add(new PontoCircuitoHubs(vertex, duracaoChegada, distancia));
        currentVertex = vertex;
        List<Localidade> locaisAdjacentes = (List<Localidade>) graph.adjVertices(vertex);
        locaisAdjacentes.sort(cmp);
        for (Localidade neighbor : locaisAdjacentes) {
            int previousSize = visitedVertices.size();
            maximizeHubs(neighbor, visitedVertices, remainingHubs, veiculo, autonomiaRestante);
            if(visitedVertices.size() != previousSize)
                break;
        }
    }

    public static CircuitoHubs obtainCircuit(Graph<Localidade, Integer> grafo, Localidade origin, Veiculo veiculo, int n){
        Map<CriteriosLocalidade, Localidade> map = ObterHubsController.obterTopNLocalidades(grafo, n);
        for(Map.Entry<CriteriosLocalidade, Localidade> entry : map.entrySet())
            Utils.getLocalidadeById(entry.getValue().getId(), grafo.vertices()).setHub(true);
        LinkedList<PontoCircuitoHubs> localidades = maximizeHubPath(grafo, origin, veiculo);
        Localidade ultimoLocal = localidades.removeLast().getLocal();
        ShortestPathMapGraph<Localidade, Integer> smpg = new ShortestPathMapGraph<>();
        addShortestPathToList(localidades, smpg.getShortestPathLinkedList(grafo, ultimoLocal, origin), grafo, veiculo);
        return new CircuitoHubs(origin, localidades);
    }
    private static void addShortestPathToList(List<PontoCircuitoHubs> pontoCircuitoHubs, List<Localidade> shortestPath,
                                              Graph<Localidade, Integer> grafo, Veiculo veiculo){
        int distancia = grafo.edge(shortestPath.get(0), pontoCircuitoHubs.get(pontoCircuitoHubs.size()-1).getLocal()).getWeight();
        int duracaoChegada = (int) (distancia / (veiculo.getVelocidadeMedia() * 1000 / 60));
        if(shortestPath.get(0).isHub())
            pontoCircuitoHubs.add(new PontoCircuitoHubs((int)veiculo.getTempoMediaCarregamentoBateria(), shortestPath.get(0), duracaoChegada,
                    (int)veiculo.getTempoMediaDescargaCabazes(), distancia));
        else
            pontoCircuitoHubs.add(new PontoCircuitoHubs((int)veiculo.getTempoMediaCarregamentoBateria(), shortestPath.get(0), duracaoChegada, distancia));
        int autonomiaRestante = (int)veiculo.getAutonomia();

        int size = shortestPath.size();
        boolean carregar = false;
        for(int i = 1; i < size; i++){
            distancia = grafo.edge(shortestPath.get(i), shortestPath.get(i-1)).getWeight();
            duracaoChegada = (int) (distancia / (veiculo.getVelocidadeMedia() * 1000 / 60));
            if(autonomiaRestante < distancia) {
                autonomiaRestante = (int) veiculo.getAutonomia();
                carregar = true;
            }
            if(shortestPath.get(i).isHub() && carregar)
                pontoCircuitoHubs.add(new PontoCircuitoHubs((int)veiculo.getTempoMediaCarregamentoBateria(), shortestPath.get(i), duracaoChegada,
                        (int)veiculo.getTempoMediaDescargaCabazes(), distancia));
            else if(shortestPath.get(i).isHub() && !carregar)
                pontoCircuitoHubs.add(new PontoCircuitoHubs(shortestPath.get(i), duracaoChegada, (int)veiculo.getTempoMediaDescargaCabazes(), distancia));
            else if(!shortestPath.get(i).isHub() && carregar)
                pontoCircuitoHubs.add(new PontoCircuitoHubs((int)veiculo.getTempoMediaCarregamentoBateria(), shortestPath.get(i), duracaoChegada, distancia));
            else
                pontoCircuitoHubs.add(new PontoCircuitoHubs(shortestPath.get(i), duracaoChegada, distancia));
            carregar = false;
        }
    }
}
