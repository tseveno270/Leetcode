/**
 * @author 270
 */
public class solution_189 {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        Solution189 s = new Solution189();
        s.rotate(nums,3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
}
class Solution189 {
    /**
     * 额外数组存放
     * O(n),O(n)
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k){
        int fast = 0;
        int slow = k%nums.length;
        int[] result = new int[nums.length];
        while (fast<nums.length){
            result[slow] = nums[fast];
            ++fast;
            slow = (fast+k)%nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    /**
     * 翻转数组
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
}
}
