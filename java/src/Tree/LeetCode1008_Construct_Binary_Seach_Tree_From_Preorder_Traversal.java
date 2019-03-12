package Tree;

import java.util.Arrays;

public class LeetCode1008_Construct_Binary_Seach_Tree_From_Preorder_Traversal {
    private int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = new int[preorder.length];
        for(int i = 0; i < preorder.length; i++)
            inorder[i] = preorder[i];
        Arrays.sort(inorder);
        return buildTree(preorder,inorder,0,preorder.length - 1);

    }
    private TreeNode buildTree(int[] preorder,int[] inorder, int left, int right){

        int curNum = preorder[index];
        TreeNode cur = new TreeNode(curNum);
        index++;
        //Binary search here for the fact inorder of BST is sorted
        if(left == right)
            return cur;
        int inorderIndex = binarySearch(inorder,left,right,curNum);

        if(inorderIndex > left)
            cur.left = buildTree(preorder, inorder, left,inorderIndex- 1);
        if(inorderIndex < right)
            cur.right = buildTree(preorder,inorder,inorderIndex + 1,right);
        return cur;
    }
    private int binarySearch(int[] array, int left, int right,int target){
        int mid = (left + right) / 2 ;
        while(array[mid] != target){
            if(array[mid] > target)
                right = mid;
            else
                left = mid + 1;
            mid = (left + right) / 2;
        }

        return mid;
    }
}
