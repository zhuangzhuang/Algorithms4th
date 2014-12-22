/**
 * Created by fanyou-yufei on 14-12-22.
 */
public class SequentialSearchST<Key, Value> {
    private int N;
    private Node first;

    private class Node{
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next){
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public SequentialSearchST(){}

    public int size(){return N;}

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public Value get(Key key){
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void put(Key key, Value val){
        if(val == null) {delete(key); return;}
        for(Node x = first; x != null; x = x.next){
            if(key.equals(x.key)){
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        N++;
    }
    public void delete(Key key){
        first = delete(first, key);
    }

    private Node delete(Node x, Key key){
        if(x == null) return null;
        if(key.equals(x.key)) {N--; return x.next;}
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        for(Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

}











