package ru.sgu.csit.csc.graphs.algorithms;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class TreePaths {
    private int parents[];
    private int distance[];

    public TreePaths(int parents[], int distance[]) {
        this.parents = parents;
        this.distance = distance;
    }

    public int getVertexCount() {
        return parents.length;
    }

    public int getDistance(int vertex) {
        return distance[vertex];
    }

    public int getPreviousVertex(int vertex) {
        return parents[vertex];
    }

    public List<Integer> getPath(int targetVertex) {
        List<Integer> list = new ArrayList<Integer>();
        int vertex = targetVertex;
        list.add(vertex);
        while (parents[vertex] != vertex) {
            vertex = parents[vertex];
            list.add(vertex);
        }
        Collections.reverse(list);
        return list;
    }
}
