import java.util.Stack;

public class solution_844 {
}

class Solution844 {
    public boolean backspaceCompare(String s, String t) {
      Stack<Character> s1 = new Stack<>();
      Stack<Character> t1 = new Stack<>();
        for (char c:s.toCharArray()){
            //当栈空且下一个进栈元素不是#那就入栈
            if (s1.isEmpty()&&c!='#'){
                s1.add(c);
                continue;
            }
            if (!s1.isEmpty()){
                if (c=='#') s1.pop();
                else s1.add(c);
            }
        }

        for (char c:t.toCharArray()){
            //当栈空且下一个进栈元素不是#那就入栈
            if (t1.isEmpty()&&c!='#'){
                t1.add(c);
                continue;
            }
            if (!t1.isEmpty()){
                if (c=='#') t1.pop();
                else t1.add(c);
            }
        }

        //现在将退格操作完成
        while (!s1.isEmpty()&&!t1.isEmpty()){
            if (s1.pop()!=t1.pop())return false;
        }
        return s1.isEmpty()&&t1.isEmpty();
    }
}
