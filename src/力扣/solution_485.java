package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月04日 16:44
 */
public class solution_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int temp = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                temp++;

            }else {
                temp = 0;
            }
            max = Math.max(max, temp);
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}
