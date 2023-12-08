package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月04日 14:48
 */
public class solution_66 {
    public static void main(String[] args) {
        int[] res = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        solution_66 s = new solution_66();
        s.plusOne1(res);
            for (int i:
                 res) {
                System.out.println(i);
            }
    }

    public int[] plusOne(int[] digits) {
        int temp = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                temp++;
            } else {
                break;
            }
        }
//        System.out.println(temp);
        if (temp == digits.length) {
            int[] res1 = new int[digits.length + 1];
            res1[0] = 1;
            return res1;
        }
        int[] res2 = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i--) {
            if (temp > 0) {
                res2[i] = 0;
                temp--;
            } else if (temp == 0) {
                res2[i] = digits[i] + 1;
                temp--;
            } else {
                res2[i] = digits[i];
            }
            System.out.println(res2[i]);
        }
        return res2;
    }

    public int[] plusOne1(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i]==9){
                digits[i]=0;
            }else {
                digits[i]+=1;
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
