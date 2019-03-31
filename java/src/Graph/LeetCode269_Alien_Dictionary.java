package Graph;
import java.util.*;
public class LeetCode269_Alien_Dictionary {
    class Node{
        char id;
        int in = 0;
        int[] next;
        Node(char c){
            this.id = c;
            this.in = 0;
            next = new int[26];
        }
    }
    Map<Character,Node> mymap;
    public String alienOrder(String[] words) {
        int[] visited = new int[26];
        this.mymap = new HashMap<>();
        for(String each:words){
            for(int i = 0; i < each.length();i++)
                visited[each.charAt(i) - 'a'] = 1;
        }
        for(int i = 0; i < words.length - 1;i++){
            int j = i + 1;
            String prevWord = words[i];
            String nextWord = words[j];
            for(int k = 0; k < Math.min(prevWord.length(),nextWord.length());k++){
                char prev = prevWord.charAt(k);
                char next = nextWord.charAt(k);
                if(!this.mymap.containsKey(prev)){
                    Node node = new Node(prev);
                    this.mymap.put(prev,node);
                }
                if(prev != next){
                    addEdge(prev,next);
                    break;
                }
            }
        }
        Stack<Character> st = new Stack<>();
        for(char i = 'a'; i <= 'z'; i++){
            char cur = i;
            if(this.mymap.containsKey(cur)){
                Node curNode = this.mymap.get(cur);
                if(curNode.in == 0){
                    st.push(cur);
                    visited[cur - 'a'] = 0;
                }
            }
        }

        // System.out.println("test");
        StringBuffer sb = new StringBuffer();
        while(!st.isEmpty()){
            char cur = st.pop();
            sb.append(cur);
            Node curNode = this.mymap.get(cur);
            for(char i = 'a'; i <= 'z';i++) {
                char next = i;
                if (curNode.next[next - 'a'] == 1) {
                    Node nextNode = this.mymap.get(next);
                    nextNode.in --;
                    if (nextNode.in == 0){
                        st.push(next);
                        visited[next - 'a'] = 0;
                    }
                }
            }
            this.mymap.remove(cur);
        }

        if(mymap.size() != 0)
            return "";
        for(char c = 'a';c <= 'z';c++){
            if(visited[c - 'a'] == 1)
                sb.append(c);
        }
        return sb.toString();
    }

    private void addEdge(char prev,char next){
        if(prev == next)
            return;
        Node prevNode = this.mymap.getOrDefault(prev,null);
        Node nextNode = this.mymap.getOrDefault(next,null);
        if(prevNode == null){
            prevNode = new Node(prev);
        }
        if(nextNode == null){
            nextNode = new Node(next);
        }
        if(prevNode.next[next - 'a'] == 0){
            prevNode.next[next - 'a'] = 1;
            nextNode.in++;
        }
        this.mymap.put(prev,prevNode);
        this.mymap.put(next,nextNode);
    }
}
