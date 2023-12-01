package 笔试;

import java.util.Scanner;

public class solution23333 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[n];
        boolean[] status = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums.length) {
                status[nums[i]] = true;
            }
        }
        for (int i = 0; i < status.length; i++) {
            if (status[i] == false){
                System.out.print(i);
                break;
            }
        }
    }
}

