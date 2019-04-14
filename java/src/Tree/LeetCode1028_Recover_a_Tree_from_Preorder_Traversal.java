package Tree;
import java.util.*;
public class LeetCode1028_Recover_a_Tree_from_Preorder_Traversal {
    public TreeNode recoverFromPreorder(String S) {
        Map<Integer,TreeNode> map = new HashMap<>();
        int i = 0;
        while(i < S.length()){
            int layer = 0;
            while(S.charAt(i) == '-'){
                layer++;
                i++;
            }
            StringBuffer sb = new StringBuffer();
            while(i < S.length() && (S.charAt(i) >= '0' && S.charAt(i) <='9')){
                sb.append(S.charAt(i));
                i++;
            }
            TreeNode node = new TreeNode(Integer.parseInt(sb.toString()));
            map.put(layer,node);
            if(layer > 0){
                TreeNode p = map.get(layer - 1);
                if(p.left == null)
                    p.left = node;
                else
                    p.right = node;
            }

        }
        return map.get(0);
    }
}
