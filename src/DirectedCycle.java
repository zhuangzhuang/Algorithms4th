/**
 * Created by fanyou-yufei on 14-12-25.
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTO;
    private boolean[] onStack;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph G){
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTO = new int[G.V()];

        for(int v = 0; v < G.V();v++){
            if(!marked[v])
                dfs(G, v);
        }
    }

    private void dfs(Digraph G, int v){
        onStack[v] = true;
        marked[v] = true;
        for(int w: G.adj(v)){
            if(cycle != null)
                return;

        }
    }
}
