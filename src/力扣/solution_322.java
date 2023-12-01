public class solution_322 {
}
class Solution322 {
    public int coinChange(int[] coins, int amount) {
        //完全背包问题dp[j]表示组成j金额的最少硬币个数
        //因为要比较最小值，所以不能用零当默认值，不然个数都为零，所以定义为max
        int max = Integer.MAX_VALUE;
        //如果j>=coins[i],则dp[j] = dp[j-coins[i]]+1；
        int[] dp = new int[amount+1];
        for (int i = 0; i <=amount; i++) {
            dp[i] = max;
        }
        //初始化，凑成金额0所需硬币个数为0
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount; j++) {
                //如果不等于max也就是说可以组合到所需金额。如果dp[j-coins[i]]为max，说明没有改过值，说明这个金额无法组合。那就返回-1
                if (dp[j-coins[i]]!=max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1:dp[amount];
    }
}
