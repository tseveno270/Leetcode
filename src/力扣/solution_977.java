package 力扣;

import java.util.Arrays;

/**
 * @author 270
 */
public class solution_977 {
    public static void main(String[] args) {
        Solution977 s = new Solution977();
        int[] a = {-4, -1, 0, 3, 10};
        int[] ints = s.sortedSquares(a);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}

class Solution977 {
    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        // 左指针，指向原数组最左边
        int left = 0;
        // 有指针，指向原数组最右边
        int right = nums.length - 1;
        // 创建一个新数组，存储平方值
        int[] result = new int[nums.length];
        // 得到元素值平方值，从新数组最后位置开始写
        int write = nums.length - 1;
        // 左右指针相遇（逐渐靠拢的过程）之后不再循环
        while (left <= right) {
            // 如果原数组的左指针对应的平方值大于右指针，那么往新数组最后位置写入左指针对应的平方值
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[write] = nums[left] * nums[left];
                // 左指针右移
                left++;
                // 移动新数组待写入的位置
                write--;
            } else {
                result[write] = nums[right] * nums[right];
                right--;
                write--;
            }
        }
        return result;
    }

    public int[] sortedSquares2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }

    public int[] sortedSquares3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int write = nums.length - 1;
        int[] result = new int[nums.length];
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[write] = nums[left] * nums[left];
                left++;
                write--;
            } else {
                result[write] = nums[right] * nums[right];
                right--;
                write--;
            }
        }
        return result;
    }

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares4(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int write = nums.length-1;
        int[] result = new int[nums.length];
        while (left<=right){
            if (nums[left]*nums[left]<=nums[right]*nums[right]){
                result[write] = nums[right]*nums[right];
                right--;
                write--;
            }else {
                result[write] = nums[left]*nums[left];
                left++;
                write--;
            }
        }
        return result;
    }
}
