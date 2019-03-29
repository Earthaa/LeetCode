package List;
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};

//链表问题一定要考虑空指针的情况！！！！
public class LeetCode138_Copy_List_With_Random_Pointer {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node cur = head;
        while(cur != null){
            Node weavedNode = new Node(cur.val,cur.next,cur.random);
            cur.next = weavedNode;
            cur = cur.next.next;
        }
        cur = head.next;
        while(cur != null){
            if(cur.random != null)
                cur.random = cur.random.next;
            if(cur.next != null)
                cur = cur.next.next;
            else
                break;
        }
        Node newHead = head.next;
        Node prevNode = head;
        cur = newHead;
        while(cur != null){
            prevNode.next = prevNode.next.next;
            if(cur.next != null)
                cur.next = cur.next.next;
            else
                break;
            prevNode = prevNode.next;
            cur = cur.next;
        }
        return newHead;

    }
}
