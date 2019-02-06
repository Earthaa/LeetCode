import java.util.*;
public class LeetCode496_Next_Greater_Element_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res  = new int[nums1.length];
        if(nums1.length == 0)
            return res;
        if(nums2.length == 1){
            res[0] = -1;
            return res;
        }

        Map<Integer,Integer> nge = new HashMap<Integer,Integer>();
        nge.put(nums2[nums2.length - 1], - 1);

        for(int i = nums2.length - 2; i >= 0; i--){
            int find = - 1;
            for(int j = i + 1; j < nums2.length; j++){
                if(nums2[j] > nums2[i]){
                    find = nums2[j];
                    break;
                }
            }
            nge.put(nums2[i],find);
        }
        for(int i = 0; i < nums1.length; i++){
            res[i] = nge.get(nums1[i]);
        }
        return res;
    }
}
