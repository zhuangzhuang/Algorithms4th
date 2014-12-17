/**
 * Created by fanyou-yufei on 14-12-17.
 */
public class Point2D implements Comparable<Point2D>{
    private final double x;
    private final double y;

    public Point2D(double x, double y){
        if(Double.isInfinite(x) || Double.isInfinite(y)){
            throw new IllegalArgumentException("Coordinates must be finite");
        }
        if (Double.isNaN(x) || Double.isNaN(y)){
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        }
        if(x == 0.0)
            x = 0.0;
        if(y == 0.0)
            y = 0.0;
        this.x = x;
        this.y = y;
    }

    public double x(){return x;}

    public double y() {return y;}

    public double r(){
        return Math.sqrt(x*x + y*y);
    }

    public double theta(){
        return Math.atan2(y, x);
    }


    @Override
    public int compareTo(Point2D o) {
        return 0;
    }

    public void draw() {
        StdDraw.point(x, y);
    }
}
