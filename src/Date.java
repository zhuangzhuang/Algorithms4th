/**
 * Created by fanyou-yufei on 14-12-17.
 */
public class Date implements Comparable<Date>{

    private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private final int month;
    private final int day;
    private final int year;


    public Date(int month, int day, int year){
        if (!isValid(month, day, year))
            throw new IllegalArgumentException("Invalid date");
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public Date(String date){
        String[] fields = date.split("/");
        if(fields.length !=3 ){
            throw new IllegalArgumentException("Invalid date");
        }
        month = Integer.parseInt(fields[0]);
        day = Integer.parseInt(fields[1]);
        year = Integer.parseInt(fields[2]);
        if (!isValid(month, day, year))
            throw new IllegalArgumentException("Invalid date");
    }

    private static boolean isValid(int m, int d, int y) {
        if (m < 1 || m > 12)      return false;
        if (d < 1 || d > DAYS[m]) return false;
        if (m == 2 && d == 29 && !isLeapYear(y)) return false;
        return true;
    }

    private static boolean isLeapYear(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }

    public int month(){
        return month;
    }
    public int day(){
        return day;
    }

    public int year(){
        return year;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/"+year;
    }

    @Override
    public boolean equals(Object x) {
        if (x == this) return true;
        if (x == null) return false;
        if(x.getClass() != this.getClass())
            return false;
        Date that = (Date)x;
        return (this.month == that.month) && (this.day == that.day) && (this.year == that.year);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31*hash + month;
        hash = 31*hash + day;
        hash = 31*hash + year;
        return hash;
    }

    @Override
    public int compareTo(Date that) {
        if (this.year  < that.year)  return -1;
        if (this.year  > that.year)  return +1;
        if (this.month < that.month) return -1;
        if (this.month > that.month) return +1;
        if (this.day   < that.day)   return -1;
        if (this.day   > that.day)   return +1;
        return 0;
    }
}
