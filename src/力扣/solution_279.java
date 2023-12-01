public class solution_279 {

}
class Solution279 {
    public int numSquares(int n) {
        //完全背包问题，并找出最少数量
        //dp[j]表示组合成j的完全平方数的最小个数
        int[] dp = new int[n+1];
        int max = Integer.MAX_VALUE;
        //为了递推如此赋值
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = max;
        }
        for (int i = 1; i*i <=n; i++) {
            for (int j = i*i; j <=n; j++) {
                if (dp[j-i*i]!=max){
                    dp[j] = Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }
}
