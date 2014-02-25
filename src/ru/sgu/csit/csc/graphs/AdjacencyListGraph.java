package ru.sgu.csit.csc.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyListGraph extends BaseGraph {
    private final List<List<Integer>> adjacencyLists;

    public AdjacencyListGraph(int vertexCount, Type type) {
        super(vertexCount, type);
        adjacencyLists = new ArrayList<List<Integer>>();
        for (int i = 0; i < vertexCount; i++) {
            adjacencyLists.add(i, new ArrayList<Integer>());
        }
    }

    public boolean addEdge(int from, int to) {
        if (this.getType() == Type.UNDIRECTED) {
            adjacencyLists.get(to).add(from);
        }
        adjacencyLists.get(from).add(to);
        super.handleAddEdge(from, to);
        return true;
    }

    public Iterable<Integer> getNeighbors(int vertex) {
        return Collections.unmodifiableList(adjacencyLists.get(vertex));
    }
}
