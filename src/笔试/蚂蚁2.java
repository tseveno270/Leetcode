package 笔试;
import java.util.Scanner;


public class 蚂蚁2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] hyb = new int[n][2];
        for (int i = 0; i < n-1; i++) {
            hyb[i][0] = sc.nextInt();
            hyb[i][1] = sc.nextInt();
        }
        int[][] nums = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            nums[hyb[i][1]][hyb[i][0]] = 1;
            nums[hyb[i][0]][hyb[i][1]] = 1;

        }
        int res = dfs(nums,1);
        System.out.println(res);
}

    private static int dfs(int[][] nums, int index) {
        int num = 0;
        for (int i = 0; i < nums[index].length; i++) {
            if (nums[index][i]==1){
                nums[index][i]=0;
                nums[i][index]=0;
                int j = dfs(nums,i);
                if (j!=0){num+=(j-index+1);}
            }
        }
        return num+index-1;
    }
}
