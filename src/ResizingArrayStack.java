import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by gujd on 2014/12/18.
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] a;
    private int N;

    public ResizingArrayStack(){
        a = (Item[]) new Object[2];
        N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    private void resize(int capacity){
        assert capacity >= N;
        Item[] temp = (Item[])new Object[capacity];
        for(int i = 0; i < N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item){
        if(N == a.length) resize(2*a.length);
        a[N++] = item;
    }

    public Item pop(){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[N-1];
        a[N-1] = null;
        N--;
        if(N > 0 && N == a.length/4) resize(a.length/2);
        return item;
    }

    public Item peek(){
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[N-1];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i;
        public ReverseArrayIterator(){
            i = N;
        }
        public boolean hasNext(){
            return i > 0;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }

        public Item next(){
            if(!hasNext()) throw new NoSuchElementException();
            return a[--i];
        }
    }

}
