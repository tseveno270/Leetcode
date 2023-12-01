package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class sf1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        int ans = 0;
        if (n>m) System.out.println(0);
        else {
            while (arr[arr.length - m] != 0) {
                ans += arr[arr.length - m];
                for (int i = 0; i < m; i++) {
                    arr[arr.length - 1 - i] -= arr[arr.length - m];
                }
                Arrays.sort(arr);
            }
            System.out.println(ans);
        }
    }
}
