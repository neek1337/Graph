package ru.sgu.csit.csc.graphs;


import ru.sgu.csit.csc.graphs.algorithms.TreePaths;
import ru.sgu.csit.csc.graphs.algorithms.impl.Bfsimpl;

/**
 * Created by neek on 16.02.14.
 */
public class Test {
    public static void main(String[] args) {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(4, Graph.Type.UNDIRECTED);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 1);
        System.out.println(graph.getEdgeCount() + " " + graph.getVertexCount());
        System.out.println(graph.getNeighborCount(0));
        System.out.print("0's neighbors: ");
        for (Integer it : graph.getNeighbors(0)) {
            System.out.print(it + " ");
        }
        System.out.println();
        TreePaths treePaths = new Bfsimpl().run(graph, 0);
        System.out.println();
        for (Integer it : treePaths.getPath(1)) {
            System.out.print(it + " ");
        }
    }
}


