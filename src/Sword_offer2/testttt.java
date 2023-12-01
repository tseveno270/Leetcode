package Sword_offer2;

public class testttt {
    public int findKthLargest(int[] nums, int k) {
        quciksort(nums,0,nums.length-1);
        return nums[nums.length-k];

    }
    public static void quciksort(int nums[],int left,int right){
        if (left>=right){
            return;
        }
        int i = left;
        int j = right;
        int pivot = nums[left];
        while (i!=j){
            while(i<j&&nums[j]>=pivot){
                j--;
            }
            while(i<j&&nums[i]<=pivot){
                i++;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        nums[left] = nums[i];
        nums[i] = pivot;
        quciksort(nums,left,i-1);
        quciksort(nums,i+1,right);
    }
    public static void heapsort(int nums[]){
        //创建大顶堆
        for (int i = nums.length/2-1;i>=0;i--){
            adjustHeap(nums,i,nums.length);
        }
        //从末尾节点交换堆顶元素
        for (int i = nums.length-1; i>=0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            //调整堆结构
            adjustHeap(nums,0,i);
        }

    }

    private static void adjustHeap(int[] nums, int parent, int length) {
        int temp = nums[parent];
        int index = 2*parent + 1;
        while(index<length){
            if (nums[index]<nums[index+1]&&index+1<length){
                index++;
            }
            if (nums[index]<=temp){
               break;
            }
            nums[parent] = nums[index];
            parent = index;
            index = 2*index+1;

        }
        nums[parent] = temp;
    }
}
