public class solution_474 {

}
class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        //1.初始化，表示含有m个0，n个1的最大子集元素个数
        int[][] dp = new int[m+1][n+1];
        //2.赋值
        dp[0][0] = 0;
        //3.遍历过程中取最大值：
        // 转移方程 dp[i][j] = max（dp[i-当前元素的1的个数][j-当前元素的0个数] + 1，dp[i][j])
        //4.m和n都是背包容量，所以这还是一个01背包问题。只不过是二维背包。
        //  所以dp[m][n]是滚动数组，需要倒序遍历。同时先进行物品遍历再进行容量遍历
        // 物品重量就是每个字符串的0、1个数
        int zero;
        int one;
        for (int i = 0; i < strs.length; i++) {
             zero = 0;
             one  = 0;
            for (char c:
                 strs[i].toCharArray()) {
                if (c=='0'){
                    zero++;
                }else{
                    one++;
                }
            }
            for (int j1 = m; j1 >=zero; j1--) {
                for (int j2 = n; j2>=one; j2--) {
                    dp[j1][j2] = Math.max(dp[j1-zero][j2-one]+1,dp[j1][j2]);
                }
            }
        }
        return dp[m][n];
    }
}

