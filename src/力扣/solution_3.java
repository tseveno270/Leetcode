import java.util.HashMap;
import java.util.Map;

public class solution_3 {
}
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<2){return s.length();}
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int len = 0;
        //1.如果表中不含当前字符 left = map.get(s.charAt(i))+1)
        //2.如果表中包含当前字符，那么从map.get(s.charAt(i))+1)开始也可能会包含重复字符
        // 那就需要从上一个left开始算。即left = Math.max(left,map.get(s.charAt(i))+1)
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))){
                left = Math.max(left,map.get(s.charAt(right))+1);
            }
            map.put(s.charAt(right),right);
            len = Math.max(len,right-left+1);
        }
        return len;
    }

    public int lengthOfLongestSubstring2(String s){
        if (s.length()<2||s==null){return s.length();}
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int len = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))){
                left = Math.max(left,map.get(s.charAt(right))+1);
            }
            map.put(s.charAt(right),right);
            len = Math.max(len,right-left+1);
        }
        return len;
    }
}
