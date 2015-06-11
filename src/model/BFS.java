package model;

import view.GraphView;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by clinton on 10.06.15.
 */
public class BFS {
    GraphModel graph;
    ArrayList<Integer> queue;
    int color[];
    int previous[];
    final int INF;
    int distance[];
    view.mainFrame mf;
    Graphics gr;
    public BFS(Object started, GraphView g, view.mainFrame mf) {

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
        queue.add(start);
        for (int i = 0; i < graph.n + 1; i++) {
            distance[i] = INF;
        }

        for (int i = 0; i < queue.size(); i++) {
            int current = queue.get(i);
            color[current] = 2;
            g.changeVertexColor(graph.vertexObjects[current], "cyan");
            waiting();
            for (int j = 0; j < graph.g.get(current).size(); j++) {
                int k = graph.g.get(current).get(j);
                if (color[k] == 0) {
                    color[k] = 1;
                    g.changeVertexColor(graph.vertexObjects[k], "grey");
                    waiting();
                    distance[k] = distance[current] + 1;
                    previous[k] = current;
                    queue.add(k);
                }
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
