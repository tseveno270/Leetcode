package DynamicProgramming;

public class bag01 {

}
class solutionbag {
    /**
     * 01背包问题
     * @param weight
     * @param value
     * @param size
     */
    public static void bag(int[] weight,int[] value,int size){
        //1.dp[i][j]表示j容量下存放前i个物品的最大值
        int[][] dp = new int[weight.length+1][size+1];
        //2.初始化 dp[i][0] = 0 dp[0][j] = 0(j小于第一件容量) dp[0][j] = value[0](j>=第一件容量)
        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }
        //3.遍历，先遍历物品，再遍历背包容量
        //转移方程，dp[i][j] = max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= size; j++) {
                if (j<weight[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }

    }

    /**
     * 一维数组遍历
     * @param weight
     * @param value
     * @param bagWeight
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++){
            for (int j = bagWeight; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }
}
