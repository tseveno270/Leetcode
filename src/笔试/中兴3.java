package 笔试;

import java.util.Scanner;

public class 中兴3  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        //nums[s.length] = 0;
        int[] dp = new int[s.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 2; i <dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i-1], dp[i - 1]);
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
