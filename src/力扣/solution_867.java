package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月02日 13:26
 */
public class solution_867 {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = matrix[j][i];
            }
        }
        return res;
    }
}
