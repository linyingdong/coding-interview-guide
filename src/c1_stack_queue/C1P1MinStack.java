package c1_stack_queue;

import java.util.Stack;

/**
 * @author lyd
 */
public class C1P1MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public C1P1MinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(Integer x) {
        dataStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public Integer pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        Integer x = dataStack.pop();
        if (x <= minStack.peek()) {
            minStack.pop();
        }
        return x;
    }

    public Integer getMin(){
        if(minStack.isEmpty()){
            throw new RuntimeException("Your stack is empty.");
        }
        return minStack.peek();
    }

    public boolean isEmpty(){
        return dataStack.isEmpty();
    }

    public static void main(String[] args) {
        C1P1MinStack c1P1MinStack = new C1P1MinStack();
        c1P1MinStack.push(5);
        c1P1MinStack.push(3);
        c1P1MinStack.push(4);

        while(!c1P1MinStack.isEmpty()){
            System.out.println(c1P1MinStack.getMin());
            c1P1MinStack.pop();
        }
    }
}
