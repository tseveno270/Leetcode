/**
 * @author 270
 */
public class solution_8 {
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        String s = "aaa987abcd";
        int atoi = solution8.myAtoi(s);
        System.out.println(atoi);
    }

}
class Solution8 {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        int idx = 0;
        while (idx < n && chars[idx] == ' ') {
            // 去掉前导空格
            idx++;
        }
        if (idx == n) {
            //去掉前导空格以后到了末尾了
            return 0;
        }
        boolean negative = false;
        if (chars[idx] == '-') {
            //遇到负号
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            // 遇到正号
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            // 其他符号
            return 0;
        }
        int ans = 0;
        while (idx < n && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                // 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
                // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
                return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative? -ans : ans;
    }
    public int myAtoi2(String str) {
       char[] chars = str.toCharArray();
       boolean neg = false;
       int n = chars.length;
       int idx = 0;
       while (idx<n&&chars[idx]==' '){
           idx++;
       }
       if (idx==n){
           return 0;
       }
       if (chars[idx]=='-'){
           neg = true;
           idx++;
       }else if (chars[idx]=='+'){
           idx++;
       }else if (!Character.isDigit(chars[idx])){
           return 0;
       }
       int ans = 0;
       while (idx<n&&Character.isDigit(chars[idx])){
           int digit = chars[idx]-'0';
           if (ans>(Integer.MAX_VALUE-digit)/10){
               return neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
           }
           ans = ans*10+digit;
           idx++;
       }
       return neg?-ans:ans;
    }
}
