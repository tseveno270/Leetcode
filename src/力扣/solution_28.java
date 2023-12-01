/**
 * @author 270
 */
public class solution_28 {

}
class Solution28 {
    public int strStr(String haystack, String needle){
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        //needle为空时返回0
        if (needle.equals(null)){
            return 0;
        }
        //双指针分别指向字符数组的初始下标
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 0; i < hay.length; i++) {
            if (hay[temp1]==need[temp2]){
                temp1++;
                temp2++;
            }
        }
        return temp2;
    }
}
