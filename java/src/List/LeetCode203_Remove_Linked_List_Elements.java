package List;

public class LeetCode203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            if (cur.val == val) {
                if (prev != null) {
                    prev.next = cur.next;
                    cur = cur.next;
                } else {
                    cur = cur.next;
                    head = cur;
                }
            } else {
                if (prev == null)
                    prev = head;
                else
                    prev = prev.next;
                cur = cur.next;
            }
        }
        return head;
    }
}
