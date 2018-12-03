class LRUCache(object):
    class biListNode:
        def __init__(self,val,key):
            self.val = val
            self.key = key
            self.next = None
            self.front = None
    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.dict = {}
        self.length = 0
        self.head = None
        self.tail = None
    def priNode(self,node):
        if self.tail == node:
            self.tail = node.front
        elif self.head == node:
            return
        if node.front != None:
            node.front.next = node.next
        if node.next != None:
            node.next.front = node.front
        node.next = self.head
        if self.head != None:
            self.head.front = node
        self.head = node
        if self.length == 1:
            self.tail = node

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if self.dict.has_key(key):
            node = self.dict[key]
            self.priNode(node)
            return node.val
        else:
            return -1

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void

        """
        if self.dict.has_key(key):
            node = self.dict[key]
            node.val = value
            self.priNode(node)
        elif self.length < self.capacity:
            self.length += 1
            newNode = self.biListNode(key=key,val=value)
            self.dict[key] = newNode
            self.priNode(newNode)
        else:
            dropkey = self.tail.key
            self.tail = self.tail.front
            del self.dict[dropkey]
            newNode = self.biListNode(key=key, val=value)
            self.dict[key] = newNode
            self.priNode(newNode)

cache = LRUCache(2)
cache.put(2,1)
cache.put(3,2)
cache.get(3)
cache.get(2)
cache.put(4,3)
cache.put(4,1)
print cache.get(3)
        # Your LRUCache object will be instantiated and called as such:
        # obj = LRUCache(capacity)
        # param_1 = obj.get(key)
        # obj.put(key,value)