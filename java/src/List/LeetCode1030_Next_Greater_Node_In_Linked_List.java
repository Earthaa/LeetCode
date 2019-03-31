package List;
import java.util.*;
public class LeetCode1030_Next_Greater_Node_In_Linked_List {
    public int[] nextLargerNodes(ListNode head) {
        if(head == null)
            return new int[0];
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            arr.add(cur.val);
            cur = cur.next;
        }
        int[] res = new int[arr.size()];
        for(int i = 0; i < arr.size();i++){
            while(!stack.isEmpty() && arr.get(stack.peek()) < arr.get(i)){
                res[stack.pop()] = arr.get(i);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        return res;
    }
}
