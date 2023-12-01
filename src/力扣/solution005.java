import java.util.HashMap;

public class solution005 {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        String s1 = s.longestPalindrome2("babad");
        System.out.println(s1);
    }
}
class Solution5 {
    public String longestPalindrome(String s) {
       /* 如果单中心拓展长度较大,则len是奇数,如果是单中心拓展,那么i就是拓展的正中心,那么i的右边就有 (len-1)/2个元素了,因为len 是奇数,所以也可以写成len/2个元素.结果都是一样的

        如果双中心拓展长度较大,则len是偶数.如果是双中心拓展,那么i就是拓展的双中心左侧元素

        注意:
        i永远是双中心左侧元素,现在双中心右侧元素是i+1!!!不要弄混了
        下面是用双中心右侧元素****i+1来计算的!!!
                注意

        那么i+1右边就有 (len-2)/2个元素了,因为 len 是偶数,所以也可以写成 (len-1)/2个元素也无所谓.结果都是一样的

        综上所述:
        奇数长度回文子串结束位置__可以是: i+(len-1)/2或者i+len/2
        偶数长度回文子串结束位置__可以是: (i+1)+(len-2)/2或者 (i+1)+(len-1)/2
        进行化简取交集得:i+len/2
        则得出回文子串结束位置: end = i + len / 2;*/

        //        先弄一个非法判断
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = len1 > len2 ? len1 : len2;
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end+1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * 中心扩散法的双指针
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
       int len = s.length()*2-1;
       int max = 0;
       HashMap<Integer,String> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int l = i/2;
            int r = l+i%2;
            while (l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
                map.put(r-l+1,s.substring(l,r+1));
                max = Math.max(max,r-l+1);
                l--;
                r++;
            }
        }
        return map.get(max);
    }
}
