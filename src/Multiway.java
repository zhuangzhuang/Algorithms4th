/**
 * Created by gujd on 2014/12/21.
 */
public class Multiway {
    private Multiway(){}

    private static void merge(In[] streams){
        int N = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<String>(N);
        for(int i = 0; i < N; i++)
            if(!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());

        while (!pq.isEmpty()){
            StdOut.print(pq.minKey() + " ");
            int i = pq.delMin();
            if(!streams[i].isEmpty())
                pq.insert(i, streams[i].readString());
        }
        StdOut.println();
    }

    public static void main(String[] args){
        int N = args.length;
        In[] streams = new In[N];
        for(int i = 0; i < N; i++)
            streams[i] = new In(args[i]);
        merge(streams);
    }
}
