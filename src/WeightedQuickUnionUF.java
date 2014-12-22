/**
 * Created by gujd on 2014/12/19.
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private byte[] rank;
    private int count;

    public WeightedQuickUnionUF(int N){
        count = N;
        id = new int[N];
        rank = new byte[N];
        for(int i =0 ; i < N; i++) {
            id[i] = i;
            rank[i] = 0;
        }
    }

    public int count(){
        return count;
    }

    public int find(int p){
        while (p != id[p])
            p = id[p];
        return p;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP == rootQ) return;

        if (rank[rootP] < rank[rootQ]) id[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) id[rootQ] = rootP;
        else {
            id[rootP] = rootQ;
            id[rootQ]++;
        }
        count--;
    }
}
