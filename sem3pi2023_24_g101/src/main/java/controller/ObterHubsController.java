package controller;

import domain.CriteriosLocalidade;
import domain.Localidade;
import domain.graph.Graph;
import domain.graph.algorithms.CriteriaAlgorithm;
import domain.graph.algorithms.ShortestPathMapGraph;

import java.util.*;

public class ObterHubsController {
    public static Map<CriteriosLocalidade, Localidade> obterTopNLocalidades(Graph<Localidade, Integer> grafo, int n){
        List<Localidade> localidades = grafo.vertices();
        Comparator<CriteriosLocalidade> cmp = (o1, o2) -> {
            int centralidadeDiff = o2.getCentralidade() - o1.getCentralidade();
            if(centralidadeDiff != 0)
                return centralidadeDiff;
            else
                return o2.getInfluencia() - o1.getInfluencia();
        };
        Map<CriteriosLocalidade, Localidade> map = new TreeMap<>(cmp);
        ShortestPathMapGraph<Localidade, Integer> spmg = new ShortestPathMapGraph<>();
        LinkedList<Localidade>[][] listaDeCaminhosCurtos = spmg.giveListOfShortestPaths(grafo);
        for(Localidade localidade : localidades){
            map.put(new CriteriosLocalidade(CriteriaAlgorithm.getInfluencia(grafo,localidade),
                    CriteriaAlgorithm.getProximidade(grafo,localidade),
                    CriteriaAlgorithm.getCentralidade(localidade, listaDeCaminhosCurtos)), localidade);
        }
        if(n > map.size())
            n = map.size();
        Iterator<Map.Entry<CriteriosLocalidade, Localidade>> iterator = map.entrySet().iterator();
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            if (count >= n) {
                iterator.remove();
            }
            count++;
        }
        return map;
    }
}
