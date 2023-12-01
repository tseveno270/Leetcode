public class solution494 {

}
class Solution494 {
    /**
     * 数组中只有加号减号
     * 假设前面为加号的和为x，则前面为减号的和是sum-x
     * 那么目标值S = x - （sum-x）
     * x = (S+sum)/2,因为x是整数和所以如果有余数证明方法数为零
     * dp[j]表示总和为j的组成方法种数
     * 这里x表示nums能组成的最大值（因为只有加号），所以j的上限为x
     * dp[j] += dp[j-nums[i]]
     * 如dp[j-nums[1]]表示已存在一个nums[i]的情况下的组成情况
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num:
             nums) {
            sum+=num;
        }
        if (((target+sum)%2)!=0){
            return 0;
        }
        int size = (target+sum)/2;
        //这里是防止出现负数，比如[100] -200。那么数组会出现dp[负数]导致报错，所以取绝对值。
        //至于为什么取绝对值不会影响结果，因为既然能凑出正数，那么剩下的肯定能凑出其相反数。所以担任空间是没问题的。
        if(size<0){
            size = -size;
        }
        int[] dp = new int[size+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j>=nums[i]; j--) {
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[size];
    }
    public int findTargetSumWays2(int[] nums, int target) {
        /**
         * 一维不太好想，用二维试试
         * neg为负数和，sum-neg为正数和
         * sum-2*neg = target
         * neg = (sum-target)/2
         */
        int sum = 0;
        for (int num:
             nums) {
            sum+=num;
        }
        int diff = sum - target;
        if (diff%2 !=0||diff<0){
            return 0;
        }
        int neg = diff/2;
        //dp[i][j]表示从nums的前i个元素中选取组合表示j的方案数。而neg为减号的和，
        // 所以dp[nums.length][neg]为答案
        //1.初始化
        int [][] dp = new int[nums.length][neg+1];
        //2.赋值
        dp[0][0] = 1;
        if (nums[0]<=neg)//大于neg的话就不是方案了
            dp[0][nums[0]]=1;
        //3.状态方程d[i][j]分类讨论，如果j<nums[i]那么nums[i]不会添加方案数,则dp[i][j] = dp[i-1][j]
        //如果j>=nums[i]，那么nums[i]可以影响方案数，多出来的dp[i-1][j-nums[i]]
        //                  所以总方案数为dp[i-1][j] + dp[i-1][j-nums[i]]

        //4.遍历
        for (int i = 1; i <nums.length; i++) {
            for (int j = 0; j <=neg; j++) {
                    dp[i][j] = dp[i-1][j];
                if (j>=nums[i]){
                    dp[i][j] = dp[i][j] + dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][neg];
    }


}
