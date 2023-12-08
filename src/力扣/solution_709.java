package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月07日 10:56
 */
public class solution_709 {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    /**
     * 用位运算的技巧
     * 大写变小写、小写变大写 : 字符 ^= 32;
     * 大写变小写、小写变小写 : 字符 |= 32;
     * 小写变大写、大写变大写 : 字符 &= -33;
     * @param str
     * @return
     */
    public String toLowerCase1(String str) {
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                // 将大写字母转换为小写
                c |= 32;
            }
            result.append(c);
        }

        return result.toString();
    }
}
