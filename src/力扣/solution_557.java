/**
 * @author 270
 */
public class solution_557 {
    public static void main(String[] args) {
        Solution557 s = new Solution557();
        String string = "Let's take LeetCode contest";
        String s1 = s.reverseWords(string);
        char[] chars = s1.toCharArray();
        System.out.println(s1);

    }
}
class Solution557 {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            buffer.append(new StringBuffer(strs[i]).reverse().toString());
            buffer.append(" ");
        }
        return buffer.toString().trim();
    }
}
