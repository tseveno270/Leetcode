/**
 * @author 270
 */
public class solution_167 {
    public static void main(String[] args) {
        Solution167 s = new Solution167();
        int[] ints = {-1,0};
        int[] ints1 = s.twoSum(ints, -1);
        System.out.println(ints1[0]);
        System.out.println(ints1[1]);
    }
}
class Solution167 {
    /**
     * 双指针
     * 分别指向头尾下标start和 end
     * 两数之和大于target时end--
     *             反之start++
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int start = 0;
        int end = numbers.length-1;
        while (start<end){
            if (numbers[start]+numbers[end]<target) {
                start++;
            }else if (numbers[start]+numbers[end]>target){
                end--;
            }else{
                result[0] = start+1;
                result[1] = end+1;
                break;
            }
        }
        return result;
    }
}




