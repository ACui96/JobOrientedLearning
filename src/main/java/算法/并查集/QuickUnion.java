package 算法.并查集;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Acui
 * @date 2022年04月27日 19:44
 */
public class QuickUnion extends UF{

    public QuickUnion(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot != qRoot) {
            id[pRoot] = qRoot;
        }
    }

    public static void main(String[] args) {
        Queue<Object> objects = new ArrayDeque<>();
        Queue<Integer> queue = new LinkedList<>();


    }
}
