package Interview.kuaishou360tencent20220424.sanliuling;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int n = Integer.valueOf(line1[0]);
        int m = Integer.valueOf(line1[1]);
        int[][] data = new int[m][3];
        String[] line2 = sc.nextLine().split(" ");
        String[] line3 = sc.nextLine().split(" ");
        String[] line4 = sc.nextLine().split(" ");
        for (int i = 0; i < m; i++) {
            data[i][0] = Integer.valueOf(line2[i]);
            data[i][1] = Integer.valueOf(line3[i]);
            data[i][2] = Integer.valueOf(line4[i]);
        }
        System.out.println(minimumCost(n, data));
    }

    private static int minimumCost(int n, int[][] connections) {
        UF uf = new UF(n + 1);
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        int mst = 0;
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (uf.connected(u, v)) {
                continue;
            }
            mst += weight;
            uf.union(u, v);
        }
        return uf.count() == 2 ? mst : -1;
    }



}

class UF {
    private  int count;
    private int[] parent;
    private int[] size;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;

    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int count() {
        return count;
    }
}
