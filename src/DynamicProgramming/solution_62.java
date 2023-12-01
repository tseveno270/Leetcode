package DynamicProgramming;

public class solution_62 {
}

class Solution {
    /**
     * 确定dp数组（dp table）以及下标的含义： dp【i】【j】 从起点dp【0】【0】到dp【i】【j】有多少种路径
     * 确定递推公式 dp【i】【j】 = dp【i-1】【j】 + dp【i】【j-1】（因为只能向下或向右走）
     * dp数组如何初始化dp【i】【0】和dp【0】【j】都为1
     * 确定遍历顺序 从左向右
     * 举例推导dp数组
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int [][] dp  = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
