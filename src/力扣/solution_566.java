package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月02日 16:24
 */
public class solution_566 {
    public static void main(String[] args) {
        solution_566 s = new solution_566();
        int[][] mat = {{1,2},{3,4}};
        s.matrixReshape(mat,1,4);

    }
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int[] nums = new int[m*n];
        int[][] res = new int[r][c];
        int flag = 0;
        if (r*c!=m*n)return mat;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[flag++] = mat[i][j];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        flag = 0;
        for (int i = 0; i <r; i++) {
            for (int j = 0; j <c; j++) {
                res[i][j] = nums[flag++];
            }
        }
        return res;
    }
}
