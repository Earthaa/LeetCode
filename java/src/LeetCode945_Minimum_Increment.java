import java.util.*;
public class LeetCode945_Minimum_Increment {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i] <= A[i - 1]){
                int tmp = A[i];
                A[i] = A[i - 1] + 1;
                count = count + (A[i] - tmp);
            }
        }
        return count;
    }
    /*
    * O(n) Solution without sort*/
}
