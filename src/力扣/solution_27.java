package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年10月27日 13:51
 */
public class solution_27 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3,2,3,4};
        solution_27 s = new solution_27();
        int i = s.removeElement(nums, 3);
        System.out.println(i);
    }
    public int removeElement(int[] nums, int val) {
        int slow = 0;//慢指针
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast]!=val){//快指针遍历至不等于val的值,则慢指针后移
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}

