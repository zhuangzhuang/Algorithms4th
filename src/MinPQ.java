import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by gujd on 2014/12/21.
 */
public class MinPQ<Key>  implements Iterable<Key>{
    private Key[] pq;
    private int N;
    private Comparator<Key> comparator;

    public MinPQ(int initCapacity){
        pq = (Key[])new Object[initCapacity+1];
        N = 0;
    }

    public MinPQ(){
        this(1);
    }

    public MinPQ(int initCapacity, Comparator<Key> comparator){
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }

    public MinPQ(Comparator<Key> comparator){
        this(1, comparator);
    }

    public MinPQ(Key[] keys){
        N = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for(int i = 0; i < N; i++)
            pq[i+1] = keys[i];
        for(int k = N/2; k >= 1; k--)
            sink(k);
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public Key min(){
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    private void resize(int capacity){
        assert capacity > N;
        Key[] temp = (Key[]) new Object[capacity];
        for(int i = 1; i <= N; i++)
            temp[i] = pq[i];
        pq = temp;
    }

    public void insert(Key x){
        if(N >= pq.length - 1)
            resize(2 * pq.length);
        pq[++N] = x;
        swim(N);
    }


    public Key delMin(){
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        exch(1, N);
        Key min = pq[N--];
        sink(1);
        pq[N+1] = null;
        if ((N > 0) && (N == (pq.length - 1) / 4)) resize(pq.length  / 2);
        return min;
    }

    private void swim(int k){
        while(k > 1 && greater(k/2, k)){
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2*k <= N){
            int j = 2 * k;
            if(j<N && greater(j, j+1)) j++;
            if(!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j){
        if(comparator == null){
            return ((Comparable<Key>)pq[i]).compareTo(pq[j]) > 0;
        }else{
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    private void exch(int i, int j){
        Key swap  =pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private boolean isMinHeap(){
        return isMinHeap(1);
    }

    private boolean isMinHeap(int k){
        return true;
    }

    @Override
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key>{
        private MinPQ<Key> copy;
        public HeapIterator(){
            if(comparator == null) copy = new MinPQ<Key>(size());
            else                   copy = new MinPQ<Key>(size(), comparator);
            for(int i = 1; i <= N; i++){
                copy.insert(pq[i]);
            }
        }

        public boolean hasNext(){
            return !copy.isEmpty();
        }

        public void remove(){throw new UnsupportedOperationException();}

        public Key next(){
            if(!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
}
