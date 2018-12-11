package Bitwise;

public class LeetCode260_Single_Number_III {
    /*n
    the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find. Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result. Find
out an arbitrary set bit (for example, the rightmost set bit).

    In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, another with the aforementinoed bit unset. Two different numbers we need to find must fall into thte two distrinct groups. XOR numbers in each group, we can find a number in either group.
    */
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int i = 0; i < nums.length; i++)
            diff ^= nums[i];
        //if there is two different numbers, bit > 0, and at least 1 bit = 1
        int[] res = new int[2];
        //Set the last bit which equals to 1 still 1, and the other bits 0
        diff &= -diff;
        for(int i = 0; i < nums.length; i++){
            if((diff & nums[i]) == 0)
                res[0]^=nums[i];
            else
                res[1]^=nums[i];
        }
        return res;

    }
}
