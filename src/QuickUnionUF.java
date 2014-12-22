/**
 * Created by gujd on 2014/12/19.
 */
public class QuickUnionUF {
    private int[] id;
    private int count;

    public QuickUnionUF(int N){
        count = N;
        id = new int[N];
        for(int i =0 ; i < N; i++)
            id[i] = i;
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
        id[rootP] = rootQ;
        count--;
    }
}
