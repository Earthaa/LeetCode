package Design;
import java.util.Stack;
class MaxStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
        maxStack.push(Integer.MIN_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        maxStack.push(Math.max(x,maxStack.peek()));
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> tmp = new Stack<>();
        while(!stack.isEmpty()){
            int num = pop();
            if(num == max){
                break;
            }
            else
                tmp.push(num);
        }
        while(!tmp.isEmpty())
            push(tmp.pop());
        return max;
    }
}
