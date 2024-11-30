package domain.graph.algorithms;

import domain.graph.Edge;
import domain.graph.Graph;
import domain.graph.map.MapGraph;

import java.util.*;

public class Kruskal {

    /**
     * Kruskal's algorithm for finding the minimum spanning tree of a connected graph.
     *
     * @param grafo Graph instance
     * @param ce comparator between elements of type E
     * @return a Collection of Edges forming the minimum spanning tree
     */
    public static <V,E> Graph<V,E> kruskall (Graph<V,E> grafo, Comparator <Edge<V,E>> ce) {
       Graph <V,E> mst = new MapGraph<>(false);

        for (V vertex: grafo.vertices())
            mst.addVertex(vertex);

        List<Edge<V, E>> edgesList = new ArrayList<>(grafo.edges());
        edgesList.sort(ce);

        for (Edge < V,E > edge: edgesList) {
            LinkedList <V> connectedVerts = Algorithms.DepthFirstSearch(mst,edge.getVOrig());
            if (!connectedVerts.contains(edge.getVDest()))
                mst.addEdge(edge.getVOrig(), edge.getVDest(), edge.getWeight());
        }
        return mst;
   }

}
