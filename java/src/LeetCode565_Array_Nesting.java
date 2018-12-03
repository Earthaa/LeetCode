import java.util.*;
public class LeetCode565_Array_Nesting {
//    private int[] hasVisted;
//    private int maxLength = 0;
//    private void doVisit(int[] nums, int start, HashSet<Integer> mySet){
//        if(mySet.contains(start)){
//            maxLength = Math.max(maxLength,mySet.size());
//            return;
//        }
//        hasVisted[start] = 1;
//        mySet.add(start);
//        int newStart = nums[start];
//        doVisit(nums,newStart,mySet);
//    }
//    public int arrayNesting(int[] nums) {
//        hasVisted = new int[nums.length];
//        for(int i = 0; i < nums.length; i++){
//            if(hasVisted[i] != 1){
//                HashSet<Integer> mySet = new HashSet<>();
//                doVisit(nums,i,mySet);
//            }
//        }
//        return maxLength;
//    }
public int arrayNesting(int[] nums) {
    // corner case
    if(nums == null || nums.length == 0) return 0;

    // initials
    int res = 0;

    // for loop
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] >= 0) {
            int index = i;
            int length = 0;
            while(nums[index] >= 0) {
                length++;
                int tmp = nums[index];
                nums[index] = -1;
                index = tmp;
            }
            res = Math.max(res, length);
        }
    }

    // return res
    return res;
}
}
