package 算法.并查集;

/**
 * @author Acui
 * @date 2022年04月27日 19:47
 */
public class WeightedQuickUnion extends UF{
    private int[] sz;
    public WeightedQuickUnion(int N) {
        super(N);
        this.sz = new int[N];
        for (int i = 0; i < N; i++) {
            this.sz[i] = 1;
        }
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
        int i = find(p);
        int j = find(q);

        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[j];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
