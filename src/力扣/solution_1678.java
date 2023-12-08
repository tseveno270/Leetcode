package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月07日 16:58
 */
public class solution_1678 {
    public String interpret(String command) {
        char[] charArray = command.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < charArray.length-1; i++) {
            if (charArray[i]=='G'){
                sb.append('G');
            }
            if (charArray[i]=='('&&charArray[i+1]==')'){
                sb.append('o');
            }
            if (charArray[i]=='('&&charArray[i+1]=='a'){
                sb.append("al");
            }
        }
        if (charArray[charArray.length-1]=='G') sb.append('G');
        return sb.toString();
    }
}
