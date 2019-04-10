package Design;
import java.util.*;
import Tree.TreeNode;
class tt{
    int test;
    tt(int test){
        this.test = test;
    }

}
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {

        TreeNode cur = root;
        st = new Stack<>();
        while(cur != null){
            st.push(cur);
            cur = cur.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        int res = st.peek().val;
        TreeNode cur = st.pop();
        cur = cur.right;
        while(cur != null){
            st.push(cur);
            cur = cur.left;
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
}