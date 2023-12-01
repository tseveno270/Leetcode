package 笔试;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        int M = scanner.nextInt();
        scanner.nextLine();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            int parent = Integer.parseInt(s1[0]);
            for (int j = 1; j < s1.length; j++) {
                map.put(Integer.parseInt(s1[j]),parent);
            }
        }
        int m1 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int res = 0;
        while (m1!=m2&&map.containsKey(m1)){
            ++res;
            m1 = map.get(m1);
        }
        while (m1!=m2&&map.containsKey(m2)){
            m2 = map.get(m2);
            ++res;
        }
        System.out.println(m1!=m2?-1:res);
    }
}
