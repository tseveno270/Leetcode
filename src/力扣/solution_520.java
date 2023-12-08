package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月07日 14:41
 */
public class solution_520 {
    public boolean detectCapitalUse(String word) {
        char[] c = word.toCharArray();
        int num = 0;
        for (char point : c) {
            if (point >= 'A' && point <= 'Z') num++;
        }
        return num == c.length || num == 0 || (num == 1 && c[0] >= 'A' && c[0] <= 'Z');
    }
}
