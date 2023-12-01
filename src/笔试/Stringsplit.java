package 笔试;

import java.util.Scanner;

public class Stringsplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int N= Integer.parseInt(s[0]);
        for (int i = 1; i < N; i++) {
            int length = s[i].length();
            if (length%8!=0){
                System.out.println(s[i].substring(0,9));
            }
        }
    }
}
