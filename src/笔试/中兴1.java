package 笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 中兴1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(" ");
        String start = strings[0];
        String end = strings[1];
        int n = Integer.parseInt(end.substring(1,2))-Integer.parseInt(start.substring(1,2));
        int m = (end.charAt(0)-'0')-(start.charAt(0)-'0');
        char ans = start.charAt(0);
        List<String> list = new ArrayList<>();
        //
        for (int i = 0; i <m+1; i++) {
            for (int j = 1; j <=n+1; j++) {
                if (j==n+1&&i==m){
                    StringBuffer res = new StringBuffer();
                    res.append(ans).append(String.valueOf(j));
                    list.add(res.toString());


                }else {
                    StringBuffer res = new StringBuffer();
                    res.append(ans).append(String.valueOf(j));
                    list.add(res.toString());


                }
            }
            ans++;
        }
        System.out.println(list.toString());
    }
}
