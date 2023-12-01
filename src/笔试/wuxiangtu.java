package 笔试;

import java.util.Scanner;

public class wuxiangtu {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String[] sa = sc.nextLine().split(" ");
        int[] a = new int[num];
        for (int i = 0; i < num; i++) {
            a[i] = Integer.parseInt(sa[i]);
        }
        //输出
        int[] result = search(a);
        int index = result[0];
        int res = result[1];
        if (index==0){
            a[0] = a[1];
            result = search(a);
            System.out.println(result[1]);
        }else {
            int min = Math.min(a[index-1],Math.max(a[index+1],a[index]));
            int max = Math.max(a[index-1],Math.max(a[index+1],a[index]));
            for (a[index] = min;a[index]<max;a[index]++){
                result = search(a);
                res = Math.min(res,result[1]);
            }
        System.out.println(res);
        }

    }
    private static int[] search(int[] res){
        int[] result = new int[2];
        result[0] = 0;
        result[1] = Math.abs(res[1]-res[0]);
        for (int i = 2; i < res.length; i++) {
            if (Math.abs(res[i]-res[i-1])>result[1]){
                result[0] = i-1;
                result[1] = Math.abs(res[i]-res[i-1]);
            }
        }
        return result;
    }
}
