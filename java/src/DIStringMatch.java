import java.util.*;
public class DIStringMatch {
    /*
      public int[] diStringMatch(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++;
            else
                ans[i] = hi--;
        }

        ans[N] = lo;
        return ans;
    }
     */
    public int[] diStringMatch(String S) {
       LinkedList<Integer> myList = new LinkedList<>();
       for(int i = 0; i <= S.length(); i++)
           myList.add(i);
       //Iterator<Integer> insertPos = myList.listIterator(0);
       int insertPos = 0;
       for(int i = 0; i < S.length();i++){
           if(S.charAt(i)=='I')
                insertPos = i + 1;
           else{
                int tmp = myList.get(i + 1);
                myList.remove(i + 1);
                myList.add(insertPos,tmp);
           }
       }
       int[] res = new int[myList.size()];
       for(int i = 0; i < myList.size(); i++)
           res[i] = myList.get(i);
       return res;
    }
}
