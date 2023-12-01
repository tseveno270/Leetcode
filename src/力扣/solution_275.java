package 力扣;

/**
 * 二分法
 * 1.若存在至少2篇论文引用值≥2次，那一定存在至少1篇论文引用值≥1次。
 * 2.若不存在3篇论文至少引用值≥3次，那一定也不存在至少4篇论文引用值≥4次。
 * 说明题目的答案具备【单调性】，可以用【二分求解】
 * @author: 270
 * @date: 2023年10月30日 16:42
 */
public class solution_275 {
    /**
     * 1.【闭区间】
     * @param citations
     * @return
     */
   public int hIndex(int[] citations){
       //在区间【left，right】中询问
       int n = citations.length;
       int left = 0;
       int right = n - 1;
       while (left<=right){//区间不为空
           //循环不变量
           //
           int mid = left+(right-left)/2;
           if (citations[mid]>=n-mid){
               right = mid - 1;
           }else{
               left = mid + 1;
           }
       }
       return n - left;
   }

    /**
     * 找出数组最大值，返回索引
     * @param citations
     * @return
     */
   public int hIndex1(int[] citations){
       int left = 0;
       //{0,1,3,5,6}
       int n = citations.length;
       int right = n - 1;
       while (left<=right){
           int mid = left+(right-left)/2;
           System.out.println(mid);
           if (citations[mid]>=n-mid){
               right = mid - 1;
               System.out.println("right="+right);
           }else{
               left = mid + 1;
               System.out.println("left="+left);
           }
       }
       //因此，当循环结束时，left 就是满足 citations[mid] < n - mid 条件的
       // 最后一个位置，而 n - left 就是至少有 n - left 篇论文的引用次数不少于 n - left，
       // 满足 h 指数的定义。所以，返回 n - left 即为所求的 h 指数。
       return n - left;
    }
}

