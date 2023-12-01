package 力扣;

import java.util.Arrays;

/**
 * @author 270
 */
public class solution_16 {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 1,-4};
        Solu solu = new Solu();
        int i = solu.threeSumClosest(arr, -4);
        System.out.println(i);

    }
}

class Solu {
    /**
     * 先将数组排序
     * k        从数组最左端指引向右边依次遍历
     * 然后通过双指针判断：
     * l        指向k右侧第一个
     * r        指向数组末尾
     * 循环外定义int res = nums[0]+nums[1]+nums[2];
     * 循环内定义int temp = nums[k]+nums[l]+nums[r];
     * 如果当前的Math.abs(res-target)>Math.abs(temp-target)
     * 则res = temp
     * 题中说假定只有唯一答案，那么不考虑元素数值相等的问题
     * <p>
     * 当nums[k == 0]>target,返回res = nums[0]+nums[1]+nums[2];
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        //先将数组排序
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int k = 0; k < nums.length; k++) {
            int l = k + 1;
            int r = nums.length - 1;
            //这里用while的作用是满足条件就一直执行，但是if是判断后就退出
            while (l<r) {
                int temp = nums[k] + nums[l] + nums[r] ;
                if (Math.abs(res-target)>Math.abs(temp-target)){
                    res = temp;
                   }
                if (temp<target){
                    l++;
                }else if(temp>target){
                    r--;
                }else {
                    return temp;
                }
                }
            }
        return res ;
        }
    }



