# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head == None or head.next == None:
            return head
        cur = head.next
        precur = head
        while cur != None:
            if head.val > cur.val:
                precur.next = cur.next
                tmp = cur
                cur = cur.next
                tmp.next = head
                head = tmp
                continue
            loc = head
            while loc != cur and not (loc.val <= cur.val and loc.next.val > cur.val):
                loc = loc.next
            if loc == cur:
                precur = precur.next
                cur = cur.next
            else:
                precur.next = cur.next
                tmp = cur
                cur = cur.next
                tmp.next = loc.next
                loc.next = tmp
        return head

MySolution = Solution()
a = ListNode(-1)
b = ListNode(5)
c = ListNode(3)
d = ListNode(4)
e = ListNode(0)
a.next = b
b.next = c
c.next = d
d.next = e
head = MySolution.insertionSortList(a)
while head != None:
    print head.val
    head = head.next


