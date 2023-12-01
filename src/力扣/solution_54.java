package 力扣;

import java.util.ArrayList;
import java.util.List;


class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        //定义上下左右四个边界
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        //按照左上>右上，右上>右下，右下>左下，左下>左上
        List<Integer> res = new ArrayList<>();
        int target = matrix.length*matrix[0].length;
        while (res.size()<target){
            for (int i = left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
            //这里判断条件有i>=left&&top<=bottom而不是仅仅i>=left
            //原因是matrix不一定是正方形，所以可能行遍历和列遍历的次数不相等
            //所以本题与59有判断上的不同
            for (int i = right;i>=left&&top<=bottom;i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom;i>=top&&left<=right;i--){
                res.add(matrix[i][left]);
            }
            left++;
        }
           return res;
    }
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        boolean[][] used = new boolean[matrix.length][matrix[0].length];
        dfs(matrix,used,res,0,0);
        return res;

    }
    private static void dfs(int[][] matrix,boolean[][] used,List<Integer>res,int i,int j){
        if (i<0||j<0||i>=matrix.length||j>=matrix[0].length||used[i][j]==true){return;}
        used[i][j] = true;
        res.add(matrix[i][j]);
        if (j<1||used[i][j-1]){
            //这里如果左边无法访问或者被访问过，那当前节点可以向右也可以向上，所以要规定先向上再向右
            dfs(matrix,used,res,i-1,j);
        }
        dfs(matrix,used,res,i,j+1);
        dfs(matrix,used,res,i+1,j);
        dfs(matrix,used,res,i,j-1);
        dfs(matrix,used,res,i-1,j);

    }
}
