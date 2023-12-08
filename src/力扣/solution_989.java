package 力扣;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月04日 16:09
 */
public class solution_989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            num = addone(num);
        }
        for (int i = 0; i < num.length; i++) {
            list.add(num[i]);
        }
        return list;
    }

    public int[] addone(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }
}
