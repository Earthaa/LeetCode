package Tree;

import java.util.*;

public class LeetCode102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)
            return res;
        Queue<TreeNode> preQueue = new LinkedList<>();
        Queue<TreeNode> curQueue = new LinkedList<>();
        preQueue.add(root);
        List<Integer> ls = new LinkedList<>();
        while(!preQueue.isEmpty()){
            TreeNode curNode = preQueue.poll();
            if(curNode.left != null)
                curQueue.add(curNode.left);
            if(curNode.right != null)
                curQueue.add(curNode.right);
            ls.add(curNode.val);
            if(preQueue.isEmpty()){
                res.add(ls);
                ls = new LinkedList<>();
                preQueue = curQueue;
                curQueue = new LinkedList<>();
            }
        }
        return res;
    }
}
