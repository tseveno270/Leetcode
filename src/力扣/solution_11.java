/**
 * @author 270
 */
public class solution_11 {
    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        Solution11 s = new Solution11();
        int i = s.maxArea(a);
        System.out.println(i);

    }
}

class Solution11 {
    /**
     * 通过双指针定义左右边界，并向中间移动数值较小的指针的位置
     * 逻辑为：假设当前左指针对应值x小于右指针对应值y，两者间距为t
     * 那么此时的容量为area = x*t
     * 那么此时无论如何移动右指针(右指针只能向左移动)，容量的值都不会超过x*t
     * 也就是说只能移动左指针
     * 即移动两个指针对应值小的那个
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
            //定义双指针
            int l = 0;
            int r = height.length-1;
            int ans = 0;
            while(l<r){
                int area = Math.min(height[l],height[r])*(r-l);
                ans = Math.max(ans,area);
                if(height[l]<=height[r]){
                    ++l;
                }else{
                    --r;
                }
            }
            return ans;
        }
}


