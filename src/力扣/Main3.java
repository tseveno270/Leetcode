import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n种商品
        int n = sc.nextInt();
        //原价
        int[] yuan = new int[n];
        for (int i = 0; i < n; i++) {
            yuan[i] = sc.nextInt();
        }
        //折扣
        int[] zhe = new int[n];
        for (int i = 0; i < n; i++) {
            zhe[i] = sc.nextInt();
        }
        //满减数量
        int m = sc.nextInt();
        //满减c
        int[] c = new int[m];
        for (int i = 0; i < m; i++) {
            c[i] = sc.nextInt();
        }
        //满减d
        int[] d = new int[m];
        for (int i = 0; i < m; i++) {
            d[i] = sc.nextInt();
        }
        System.out.println(sol(n,yuan,zhe,m,c,d));

    }

    private static String sol(int n, int[] yuan, int[] zhe, int m, int[] c, int[] d) {
        StringBuilder res = new StringBuilder();
        int zhekou = 0;
        int zongjia = 0;
        for (int i = 0; i < n; i++) {
            zhekou = zhekou+zhe[i];
            zongjia = zongjia + yuan[i];
            if (i<m-1){
                if (zongjia-zhekou==0)res.append('B');
                else res.append('Z');
            }else {
                for (int index = 0; index < m-1; index++) {
                    if (zongjia>=c[m-1]){
                        if (zhekou<zongjia-d[m-1])res.append('Z');
                        else if (zhekou>zongjia-d[m-1])res.append('M');
                        else res.append('B');
                    }
                    if (zongjia<c[0]){
                        if (zongjia-zhekou==0)res.append('B');
                        else res.append('Z');
                    }
                    if (zongjia>=c[index]&&zongjia<c[index+1]){
                        if (zhekou<zongjia-d[index])res.append('Z');
                        else if (zhekou>zongjia-d[index])res.append('M');
                        else res.append('B');
                    }
                }
            }
        }
        String s = res.toString().trim();
        return s;
    }

}
