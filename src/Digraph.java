import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * Created by fanyou-yufei on 14-12-25.
 */
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V){
        if(V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V =V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Object[V];
        for(int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }

    public Digraph(In in){
        try{
            this.V = in.readInt();
            if(V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
            adj = (Bag<Integer>[]) new Object[V];
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("Number of edges in a Digraph must be nonnegative");
            for(int i = 0; i < E; i++){
                int v = in.readInt();
                int w = in.readInt();
                addEdge(v, w);
            }
        }catch (NoSuchElementException e){
            throw new InputMismatchException("Invalid input format in Digraph constructor");
        }
    }
    public Digraph(Digraph G){
        this(G.V());
        this.E = G.E();
        for(int v = 0; v < G.V(); v++){
            Stack<Integer> reverse = new Stack<Integer>();
            for(int w : G.adj[v]){
                reverse.push(w);
            }

            for(int w: reverse){
                adj[v].add(w);
            }
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    private void validateVertex(int v){
        if(v <0 || v>=V){
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }

    public void addEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }

    public int outdegree(int v){
        validateVertex(v);
        return adj[v].size();
    }

    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for(int v = 0; v < V; v++){
            for(int w : adj(v)){
                R.addEdge(w, v);
            }
        }
        return R;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

}
