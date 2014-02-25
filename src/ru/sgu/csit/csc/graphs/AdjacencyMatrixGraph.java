package ru.sgu.csit.csc.graphs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AdjacencyMatrixGraph extends BaseGraph {
    private final boolean adjacencyMatrix[][];


    AdjacencyMatrixGraph(int VertexCount, Graph.Type type) {
        super(VertexCount, type);
        this.adjacencyMatrix = new boolean[VertexCount][VertexCount];
    }

    public boolean addEdge(int from, int to) {
        if (adjacencyMatrix[from][to]) {
            return false;
        } else {
            adjacencyMatrix[from][to] = true;
            if (this.getType() == Type.UNDIRECTED) {
                adjacencyMatrix[to][from] = true;
            }
            super.handleAddEdge(from, to);
            return true;
        }
    }


    public Iterable<Integer> getNeighbors(final int vertex) {
        return new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>() {
                    private int currentIndex = 0;
                    private int localIndex = 0;

                    public boolean hasNext() {
                        return currentIndex < getNeighborCount(vertex);
                    }

                    public Integer next() {
                        for (int i = localIndex; i < getVertexCount(); i++) {
                            if (adjacencyMatrix[vertex][i]) {
                                localIndex = i + 1;
                                currentIndex++;
                                return i;
                            }
                        }
                        throw new NoSuchElementException("Iteration has no more elements.");
                    }

                    public void remove() {
                        // TODO Auto-generated method stub
                    }
                };
            }
        };
    }

}


