package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年10月30日 16:18
 */
public class solution_2894 {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i <=n; i++) {
            if (i%m==0)num2+=i;
            else num1+=i;
        }
        return num1 - num2;
    }
}
