package Design;
import java.util.Stack;
class MinStack {
    Stack<Integer> stack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(min);
        stack.push(x);
        min = Math.min(x,min);
    }

    public void pop() {
        stack.pop();
        min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
