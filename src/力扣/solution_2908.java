package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年11月09日 8:57
 */
public class solution_2908 {
    public static void main(String[] args) {
        int[] nums = {49,50,48};
        solution_2908 solution = new solution_2908();
        int i = solution.minimumSum(nums);
        System.out.println(i);

    }
    /**暴力循环
     * 元素最小的山形三元组
     *{8,6,1,5,3};
     * @param nums
     * @return
     */
    public int minimumSum(int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            int mini = Integer.MAX_VALUE;
            int mink = Integer.MAX_VALUE;
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    mini = Math.min(nums[i], mini);
                    System.out.println("mini="+mini);
                }
            }
            for (int k = nums.length - 1; k > j; k--) {
                if (nums[k]<nums[j]){
                    mink = Math.min(nums[k],mink);
                    System.out.println(mink);
                }
            }
            if (mini!=Integer.MAX_VALUE&&mink!=Integer.MAX_VALUE){
                result = Math.min(result,mini+nums[j]+mink);
            }
        }
        return result == Integer.MAX_VALUE?-1:result;
    }
    public int mininumSum2(int[] nums){
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                   if (nums[i]<nums[j]&&nums[j]>nums[k]){
                       result = Math.min(result,nums[i]+nums[j]+nums[k]);
                   }
                }
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}
