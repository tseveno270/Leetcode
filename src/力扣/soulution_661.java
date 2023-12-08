package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月04日 16:57
 */
public class soulution_661 {
    public static void main(String[] args) {
        soulution_661 s = new soulution_661();
        int[][] res = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        s.imageSmoother(res);
    }

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        if (m==n&&n==1)return img;
        if (m==1&&n!=1){
            res[0][0] = (img[0][0]+img[0][1])/2;
            res[0][n-1] = (img[0][n-1]+img[0][n-2])/2;
            for (int j = 1; j < n-1; j++) {
                res[0][j] = (img[0][j-1]+img[0][j]+img[0][j+1]);
            }
        }
        if (n==1&&m!=1){
            res[0][0] = (img[0][0]+img[1][0])/2;
            res[m-1][0] = (img[m-1][0]+img[m-2][0])/2;
            for (int i = 1; i < m-1; i++) {
                res[i][0] = (img[i][0]+img[i+1][0]+img[i-1][0]);
            }
        }
        if (m!=1&&n!=1){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0)
                        res[i][j] = (img[i][j] + img[i][j + 1] + img[i + 1][j] + img[i + 1][j + 1]) / 4;
                    else if (i == 0 && j == n - 1)
                        res[i][j] = (img[i][j] + img[i][j - 1] + img[i + 1][j] + img[i + 1][j - 1]) / 4;
                    else if (i == m - 1 && j == 0)
                        res[i][j] = (img[i][j] + img[i][j + 1] + img[i - 1][j] + img[i - 1][j + 1]) / 4;
                    else if (i == m - 1 && j == n - 1)
                        res[i][j] = (img[i][j] + img[i][j - 1] + img[i - 1][j - 1] + img[i - 1][j]) / 4;
                    else if (i == 0)
                        res[i][j] = (img[i][j] + img[i][j - 1] + img[i][j + 1] + img[i + 1][j - 1] + img[i + 1][j] + img[i + 1][j + 1]) / 6;
                    else if (i == m - 1)
                        res[i][j] = (img[i][j] + img[i][j - 1] + img[i][j + 1] + img[i - 1][j - 1] + img[i - 1][j] + img[i - 1][j + 1]) / 6;
                    else if (j == 0)
                        res[i][j] = (img[i][j] + img[i - 1][j] + img[i + 1][j] + img[i][j + 1] + img[i + 1][j + 1] + img[i - 1][j + 1]) / 6;
                    else if (j == n - 1)
                        res[i][j] = (img[i][j] + img[i - 1][j] + img[i + 1][j] + img[i][j - 1] + img[i + 1][j - 1] + img[i - 1][j - 1]) / 6;
                    else
                        res[i][j] = res[i][j] = (img[i][j] + img[i - 1][j] + img[i + 1][j] + img[i][j + 1] + img[i + 1][j + 1] + img[i - 1][j + 1] + img[i][j - 1] + img[i + 1][j - 1] + img[i - 1][j - 1]) / 9;

                }
            }
        }
        return res;
    }
}
