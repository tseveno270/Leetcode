package 笔试;

import java.util.ArrayList;

public class 美的2 {
    public static void main(String[] args) {
        int i = 9;
        int j = 8;
        int n = (i|j)%(i&j);
        System.out.println(n);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param m int整型
     * @param n int整型
     * @return int整型ArrayList
     */
    public ArrayList<Integer> findPrimeNumber (int m, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = m; i <=n; i++) {
            int j =2;
            for ( ; j < i; j++) {
                if (i%j==0){
                    break;
                }
            }
            if (j==i){
                res.add(i);
            }
        }
        return res;
    }
}
