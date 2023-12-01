public class solution_415 {
}
class Solution415 {
    /**
     * 模拟竖式加法
     * 因为String的append方法是在尾部添加，所以最后需要反转字符串
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
       int i = num1.length()-1;
       int j = num2.length()-1;
       StringBuilder res = new StringBuilder();
       int add = 0;
       while(i>=0||j>=0||add!=0){
           int a = i>=0?num1.charAt(i)-'0':0;
           int b = j>=0?num2.charAt(j)-'0':0;
           int temp = a+b+add;
           res.append(temp%10);
           add = temp/10;
           i--;
           j--;
       }
       return res.reverse().toString();
    }
}
