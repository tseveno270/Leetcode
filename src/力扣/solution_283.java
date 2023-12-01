/**
 * @author 270
 */
public class solution_283 {

}
class Solution283 {
    public void moveZeroes(int[] nums){
        int length = nums.length;
        int j =0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
             while (j<length){
                 nums[j++] = 0;
             }
        }



    public void moveZeroes2(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i]==0&&nums[j]!=0){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}