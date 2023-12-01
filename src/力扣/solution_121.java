public class solution_121 {
}
class Solution121 {
    public static void main(String[] args) {
        maxProfit2(new int[]{7,1,5,3,6,4});
    }
    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //1.dp含义 dp[i][0]表示第i天持有股票的最大利益
        //dp[i][1]表示第i天不持有股票的最大利益
        int[][] dp = new int[prices.length][2];
        //2.递推公式
        //dp[i][0]说明之前一直持有股票或者第i天买入，那么dp[i][0] = Math.max(dp[i-1][0],-prices[i])
        //第i天直接买入的话，是不能用dp[i-1][1]-price[i]的，因为只能买卖一次，所以前i-1天的利润为0
        //dp[i][1]说明之前持有股票第i天才卖或者之前就卖掉了，dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i])
        //3.初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }

        return dp[prices.length-1][1];
    }

    /**
     * 贪心算法
     * @param prices
     * @return
     */
    public  static int maxProfit2(int[] prices) {
       //找到能使利润最大的左边最小和右边最大
        int cur = prices[0];
        int max = 0;
        for (int p:prices){
            if (p< cur){
                cur = p;
            }else {
                max = Math.max(max,p-cur);
            }
        }
        return max;
    }

    public int maxProfit3(int[] prices) {
       int[][] dp = new int[prices.length][2];
       dp[0][0] = -prices[0];
       dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }
}
