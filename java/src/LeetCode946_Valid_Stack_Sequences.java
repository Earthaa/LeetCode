import java.util.*;
public class LeetCode946_Valid_Stack_Sequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0)
            return true;
        Stack<Integer> stack = new Stack<>();
        int push_index = 0;
        int pop_index = 0;
        while (push_index < pushed.length){
            stack.push(pushed[push_index]);
            ++push_index;
            while(!stack.empty() && stack.peek() == popped[pop_index]) {
                stack.pop();
                ++pop_index;
            }
        }
            return stack.isEmpty();
    }
}
