import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 270
 */
public class solution_15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Solution15 s = new Solution15();
        List<List<Integer>> lists = s.threeSum(nums);
        System.out.println(lists);

    }
}
class Solution15 {
    /**
     * 在容量为n的数组内找出所有和为0的三元组
     * 先通过Arrays.sort方法从小到大排序
     * 【双指针法】
     * 选定三个指针，最左边指针固定(数值最小的固定) k。
     * 另外两个固定在除最左边以外的头尾 i 和 j。
     * 1.当nums[k]>0;break
     * 2.当nums[k] == nums[k-1]时，则跳过当前k，因为重复了
     * 3.令三指针对应的和为sum
     *    sum<0 i++
     *    sum>0 j--
     *    逻辑为k固定时，当sum<0,此时j对应最大值，所以i++
     *                   当sum>0,此时i对应最小值，所以j--
     *
     * 注意：while(i<j&&nums[j+1]==nums[j])
     *           j--;
     * 这三行等同于 while(i<j&&nums[j]==nums[--j]);
     * 即在sum>0时
     * 先令j = j - 1;
     * 之后如果满足i<j&&nums[j+1]==nums[j]
     * 那么执行while后的语句：j--；
     *
     *
     * 注意：while后面加分号表示循环体为空
     * 不加分号循环体为下面那一句
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums,0,nums.length);
        for (int k = 0; k < nums.length-2; k++){
            //当最小元素大于零时，跳出循环
            if(nums[k]>0){
                break;
            }
            //当重复元素时，跳过
            if (k>0 && nums[k] == nums[k-1]){
                continue;
            }
            int i = k +1;
            int j = nums.length - 1;
            while (i<j){
                int sum = nums[k] +nums[i]+nums[j];
                if(sum>0){
                    j--;
                    while(i<j&&nums[j+1]==nums[j])
                        j--;
                }else if(sum<0){
                    i++;
                    while(i<j&&nums[i-1]==nums[i])
                        i++;
                }else {
                    lists.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    //如果重复就跳过
                    while(i<j&&nums[i]==nums[++i]);
                    while(i<j&&nums[j]==nums[--j]);
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> threeSum2(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
           if (nums[i]>0){return list;}
           //重复元素跳过,这里先后顺序不能错，需要先i>0再判断，因为先判断nums[i]==nums[i-1]的话会取到i=0的情况，数组下标越界。
           if (i>0&&nums[i]==nums[i-1]){continue;}
           int left = i+1;
           int right = nums.length-1;
           while(left<right){
               int sum = nums[i] + nums[left] + nums[right];
               if (sum>0){
                   right--;
               }else if(sum<0){
                   left++;
               }else{
                   list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                   while (right > left && nums[right] == nums[right - 1]) right--;
                   while (right > left && nums[left] == nums[left + 1]) left++;

                   //找到答案后
                   right--;
                   left++;

               }
           }
        }
        return list;
    }

    public List<List<Integer>> threeSum3(int[] nums){
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){return res;}
            if (i>0&&nums[i]==nums[i-1]){continue;}
            int left = i+1;
            int right = nums.length-1;
            while (left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                }else {
                    res.add(Arrays.asList(nums[left],nums[right],nums[i]));
                    while (left<right&&nums[right]==nums[right-1])right--;
                    while (left<right&&nums[left]==nums[left+1])left++;

                    left++;
                    right--;
                }
            }
        }
        return res;
    }

    private void quick(int[] nums, int left, int right){
        if (left>right){
            return;
        }
        int pivot = nums[left];
        int l = left;
        int r = right;
        while (l!=r){
            //r在前l在后，顺序不能相反。记住！
            while (l<r&&nums[r]>=pivot){
                r--;
            }
            while (l<r&&nums[l]<=pivot){
                l++;
            }
            if (l<r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        nums[left] = nums[l];
        nums[l] = pivot;
        quick(nums,left,l-1);
        quick(nums,l+1,right);

    }
    private void quick2(int[] nums, int left, int right){
        if (left>right){
            return;
        }
        int pivot = nums[left];
        int start = left;
        int end = right;
        while (start!=end){
            while (start<end&&nums[end]>=pivot){
                end--;
            }
            while (start<end&&nums[start]<=pivot){
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
        quick2(nums,left,start-1);
        quick2(nums,start+1,right);
    }

}


