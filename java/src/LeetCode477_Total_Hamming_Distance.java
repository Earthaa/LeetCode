public class LeetCode477_Total_Hamming_Distance {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                res += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        return res;
    }
}
