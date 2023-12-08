package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月01日 13:30
 */
public class solution_1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3)return false;
        int flag = 0;
        for (int i = 0; i < arr.length-2; i++) {
            if (arr[i]%2!=0&&arr[i+1]%2!=0&&arr[i+2]%2!=0){
                flag=1;
            }
        }
        return flag==1;
    }
}
