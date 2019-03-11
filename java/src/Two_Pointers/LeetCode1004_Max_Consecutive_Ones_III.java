package Two_Pointers;

public class LeetCode1004_Max_Consecutive_Ones_III {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int res = 0;
        while(right < A.length){
            if(A[right] == 1){
                right++;
            }
            else{
                if(K > 0){
                    right++;
                    K--;
                }
                else if(A[left] == 0){
                    left ++;
                    right ++;
                }
                else{
                    left++;
                }
            }
            res = Math.max(res,right - left);
        }
        return res;

    }
}
