public class solution_377 {

}
class Solution377 {
    /**
     * 完全背包求次数
     *
     * 排列数：先遍历容量再遍历背包
     * 组合数：先遍历背包再遍历容量
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int j = 0; j <=target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j>=nums[i]){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}
