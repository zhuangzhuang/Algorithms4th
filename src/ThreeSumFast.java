import java.util.Arrays;

/**
 * Created by fanyou-yufei on 14-12-19.
 */
public class ThreeSumFast {
    public static int count(int[] a){
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for(int i = 0; i < N; i++)
            for(int j = i+1; j<N;j++)
            if (BinrySearch.rank(-a[i]-a[j], a) > j)
                cnt++;
        return cnt;
    }
    public static void main(String[] args){
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
