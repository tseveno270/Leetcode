public class solution_122 {
}
class Solution122{
    public int maxProfit2(int[] prices){
        if (prices.length==0||prices==null){
            return 0;
        }
        //dp[i][0]表示第i天持有股票的最大现金
        //dp[i][1]表示第i天已经卖出股票的最大现金
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] =  0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][1];

    }

    public int maxProfit3(int[] prices){
        if (prices.length==0||prices==null){
            return 0;
        }
        //dp[i][0]表示第i天持有股票的最大现金
        //dp[i][1]表示第i天已经卖出股票的最大现金
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] =  0;
        for (int i = 1; i < prices.length; i++) {
            //和121不同就在递推公式，121只能买卖一次，122可以多次。
            // 所以dp[i][0]如果表示在第i天卖出的话，dp[i-1][1]也需要考虑，因为之前可能买卖过
            //122如果在第i天卖出的话，那么之前是没有买卖的，也就是说之前没有赚取利益，不用考虑
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][1];

    }
}
