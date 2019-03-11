import java.util.*;
public class LeetCode1002_Find_Common_Characters {
    public List<String> commonChars(String[] A) {
        List<String> res = new LinkedList<>();
        int[] charTable = new int[26];
        int[] occTable = new int[26];
        for(int i = 0; i < A.length; i++){
            int[] curTable = new int[26];
            for(int j = 0; j < A[i].length(); j++){
                int index = A[i].charAt(j) - 'a';
                if(charTable[index] == i)
                    charTable[index] += 1;
                curTable[index] += 1;
            }
            for(int k = 0; k < 26; k++){
                if(occTable[k] == 0)
                    occTable[k] = curTable[k];
                else
                    occTable[k] = Math.min(curTable[k], occTable[k]);
            }
        }
        for(int i = 0; i < 26; i++){
            if(charTable[i] == A.length){
                char curChar = (char)(i + 'a');
                String ans = Character.toString(curChar);
                for(int j = 0; j < occTable[i]; j++){
                    res.add(ans);
                }
            }
        }
        return res;
    }
}
