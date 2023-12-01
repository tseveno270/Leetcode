import Sword_offer2.TreeNode;

public class solution_124 {
}
class Solution124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    /**
     * 方法用来求以当前节点为起点的最大路径和
     * @param node
     * @return
     */
    public int maxGain(TreeNode node) {
        if (node ==null){
            return 0;
        }
        int lGain = Math.max(0,maxGain(node.left));
        int rGain = Math.max(0,maxGain(node.right));
        //包含当前节点的最大路径和
        int temp = node.val+lGain+rGain;
        max = Math.max(max,temp);

        return node.val+Math.max(lGain,rGain);
    }
}
