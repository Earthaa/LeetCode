package Tree;

public class LeetCode236_Lowest_Coomon_Ancesotr_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null)
            return root;
        else if(left != null && right == null)
            return left;
        return right;
    }
}
