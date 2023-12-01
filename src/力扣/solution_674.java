import java.util.Arrays;

public class solution_674 {

}
class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]){
                dp[i] = dp[i-1]+1;
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
