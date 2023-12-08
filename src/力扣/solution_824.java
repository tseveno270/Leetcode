package 力扣;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月07日 16:11
 */
public class solution_824 {
    public static void main(String[] args) {
        solution_824 solution824 = new solution_824();
        String s = "I speak Goat Latin";
        System.out.println(solution824.toGoatLatin(s));
    }
    public String toGoatLatin(String sentence) {
        String[] strings = sentence.split(" ");
        StringBuffer[] stringBuffers = new StringBuffer[strings.length];
        StringBuffer result = new StringBuffer();
        List<Character> list = new ArrayList<>();
        char[] c = {'a','e','i','o','u','A','E','I','O','U'};
        for (char a:c) list.add(a);
        for (int i = 0; i < strings.length; i++) {
            //初始化String-buffer
            stringBuffers[i] = new StringBuffer();
            if (list.contains(strings[i].charAt(0))){
                stringBuffers[i].append(strings[i]);
            }else {
                stringBuffers[i].append(strings[i].substring(1)).append(strings[i].charAt(0));
            }
            stringBuffers[i].append("ma");
            for (int j = -1; j < i; j++) {
                stringBuffers[i].append('a');
            }
        }
        for (int i = 0; i < stringBuffers.length; i++) {
            if (i<stringBuffers.length-1) result.append(stringBuffers[i]).append(" ");
            else result.append(stringBuffers[i]);
        }
        return result.toString();
    }
}
