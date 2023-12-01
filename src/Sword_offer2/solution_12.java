package Sword_offer2;

public class solution_12 {

}
class Solution12 {
    /**
     * 回溯 + dfs深度搜索
     * 方向优先级采用“下”——>“右”——>“左”——>“上”
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        //字符串转为字符数组
        char[] chars = word.toCharArray();
        //二维数组行数
        int m = board.length;
        //二维数组列数
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board,chars,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,char[] word,int i,int j,int k){
        //当前坐标越界或者单词长度越界或者当前元素与字符串中对应元素不匹配
        if (i<0||i>= board.length||j<0||j>=board[0].length||k>= word.length||board[i][j]!=word[k]){
            return false;
        }
        if (k == word.length-1){
            return true;
        }
        //board[i][j]表示当前位置的字母，将其替换成其余元素，这样保证下次搜索时不会重复，搜索完再将其还原
        board[i][j] = '.';
        boolean res = dfs(board,word,i,j+1,k+1)||dfs(board,word,i+1,j,k+1)||dfs(board,word,i-1,j,k+1)||dfs(board,word,i,j-1,k+1);
        board[i][j]=word[k];
        return res;
    }
}
