package Sword_offer2;

public class solution_42 {

}

class Solution42 {
    public int maxSubArray(int[] nums) {
        //1.dp数组表示下标为i的元素开头的连续子数组的最大和
        int[] dp = new int[nums.length];
        //2.初始化,最后一个元素的最大值为其自身
        dp[nums.length-1] = nums[nums.length-1];
        int max = dp[nums.length-1];
        //3.转移方程dp[i] = max(nums[i]+nums[i+1],nums[i]+dp[i+1])
        for (int i = nums.length-2; i >=0; i--) {
            dp[i] = nums[i]+Math.max(0,dp[i+1]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
