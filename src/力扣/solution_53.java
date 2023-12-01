public class solution_53 {
}
class Solution53 {
    public int maxSubArray(int[] nums) {
        //dp[i]表示包括i的子序列最大和
        int[] dp = new int[nums.length];
        //递推公式
        //dp[i] = Math.max(dp[i-1] +nums[i],nums[i])
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i <nums.length; i++) {
            dp[i] = Math.max(dp[i-1] +nums[i],nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
      int[] dp = new int[nums.length];
      dp[0] = nums[0];
      int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
