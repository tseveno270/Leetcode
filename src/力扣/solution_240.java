public class solution_240 {
    public static void main(String[] args) {
        int[][] m = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        Solution240 sa = new Solution240();
        sa.searchMatrix(m,20);

    }


}
class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length,n=matrix[0].length;
        if(matrix==null||m==0||n==0) return false;
        int i =0,j =n-1;
        while(i<m&&j>=0){
            if(matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]<target){
                i++;
            } else {
                j--;
            }
        }

        return false;

    }
}
