package Sword_offer2;

public class solution_46 {

}

class Solution46 {

    public int translateNum(int num) {
        //把整数各位转为数组
        String str = String.valueOf(num);
        int[] temp = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            temp[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        //1.dp[i]表示以第i位数字表示的字符串个数
        //2.初始化 一位数为1，两位数如果大于25，也为1
        int[] dp = new int[temp.length];
        dp[0] = 1;
        if (temp.length<2){
            return 1;
        }
        int test = temp[0]*10 +temp[1];
        if (test>25){
            dp[1] = 1;
        }else {
            dp[1] = 2;
        }
        for (int i = 2; i <temp.length; i++) {
            if (temp[i-1]*10 +temp[i]>25 || temp[i-1]==0){
                dp[i] = dp[i-1];
            }else if(temp[i-1]!=0){
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[temp.length-1];
    }
}

class solutiontwo{
    class Solution {
        public int translateNum(int num) {
            String s = String.valueOf(num);
            int a = 1, b = 1;
            for(int i = s.length() - 2; i > -1; i--) {
                String tmp = s.substring(i, i + 2);
                int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
                b = a;
                a = c;
            }
            return a;
        }
    }
}
