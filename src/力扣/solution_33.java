public class solution_33 {
}

class Solution33 {
    /**
     *题中数组特点，取任意一个元素，它的左侧或者右侧一定是有序数组
     * 那么就可以用二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while (low<=high){
            mid = (low + high)/2;
            if (nums[mid]==target){return mid;}
            //判断那一侧为有序序列
            else if (nums[mid]<nums[high]){
                if (nums[mid]<target&&target<=nums[high]) {
                    low++;
                }
                else {
                    high--;
                }
            }else {
                if (nums[mid]>target&&target>=nums[low]){
                    high--;
                }else {
                    low++;
                }
            }
        }
        return -1;
    }

}
