/**
 * Created by fanyou-yufei on 14-12-17.
 */
public class Interval2D {
    private final Interval1D x;
    private final Interval1D y;

    public Interval2D(Interval1D x, Interval1D y){
        this.x = x;
        this.y = y;
    }

    public boolean intersects(Interval2D that){
        if (!this.x.intersects(that.x)) return false;
        if (!this.y.intersects(that.y)) return false;
        return true;
    }

    public boolean contains(Point2D p){
        return x.contains(p.x()) && y.contains(p.y());
    }

    public double area(){
        return x.length() + y.length();
    }

    public String toString(){
        return x + " x " + y;
    }

    public void draw(){
        double xc = (x.left() + x.right()) / 2.0;
        double yc = (y.left() + y.right()) / 2.0;
        StdDraw.rectangle(xc, yc, x.length() / 2.0, y.length()/2);
    }

    public static void main(String[] args){
        double xlo = 0.2;
        double xhi = 0.5;
        double ylo = 0.5;
        double yhi = 0.6;
        int T = 10000;

        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();

        Counter c = new Counter("hits");
        for(int t = 0; t < T; t++){
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            if (box.contains(p)) c.increment();
            else                 p.draw();
        }
        StdOut.println(c);
        StdOut.println(box.area());
    }
}
