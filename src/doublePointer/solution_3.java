package doublePointer;

import java.util.HashMap;
import java.util.Map;

public class solution_3 {
    public static void main(String[] args) {
        String s  = "pwkkew";
        Solution3 s1 = new Solution3();
        int i = s1.lengthOfLongestSubstring2(s);
        System.out.println(i);
    }

}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        //1.如果字符串长度为0或1，则返回字符串长度
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        //2.创建哈希表
        HashMap<Character, Integer> map = new HashMap<>();
        //3.设置起点和结果
        int left = 0;
        int result = 0;
        //4.遍历字符串
        for (int i = 0; i < s.length(); i++) {
            /**
             *left = Math.max(start,map.get(s.charAt(i))+1);
             *出现重复字符分为两种情况：
                  1. 当前字符存在于有效子段中（abca）
             到第二个a时，第一个a在map中，为map.get(a) = 0.所以更新左指针位置，
             map.get(s.charAt(a ))+1，这样左指针像右移动了一位，现在指针指向b
             2.当前字符不在有效子段中（abbac）
             当遍历到第二个b的时候，由于当前有效字段为ab，而且a，b此时都在map中，分别为
             *map.get(a) = 0;map.get(b) =1;,此时更新左指针位置left = map.get(b)+1 = 2;
             *而当到第二个a的时候，由于第一个a仍然在map中，如果根据left = map.get(s.charAt(i))+1
             *的规则定义left，则此时left = map.get(a) + 1 = 0 + 1 = 1,这是错误的，
             * 这里因为图的唯一性，left = map,get(b)+1 只能讲重复的b删去，
             * 但是图里的a在其前方，所以再遇到重复的a的时候要取最大值来避免这种情况
             * 因为left应该为第二个b也就是2才对，所以编写  left = Math.max(start,map.get(s.charAt(i))+1);取最大值
             *同时每次循环都更新map中元素—— map.put(s.charAt(i), i);
             */
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            //将字符串的元素存入表中
            map.put(s.charAt(i), i);
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
    public int lengthOfLongestSubstring2(String s) {
    if (s.length()<2){return s.length();}
    int left = 0;
    int len = 0;
    Map<Character,Integer> map = new HashMap<>();
    for (int right = 0;right<s.length();right++){
        if (map.containsKey(s.charAt(right))){
            left = Math.max(left,map.get(s.charAt(right))+1);
        }
        map.put(s.charAt(right),right);
        len = Math.max(len,right-left+1);
    }
    return len;
    }
}
