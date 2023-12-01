package 笔试;

import java.util.Arrays;

 class solutionbishi2 {
    public static void main(String[] args) {
        int a = 9;
        int b = 4;
        int[][] nums = new int[a][2];
        int[][] result = new int[4][2];
        int[][] intervals = merge(result);
        result[0][0] = 1;
        result[0][1] = 5;
        result[1][0] = 3;
        result[1][1] = 4;
        result[2][0] = 2;
        result[2][1] = 6;
        result[3][0] = 8;
        result[3][1] = 9;
        String s1 = new String("Hi There");
        String s2 = new String("Hi There");
        String s3 = s1;
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }
     public static int[][] merge(int[][] intervals) {
         //只考虑起始位置，使用lambda表达式，
         // 各个区间v1，v2的排列顺序根据区间起始位置v1【0】，v2【0】决定
         Arrays.sort(intervals,(v1, v2)->v1[0]-v2[0]);
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
}

