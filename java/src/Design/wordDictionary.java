package Design;

public class wordDictionary {
    class WordDictionary {
        private class node{
            boolean isWord;
            node[] next;
            node(){next = new node[26];
                isWord = false;}
        }
        node root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new node();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            node cur = root;
            for(int i = 0; i < word.length(); i++){
                int index = word.charAt(i) - 97;
                if(cur.next[index] == null)
                    cur.next[index] = new node();
                cur = cur.next[index];
                if(i == word.length() - 1)
                    cur.isWord = true;
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return doSearch(word,root,0);
        }
        private boolean doSearch(String word, node start, int stridx){
            if(stridx >= word.length())
                return start.isWord == true;

            if(word.charAt(stridx) != '.'){
                if(start.next[word.charAt(stridx) - 97] == null)
                    return false;
                return doSearch(word,start.next[word.charAt(stridx) - 97], stridx + 1);
            }
            else{
                boolean flag = false;
                for(int i = 0 ; i < 26; i++){
                    if(start.next[i] != null){
                        flag |= doSearch(word,start.next[i],stridx + 1);}
                    if(flag == true)
                        return flag;
                }
                return flag;
            }
        }
    }
}
