import java.util.HashMap;

public class solution_1 {
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for(int i =0;i<nums.length;i++){
            for(int j =i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    array[0] = i;
                    array[1] = j;
                }
            }
        }
        return array;
    }

    /**
     * 这个put要放在后面，因为放在前面的话，
     * if (map.containsKey(target-nums[i]))这条判断语句是可以考虑自身+自身的
     * 放在后面，判断语句就只会判断当前数之前的数字
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
       HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public int[] twoSum3(int[] nums,int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

}
