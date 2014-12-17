/**
 * Created by fanyou-yufei on 14-12-17.
 */
public class Transaction implements Comparable<Transaction> {
    private final String who;
    private final Date   when;
    private final double amount;

    public Transaction(String who, Date when, double amount){
        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
        this.when = when;
        this.who = who;
        if(amount == 0.0) this.amount = 0.0;
        else this.amount = amount;
    }

    public Transaction(String transcation){
        String[] a = transcation.split("\\s+");
        who = a[0];
        when = new Date(a[1]);
        double value = Double.parseDouble(a[2]);
        if(value == 0.0) amount = 0.0;
        else             amount = value;
        if (Double.isNaN(amount) || Double.isInfinite(amount))
            throw new IllegalArgumentException("Amount cannot be NaN or infinite");
    }

    public String who(){
        return who;
    }

    public Date when(){
        return when;
    }

    public double amount(){
        return amount;
    }


    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31*hash + who.hashCode();
        hash = 31*hash + when.hashCode();
        hash = 31*hash + ((Double) amount).hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object x) {
        if (x == this) return true;
        if (x == null) return false;
        if (x.getClass() != this.getClass()) return false;
        Transaction that = (Transaction) x;

        return (this.amount == that.amount) && (this.who.equals(that.who))
                && (this.when.equals(that.when));
    }

    @Override
    public String toString() {
        return String.format("%-10s %10s %8.2f", who, when, amount);
    }

    @Override
    public int compareTo(Transaction that) {
        if (this.amount < that.amount)     return -1;
        else if(this.amount > that.amount) return +1;
        else                               return  0;
    }
}
