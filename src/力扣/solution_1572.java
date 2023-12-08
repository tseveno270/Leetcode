package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月02日 13:40
 */
public class solution_1572 {
    public int diagonalSum(int[][] mat) {
        int res = 0;
        int m = mat.length;
        for (int i = 0; i < m; i++) {
                res+=mat[i][i];
                res+=mat[i][m-1-i];
        }
        if (m%2!=0){
            res-=mat[(m-1)/2][(m-1)/2];
        }
        return res;
    }
}
