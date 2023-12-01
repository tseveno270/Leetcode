package Sword_offer2;

public class solution_13 {
}
class Solution13 {
    /**
     * dfs算法
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited,m,n,0,0,k);
    }
    private int dfs(boolean[][] visited,int m,int n,int i,int j,int k){
        if(i >= m || j >= n || visited[i][j] || bitSum(i) + bitSum(j) > k) return 0;
        visited[i][j] = true;
        return 1+ dfs(visited,m,n,i+1,j,k) + dfs(visited,m,n,i,j+1,k);
    }
    /**
     * 数位和函数
     * 求个位数之和
     * @param n
     * @return
     */
    private int bitSum(int n){
        int sum = 0;
        while(n>0){
            sum += n%10;
            n /=10;
        }
        return sum;
    }
}
