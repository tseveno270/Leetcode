public class solution_1035 {
}
class Solution1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        //相对顺序不能变 dp[i][j]表示i-1和j-1前的最大相同序列长度
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        //递推方程，如果nums1[i-1] == nums2[j-1]
        //           dp[i][j] = dp[i-1][j-1] +1
        //           如果不相等，那么dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j])
        for (int i = 1; i <=nums1.length; i++) {
            for (int j = 1; j <=nums2.length; j++) {
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
