/**
 * @author 270
 */
class Solution35 {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        int mid = (left+right)/2;
        int midVal = nums[mid];
        //说明原数组不存在相同的值，此时left和right分别指向距离target最接近的两个值
        //此时left=right+1
        //target应该顶替比它大的数字里面下标最小的一个，也就是当前下标为left的值
        if (left>right){
            return left;
        }
        if (midVal>target){
            return binarySearch(nums,left,mid-1,target);
        }else if (midVal<target){
            return binarySearch(nums,mid+1,right,target);
        }else {
            return mid;
        }
    }
}
