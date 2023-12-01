import java.util.Stack;

/**
 * @author 270
 */
public class solution_20 {
    public static void main(String[] args) {
        Solution20 s = new Solution20();
        String s1 = "{[()]}";
        boolean valid = s.isValid(s1);
        System.out.println(valid);
        System.out.println(s1);
    }
}
class Solution20 {
    /**
     *
     * 利用栈先入后出的特点利用栈完成逻辑判断
     * 1.左括号直接入栈相应的右括号
     * 2.中途栈不为空的情况下(遍历中途为空说明左右括号数量不等，返回false)，若为右括号判断与stack.pop()是否匹配
     * 3.如果栈非空并且push的为右括号，返回false
     * 4.如果最后栈为空，那么返回true
     * @param s
     * @return
     */
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()){
            if (c=='{')stack.push('}');
            else if (c=='[')stack.push(']');
            else if (c=='(')stack.push(')');
            else if (!stack.isEmpty()&&c==stack.peek())stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }

}
