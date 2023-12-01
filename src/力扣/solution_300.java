import java.util.Arrays;

public class solution_300 {
}
class Solution300 {
    public int lengthOfLIS(int[] nums) {
        //下标为i而不是第i个，所以下标i最大取到nums.length.所以初始化不用nums.length+1
     int[] dp = new int[nums.length];
     //结果最小也是1
     int res = 1;
     //初始化为1，因为单个数也算序列，不可能比这个小
     Arrays.fill(dp,1);
     //i表示要添加的数字，从第二个开始遍历，即下标为1开始
        for (int i = 1; i < nums.length; i++) {
            //将i之前的j和i对应的元素比较，如果i大，那可以添加
            //即0到i-1之间寻找最长的子序列+1的最大值
            //这里的含义就是之前最长序列+1，那为什么还要循环呢，为什么不能直接dp[i-1]+1
            //比如【10，9，2，5，3】
            //这样算的话dp【0】 = 1 dp【1】 = 1 dp【2】 = 1 dp【3】 = 2 dp【4】 = 3
            //但起始dp【4】代表的应该是2即【2，5】或者【2，3】
            //错就错在，只考虑了之前是不是有比当前元素小的
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
    return res;
    }
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
