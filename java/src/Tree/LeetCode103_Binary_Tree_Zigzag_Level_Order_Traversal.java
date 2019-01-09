package Tree;
import java.util.*;
public class LeetCode103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)
            return res;
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> curStack = new Stack<>();
        preStack.push(root);
        boolean leftToRight = true;
        List<Integer> ls = new LinkedList<>();
        while(!preStack.isEmpty()){
            TreeNode curNode = preStack.pop();
            if(leftToRight){
                if(curNode.left != null)
                    curStack.push(curNode.left);
                if(curNode.right != null)
                    curStack.push(curNode.right);
            }
            else{
                if(curNode.right != null)
                    curStack.push(curNode.right);
                if(curNode.left != null)
                    curStack.push(curNode.left);
            }
            ls.add(curNode.val);
            if(preStack.isEmpty()){
                res.add(ls);
                ls = new LinkedList<>();
                preStack = curStack;
                curStack = new Stack<>();
                leftToRight = !leftToRight;
            }
        }
        return res;
    }
}
