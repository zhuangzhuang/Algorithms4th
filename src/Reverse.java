import java.util.Scanner;

/**
 * Created by gujd on 2014/12/18.
 */
public class Reverse {
    public static void main(String[] args){
        Stack<Integer> stack;
        stack = new Stack<Integer>();
        while(!StdIn.isEmpty()){
            stack.push(StdIn.readInt());
        }
        for(int i: stack){
            StdOut.println(i);
        }
    }
}
