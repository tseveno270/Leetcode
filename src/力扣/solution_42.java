

class Solution42 {
    static int res = 0;
    public static void main(String[] args) {
        int[] r = {5,1,2,1,5};
         res = trap2(r);
        System.out.println(res);
    }

    public int trap(int[] height) {
        //动态规划
        //1.left[i] right[i]分别表示左侧和右侧的最大高度，包括i。
        if (height==null||height.length==0){return 0;}
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        //2.初始化
        left[0] = height[0];
        right[height.length-1] = height[height.length-1];
        //3.遍历+递推公式
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i-1],height[i]);
        }
        for (int i = height.length-2; i>=0; i--) {
            right[i] = Math.max(right[i+1],height[i]);
        }
        //4.每格能接到的水
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans+=Math.min(left[i],right[i])-height[i];
        }
        return ans;
    }
    private  static int trap2(int[] height) {
        //动态规划
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        //1.left[i] right[i]分别表示左侧和右侧的最大高度，包括i。
        //2.初始化
        left[0] = height[0];
        right[height.length-1] = height[height.length-1];
        //3.遍历+递推公式
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i-1],height[i]);
        }
        for (int i =height.length-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        //4.每格能接到的水
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int temp =Math.min(left[i],right[i])-height[i];
            if (temp>0){res++;}
            ans+=temp;
        }
        return res;
    }
}

