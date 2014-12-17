/**
 * Created by fanyou-yufei on 14-12-17.
 */
public class Home1 {

    public static String exR1(int n){
        if(n <= 0) return "";
        return exR1(n-3) + n + exR1(n-2)+n;
    }

    public static void main(String[] args) {
//        int[] a = new int[10];
//        for(int i = 0; i < 10; i++){
//            a[i] = 9 - i;
//        }
//        for(int i = 0; i < 10; i++){
//            a[i] = a[a[i]];
//        }
//        for(int i = 0; i < 10; i++){
//            System.out.println(a[i]);
//        }





        System.out.println(exR1(5));

//        int f = 0;
//        int g = 1;
//        for(int i = 0; i <= 15; i++){
//            StdOut.println(f);
//            f = f + g;
//            g = f - g;
//        }
    }
}
