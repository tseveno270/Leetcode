package DynamicProgramming;

public class solution_115 {
}
class Solution115 {
    public int numDistinct(String s, String t) {
        //1.dp[i][j]表示前i-1元素的s包含t前j-1个元素的方案数
        int[][] dp = new int[s.length()+1][t.length()+1];
        //2.递推公式
        //dp[i][j] 若s[i-1] = t[j-1],那么要看那之前的
        //          dp[i][j] = dp[i-1][j-1] + dp[i-1][j] 含义为最后一位相等，
        //要么前面相等的是不含最后一位的其他位dp[i-1][j-1],要么前面已经全部相等只需把最后一位相等的换为当前位即dp[i][j-1]
        //         若不相等 dp[i][j] = dp[i-1][j]
        //3.初始化 递推公式得要初始化dp[i-1][j-1],dp[i-1][j],dp[0][0]和dp[0][j]都是0为默认值,dp[i][0]等于i包含空字符串的个数为1
        dp[0][0] = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < t.length(); j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <=s.length(); i++) {
            for (int j = 1; j <=t.length(); j++) {
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
