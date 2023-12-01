package 笔试;

import java.util.Scanner;

public class sf2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        dp[1] =1;
        dp[2] =1;
        dp[3] =1;
        for (int i = 4; i <=n; i++) {
            dp[i] = (dp[i-1]%1000000007)+(dp[i-2]%1000000007)+(dp[i-3]%1000000007)+1;
            dp[i]%=1000000007;
        }
        System.out.println(dp[n]%1000000007);
    }

}
