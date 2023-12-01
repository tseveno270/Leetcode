import Sword_offer2.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class solution_94 {
}
class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        infixOrder(root,res);
        return res;

    }

    private void infixOrder(TreeNode root, List<Integer> res) {
        if (root==null){return;}
        infixOrder(root.left,res);
        res.add(root.val);
        infixOrder(root.right,res);
    }
}
