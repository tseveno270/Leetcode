package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月07日 17:08
 */
public class solution_551 {
    public static void main(String[] args) {
        solution_551 solution551 = new solution_551();
        boolean result = solution551.checkRecord("PPALLLP");
        System.out.println(result);
    }
    public boolean checkRecord(String s) {
        char[] charArray = s.toCharArray();
        if (s.contains("LLL"))return false;
        int late = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i]=='A')late++;
        }
        if (late>=2)return false;
        return true;
    }
}
