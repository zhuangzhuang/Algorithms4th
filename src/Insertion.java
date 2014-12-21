import java.util.Comparator;

/**
 * Created by gujd on 2014/12/20.
 */
public class Insertion {
    private Insertion(){}

    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i = 0; i < N; i++){
            for(int j = i; j > 0 && less(a[j], a[j-1]) ;j--){
                exch(a, j, j-1);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    public static void sort(Comparable[] a, Comparator c){
        int N = a.length;
        for(int i = 0; i < N; i++){
            for(int j = i; j > 0 && less(c, a[j], a[j-1]) ;j--){
                exch(a, j, j-1);
            }
            assert isSorted(a, c, 0, i);
        }
        assert isSorted(a, c);
    }


    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static boolean less(Comparator c, Object v, Object w){
        return c.compare(v, w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void show(Comparable[] a){
        for(int i =0; i<a.length; i++){
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length -1);
    }

    public static boolean isSorted(Comparable[] a, int lo, int hi){
        for(int i = lo + 1; i <= hi; i++){
            if (less(a[i], a[i-1]))
                return false;
        }
        return true;
    }

    public static boolean isSorted(Comparable[] a, Comparator c) {
        return isSorted(a, c, 0, a.length -1);
    }

    public static boolean isSorted(Comparable[] a,Comparator c, int lo, int hi){
        for(int i = lo + 1; i <= hi; i++){
            if (less(c, a[i], a[i-1]))
                return false;
        }
        return true;
    }
}
