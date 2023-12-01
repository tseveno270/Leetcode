package DynamicProgramming;

public class solution_746 {
}

class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if (length == 0 || cost == null){
            return 0;
        }
        if(length == 1){
            return cost[0];
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        //这里加cost[i]因为i不是最后一个台阶，所以需要爬，要花费体力
        for (int i = 2; i<length;i++){
            dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
        }
        //最后肯定是从倒数第二个爬两阶，这样最后一阶的体力值不算，所以不用加cost[length-1]
        return Math.min(dp[length-1],dp[length-2]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        if (cost==null||cost.length==0){
            return 0;
        }
        if (cost.length==1){
            return cost[0];
        }
        //1.定义dp数组，dp[i]表示爬到第i阶的最低费用
        int[] dp = new int[cost.length+1];
        //2.递推公式: 到第i层有两种方法，从i-1或者i-2
        //3.初始化
        dp[0] = cost[0];
        dp[1] = cost[1];
        //4.遍历
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i]);
        }
        //5.最后一阶是从倒数第二阶爬两层或者倒数第一阶爬一层。那么不需要加最后一阶的费用。
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}
