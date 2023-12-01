package 力扣;

/**
 * @author 270
 */
public class solution_704 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        Solution704 solution704 = new Solution704();
        int search = solution704.search(nums, 9);
        System.out.println(search);
    }
}
class Solution704 {
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
    private int binarySearch(int[] nums, int left, int right, int target) {
        int mid = (left+right)/2;
        int midVal = nums[mid];
        if (left>right){
            return -1;
        }
        if (midVal>target){
            return binarySearch(nums,left,mid-1,target);
        }else if (midVal<target){
            return binarySearch(nums,mid+1,right,target);
        }else {
            return mid;
        }
    }


    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left + (right - left)/2;
            if (nums[mid]>target){
                right = mid - 1;
            }else if(nums[mid]< target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }



}
