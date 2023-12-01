public class solution_26 {
    public static void main(String[] args) {

    }
}
class Solution26 {
    /**
     * 双指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (nums.length<2){
            return n;
        }
        int fast = 1;
        int slow = 1;
        while(fast<n){
            if (nums[fast]!=nums[fast-1]){
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
    public int removeDuplicates2(int[] nums) {
       int n = nums.length;
       int slow = 1;
       int fast = 1;
       if (nums.length<2){return n;}
       while (fast<n){
           if (nums[fast]!=nums[fast-1]){
               nums[slow] = nums[fast];
               slow++;
           }
           fast++;
       }
       return slow;
    }
}
