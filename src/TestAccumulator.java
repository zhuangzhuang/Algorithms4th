/**
 * Created by fanyou-yufei on 14-12-17.
 */
public class TestAccumulator {
    public static void main(String[] args){
        int T = 1000;
        Accumulator a = new Accumulator();
        for(int t = 0; t < T; t++){
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);
    }
}
