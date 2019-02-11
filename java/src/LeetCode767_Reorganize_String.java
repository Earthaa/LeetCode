import java.util.*;

public class LeetCode767_Reorganize_String {
    public String reorganizeString(String S) {
        Map<Character,Integer> freq = new HashMap<>();
        Character mostLetter = ' ';
        int mostLetterFreqs = 0;
        for(int i = 0; i < S.length(); i++){
            Character ch = S.charAt(i);
            if(freq.get(ch) != null)
                freq.put(ch,freq.get(ch) + 1);
            else
                freq.put(ch,1);
            if(freq.get(ch) > mostLetterFreqs){
                mostLetterFreqs = freq.get(ch);
                mostLetter = ch;
            }
        }
        int remain = S.length() - mostLetterFreqs;
        if(remain < mostLetterFreqs - 1)
            return "";
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for(int i = 0; i < S.length(); i++){
            Character ch = S.charAt(i);
            if(!ch.equals(mostLetter))
                pq.add(ch);
        }
        StringBuffer res = new StringBuffer();
        if(pq.size() <= mostLetterFreqs){
            while(!pq.isEmpty()){
                res.append(mostLetter);
                res.append(pq.poll());
                mostLetterFreqs--;
            }
            if(mostLetterFreqs != 0)
                res.append(mostLetter);
        }
        else{
            StringBuffer[] insertLetters = new StringBuffer[mostLetterFreqs];
            int index = 0;
            while(!pq.isEmpty()){
                if(insertLetters[index % mostLetterFreqs] == null)
                    insertLetters[index%mostLetterFreqs] = new StringBuffer();
                insertLetters[index % mostLetterFreqs].append(pq.poll());
                index++;
            }
            for(int i = 0; i < insertLetters.length;i++){
                res.append(mostLetter);
                res.append(insertLetters[i]);
            }
        }
        return res.toString();
    }
}
/*
 public String reorganizeString(String S) {
        int N = S.length();
        int[] counts = new int[26];
        for (char c: S.toCharArray()) counts[c-'a'] += 100;
        for (int i = 0; i < 26; ++i) counts[i] += i;
        //Encoded counts[i] = 100*(actual count) + (i)
        Arrays.sort(counts);

        char[] ans = new char[N];
        int t = 1;
        for (int code: counts) {
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (N+1) / 2) return "";
            for (int i = 0; i < ct; ++i) {
                if (t >= N) t = 0;
                ans[t] = ch;
                t += 2;
            }
        }

        return String.valueOf(ans);
    }
 */
