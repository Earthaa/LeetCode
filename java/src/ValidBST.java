public class ValidBST {
    private boolean isValid(TreeNode root,TreeNode shouldBigger,TreeNode shouldSmaller){
        if(root == null)
            return true;
        boolean thisRootValid = (shouldBigger == null || root.val > shouldBigger.val) &&
                (shouldSmaller == null || root.val < shouldSmaller.val);
        boolean valid = thisRootValid && isValid(root.left,shouldBigger,root) &&
                isValid(root.right,root,shouldSmaller);
        return valid;

    }
    public boolean isValidBST(TreeNode root) {
        return isValid(root,null,null);
    }
}
