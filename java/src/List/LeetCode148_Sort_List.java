package List;

public class LeetCode148_Sort_List {
    public ListNode sortList(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        // System.out.println(count);
        return sort(head, count);
    }
    private ListNode sort(ListNode head, int count){
        //System.out.println(count);
        if(head == null || count == 1)
            return head;
        ListNode head2 = head;
        int con = 0;
        int target = count / 2;
        ListNode prev = new ListNode(0);
        prev.next = head2;
        while(con < target){
            con++;
            head2 = head2.next;
            prev = prev.next;
        }
        prev.next = null;

        ListNode l1;
        ListNode l2;
        l1 = sort(head,target);
        l2 = sort(head2,count - target);
        return mergeList(l1,l2);
    }

    private ListNode mergeList(ListNode head1, ListNode head2){
        ListNode preNode = new ListNode(-1);
        ListNode prev = preNode;
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                prev.next = head1;
                head1 = head1.next;
            }
            else{
                prev.next = head2;
                head2 = head2.next;
            }
            prev = prev.next;
            // System.out.println(head1.val);
        }
        prev.next = head1 == null ? head2 : head1;
        return preNode.next;
    }
}
