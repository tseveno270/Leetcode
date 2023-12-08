package 力扣;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月07日 15:41
 */
public class solution_1704 {
    public boolean halvesAreAlike(String s) {
        char[] c = {'a','e','i','o','u','A','E','I','O','U'};
        List<Character> list = new ArrayList<>();
        for (char a: c) list.add(a);
        char[] charArray = s.toCharArray();
        int l = 0;
        int r = 0;
        for (int i = 0; i < charArray.length/2; i++) if (list.contains(charArray[i]))l++;
        for (int i = charArray.length/2; i < charArray.length; i++) if (list.contains(charArray[i]))r++;
        return l==r;
    }
}
