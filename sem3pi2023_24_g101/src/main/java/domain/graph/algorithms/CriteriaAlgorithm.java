package domain.graph.algorithms;

import domain.Localidade;
import domain.graph.Edge;
import domain.graph.Graph;
import utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class CriteriaAlgorithm {

    private CriteriaAlgorithm() {

    }
    public static int getInfluencia(Graph<Localidade, Integer> grafo, Localidade local){
        return grafo.outDegree(local) + grafo.inDegree(local);
    }
    public static int getProximidade(Graph<Localidade, Integer> grafo, Localidade local){
        int proximidade = 0;
        List<Localidade> vertices = grafo.vertices();
        for (int i = 0; i < vertices.size() - 1; i++)
            if(!vertices.get(i).equals(local)) {
                double shortestDifference = Double.MAX_VALUE;
                Localidade shortestDifferenceLocalidade = null;
                for(int j = i + 1; j < vertices.size(); j++){
                    double difference = Utils.haversineDistance(vertices.get(i).getCoords(), vertices.get(j).getCoords());
                    if(difference < shortestDifference || (difference <= shortestDifference && Objects.equals(shortestDifferenceLocalidade, local))){
                        shortestDifference = difference;
                        shortestDifferenceLocalidade = vertices.get(j);
                    }
                }
                if(shortestDifferenceLocalidade.equals(local))
                    proximidade++;
            }
        return proximidade;
    }
    public static int getCentralidade(Localidade local, LinkedList<Localidade>[][] listaDeCaminhosMaisCurtos){
        int centralidade = 0;
        for(int i = 0; i < listaDeCaminhosMaisCurtos.length - 1; i++)
            for(int j = i + 1; j < listaDeCaminhosMaisCurtos[i].length; j++)
                if(listaDeCaminhosMaisCurtos[i][j].contains(local))
                    centralidade++;
        return centralidade;
    }
    //public static List<Edge<Localidade, Integer>> getAllShortestPathsBetweenTwoPoints(Graph<Localidade, Integer> grafo){

    //}
}
