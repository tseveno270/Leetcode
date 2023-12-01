package Sword_offer2;

/**
 * @author 270
 */
public class solution_17 {
}
class Solution17 {
    public int[] printNumbers(int n) {
        if (n==0){return null;}
        int[] result = new int[(int) Math.pow(10, n)-1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i+1;
        }
        return result;
    }
}
