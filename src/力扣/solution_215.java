import java.util.Arrays;
import java.util.PriorityQueue;

public class solution_215 {
}
class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    /**
     * 插入排序
     * O(n*n) 最好情况O(n) 平均情况O(n*logn)
     * @param nums
     * @param k
     * @return
     */
    public int insertsort(int[] nums,int k){
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int index = i - 1;
            while (index>=0&&val<nums[index]){
                //当满足条件时，将nums[index]后移把位置给val留出来
                nums[index+1] = nums[index];
                index--;
            }
            nums[index+1] = val;
        }
        return nums[nums.length-k];
    }

    /**
     * O(N*logN)
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public void quicksort(int[]arr,int left,int right){
        if (left>right){
            return;
        }
        //初始化基准值为第一个元素
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i!=j){
            //快排升序一定要从右边开始循环，这样最后i，j相遇时的值才比pivot小。从左边排的话比pivot大，就失去了意义
            //从右往左找比pivot小的
            while(arr[j]>=pivot&&i<j){
                j--;
            }
            //从左往右找比pivot大的
            while (arr[i]<=pivot&&i<j){
                i++;
            }
            //找到后交换位置
            if (i<j){
               int temp = arr[j];
               arr[j] = arr[i];
               arr[i] = temp;
            }
        }
        //将基准值放到中间位置
        arr[left] = arr[i];
        arr[i] = pivot;

        //递归
        quicksort(arr,left,i-1);
        quicksort(arr,i+1,right);
    }

    /**
     * 用优先队列的，先放k个,自动排序。此时队首元素为最小的。如果它大于剩余所有元素，那么就是答案
     * 然后遍历 如果之后的大于当前队首元素，替换。
     * 替换完毕后自然队首就是返回值
     * add 添加
     * peek 获取队首元素
     * poll 获取并删除队首元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            queue.add(nums[i]);
        for (int i = k; i < nums.length; i++){
            if (nums[i] > queue.peek()){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }

    /**堆排序
     * 创建堆，
     * @param arr 待排序列
     */
    private static void heapSort(int[] arr) {
        //创建堆
        // (arr.length - 1) / 2 第一次非叶子节点
        for (int i = arr.length/2-1; i >= 0; i--) {
            //从第一个非叶子结点从下至上，由右至左
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i >=0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整堆
     * @param arr 待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(int[] arr, int parent, int length) {
        //将temp作为父节点
        int temp = arr[parent];
        //左孩子
        int lChild = 2*parent+1;
        while (lChild<length){
            //右孩子
            int RChild = lChild+1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (RChild<length && arr[lChild]<arr[RChild]){
                //表示现在交换的是右孩子即左孩子++
                lChild++;
            }
            // 如果父结点的值已经大于孩子结点的值，则直接结束
            //这里用temp而不是nums[parent]是因为需要与最开始的parent比较，而nums[parent]会改变
            if (temp>=arr[lChild]){
                break;
            }
            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];
            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2*lChild+1;
        }
        //将排序后的孩子节点的值赋为排序前的父节点
        //排序后已经成为大顶堆，将排序前的值放到最终的位置
        arr[parent] = temp;
    }
    public void quicksort3(int[] arr, int start, int end){
        int pivot = arr[start];
        int left = start;
        int right = end;
        while (left!=right){
            while (left<right&&arr[right]>pivot){
                right--;
            }
            while (left<right&&arr[left]<pivot){
                left++;
            }
            if (left<right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[start] = arr[left];
        arr[left] = pivot;

        quicksort(arr,left,start-1);
        quicksort(arr,start+1,end);
    }

}


