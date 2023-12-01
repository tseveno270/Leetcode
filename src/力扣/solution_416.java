public class solution_416 {

}
class Solution416 {
    /**
     * 转化为01背包问题
     * 容量为sum/2,价值和重量都为元素的数值
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums==null||nums.length==0){
            return false;
        }
        int sum = 0;
        for (int num:
                nums) {
            sum+=num;
        }
        if (sum%2!=0){return false;}
        int target = sum/2;
        int[] dp = new int[target+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j>=nums[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target] == target;
    }
}
