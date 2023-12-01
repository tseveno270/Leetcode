public class solution_05 {
}
class Solution05 {
    /**
     * 遍历字符串数组，并依次添加到新字符串中，如果是空格就替换成%20
     * 空格的ASCII为32
     * @param s
     * @return
     */
    public String replaceSpace(String s){
        char[] chars = s.toCharArray();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]!=32){
                res+=chars[i];
            }else{
                res+="%20";
            }
        }
        return res;
    }

    /**
     * 将数组扩充到能填充的长度，然后通过双指针从后向前替换空格
     * @param s
     * @return
     */
    public String replaceSpace2(String s){
        if(s == null || s.length() == 0){
            return s;
        }
        //扩充空间，空格数量2倍
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                str.append("  ");
            }
        }
        //若是没有空格直接返回
        if(str.length() == 0){
            return s;
        }
        //有空格情况 定义两个指针
        int left = s.length() - 1;//左指针：指向原始字符串最后一个位置
        s += str.toString();
        int right = s.length()-1;//右指针：指向扩展字符串的最后一个位置
        char[] chars = s.toCharArray();
        while(left>=0){
            if(chars[left] == ' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else{
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
        }
    }

