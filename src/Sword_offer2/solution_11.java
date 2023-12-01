package Sword_offer2;

import java.util.Arrays;

public class solution_11 {
}
class Solution11 {
    /**
     * 二分查找
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

}
