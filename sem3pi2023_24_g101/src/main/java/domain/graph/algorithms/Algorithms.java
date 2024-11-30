package domain.graph.algorithms;

import domain.graph.matrix.MatrixGraph;
import domain.graph.Edge;
import domain.graph.Graph;

import java.util.*;
import java.util.function.BinaryOperator;

/**
 *
 * @author DEI-ISEP
 *
 */
public class Algorithms {

    /** Performs breadth-first search of a Graph starting in a vertex
     *
     * @param g Graph instance
     * @param vert vertex that will be the source of the search
     * @return a LinkedList with the vertices of breadth-first search
     */
    public static <V, E> LinkedList<V> BreadthFirstSearch(Graph<V, E> g, V vert) {
        if(g.key(vert) == -1)
            return null;
        LinkedList<V> qbfs = new LinkedList<>();
        LinkedList<V> qaux = new LinkedList<>();
        qbfs.add(vert); qaux.add(vert);

        boolean[] visited = new boolean[g.numVertices()];
        visited[g.key(vert)] = true;
        while(!(qaux.isEmpty())){
            V currentVertex = qaux.removeFirst();
            for(V vAdj : g.adjVertices(currentVertex))
                if(!visited[g.key(vAdj)]){
                    qbfs.add(vAdj);
                    qaux.add(vAdj);
                    visited[g.key(vAdj)] = true;
                }
        }
        return qbfs;
    }

    /** Performs depth-first search starting in a vertex
     *
     * @param g Graph instance
     * @param vOrig vertex of graph g that will be the source of the search
     * @param visited set of previously visited vertices
     * @param qdfs return LinkedList with vertices of depth-first search
     */
    private static <V, E> LinkedList<V> DepthFirstSearch(Graph<V, E> g, V vOrig, boolean[] visited, LinkedList<V> qdfs) {
        if(g.key(vOrig) == -1){
            return null;
        }
        if(!visited[g.key(vOrig)]) {
            qdfs.add(vOrig);
            visited[g.key(vOrig)] = true;

            for (V vAdj : g.adjVertices(vOrig))
                DepthFirstSearch(g, vAdj, visited, qdfs);
        }
        return qdfs;
    }

    /** Performs depth-first search starting in a vertex
     *
     * @param g Graph instance
     * @param vert vertex of graph g that will be the source of the search

     * @return a LinkedList with the vertices of depth-first search
     */
    public static <V, E> LinkedList<V> DepthFirstSearch(Graph<V, E> g, V vert) {
        boolean[] visited = new boolean[g.numVertices()];
        return DepthFirstSearch(g, vert, visited, new LinkedList<>());
    }

    /** Returns all paths from vOrig to vDest
     *
     * @param g       Graph instance
     * @param vOrig   Vertex that will be the source of the path
     * @param vDest   Vertex that will be the end of the path
     * @param visited set of discovered vertices
     * @param path    stack with vertices of the current path (the path is in reverse order)
     * @param paths   ArrayList with all the paths (in correct order)
     */
    private static <V, E> void allPaths(Graph<V, E> g, V vOrig, V vDest, boolean[] visited,
                                        LinkedList<V> path, ArrayList<LinkedList<V>> paths) {
        path.push(vOrig);
        visited[g.key(vOrig)] = true;
        for(V vAdj : g.adjVertices(vOrig)){
            if(vAdj == vDest){
                path.push(vDest);
                paths.add(path);
                path.pop();
            } else if (!visited[g.key(vAdj)]) {
                allPaths(g, vAdj, vDest, visited, path, paths);
            }
        }
        path.pop();
    }

    /** Returns all paths from vOrig to vDest
     *
     * @param g     Graph instance
     * @param vOrig information of the Vertex origin
     * @param vDest information of the Vertex destination
     * @return paths ArrayList with all paths from vOrig to vDest
     */
    public static <V, E> ArrayList<LinkedList<V>> allPaths(Graph<V, E> g, V vOrig, V vDest) {
        ArrayList<LinkedList<V>> paths = new ArrayList<>();
        LinkedList<V> onePath = new LinkedList<>();
        boolean[] visited = new boolean[g.numVertices()];
        allPaths(g, vOrig, vDest, visited, onePath, paths);
        return paths;
    }

