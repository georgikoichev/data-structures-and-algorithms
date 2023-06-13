package nonLinearStructures;

import java.util.*;

public class Graph<T> {
    private T[] el;
    private int[][] graf;
    private Map<T,Integer> mapEl;
    private boolean dir;
    private boolean weight;

    public Graph(Collection<T> el) {
        this.el=(T[])el.toArray();
        graf=new int[el.size()][el.size()];
        mapEl=new HashMap<>();
        int i=0;
        for (T t : this.el) {
            mapEl.put(t, i);
            i++;
        }
    }
    public Graph(Collection<T> el, boolean dir, boolean weight) {
        this.el=(T[])el.toArray();
        graf=new int[el.size()][el.size()];
        int i=0;
        mapEl=new HashMap();
        for (T t : el) {
            mapEl.put(t, i);
            i++;
        }
        this.dir=dir;
        this.weight=weight;
        if(weight)
            for (i = 0; i < graf.length; i++)
                for (int j = 0; j < graf.length; j++)
                    graf[i][j]=-1;
    }

    public void addConnection(T sor, T des, int weight) {
        if(mapEl.containsKey(sor) && mapEl.containsKey(des)) {
            graf[mapEl.get(sor)][mapEl.get(des)]=(this.weight)?weight:1;
            if(!this.dir)
                graf[mapEl.get(des)][mapEl.get(sor)]=(this.weight)?weight:1;
        }else {
            System.out.println("Elements not in the graf.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("   ");
        int i=0;
        for (T t : el) {
            sb.append(i+"  ");
            i++;
        }
        sb.append('\n');
        i=0;
        for (T t : el) {
            sb.append(String.format("%d:%s\n", i,Arrays.toString(graf[i])));
            i++;
        }
        i=0;
        for (T t : el) {
            sb.append(String.format("%d - %s\n", i,el[i]));
            i++;
        }
        return sb.toString();
    }
    public void depthFirstSearch(T start) {
        boolean[] visited = new boolean[el.length];
        int startIndex = mapEl.get(start);
        dfsHelper(startIndex, visited);
    }

    private void dfsHelper(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(el[vertex]);

        for (int i = 0; i < graf.length; i++) {
            if (graf[vertex][i] != 0 && !visited[i]) {
                dfsHelper(i, visited);
            }
        }
    }

    public void dfs(T start) {
        boolean[] visited = new boolean[el.length];
        int startIndex = mapEl.get(start);

        int[] stack = new int[el.length];
        int top = -1;
        stack[++top] = startIndex;

        while (top >= 0) {
            int vertex = stack[top--];
            if (!visited[vertex]) {
                visited[vertex] = true;
                System.out.println(el[vertex]);

                int[] unvisitedNeighbors = new int[el.length];
                int neighborCount = 0;

                for (int i = 0; i < graf.length; i++) {
                    if (graf[vertex][i] != 0 && !visited[i]) {
                        unvisitedNeighbors[neighborCount++] = i;
                    }
                }

                for (int i = neighborCount - 1; i >= 0; i--) {
                    stack[++top] = unvisitedNeighbors[i];
                }
            }
        }
    }
}
