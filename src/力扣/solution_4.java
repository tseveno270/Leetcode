import java.util.ArrayList;
import java.util.Collections;

public class solution_4 {
}
class Solution04{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m+n+1)/2;
        int right = (m+n+2)/2;
        //1.中位数可能是中间数本身或者中间数的平均值。所以做以上处理
        //  两个数组共有m+n个元素，当m+n为奇数时。left==right==中位数
        //                          m+n为偶数时，left和right分别表示两个中间数
        return (find(nums1,0,left,0,nums2)+find(nums1,0,right,0,nums2))/2.0;

    }

    private double find(int[] nums1, int i, int k, int j, int[] nums2) {
        //某个数组为空或者已经遍历空则返回另一个数组
        if (i >= nums1.length)return nums2[j+k-1];
        if (j >= nums2.length)return nums1[i+k-1];
        if (k==1)return nums1[i]<nums2[j]?nums1[i]:nums2[j];
        //加快搜索速度，采用二分查找，分别在两个数组中找第k/2个元素
        //先判断是否有第k/2个元素,有则取值
        int midVal1 = (i+k/2-1< nums1.length?nums1[i+k/2-1]:Integer.MAX_VALUE);
        int midVal2 = (j+k/2-1< nums2.length?nums2[j+k/2-1]:Integer.MAX_VALUE);
        //进行二分查找，如果都找到，那么小到那一方的前K/2个数字可以舍去,
        //如果只有一方找得到，那么舍弃另一个所有元素和这个的前K/2元素
        //同时当已经验证了前k/2个元素不是k之后。那么起始要提前k/2,k也要减去k/2
        if (midVal1<midVal2){
            return find(nums1,k/2+i,k-k/2,j,nums2);
        }else {
            return find(nums1,i,k-k/2,j+k/2,nums2);
        }
    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        //设置数组长度
        ArrayList<Integer> list = new ArrayList<>();
        //从小到大排列
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }
        Collections.sort(list);

        int size = list.size();

        if(size == 1){
            if(nums1 ==null){
                return nums2[0];
            }else if(nums2 == null){
                return nums1[0];
            }
        }
        if(size%2!=0){
            return list.get((size-1)/2);
        }else{
            return (list.get((size-1)/2)+list.get(size/2))/2.0;
        }
    }
}

