package Sword_offer2;

public class solution_63 {

}

class Solution63 {
    public int maxProfit(int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int profit = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min,prices[i]);
            profit = Math.max(profit,prices[i]-min);
        }
        return profit;
    }

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
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][1];

    }
}

