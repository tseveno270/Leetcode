package doublePointer;

/**
 * @author 270
 */
public class solution_27 {

}
class Solution27 {
    public int removeElement(int[] nums, int val){
        int fast = 0;
        int slow = 0;
        while(fast<nums.length){
            if (nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }
            ++fast;
        }
        return slow;
    }
}
