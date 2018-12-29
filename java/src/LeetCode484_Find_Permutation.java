import java.util.LinkedList;

public class LeetCode484_Find_Permutation {
    public int[] findPermutation(String s) {
        LinkedList<Integer> res = new LinkedList<>();
        res.addLast(1);
        int pos = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'I'){
                res.addLast(i + 2);
                pos = i + 1;
            }
            else if(s.charAt(i) == 'D')
                res.add(pos,i + 2);
        }
        int[] result = new int[res.size()];
        int i = 0;
        while(res.size() != 0){
            result[i] = res.poll();
            i++;
        }
        return result;
    }
}
