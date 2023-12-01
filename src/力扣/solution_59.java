package 力扣;

class Solution59 {
    public static void main(String[] args) {
        Solution59 s = new Solution59();
        int[][] res = s.generateMatrix(10);
        for (int[] ints :
                res) {
            for (int i = 0; i < ints.length; i++) {
                System.out.print(ints[i] + " ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        //定义四个边界
        /**
         * r,b两个边界不能设为n，因为输出大小为【n】【n】的数组其上限就是n-1；
         */
        int[][] result = new int[n][n];
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = n - 1;
        int num = 1;
        while (num <= n * n) {
            for (int i = l; i <= r; i++) result[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) result[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--) result[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) result[i][l] = num++;
            l++;
        }
        return result;
    }
}
