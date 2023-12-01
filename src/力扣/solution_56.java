import java.util.Arrays;

public class solution_56 {
}
class Solution56 {
    public int[][] merge(int[][] intervals) {
        //只考虑起始位置，使用lambda表达式，
        // 各个区间v1，v2的排列顺序根据区间起始位置v1【0】，v2【0】决定
        Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);
        int[][] res = new int[intervals.length][2];
        //idx表示返回数组的最后一个区间下标。-1表示返回值为空
        int idx = -1;
        //遍历区间
        for (int[] interval:intervals){
            //返回值为空，或者当前区间的起始值不在返回值的最后区间内（不重叠）
            // 那么将当前区间直接加入返回值末端
            if (idx==-1||interval[0]>res[idx][1]){
                res[++idx] = interval;
            }else {
                //将当前区间合并到返回值的最后区间,
                //因为已经排序，所以结果区间的起始值小，不用改变
                //所以只需改变返回值的末尾区间的结束值
                res[idx][1] = Math.max(res[idx][1],interval[1]);
            }
        }
        //初始值长度是没有合并的，现在需要清除0值。idx为下标最大值，idx+1为长度
        return Arrays.copyOf(res,idx+1);
    }
    public int[][] merge2(int[][] intervals) {
       Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);
       int[][] res = new int[intervals.length][2];
       int idx = -1;
       for (int[] interval:intervals){
           if (idx==-1||interval[0]>res[idx][1]){
               res[++idx] = interval;
           }else {
               res[idx][1] = Math.max(interval[1],res[idx][1]);
           }
       }
       return Arrays.copyOf(res,idx+1);
    }
}
