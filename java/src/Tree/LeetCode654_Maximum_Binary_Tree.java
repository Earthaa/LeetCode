package Tree;

public class LeetCode654_Maximum_Binary_Tree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return doConstruct(nums, 0, nums.length - 1);
    }
    private TreeNode doConstruct(int[] nums, int left, int right){
        if(left > right)
            return null;
        if(left == right)
            return new TreeNode(nums[left]);
        int maxIndex = findMaxIndex(nums, left, right);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = doConstruct(nums,left,maxIndex - 1);
        node.right = doConstruct(nums, maxIndex + 1, right);
        return node;

    }
    private int findMaxIndex(int[] nums, int left, int right){
        int max = Integer.MIN_VALUE;
        int index = left;
        for(int i = left; i <= right; i++){
            if(nums[i] > max){
                index = i;
                max = nums[i];
            }
        }
        return index;
    }
}
