package List;
import java.util.Stack;
public class LeetCode445_Add_Two_Numbers_II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode cur = l1;
        while(cur != null){
            s1.push(cur.val);
            cur = cur.next;
        }
        cur = l2;
        while(cur != null){
            s2.push(cur.val);
            cur = cur.next;
        }

        if(s2.size() > s1.size()){
            Stack<Integer> tmp = s1;
            s1 = s2;
            s2 = tmp;
        }

        ListNode last = null;
        int carry = 0;
        while(!s1.isEmpty()){
            int val1 = s1.pop();
            int val2;
            if(s2.isEmpty())
                val2 = 0;
            else
                val2 = s2.pop();
            ListNode newNode = new ListNode((val1 + val2 + carry) % 10 );
            carry = (val1 + val2 +carry) / 10;
            newNode.next = last;
            last = newNode;
        }
        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            newNode.next = last;
            last = newNode;
        }
        return last;

    }
}
