import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 270
 */
public class solution_18 {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        Solution18 s = new Solution18();
        List<List<Integer>> lists = s.fourSum(nums,0);
        System.out.println(lists);
    }

}
class Solution18 {
    /**
     * 找出所有四数之和为target且不重复的四元组
     * 与找三数之和相同，只不过是双指针外再添加一个for循环
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4 || nums == null) return lists;
        Arrays.sort(nums);
        int len = nums.length;
        for (int k = 0; k < len - 3; k++) {
            if (k > 0 && nums[k - 1] == nums[k]) continue;
            for (int v = k + 1; v < len - 2; v++) {
                if (v > k + 1 && nums[v - 1] == nums[v]) continue;
                int l = v + 1;
                int r = len - 1;
                while (l < r) {
                    int sum = nums[k] + nums[v] + nums[l] + nums[r];
                    if (sum == target) {
                        lists.add(Arrays.asList(nums[k], nums[v], nums[l], nums[r]));
                        while (l < r && nums[l + 1] == nums[l]) l++;
                        while (l < r && nums[r - 1] == nums[r]) r--;
                        l++;
                        r--;
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }

            }
        }
        return lists;
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4 || nums == null) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum>target){
                        right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        lists.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(right>left&&nums[right]==nums[right-1])right--;
                        while(right>left&&nums[left]==nums[left+1])left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return lists;
    }
}

