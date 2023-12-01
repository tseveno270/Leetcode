package Sword_offer2;

/**
 * @author 270
 */
public class solution_04 {
    public static void main(String[] args) {
        int[][] martix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        Solution04 s = new Solution04();
        boolean flag = s.findNumberIn2DArray(martix, 16);
        System.out.println(flag);


    }
}
class Solution04 {
    /**
     * 从二维数组右上角开始遍历，若当前元素等于target返回true
     *                          当前元素大于target，说明这一列没有target，所以向同行的左边遍历
     *                          当前元素小于target，说明这一行没有target，向同列的下边遍历
     *                          重复直到找到，如果结束循环后没有找到返回false
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target){
                return true;
            } else if (num > target){
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}