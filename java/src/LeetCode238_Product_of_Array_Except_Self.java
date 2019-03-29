public class LeetCode238_Product_of_Array_Except_Self {
    /*With extra space*/
    public int[] productExceptSelf(int[] nums) {
        int[] prefixP = new int[nums.length];
        int[] sufixP = new int[nums.length];

        prefixP[0] = nums[0];
        sufixP[nums.length - 1] = nums[nums.length - 1];

        for(int i = 1; i < nums.length - 1; i++){
            prefixP[i] = prefixP[i - 1] * nums[i];
        }
        for(int i = nums.length - 2; i > 0; i--){
            sufixP[i] = sufixP[i + 1] * nums[i];
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int preProduct = i > 0 ? prefixP[i - 1] : 1;
            int postProduct = i < nums.length - 1 ? sufixP[i + 1] : 1;
            res[i] = preProduct * postProduct;
        }
        return res;

    }
    //No Extra Space
    /*
    * public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0, tmp = 1; i < nums.length; i++) {
        result[i] = tmp;
        tmp *= nums[i];
    }
    for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
        result[i] *= tmp;
        tmp *= nums[i];
    }
    return result;
}*/
}