    /**
     * Computes shortest-path distance from a source vertex to all reachable
     * vertices of a graph g with non-negative edge weights
     * This implementation uses Dijkstra's algorithm
     *
     * @param g        Graph instance
     * @param vOrig    Vertex that will be the source of the path
     * @param visited  set of previously visited vertices
     * @param pathKeys minimum path vertices keys
     * @param dist     minimum distances
     */
    private static <V, E> void shortestPathDijkstra(Graph<V, E> g, V vOrig,
                                                    Comparator<E> ce, BinaryOperator<E> sum, E zero,
                                                    boolean[] visited, V [] pathKeys, E [] dist) {
        for(V vert : g.vertices()){
            int key = g.key(vert);
            dist[key] = null;
            pathKeys[key] = null;
            visited[key] = false;
        }
        dist[g.key(vOrig)] = zero;
        while(g.key(vOrig) != -1){
            visited[g.key(vOrig)] = true;
            for(V vAdj : g.adjVertices(vOrig)){
                Edge<V,E> edge = g.edge(vOrig, vAdj);
                if(!visited[g.key(vAdj)] && (dist[g.key(vAdj)] == null || ce.compare(dist[g.key(vAdj)], sum.apply(dist[g.key(vOrig)], edge.getWeight())) > 0)){
                    dist[g.key(vAdj)] = sum.apply(dist[g.key(vOrig)], edge.getWeight());
                    pathKeys[g.key(vAdj)] = vOrig;
                }
            }
            vOrig = getVertMinDist(g, dist, visited, ce);
        }
    }

    /**
     * Gets the vertex whose dist index is the littlest of all the dist array
     * @param g         Graph distance
     * @param dist     minimum distances
     * @param visited  set of previously visited vertices
     * @return          vertex with minimum distance
     */
    private static <V, E> V getVertMinDist(Graph<V, E> g, E[] dist, boolean[] visited, Comparator<E> ce){
        E minDist = null;
        V minDistVert = null;
        for(V vert : g.vertices()){
            int key = g.key(vert);
            if(!visited[key] && (minDist == null || ce.compare(dist[key], minDist) < 0)){
                minDist = dist[key];
                minDistVert = vert;
            }
        }
        return minDistVert;
    }

    /** Shortest-path between two vertices
     *
     * @param g graph
     * @param vOrig origin vertex
     * @param vDest destination vertex
     * @param ce comparator between elements of type E
     * @param sum sum two elements of type E
     * @param zero neutral element of the sum in elements of type E
     * @param shortPath returns the vertices which make the shortest path
     * @return if vertices exist in the graph and are connected, true, false otherwise
     */
    public static <V, E> E shortestPath(Graph<V, E> g, V vOrig, V vDest,
                                        Comparator<E> ce, BinaryOperator<E> sum, E zero,
                                        LinkedList<V> shortPath) {
        return null;
    }

    /** Shortest-path between a vertex and all other vertices
     *
     * @param g graph
     * @param vOrig start vertex
     * @param ce comparator between elements of type E
     * @param sum sum two elements of type E
     * @param zero neutral element of the sum in elements of type E
     * @param paths returns all the minimum paths
     * @param dists returns the corresponding minimum distances
     * @return if vOrig exists in the graph true, false otherwise
     */
    public static <V, E> boolean shortestPaths(Graph<V, E> g, V vOrig,
                                               Comparator<E> ce, BinaryOperator<E> sum, E zero,
                                               ArrayList<LinkedList<V>> paths, ArrayList<E> dists) {
        if(g.key(vOrig) == -1)
            return false;

        for(V vert : g.vertices())
            if(!vOrig.equals(vert)) {
                LinkedList<V> path = new LinkedList<>();
                shortestPath(g, vOrig, vert, ce, sum, zero, path);
                paths.add(path);
            }
        return true;
    }

}