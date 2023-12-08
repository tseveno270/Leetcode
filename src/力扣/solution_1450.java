package 力扣;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年12月02日 16:03
 */
public class solution_1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime<=endTime[i]&&queryTime>=startTime[i]){
                res++;
            }
        }
        return res;
    }
}
