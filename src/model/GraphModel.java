package model;

import view.GraphView;

import java.util.ArrayList;

/**
 * Created by smerf on 11.06.15.
 */
public class GraphModel {
    int n, m;
    ArrayList<ArrayList<Integer>> g;
    Object[] vertexObjects;

    public GraphModel(GraphView graph) {
        n = graph.listVertex.size();
        g = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n + 2; i++) {
            g.add(new ArrayList<Integer>());
        }
        vertexObjects = graph.V;
        boolean[][] graphMatrix = graph.neighbours;
        for (int i = 0; i < graphMatrix.length; i++) {
            for (int j = 0; j < graphMatrix[i].length; j++) {
                if (graphMatrix[i][j]) {
                    g.get(i).add(j);
                }
            }
            System.out.print("\n");
        }
    }

    void changeColorOfAllVertices(GraphView graphView) {
        for (int i = 0; i < vertexObjects.length; i++) {
            graphView.changeVertexColor(this.vertexObjects[i], "white");
        }
    }
}
