package ru.sgu.csit.csc.graphs.algorithms.impl;

import ru.sgu.csit.csc.graphs.Graph;
import ru.sgu.csit.csc.graphs.algorithms.Bfs;
import ru.sgu.csit.csc.graphs.algorithms.TreePaths;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BfsImpl implements Bfs {

    public TreePaths run(final Graph graph, final int sourceVertex) {
        int[] distance = new int[graph.getVertexCount()];
        int[] parents = new int[graph.getVertexCount()];
        for (int i = 0; i < graph.getVertexCount(); i++) {
            distance[i] = Integer.MAX_VALUE;
            parents[i] = -1;
        }
        distance[sourceVertex] = 0;
        parents[sourceVertex] = sourceVertex;
        Queue<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(sourceVertex);
        while (!linkedList.isEmpty()) {
            int v = linkedList.poll();

            for (Integer u : graph.getNeighbors(v)) {
                if (distance[u] == Integer.MAX_VALUE) {
                    distance[u] = distance[v] + 1;
                    parents[u] = v;
                    linkedList.add(u);
                }
            }
        }
        return new TreePaths(parents,distance) ;
    }
}
