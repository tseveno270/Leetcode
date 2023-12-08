package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月07日 11:02
 */
public class solution_1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        for (String s:
             word1) {
            s1.append(s);
        }
        for (String s:
                word2) {
            s2.append(s);
        }
        return s1.toString().equals(s2.toString());
    }
}
