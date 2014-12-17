/**
 * Created by gujd on 2014/12/17.
 */
public class Stats {
    public static void main(String[] args){
        Bag<Double> number = new Bag<Double>();

        while (!StdIn.isEmpty()){
            number.add(StdIn.readDouble());
        }
        int N = number.size();

        double sum = 0.0;
        for(double x: number)
            sum += x;
        double mean = sum / N;

        sum = 0.0;
        for(double x: number)
            sum += (x-mean)*(x-mean);
        double std = Math.sqrt(sum/(N-1));

        StdOut.printf("Mean: %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
