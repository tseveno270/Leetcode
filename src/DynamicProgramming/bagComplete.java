package DynamicProgramming;

public class bagComplete {
}
class SolutionbagComplete{
    /**
     * 对于背包遍历问题
     * 01背包 : 二维dp数组可以颠倒顺序——都是从左边或者上边的值求得当前值的，所以不会影响
     *          一维dp数组，先物品后容量——容量是倒序遍历所以需要内嵌。如果在外层每次遍历后背包内只会有一件物品。
     *                                      正序遍历的话会重复使用外层物品的价值导致重复指d[j-weight[i]] + value[i] 的value[i]
     * 完全背包：都可以颠倒
     *          一维dp数组，不管什么顺序容量都需要正序遍历
     *          【注意】：这只是指纯背包问题，如果是求存放种类或者别的变种问题的话遍历顺序需要具体分析
     *
     * 在求装满背包有几种方案的时候，认清遍历顺序是非常关键的。
     * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
     * 如果求排列数就是外层for遍历背包，内层for循环遍历物品
     */
    //先遍历物品，再遍历背包
    private static void testCompletePack(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++){ // 遍历物品
            for (int j = weight[i]; j <= bagWeight; j++){ // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int maxValue : dp){
            System.out.println(maxValue + "   ");
        }
    }

    //先遍历背包，再遍历物品
    private static void testCompletePackAnotherWay(){
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 1; i <= bagWeight; i++){ // 遍历背包容量
            for (int j = 0; j < weight.length; j++){ // 遍历物品
                if (i - weight[j] >= 0){
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        for (int maxValue : dp){
            System.out.println(maxValue + "   ");
        }
    }
}
