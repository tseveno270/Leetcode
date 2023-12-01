public class solution_278 {
    public static void main(String[] args) {
        int i = 7/2;
        System.out.println(i);
    }
}
class Solution278{
    /**
     * 二分法查找
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
       int low =1;
       int high = n;
       while (low<high){
           //当区间长度为1时跳出循环
           int mid = low +(high-low)/2;
           if (isBadVersion(mid)){
               //说明当前版本已经出错，向前查找
               high =mid;
           }else{
               //说明还未出错，向后查找
               low = mid+1;
           }
       }
       //此时low = high
       return low;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }
}



