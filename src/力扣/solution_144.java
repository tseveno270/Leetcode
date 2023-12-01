import Sword_offer2.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class solution_144 {
}
class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        preOrder(root,res);
        return res;

    }

    private void preOrder(TreeNode root, List<Integer> res){
        if (root==null){return;}
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }


}
