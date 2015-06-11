package model;

import view.GraphView;

import java.util.ArrayList;

/**
 * Created by clinton on 10.06.15.
 */
public class BFS {
    GraphModel graph;
    ArrayList<Integer> queue;
    // kolor - 0 - bialy, 1 - szary, 2 - czarny
    int color[];
    // tablica poprzednikow
    int previous[];
    final int INF;
    int distance[];
    BFS(Object started, GraphView g) {
        graph = new GraphModel(g);
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
        color[start] = 2;

        for (int i = 0; i < queue.size(); i++) {
            int current = queue.get(i);
            color[i] = 2;
            g.changeVertexColor(graph.vertexObjects[i], "red");
            for (int j = 0; j < graph.g.get(current).size(); j++) {
                int k = graph.g.get(current).get(j);
                if (color[k] == 0) {
                    color[k] = 1;
                    g.changeVertexColor(graph.vertexObjects[k], "grey");
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
}
