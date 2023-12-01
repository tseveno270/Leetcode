package Sword_offer2;

public class solution_47 {

}
class Solution47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //初始化，表示到达第ij个单元的最高价值
        int[][] dp = new int[m][n];

        //赋值
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        //特殊情况
        if (m==1&&n==1){
            return dp[0][0];
        }
        if (m==1){
            return dp[0][n];
        }
        if (n==1){
            return dp[m][0];
        }

        int max = 0;
        //状态方程
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                max = Math.max(dp[i][j],max);
            }
        }
        return max;
    }
}
