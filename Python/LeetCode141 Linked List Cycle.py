# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        startone = head
        starttwo = head
        while starttwo != None and starttwo.next != None:
            startone = startone.next
            starttwo = starttwo.next.next
            if startone == starttwo:
                return True

        return False
