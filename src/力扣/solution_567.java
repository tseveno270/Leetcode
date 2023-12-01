import java.util.Arrays;

public class solution_567 {
    public static void main(String[] args) {
        Solution567 solution567 = new Solution567();
        String s2 = "abababababsadadasdccvf";
        String s1 = "aaaabbb";
        System.out.println(solution567.checkInclusion(s1,s2));

    }
}
class Solution567 {
    /**
     * 只要s2中的某个字串出现的字符次数和s1完全相等，即可返回true
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2){
        //定义两个数组分别存储s1和s2滑动窗口中的字符个数
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        if (s1.length()>s2.length()){
            return false;
        }
        int n = s1.length();
        int m = s2.length();
        //将s1和s2前n个字符数量统计到num1和nums2中
        for (int i = 0; i < n; i++) {
            ++nums1[s1.charAt(i)-'a'];
            ++nums2[s2.charAt(i)-'a'];
        }
        if (Arrays.equals(nums1,nums2)){
            return true;
        }
        //这里滑动窗口从左向右
        for (int i = n; i < m; i++) {
            ++nums2[s2.charAt(i)-'a'];
            --nums2[s2.charAt(i-n)-'a'];
            if (Arrays.equals(nums1,nums2)){
                return true;
            }
        }
        return false;
    }
}
