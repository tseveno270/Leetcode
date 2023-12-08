package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月07日 17:15
 */
public class solution_1556 {
    public String thousandSeparator(int n) {
        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();
        if (s)
        StringBuffer sb = new StringBuffer();
        int temp = 1;
        for (int i = charArray.length-1; i >= 0; i--) {
            sb.append(charArray[i]);
            if (temp%3==0&&temp!=0){
                sb.append('.');
            }
            temp++;
        }
    return sb.reverse().toString();
    }
}
