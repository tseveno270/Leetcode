import Sword_offer2.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class solution_102 {
}
class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root==null){return list;}
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
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
            list.add(level);
        }
        return list;
    }
    public List<List<Integer>> levelOrer(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root==null){return res;}
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++){
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

    /**深度遍历
     *
     * @param root
     */
    void dfs(TreeNode root){
        if (root==null){return;}
        dfs(root.left);
        dfs(root.right);
    }

    /**
     * 广度优先遍历
     * @param root
     */
    void bfs(TreeNode root){
      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);
      while (!queue.isEmpty()){

          TreeNode node = queue.poll();
          if (node.left!=null){
              queue.add(node.left);
          }
          if (node.right!=null){
              queue.add(node.right);
          }
      }
    }


}

