/**
 * Created by fanyou-yufei on 14-12-17.
 */
public class Interval1D {
    private final double left;
    private final double right;

    public Interval1D(double left, double right){
        if (Double.isInfinite(left) || Double.isInfinite(right))
            throw new IllegalArgumentException("Endpoints must be finite");
        if (Double.isNaN(left) || Double.isNaN(right))
            throw new IllegalArgumentException("Endpoints cannot be NaN");

        if(left <= right){
            this.left = left;
            this.right = right;
        }
        else
            throw new IllegalArgumentException("Illegal interval");
    }

    public double left(){
        return left;
    }

    public double right(){
        return right;
    }

    public boolean intersects(Interval1D that){
        if(this.right < that.left) return false;
        if(this.left > that.right) return false;
        return true;
    }

    public boolean contains(double x){
        return (left <= x) && (x <= right);
    }

    public double length(){
        return right - left;
    }

    public String toString(){
        return "[" + left + ", " + right + "]";
    }

    public void draw(){

    }
}

















