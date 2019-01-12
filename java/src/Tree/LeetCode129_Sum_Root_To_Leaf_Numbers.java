package Tree;

public class LeetCode129_Sum_Root_To_Leaf_Numbers {
    private int getValue(TreeNode root, int lastNum){
        int curNum = lastNum * 10 + root.val;
        int total = 0;
        if(root.left == null && root.right == null)
            return curNum;
        if(root.left != null){
            total += getValue(root.left,curNum);
        }
        if(root.right != null){
            total += getValue(root.right,curNum);
        }
        return total;
    }
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return getValue(root,0);
    }
}
