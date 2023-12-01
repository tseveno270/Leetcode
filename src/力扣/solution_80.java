public class solution_80 {
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len<2){return nums.length;}
        int slow = 2;
        int fast = 2;
        while (fast<len){
            if (nums[slow-2]!=nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
