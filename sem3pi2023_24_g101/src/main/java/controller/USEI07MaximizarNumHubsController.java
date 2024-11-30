package controller;

import domain.*;
import domain.graph.Edge;
import domain.graph.Graph;
import utils.Utils;

import java.time.LocalTime;
import java.util.*;

public class USEI07MaximizarNumHubsController {
    private static Graph<Localidade, Integer> graph = null;
    private static Localidade currentVertex = null;
    private final static Comparator<Localidade> cmp = (o1, o2) -> {
        if(o1.isHub() && !o2.isHub())
            return -1;
        else if (!o1.isHub() && o2.isHub())
            return 1;
        else
            return Double.compare(graph.edge(currentVertex, o1).getWeight(),
                    graph.edge(currentVertex, o2).getWeight());
    };

    private static LinkedList<PontoPercursoHubs> maximizeHubPath(Graph<Localidade, Integer> receivedGraph, Localidade vOrig,
                                                                 Veiculo veiculo, LocalTime horaInicial) {
        LinkedList<PontoPercursoHubs> visitedVertices = new LinkedList<>();
        graph = receivedGraph.clone();
        Set<Localidade> hubs = Utils.getHubs(graph.vertices());  // Obtém todos os hubs
        maximizeHubs(vOrig, visitedVertices, hubs, veiculo, horaInicial, (int)veiculo.getAutonomia());
        return visitedVertices;
    }

    private static void maximizeHubs(Localidade vertex, List<PontoPercursoHubs> visitedVertices,
                                     Set<Localidade> remainingHubs, Veiculo veiculo, LocalTime hora, int autonomiaRestante) {
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
                hora = hora.plusMinutes((int) (distancia / (veiculo.getVelocidadeMedia() * 1000 / 60)));
                if (Utils.isBetween(hora, vertex.getTempoInicial(), vertex.getTempoFinal())) {
                    addVertexToList(vertex, visitedVertices, remainingHubs, veiculo, hora, distancia, autonomiaRestante - distancia);
                }
            }
        } else {
            addVertexToList(vertex, visitedVertices, remainingHubs, veiculo, hora, 0, autonomiaRestante);
        }
    }
    private static boolean wasVertexAlreadyVisited(List<PontoPercursoHubs> pontos, Localidade localidade){
        for(PontoPercursoHubs ponto : pontos)
            if(ponto.getLocal().equals(localidade))
                return true;
        return false;
    }
    private static void addVertexToList(Localidade vertex, List<PontoPercursoHubs> visitedVertices, Set<Localidade> remainingHubs,
                                        Veiculo veiculo, LocalTime hora, int distancia, int autonomiaRestante) {
        LocalTime horaFinal = hora;
        if (vertex.isHub() && remainingHubs.contains(vertex)) {
            //System.out.println(vertex);  // Se desejar imprimir apenas hubs
            remainingHubs.remove(vertex);  // Remove o hub da lista de hubs restantes
            horaFinal = hora.plusMinutes((int)veiculo.getTempoMediaDescargaCabazes());
        }

        if(autonomiaRestante < Utils.getBiggestDistance(vertex, Utils.getLocalidadesFromPontosDePercurso(visitedVertices), graph)) {
            autonomiaRestante = (int) veiculo.getAutonomia();
            horaFinal = horaFinal.plusMinutes((int)veiculo.getTempoMediaCarregamentoBateria());
        }

        visitedVertices.add(new PontoPercursoHubs(vertex, hora, horaFinal, distancia));

        currentVertex = vertex;
        List<Localidade> locaisAdjacentes = (List<Localidade>) graph.adjVertices(vertex);
        locaisAdjacentes.sort(cmp);

        for (Localidade neighbor : locaisAdjacentes) {
            int previousSize = visitedVertices.size();
            maximizeHubs(neighbor, visitedVertices, remainingHubs, veiculo, horaFinal, autonomiaRestante);
            if(visitedVertices.size() != previousSize)
                break;
        }
    }
    public static PercursoHubs obterPercursoComMaxNumHubs(Graph<Localidade, Integer> grafo, int n, LocalTime horaInicial,
                                                          Localidade localInicial, Veiculo veiculo){
        Map<CriteriosLocalidade, Localidade> map = ObterHubsController.obterTopNLocalidades(grafo, n);
        for(Map.Entry<CriteriosLocalidade, Localidade> entry : map.entrySet())
            Utils.getLocalidadeById(entry.getValue().getId(), grafo.vertices()).setHub(true);
        List<PontoPercursoHubs> pontos = maximizeHubPath(grafo, localInicial, veiculo, horaInicial);

        return new PercursoHubs(localInicial, pontos.get(pontos.size()-1).getLocal(), horaInicial,
                pontos.get(pontos.size() - 1).getHoraDeSaida(), pontos);
    }
    public static boolean verificarSeLocalidadesTemHorarios(List<Localidade> localidades){
        for(Localidade local : localidades)
            if(local.getTempoInicial() == null || local.getTempoFinal() == null)
                return false;
        return true;
    }
}
