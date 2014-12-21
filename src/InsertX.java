/**
 * Created by gujd on 2014/12/21.
 */
public class InsertX {
    private InsertX(){}

    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i = N-1; i > 0; i--)
            if (less(a[i], a[i-1]))
                exch(a, i, i-1);

        for(int i = 2; i < N; i++){
            Comparable v = a[i];
            int j = i;
            while(less(v, a[j-1])){
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
        }
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
