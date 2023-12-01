import Sword_offer2.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class solution_103 {
}

class Solution103 {
    /**
     * 还是基于广度优先搜索实现层序遍历，只不过这次每层的左右顺序是交替的、
     * 可以分别从左向右和从右到左层序遍历，然后交替加入res中
     * 通过创建一个flag标识来分辨每一层到底如何遍历
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //创建队列
        Queue<TreeNode> queueLeft = new ArrayDeque<>();
        Queue<TreeNode> queueRight = new ArrayDeque<>();
        if (root==null){return res;}
        queueLeft.add(root);
        queueRight.add(root);
        int flag = 1;
        while (!queueLeft.isEmpty()&&!queueRight.isEmpty()){
            //每层长度
            int size=queueLeft.size();
            //表示每一层的集合
            List<Integer> levelLeft = new ArrayList<>();
            List<Integer> levelRight = new ArrayList<>();
            //for循环内为添加了下一层的所有非空节点和这一层的所有数值到level
            flag++;
            for (int i = 0; i < size; i++) {
                TreeNode nodeL = queueLeft.poll();
                TreeNode nodeR = queueRight.poll();
                levelLeft.add(nodeL.val);
                levelRight.add(nodeR.val);
                if (nodeL.left!=null){
                   queueLeft.add(nodeL.left);
                }
                if (nodeL.right!=null){
                    queueLeft.add(nodeL.right);
                }
                if (nodeR.right!=null){
                    queueRight.add(nodeR.right);
                }
                if (nodeR.left!=null){
                    queueRight.add(nodeR.left);
                }
            }
            if (flag%2==0)res.add(levelLeft);
            else res.add(levelRight);
        }
        return res;
    }
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> LQueue = new ArrayDeque<>();
        Queue<TreeNode> RQueue = new ArrayDeque<>();
        if (root==null){return res;}
        LQueue.add(root);
        RQueue.add(root);
        int flag = 1;
        while (!LQueue.isEmpty()&&!RQueue.isEmpty()){
            List<Integer> Llevel = new ArrayList<>();
            List<Integer> Rlevel = new ArrayList<>();
            int size = LQueue.size();
            flag++;
            for (int i = 0; i < size; i++) {
                TreeNode LNode = LQueue.poll();
                TreeNode RNode = RQueue.poll();
                Llevel.add(LNode.val);
                Rlevel.add(RNode.val);
                if (LNode.left!=null){
                    LQueue.add(LNode.left);
                }
                if (LNode.right!=null){
                    LQueue.add(LNode.right);
                }
                if (RNode.right!=null){
                    RQueue.add(RNode.right);
                }
                if (RNode.left!=null){
                    RQueue.add(RNode.left);
                }
            }
            if (flag%2==0) res.add(Llevel);
            else res.add(Rlevel);
        }
        return res;
    }
}
