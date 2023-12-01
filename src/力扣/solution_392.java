public class solution_392 {
}
class Solution392 {
    public boolean isSubsequence(String s, String t) {
     //dp[i][j]表示j-1(包括)之前的t子序列是否包含s的前i-1个元素
        boolean[][] dp = new boolean[s.length()+1][t.length()+1];
        dp[0][0] = true;
        for (int j = 0; j < t.length(); j++) {
            dp[0][j] = true;
        }
        if (s==null||s.length()==0){
            return true;
        }
        for (int i = 1; i <=s.length(); i++) {
            for (int j = 1; j <=t.length(); j++) {
                if (s.charAt(i-1)==t.charAt(j-1)&&dp[i-1][j-1]){
                    dp[i][j] = true;
                }else{
                    dp[i][j] =  dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public boolean isSubsequence2(String s, String t) {
        int length1 = s.length(); int length2 = t.length();
        int[][] dp = new int[length1+1][length2+1];
        for(int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if(dp[length1][length2] == length1){
            return true;
        }else{
            return false;
        }
    }
}
