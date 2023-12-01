package doublePointer;

public class solution_344 {
    public static void main(String[] args) {
        Solution344 s = new Solution344();
        char[] chars = {'h','e','l','l','o'};
        s.reverseString(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

    }
}
class Solution344 {
    /**
     * 双指针
     * 分别指向数组的头尾元素下标
     * @param s
     */
    public void reverseString(char[] s){
      int start = 0;
      int end  = s.length-1;
      while(start<end){
          char temp = s[start];
          s[start] = s[end];
          s[end] = temp;
          start++;
          end--;
      }
    }
}
