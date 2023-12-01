package 笔试;

import java.util.Scanner;

public class 字符串大小写转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (i<k){
                sb.append(Character.toUpperCase(s.charAt(i)));
            }else {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        System.out.println(sb.toString());
    }
}
