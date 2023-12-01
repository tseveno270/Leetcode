package Sword_offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 270
 */
public class solution_03{
    public static void main(String[] args){
        Solution03 s = new Solution03();
        int[] nums = {2,3,1,4,4};
        int repeatNumber = s.findRepeatNumber(nums);
        System.out.println(repeatNumber);
    }

}
class Solution03 {
    /**
     * 升序排序数组，将每个不同数值的元素和其出现次数添加到HashMap中，如果value>1,输出
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int num:nums){
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        int res = 0;
       for (int num:nums){
           if (map.get(num)>1){
               res = num;
           }
       }
       return res;
    }

    /**
     * 优化版，因为肯定有重复的，所以最后可以返回-1，因为肯定会在循环中返回某个num
     * @param nums
     * @return
     */
    public int findRepeatNumber_02(int[] nums){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int num:nums){
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
                return num;
            }else{
                map.put(num,1);
            }
        }
        return -1;
    }


}

