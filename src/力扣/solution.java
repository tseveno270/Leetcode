import Sword_offer2.TreeNode;

public class solution {
}
class Solution317 {
    public int rob(TreeNode root) {
        int[] dp = robAction3(root);

        return Math.max(dp[0],dp[1]);
    }

     int[] robAction3(TreeNode root) {
        //dp表示偷到当前节点(包括当前节点)为止的最大值
        //dp[0]表示未偷本节点，dp[1]表示偷了本节点
        int[] dp = new int[2];
        if (root==null){
            return dp;
        }
        int[] left = robAction3(root.left);
        int[] right = robAction3(root.right);
        dp[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        dp[1] = left[0] + right[0] +root.val;
        return dp;

    }
}
