package ru.sgu.csit.csc.graphs;

public abstract class BaseGraph implements Graph {
    private final int vertexCount;
    private final Type type;
    private final int[] neighborCounts;
    private int edgeCount;

    BaseGraph(int vertexCount, Type type) {
        this.vertexCount = vertexCount;
        this.type = type;
        this.edgeCount = 0;
        neighborCounts = new int[vertexCount];
    }

    protected Type getType() {
        return type;
    }

    @Override
    public int getVertexCount() {
        return this.vertexCount;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getEdgeCount() {
        return this.edgeCount;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getNeighborCount(int vertex) {
        return neighborCounts[vertex];
    }

    protected void handleAddEdge(int from, int to) {
        if (type != Type.DIRECTED) {
            if (from == to) {
                throw new IllegalArgumentException("Undirected graph don't allow loops.");
            }
            neighborCounts[to]++;
        }
        neighborCounts[from]++;
        edgeCount++;
    }
}