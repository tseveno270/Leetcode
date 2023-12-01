public class solution_88 {
}

class Solution88 {
    /**
     * 快速排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length-nums2.length; i < nums1.length; i++) {
            nums1[i] = nums2[i-nums1.length+nums2.length];
        }
        quick(nums1,0,nums1.length-1);
    }
    public void quick(int[] nums,int left,int right){
        if (left>right)return;
        int pivot = nums[left];
        int start = left;
        int end = right;
        while (start!=end){
            while (start<end&&pivot<=nums[end]){
                end--;
            }
            while (start<end&&pivot>=nums[start]){
                start++;
            }
            if (start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        nums[left] = nums[start];
        nums[start] = pivot;
       quick(nums,left,start-1);
       quick(nums,start+1,right);
    }

    /**
     * 双指针法
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int a = 0;
        int b = 0;
        int cur = 0;
        int[] sort = new int[m+n];
        while (a<m||b<n){
            if (a==m){
                cur = nums2[b++];
            }else if (b==n){
                cur = nums1[a++];
            }else if (nums1[a]<nums2[b]){
                cur = nums1[a++];
            }else {
                cur = nums2[b++];
            }
            //这里减去1，因为上述的每个状况都等于确立了当前指针指向下一个添加元素后
            //又向后移了一位，所以需要减去1
            sort[a+b-1] = cur;
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = sort[i];
        }
    }
}
