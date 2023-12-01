package DynamicProgramming;

public class solution_70 {

}

class Solution70 {
    public int climbStairs(int n) {
        if(n<3){
            return n;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 2; i < n; i++) {
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 理解为完全背包的排列问题
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
    int[] weight = {1,2};
    int[] dp = new int[n+1];
    //递归初始化需要dp[0] = 1,也很好理解爬零层台阶有一种方法即不爬。
    dp[0] = 1;
    //这是排列有先后顺序问题所以需要先遍历容量并嵌套物品
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <weight.length; j++) {
                if (weight[j]<=i){
                    dp[i]+=dp[i-weight[j]];
                }
            }
        }
        return dp[n];

    }

    /**
     * 理解成完全背包问题的排列问题，外层背包内层物品，从小到大
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
     int[] weight = {1,2};
     int[] dp = new int[n+1];
     dp[0] = 1;
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <weight.length; j++) {
                if (weight[j]<=i){
                    dp[i]+=dp[i-weight[j]];
                }
            }
        }
        return dp[n];
    }

}
