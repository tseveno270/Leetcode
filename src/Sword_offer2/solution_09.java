package Sword_offer2;

public class solution_09 {
    public static void main(String[] args) {
        Solution09 s = new Solution09();
        System.out.println(s.fib(44));
    }

}
class Solution09 {
    /**
     * 动态规划
     * @param n
     * @return
     */
    public int fib(int n){
        if (n==0||n==1){
            return n;
        }
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] + res[i-2];
            res[i] %= 1000000007;
        }
        return res[n];
    }
}
