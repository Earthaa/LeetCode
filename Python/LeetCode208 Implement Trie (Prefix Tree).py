class Trie(object):
    class Node(object):
        def __init__(self):
            self.val = False
            self.next = {}
    Root = Node()

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.Root = self.Node()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        def insert_helper(x, d):
            if not x:
                x = self.Node()
            if d == len(word) - 1:
                x.val = True #The end of a word
                return x
            else:
                next_char = word[d+1]
                if next_char not in x.next:
                    x.next[next_char] = None
                x.next[next_char] = insert_helper(x.next[next_char], d + 1)
            return x
        self.Root = insert_helper(self.Root, -1)

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        def search_helper(x , d):
            if not x:
                return False
            if d == len(word) - 1:
                return x.val
            next_char = word[d + 1]
            if next_char not in x.next:
                return False
            return search_helper(x.next[next_char], d + 1)
        return search_helper(self.Root,-1)


    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        def startsWith_helper(x, d):
            if not x:
                return False
            if d == len(prefix) - 1:
                return True
            next_char = prefix[d + 1]
            if next_char not in x.next:
                return False
            return startsWith_helper(x.next[next_char], d + 1)
        return startsWith_helper(self.Root, -1)


obj = Trie()
obj.insert("app")
obj.insert("apple")
# obj.insert("beer")
# obj.insert("add")
# obj.insert("jam")
# obj.insert("rental")

print obj.search("app")
