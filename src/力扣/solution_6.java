/**
 * @author 270
 */
public class solution_6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        Solution6 solution = new Solution6();
        String convert = solution.convert(s, 4);
        System.out.println(convert);
    }
}
class Solution6 {
    /**
     * 总结出"Z字型"的字符串各行的间距
     *      第0行和第length-1行：step = 2*numRows-2
     *      第i行：              （step-2*i）和（2*i）交替
     * @param s
     * @param numRows
     * @return
     * 各个参数：
     *      i：当前位于第i行
     *      index:被读取元素下标
     *      step：头尾行的间距
     *      add:用于表示第i行的间距
     *
     * 虽然循着Z型遍历字符串，但每个元素都可以被遍历到，
     * 所以当index<s.length()表示当前层字符串遍历完毕，即可进入下一层
     */
    public String convert(String s, int numRows) {
        //当只有一行时
        if(numRows == 1){return s;}
        int index = 0;
        int step = numRows*2-2;
        int add = 0;
        String res ="";
        for (int i = 0; i<numRows; i++){
            index = i;
            add = 2*i;
            while (index<s.length()){
                res +=s.charAt(index);
                //这里add第一次为step-2*i，第二次为step-(step-2*i) = 2*i
                add = step - add;
                //除头尾行其余时候间距为add，否则为stemp
                index+=(i == 0||i==numRows-1)?step:add;
            }
        }
        return res;
    }
}
