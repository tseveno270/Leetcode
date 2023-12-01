public class solution_72 {
}
class Solution72 {
    public int minDistance(String word1, String word2) {
        //1.dp[i][j]表示前i和前j相同的最少操作
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //2.递推公式
        //  if(word1.charAt(i-1)==word2.charAt(j-1)),说明当前位不用操作
        //      那么dp[i][j] = dp[i-1][j-1]
        //如果不相等，要么删除要么替换(a添加等于b删除)
        //删除  dp[i-1][j] + 1或者dp[i][j-1] + 1 比如i删除了一个，那就比较i-2和j-1的即dp[i-1][j]
        //替换  dp[i-1][j-1] + 1 因为将word1[i-1]与word2[j-1]替换为相等了，所以从i-2和j-2位开始统计

        //3.初始化
        dp[0][0] = 0;

        //与空字符串相同只需要删除所有元素
        for (int i = 1; i <=word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <=word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <=word1.length(); i++) {
            for (int j = 1; j <=word2.length(); j++) {
                //word1.charAt(0) 表示第一个元素，charAt（i-1）表示第i个
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }

            }
        }
        return dp[word1.length()][word2.length()];
    }
    public int minDistance2(String word1, String word2) {
        //1.dp[i][j]表示前i个和前j个相等的编辑距离
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //2.递推公式
        //2.1如果当前字符相等
        //dp[i][j] = dp[i-1][j-1]
        // 2.2 需要删除
        //     要么删j要么删i Math.min(dp[i-1][j],dp[i][j-1])+1
        // 2.3 插入 前面的不动，只是当前的插入操作+1
        //     dp[i-1][j-1]+1
        //3.初始化
        dp[0][0] = 0;
        for (int i = 1; i <=word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <=word1.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <=word1.length(); i++) {
            for (int j = 1; j <=word2.length(); j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
        }
}
