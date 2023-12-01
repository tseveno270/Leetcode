public class solution_518 {

}
class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <=amount; j++) {
                //默认值是零，所以循环为dp[1] = dp[1] + dp[0] = 0 + 1 = 1
                                        //dp[1] = dp[2] + dp[1] = 0 + 1 = 1
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
