public class solution_1143 {
}
class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        //初始化为0，因为默认值是0，所以不需要再赋值
        for (int i = 1; i <=text1.length(); i++) {
            char A = text1.charAt(i-1);
            for (int j = 1; j <=text2.length(); j++) {
                char B = text2.charAt(j-1);
                if (A==B){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
