/**
 * Created by gujd on 2014/12/17.
 */
public class Whitelist {
    public static void main(String[] args){
        In in = new In(args[0]);
        int[] white = In.readInts();
        StaticSETofInts set = new StaticSETofInts(white);

        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if (!set.contains(key)){
                StdOut.println(key);
            }
        }
    }
}
