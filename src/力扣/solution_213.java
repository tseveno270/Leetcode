public class solution_213 {
}
class Solution213 {
    public int rob(int[] nums) {
        //1.确定dp数组含义，dp[i]表示i间房能偷到的最大利润(不含尾元素)
        //mp[i]dp[i]表示i间房能偷到的最大利润(不含头元素)
        int[] dp = new int[nums.length-1];
        int[] mp = new int[nums.length-1];
        //2.转移方程
        /**
         * 分类讨论
         * 不考虑头元素和不考虑尾元素。取最大值。
         * 这样题目就变成了T198
         */
        if(nums.length==0||nums==null) {
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        if (nums.length>2) {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            mp[0] = nums[1];
            mp[1] = Math.max(nums[1], nums[2]);
        }
        //不含尾元素
        for (int i = 2; i < nums.length-1; i++) {
          dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        int max1 = dp[nums.length-2];

        //不含头元素
        for (int i = 2; i < nums.length-1; i++) {
            mp[i] = Math.max(mp[i-1],mp[i-2]+nums[i+1]);
        }
        int max2 = mp[nums.length-2];
        return Math.max(max2,max1);
    }
}

