import java.util.*;
public class rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root == null)
            return res;
        Queue<TreeNode> nodeQueue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> nodeQueue2 = new LinkedList<TreeNode>();
        nodeQueue1.add(root);
        while(!nodeQueue1.isEmpty()){
            res.add(nodeQueue1.peek().val);
            while(!nodeQueue1.isEmpty()){
                TreeNode cur = nodeQueue1.poll();
                if(cur.right != null)
                    nodeQueue2.add(cur.right);
                if(cur.left  != null)
                    nodeQueue2.add(cur.left);
            }
            Queue<TreeNode> tmp = nodeQueue2;
            nodeQueue2 = nodeQueue1;
            nodeQueue1 = tmp;
        }
        return res;
    }
}
/*
class Solution {
    List<Integer> res = new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs (TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(node.val);
        }

        dfs(node.right, depth+1);
        dfs(node.left, depth+1);
    }
}*/
