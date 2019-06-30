package Design;
import java.util.*;

class StreamChecker {
    class TrieNode{
        TrieNode[] next;
        boolean isEnd;
        TrieNode(){
            next = new TrieNode[26];
            isEnd = false;
        }
    }
    Map<Character, TrieNode> startNodeSet;
    LinkedList<Character> queries;

    public StreamChecker(String[] words) {
        queries = new LinkedList<>();
        startNodeSet = new HashMap<>();
        for(String word:words){
            TrieNode startNode = startNodeSet.getOrDefault(word.charAt(word.length() - 1), new TrieNode());
            TrieNode cur = startNode;
            if(word.length() > 1){
                for(int i = word.length() - 2; i >= 0; i--){
                    char c = word.charAt(i);
                    if(cur.next[c - 'a'] == null)
                        cur.next[c - 'a'] = new TrieNode();
                    cur = cur.next[c - 'a'];
                }
            }
            cur.isEnd = true;
            startNodeSet.put(word.charAt(word.length() - 1),startNode);
        }
    }

    public boolean query(char letter) {
        queries.addFirst(letter);
        if(!startNodeSet.containsKey(letter))
            return false;
        TrieNode cur = startNodeSet.get(letter);
        Iterator<Character> iter = queries.iterator();
        Character c = iter.next();
        if(cur.isEnd == true)
            return true;
        while(iter.hasNext()){
            c = iter.next();
            cur = cur.next[c.charValue() - 'a'];
            if(cur == null)
                return false;
            if(cur.isEnd == true)
                return true;

        }
        return false;
    }
}