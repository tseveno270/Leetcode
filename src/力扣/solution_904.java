import java.util.HashMap;

public class solution_904 {

}
class Solution904 {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> window = new HashMap<>();
        int L = 0;
        int R = 0;
        int max = 0;
        while(R < n){
            int addWindow = fruits[R];
            R++;
            // 扩大右边界
            if(window.size() <= 2){
                window.put(addWindow, window.getOrDefault(addWindow, 0) + 1);
            }
            // 收缩左边界
            while(window.size() > 2){
                int subWindow = fruits[L];
                L++;
                if(window.containsKey(subWindow)){
                    window.put(subWindow, window.getOrDefault(subWindow, 0) - 1);
                    // 终于把一种水果从窗口内清空了 将该种水果直接remove
                    if(window.get(subWindow) <= 0){
                        window.remove(subWindow);
                    }
                }
            }
            // 更新结果位置---
            max = Math.max(max, R - L);
        }
        return max;
    }
}
