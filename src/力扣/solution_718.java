public class solution_718 {
}
class Solution718 {
    public int findLength(int[] nums1, int[] nums2) {
        //dp[i][j]表示nums1中i-1前元素和nums2中j-1前元素的最长序列长度
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        //初始化
        if (nums1.length==0||nums1==null||nums2.length==0||nums2==null){
            return 0;
        }
        dp[0][0] = 0;
        int res = 0;

            for (int i = 0; i <=nums1.length; i++) {
                dp[i][0] = 0;
            }
            for (int j = 0; j < nums2.length; j++) {
                dp[0][j] = 0;
            }

        //因为需要取到所有数组元素
        for (int i = 1; i <nums1.length; i++) {
            for (int j = 1; j <nums2.length; j++) {
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(dp[i][j],res);
                }
            }
        }
        return res;
    }
}
