package 笔试;

import java.util.Scanner;

public class 蚂蚁3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        /*int pow = (int)Math.pow(2,26);
        int[] dp = new int[pow];*/
        int[] dp = new int[1<<26];
        dp[0] =1;
        int sum =0;
        long res =0;
        for(char c:str.toCharArray()){
            sum ^= (1<<(c-'a'));
            for (int i =0;i<26;i++)res+=dp[sum^(1<<i)];
            dp[sum]++;
        }
        System.out.println(res);
    }

}
