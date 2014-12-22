/**
 * Created by gujd on 2014/12/21.
 */
public class Quick3Way {
    private Quick3Way(){}

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int lt = lo, gt = hi;
        Comparable v = a[lo];

        int i = lo;
        while(i<=gt){
            int cmp = a[i].compareTo(v);
            if (cmp <0) exch(a, lt++, i++);
            else if(cmp > 0) exch(a, i, gt--);
            else      i++;
        }

        sort(a, lo, lt-1);
        sort(a, gt+1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
