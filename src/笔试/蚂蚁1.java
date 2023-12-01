package 笔试;

import java.util.Scanner;

public class 蚂蚁1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        StringBuilder res = new StringBuilder();
        while (s>0){
            if (s==1) {
                res.append("a");
                break;
            }
        double a = (int)(Math.log(s)/Math.log(2));
        res.append((char)(a+'a'));
        s-=Math.pow(2,a);
        }
        System.out.println(res);
    }
}
