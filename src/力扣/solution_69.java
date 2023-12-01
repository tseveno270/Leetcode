public class solution_69 {
}
class Solution69 {
    /**
     * 二分查找，找到乘积小于x的最后一个整数返回
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x==0){return 0;}
        if (x==1){return 1;}
        int l = 0;
        int r = x;
        //迭代，如果当间隔小于等于1,那就不用迭代了
        while (r-l>1){
            int mid = (l+r)/2;
            if (mid>x/mid){
                r = mid;
            }else {
                l = mid;
            }
        }
        return l;
    }
}
