package domain.graph.algorithms;

import domain.graph.Edge;
import domain.graph.Graph;

import java.util.*;

public final class ShortestPathMapGraph<V, E> {

    public List<Edge<V, E>> getShortestPath(Graph<V, E> graph, V origin, V destination) {
        // Step 1: Initialize data structures
        Map<V, Integer> weights = new HashMap<>(); // Change the data type to Integer
        Map<V, V> previousVertices = new HashMap<>();
        PriorityQueue<V> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(weights::get)); // Change to comparingInt

        for (V vertex : graph.vertices()) {
            weights.put(vertex, Integer.MAX_VALUE); // Change to Integer.MAX_VALUE
            previousVertices.put(vertex, null);
        }

        // Step 2: Set the distance of the origin vertex to 0
        weights.put(origin, 0);
        priorityQueue.add(origin);

        // Step 3: Relax edges until the destination vertex is reached
        while (!priorityQueue.isEmpty()) {
            V currentVertex = priorityQueue.poll();

            for (Edge<V, E> edge : graph.outgoingEdges(currentVertex)) {
                V neighbor = edge.getVDest();
                int newDistance = weights.get(currentVertex) + getEdgeWeight(graph, currentVertex, neighbor); // Change to int

                if (newDistance < weights.get(neighbor)) {
                    weights.put(neighbor, newDistance);
                    previousVertices.put(neighbor, currentVertex);
                    priorityQueue.add(neighbor);
                }
            }
        }

        // Step 4: Build the path from destination to origin
        List<Edge<V, E>> shortestPath = new ArrayList<>();
        V currentVertex = destination;

        while (previousVertices.get(currentVertex) != null) {
            V previousVertex = previousVertices.get(currentVertex);
            Edge<V, E> edge = graph.edge(previousVertex, currentVertex);
            shortestPath.add(0, edge); // Add to the beginning of the list to maintain order
            currentVertex = previousVertex;
        }

        return shortestPath;
    }
    public LinkedList<V> getShortestPathLinkedList(Graph<V, E> graph, V origin, V destination) {
        // Step 1: Initialize data structures
        Map<V, Integer> weights = new HashMap<>(); // Change the data type to Integer
        Map<V, V> previousVertices = new HashMap<>();
        PriorityQueue<V> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(weights::get)); // Change to comparingInt

        for (V vertex : graph.vertices()) {
            weights.put(vertex, Integer.MAX_VALUE); // Change to Integer.MAX_VALUE
            previousVertices.put(vertex, null);
        }

        // Step 2: Set the distance of the origin vertex to 0
        weights.put(origin, 0);
        priorityQueue.add(origin);

        // Step 3: Relax edges until the destination vertex is reached
        while (!priorityQueue.isEmpty()) {
            V currentVertex = priorityQueue.poll();

            for (Edge<V, E> edge : graph.outgoingEdges(currentVertex)) {
                V neighbor = edge.getVDest();
                int newDistance = weights.get(currentVertex) + getEdgeWeight(graph, currentVertex, neighbor); // Change to int

                if (newDistance < weights.get(neighbor)) {
                    weights.put(neighbor, newDistance);
                    previousVertices.put(neighbor, currentVertex);
                    priorityQueue.add(neighbor);
                }
            }
        }

        // Step 4: Build the path from destination to origin
        LinkedList<V> shortestPath = new LinkedList<>();
        V currentVertex = destination;
        shortestPath.add(0, currentVertex);
        while (previousVertices.get(currentVertex) != null) {
            V previousVertex = previousVertices.get(currentVertex);
            shortestPath.add(0, previousVertex); // Add to the beginning of the list to maintain order
            currentVertex = previousVertex;
        }

        return shortestPath;
    }
    public LinkedList<V>[][] giveListOfShortestPaths(Graph<V,E> graph){
        List<V> localidades = graph.vertices();
        int listSize = localidades.size();
        LinkedList<V>[][] listOfShortestPaths = new LinkedList[listSize][listSize];
        for(int i = 0; i < listSize - 1; i++)
            for(int j = i + 1; j < listSize; j++)
                listOfShortestPaths[i][j] = getShortestPathLinkedList(graph, localidades.get(i), localidades.get(j));
        return listOfShortestPaths;
    }
    private int getEdgeWeight(Graph<V, E> graph, V source, V destination) { // Change the return type to int
        Edge<V, E> edge = graph.edge(source, destination);
        return (edge != null) ? (int) edge.getWeight() : Integer.MAX_VALUE; // Change to int and Integer.MAX_VALUE
    }
}
