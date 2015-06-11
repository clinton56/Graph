package model;

import com.mxgraph.model.mxCell;
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
        //System.out.println("Wprowadz ilosc wierzcholkow");
        n = graph.listVertex.size();
        g = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n + 2; i++) {
            g.add(new ArrayList<Integer>());
        }
        //m = graph.getAllEdges().length
        vertexObjects = graph.V;
        boolean[][] graphMatrix = graph.neighbours;
        System.out.println("Macierz kurwa chuj: \n");
        for (int i = 0; i < graphMatrix.length; i++) {
            for (int j = 0; j < graphMatrix[i].length; j++) {
                System.out.print(graphMatrix[i][j] + "   ");
                if (graphMatrix[i][j]) {
                    g.get(i).add(j);
                }
            }
            System.out.print("\n");
        }
        //     for (int i = 0; i < m)
        //   int x = reader.nextInt();
        //   int y = reader.nextInt();
        //  // graf nieskierowany
        //  g.get(x).add(y);
        // g.get(y).add(x);
    }

    void changeColorOfAllVertices(GraphView graphView) {
        for (int i = 0; i < vertexObjects.length; i++) {
            graphView.changeVertexColor(this.vertexObjects[i], "white");
        }
    }
}
