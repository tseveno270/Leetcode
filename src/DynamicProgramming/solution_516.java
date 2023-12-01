package DynamicProgramming;

public class solution_516 {
}
class Solution516 {
    public int longestPalindromeSubseq(String s) {
        //1.dp[i][j]表示i，j为端点的的最长子序列长度
        int[][] dp = new int[s.length()+1][s.length()+1];
        //2.递推公式
        //  如果s[i] != s[j] 说明i，j不能同时加入，所以选择加入一个来判断d[i][j] = Math.max(d[i+1][j],d[i][j-1])
        //  如果相等
        //   dp[i][j] = dp[i+1][j-1] +2
        //
        //3.初始化
        dp[0][0] = 0;

        //4.遍历 因为遍历需要dp[i+1][j],所以需要从后往前遍历
        for (int i = s.length()-1; i >=0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] +2;
                }else {
                    dp[i][j] = Math.max(dp[i][j],Math.max(dp[i+1][j],dp[i][j-1]));
                }
            }
        }

        return dp[0][s.length()-1];
    }

    public int longestPalindromeSubseq2(String s) {
      //1.dp[i][j]表示[i,j]之间最长的回文序列长度
        int[][] dp = new int[s.length()+1][s.length()+1];
      //2.递推公式 如果i,j相等，那么直接dp[i-1][j-1]+2
      //如果不相等，那么最多有一个可以加入Math.max(dp[i-1][j],dp[i][j-1])
      //3.初始化
        dp[0][0] = 0;
        //4.遍历，求dp[i][j]需要dp[i+1][j]，所以需要从后往前遍历
        for (int i = s.length()-1; i >=0; i--) {
            dp[i][i] = 1;
            //因为这里j=s.length ,所以初始化需要s.length+1
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] +2;
                }else{
                    dp[i][j] = Math.max(dp[i][j],Math.max(dp[i+1][j],dp[i][j-1]));
                }
            }

        }
        return dp[0][s.length()-1];

    }
}

