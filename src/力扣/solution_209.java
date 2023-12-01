package 力扣;


class Solution209 {
    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        int i = solution209.minSubArrayLen2(11, new int[]{1, 2, 3, 4, 5});


    }

    /**
     * 滑动窗口
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int right = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
