/**
 * Created by fanyou-yufei on 14-12-17.
 */
public class Flips {
    public static void main(String[] args){
        int T = Integer.parseInt("100");
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for(int t = 0; t < T; t++){
            if(StdRandom.bernoulli(0.5))
                heads.increment();
            else
                tails.increment();
        }
        StdOut.println(heads);
        StdOut.println(tails);
        int d = heads.tally() - tails.tally();
        StdOut.println("delta: " + Math.abs(d));
    }
}
