package Sword_offer2;

public class solution_16 {
    public static void main(String[] args) {
        Solution16 s = new Solution16();
        double v = s.myPow(2, 10);
        System.out.println(v);
    }
}

class Solution16 {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if (n==1){
            return x;
        }
       if (n==-1){
           return 1/x;
       }
       double half = myPow(x,n/2);
       double mod = myPow(x,n%2);
       return half*half*mod;
    }
    /**这样递归遇到测试用例0.00001 2147483647会卡住
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }else if (n>0){
            return x*myPow(x,n-1);
        }else{
            return 1/(x*myPow(x,n+1));
        }
    }
    */
}
