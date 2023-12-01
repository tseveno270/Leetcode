public class solution_198 {

}

class Solution198 {
    public int rob(int[] nums) {
        //1.确定dp意义，dp[i]表示到第i间房能偷到的最大金额
        if(nums.length==0||nums==null){
            return 0;
        }
        if (nums.length==1){return nums[0];}
        int[] dp = new int[nums.length];
        //2.确定递推公式
        //  dp[i]:偷第i间的，那么就不能偷第i-1间的，dp[i-2] + nums[i]
        //        不偷第i间的，dp[i-1]
        // 取最大
        //3.初始化数组
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        //4.遍历
        for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
            }
        return dp[nums.length-1];
    }
}
