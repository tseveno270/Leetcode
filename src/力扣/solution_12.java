import java.util.Random;

/**
 * @author 270
 */
public class solution_12 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String s = solution.intToRoman(50);
        System.out.println(s);
        Random random = new Random();
        int i = random.nextInt()*2;
        System.out.println(i);

    }
}
class Solution2 {
    /**
     * 这里想用hashmap实现，但hashmap遍历出来的顺序是完全随机的，不合适
     * @param num
     * @return
     */
        public String intToRoman(int num) {
            int[] a = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
            String[] s = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            String res = "";
            for (int i = 0; i < a.length; i++) {
                while (num>=a[i]){
                    num -= a[i];
                    res += s[i];
                }
            }
            return res;

        }
    }

