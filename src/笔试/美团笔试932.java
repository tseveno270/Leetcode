package 笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 美团笔试932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(s[i]));
        }
        for (int i = 0;i<n;i++){
            Integer remove = list.remove(i);
            for (int j = 0; j < n; j++) {
                if (!list.contains(j)){
                    System.out.print(j+" ");
                    break;
                }
            }
            list.add(i,remove);
        }
        }
    }

