import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

/**
 * Created by gujd on 2014/12/22.
 */
public class SET<Key extends Comparable<Key>> implements Iterable<Key> {
    private TreeSet<Key> set;

    public SET(){
        set = new TreeSet<Key>();
    }

    public void add(Key key){
        if(key == null) throw new  NullPointerException("called add() with a null key");
        set.add(key);
    }

    public boolean contains(Key key){
        if(key == null) throw new  NullPointerException("called add() with a null key");
        return set.contains(key);
    }

    public void delete(Key key){
        if(key == null) throw new  NullPointerException("called add() with a null key");
        set.remove(key);
    }

    public int size(){
        return set.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public Iterator<Key> iterator(){
        return set.iterator();
    }

    public Key max(){
        if(isEmpty()) throw new NoSuchElementException("called max() with empty");
        return set.last();
    }

    public Key min(){
        if(isEmpty()) throw new NoSuchElementException("called max() with empty");
        return set.first();
    }

    public Key ceiling(Key key){
        if(key == null) throw new NullPointerException("called ceiling() with a null key");
        Key k = set.ceiling(key);
        if(k == null)
            throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    public Key floor(Key key){
        if(key == null) throw new NullPointerException("called ceiling() with a null key");
        Key k = set.floor(key);
        if(k == null)
            throw new NoSuchElementException("all keys are greeter than " + key);
        return k;
    }

    public SET<Key> union(SET<Key> that){
        if(that == null) throw new NullPointerException("called union() with a null argumen");
        SET<Key> c = new SET<Key>();
        for(Key x: this) {
            c.add(x);
        }
        for(Key x: that) {
            c.add(x);
        }
        return c;
    }

    public SET<Key> intersects(SET<Key> that){
        if(that == null) throw new NullPointerException("called union() with a null argumen");
        SET<Key> c = new SET<Key>();
        if(this.size() < that.size()){
            for(Key x: this){
                if(that.contains(x))
                    c.add(x);
            }
        } else{
            for(Key x: that){
                if(this.contains(x))
                    c.add(x);
            }
        }
        return c;
    }

    public boolean equals(Object y){
        if(y == this) return true;
        if(y == null) return false;
        if(y.getClass() != this.getClass()) return false;
        SET<Key> that = (SET<Key>)y;
        if(this.size() != that.size()) return false;
        try{
            for(Key k : this){
                if(!that.contains(k))
                    return false;
            }
        }
        catch(ClassCastException exception){
            return false;
        }
        return true;
    }
}
