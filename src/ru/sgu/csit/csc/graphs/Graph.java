package ru.sgu.csit.csc.graphs;

public interface Graph {
    int getVertexCount();
    int getEdgeCount();

    boolean addEdge(int from, int to);

    int getNeighborCount(int vertex);
    Iterable<Integer> getNeighbors(int vertex);

   enum Type{
       DIRECTED,
       UNDIRECTED
   }
}
