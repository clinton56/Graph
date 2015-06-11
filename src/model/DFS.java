package model;

import view.GraphView;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by clinton on 10.06.15.
 */
public class DFS {
    GraphModel graph;
    ArrayList<Integer> queue;
    int color[];
    int previous[];
    final int INF;
    int distance[];
    view.mainFrame mf;
    Graphics gr;
    GraphView g;

    void DFSFun(int current) {
        color[current] = 1;
        g.changeVertexColor(graph.vertexObjects[current], "grey");
        waiting();
        for (int j = 0; j < graph.g.get(current).size(); j++) {
            int k = graph.g.get(current).get(j);
            if (color[k] == 0) {
                previous[k] = current;
                DFSFun(k);
            }
        }
        color[current] = 2;
        g.changeVertexColor(graph.vertexObjects[current], "cyan");
        waiting();
    }

    public DFS(Object started, GraphView g, view.mainFrame mf) {
        this.g = g;
        this.mf = mf;
        mf.repaint();
        gr = mf.getGraphics();
        graph = new GraphModel(g);
        graph.changeColorOfAllVertices(g);
        waiting();
        int start = findStarted(started, graph);
        queue = new ArrayList<Integer>();
        color = new int[graph.n + 2];
        previous = new int[graph.n + 2];
        distance = new int[graph.n + 2];
        INF = graph.n + 100;
        for (int i = 0; i < graph.n + 1; i++) {
            distance[i] = INF;
        }

        DFSFun(start);
        for (int i = 0; i < graph.n; i++) {
            if (g.V[i] != null && color[i] == 0) {
                DFSFun(i);
            }
        }
    }

    int findStarted(Object o, GraphModel g) {
        for (int i = 0; i < g.n; i++) {
            if (g.vertexObjects[i] != null && g.vertexObjects[i] == o) {
                return i;
            }
        }
        return -1;
    }

    void waiting() {
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e1){
            e1.printStackTrace();
        }
        mf.revalidate();
        mf.repaint();
        mf.update(gr);
    }
}
