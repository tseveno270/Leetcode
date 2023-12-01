public class solution_912 {
}
class Solution912 {
    public static void main(String[] args) {
        int[] nums = {21,88,19,45,13,25,66,33,18};
    }
    public int[] sortArray(int[] nums) {
        quick(nums,0,nums.length-1);
        return nums;
    }
    public void quick(int[] arr, int left, int right){
        if (left>right){
            return;
        }
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i!=j){
            while(i<j&&arr[j]>=pivot){
                j--;
            }
            while (i<j&&arr[i]<=pivot){
                i++;
            }
            if (i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //基准点移动到中心
        arr[left] = arr[i];
        arr[i] = pivot;
        quick(arr,left,i-1);
        quick(arr,i+1,right);
    }

    public void quick1(int[] arr,int left,int right){
        if (left>right){return;}
        int pivot = arr[left];
        int l = left;
        int r = right;
        while (l!=r){
            while (l<r&&arr[r]>=pivot){r--;}
            while (l<r&&arr[l]<=pivot){l++;}
            if (l<r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        arr[left] = arr[l];
        arr[l] = pivot;

        quick1(arr,left,l-1);
        quick1(arr,l+1,right);
    }
}
