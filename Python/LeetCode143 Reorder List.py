# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return
        nodeSum = 0
        ptr = head
        while ptr != None:
            ptr = ptr.next
            nodeSum += 1
        nodeSum -= 1
        def reverseList(head):
            if head.next == None:
                return head
            ptr1 = head
            ptr2 = head.next
            ptr1.next = None
            while ptr2 != None:
                tmp = ptr1
                ptr1 = ptr2
                ptr2 = ptr2.next
                ptr1.next = tmp
            return ptr1

        i = 0
        ptr = head
        while i < nodeSum/2 + 1:
            ptr = ptr.next
            i += 1
        head1 = head
        head2 = reverseList(ptr)
        while head1 != None and head2 != None:
            tmp1 = head1
            tmp2 = head2
            head1 = head1.next
            head2 = head2.next
            tmp1.next = tmp2
            tmp2.next = head1
        if head1 != None and head2 == None:
            head1.next = None
        return head

def printList(head):
    while head != None:
        print head.val
        head = head.next



a = ListNode(1)
b = ListNode(2)
# c = ListNode(3)
# d = ListNode(4)
# e = ListNode(5)
# a.next=b
#b.next=c
# c.next=d
# d.next=e
MySolution = Solution()
MySolution.reorderList(a)
printList(a)