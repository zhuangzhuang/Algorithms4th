/**
 * Created by fanyou-yufei on 14-12-25.
 */
public class DirectedDFS{
    private boolean[] marked;
    private int count;

    public DirectedDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for(int v: sources){
            if(!marked[v])dfs(G, v);
        }

    }

    public void dfs(Digraph G, int v){
        count++;
        marked[v] = true;
        for(int w: G.adj(v)){
            if(!marked[w])
                dfs(G, w);
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public int count(){
        return count;
    }
}
