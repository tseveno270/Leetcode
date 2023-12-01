public class solution_583 {
}
class Solution583 {
    public int minDistance(String word1, String word2) {
        //1.转化为寻找相同的最长连续子序列，然后返回word1.length+word2.length-2*子序列长度
        //2.dp[i][j]表示word1的前i-1元素和word2的前j-1元素的最长子序列长度
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //3.递推公式
        //  dp[i][j] 如果word1[i-1] == word2[j-1]
        //           dp[i][j] = dp[i-1][j-1] + 1
        //           如果不同
        //           dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])
        //4.初始化
        dp[0][0] = 0;
        for (int i = 0; i < word1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < word2.length(); j++) {
            dp[0][j] = 0;
        }
        int res = 0;
        for (int i = 1; i <=word1.length(); i++) {
            for (int j = 1; j <=word2.length(); j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                res = Math.max(dp[i][j],res);
            }
        }
        return word1.length()+word2.length()-2*res;
    }

    public int minDistance2(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) dp[i][0] = i;
        for (int j = 0; j < word2.length() + 1; j++) dp[0][j] = j;

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 2,
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
