package Sword_offer2;

public class solution_14 {
}
class Solution {
    /**
     * 动态规划
     * //长度为二时乘积固定
     *         temp[2] = 1;
     *         //从长度为三开始计算
     *         for (int i = 3; i <n+1; i++) {
     *             //减去长度为j的一段绳子，j>1且j<n
     *             for (int j = 2;j<i;j++){
     *                 //转移方程如下
     *                 temp[i] = Math.max(temp[i],Math.max(j*(i-j),j*temp[i-j]));
     *【尝试在动态规划的基础上取余，就算把数据类型都换成long也是无解的，对每次的dp[i]取余确实可以避免溢出的问题，但是由于过程中修改了值，会导致最终结果和预期不同。比如
     * 这一步：
     * dp[i] = Math.max(dp[i] ，x * y );
     * x * y = 1000000005 ，若dp[i] 本该等于 1000000008 ，但是经过上次取余后变成了1，本来的结果应该是1000000008 ，
     * 现在却变成了1000000005，所以在动态规划过程中是不能取余的，那么就只能使用BigInter存储中间结果了】
     *
     * 所以这道题该用贪心算法，尽可能的分为长度为三的小段并相乘
     */
    public int cuttingRope(int n) {
       if (n<3){return 1;}
       if (n==3){return 2;}
       if (n==4){return 4;}
       long res = 1;
        int mod = 1000000007;
       while(n>3){
            res*=3;
            res%=mod;
            n-=3;
       }
       return (int)(n*res%mod);
    }
}
