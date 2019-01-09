import java.util.*;
public class LeetCode127_WordLadder {
    private boolean canTransform(String start,String end){
        int a = 0;
        for(int i = 0; i < start.length(); i++){
            if(start.charAt(i) != end.charAt(i))
                a++;
            if(a > 1)
                return false;
        }
        return a == 1;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        int[] count = new int[wordList.size()];
        String[] wordArray = wordList.toArray(new String[wordList.size()]);
        Stack<String> prev = new Stack<>();
        Stack<String> current = new Stack<>();
        prev.push(endWord);
        int length = 1;
        while(!prev.isEmpty()){
            String cur = prev.pop();
            for(int i = 0; i < wordArray.length; i++){
                if(count[i] != 0)
                    continue;
                if(!wordArray[i].equals(endWord) && canTransform(cur,wordArray[i])){
                    count[i] = length;
                    current.push(wordArray[i]);
                }
            }
            if(prev.isEmpty()){
                prev = current;
                current = new Stack<>();
                length++;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < wordArray.length; i++){
            //System.out.println(count[i]);
            if((count[i] != 0 && canTransform(beginWord,wordArray[i]))||(wordArray[i].equals(endWord) && canTransform(beginWord,wordArray[i] )))
                res = Math.min(res,count[i] + 1);
        }
        return res == Integer.MAX_VALUE ? 0 : res + 1;
    }
}
