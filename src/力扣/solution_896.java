package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月02日 14:00
 */
public class solution_896 {
    public boolean isMonotonic(int[] nums) {
       boolean flag1 = true;
       boolean flag2 = true;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1]-nums[i]>0) flag1 = false;
            if (nums[i+1]-nums[i]<0) flag2 = false;
        }

        return flag1 || flag2;
    }
}
