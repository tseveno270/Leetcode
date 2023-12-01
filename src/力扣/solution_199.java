import Sword_offer2.TreeNode;

import java.util.*;

public class solution_199 {
}
class Solution199 {
    /**
     * 可以返回层序遍历(从右到左)每层的最后一个
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
       List<List<Integer>> levelOrder = new ArrayList<>();
       List<Integer> res = new ArrayList<>();
       levelOrder = levelOrder(root);
       for (List<Integer> level:levelOrder){
           res.add(level.get(level.size()-1));
       }
        return res;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            List<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

}
