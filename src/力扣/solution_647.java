public class solution_647 {
}
class Solution647 {
    /**
     * 双指针法，把两个数之间的间隔也看成回文中心，比如abba中的两个b之间
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int len = s.length();
        int ans = 0;
        if (s == null || (len = s.length()) < 1) return 0;
        //总共有2 * len - 1个中心点
        for (int i = 0; i < 2 * len - 1; i++) {
            //通过遍历每个回文中心，向两边扩散，并判断是否回文字串
            //有两种情况，left == right，right = left + 1，这两种回文中心是不一样的
            //当left=right，说明回文中心为单个字母，反之为间隔
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                //如果当前是一个回文串，则记录数量
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
    /**
     * 动态规划法
     * @param s
     * @return
     */
    public int countSubstrings2(String s) {
        int len, ans = 0;
        if (s == null || (len = s.length()) < 1) return 0;
        //dp[i][j]：s字符串下标i到下标j的字串是否是一个回文串，即s[i, j]
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                //当两端字母一样时，才可以两端收缩进一步判断
                if (s.charAt(i) == s.charAt(j)) {
                    //i++，j--，即两端收缩之后i,j指针指向同一个字符或者i超过j了,必然是一个回文串
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        //否则通过收缩之后的字串判断
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {//两端字符不一样，不是回文串
                    dp[i][j] = false;
                }
            }
        }
        //遍历每一个字串，统计回文串个数
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (dp[i][j]) ans++;
            }
        }
        return ans;
    }
}
