package Interview.NetEasy20220421;

import java.sql.Statement;
import java.util.*;

public class Q3 {

    static class State {
        int id;
        int distFromStart;

        State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] data = new int[m][3];
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            data[i][0]=from;
            data[i][1] = to;
            data[i][2] = weight;
        }
        func(data, n, m);
    }

    private static void func(int[][] data, int n, int m) {
        LinkedList<int[]>[] graph = new LinkedList[n + 1];
        int minP = Integer.MAX_VALUE;
        for (int j = 1; j <= m; j++) {
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            int[] addEdge = data[j - 1];
            int f = addEdge[1];
            int t = addEdge[0];
            int w = addEdge[2];
            graph[f].add(new int[]{t, w});
            for (int[] edge : data) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                graph[from].add(new int[]{to, weight});
            }
            int[] distTo = dijkstra(1, graph);
            minP = Math.min(minP, distTo[n]);
        }
        if (minP == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minP);
        }
    }

    private static int[] dijkstra(int start, LinkedList<int[]>[] graph) {
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        Queue<State> pq = new PriorityQueue<>((a, b) ->{
            return a.distFromStart - b.distFromStart;
        });
        pq.offer(new State(start,0));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;
            if (curDistFromStart > distTo[curNodeID]) {
                continue;
            }
            for (int[] neighbor : graph[curNodeID]) {
                int nextNodeID = neighbor[0];
                int distToNextNode = distTo[curNodeID] + neighbor[1];
                if (distTo[nextNodeID] > distToNextNode) {
                    distTo[nextNodeID] = distToNextNode;
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }

        return distTo;
    }

}
