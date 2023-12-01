import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class solution_200 {
}
class Solution200 {
    /**
     * 岛屿由题意，；理解为相邻的1的组合。
     * 任何位置的1一定属于某一个岛屿
     * 将相邻的1都找到，那么一定被0包围。一定是岛屿
     * dfs
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,char[][] grid){
        if (i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0'){return;}
        //当前为1，是岛屿组成部分，所以将其变为0
        grid[i][j] =  '0';
        dfs(i-1,j,grid);
        dfs(i,j-1,grid);
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
    }

    /**
     * bfs遍历
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'){
                    bfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int i ,int j,char[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            if (i>=0&&j<grid[0].length&&i<grid.length&&j>=0&&grid[i][j]=='1'){
                grid[i][j] = '0';
                queue.add(new int[]{i-1,j});
                queue.add(new int[]{i+1,j});
                queue.add(new int[]{i,j-1});
                queue.add(new int[]{i,j+1});
            }

        }
    }
    public void dfs2(int i,int j,char[][] grid){
        if (i>=0&&j>=0&&i<grid.length&&j<grid[0].length&&grid[i][j]=='0'){return;}
            grid[i][j] = '0';
            dfs(i+1,j,grid);
            dfs(i-1,j,grid);
            dfs(i,j+1,grid);
            dfs(i,j-1,grid);
        }
    public void bfs2(int i ,int j,char[][] grid){
       Queue<int[]> queue = new ArrayDeque<>();
       queue.add(new int[]{i,j});
       while (!queue.isEmpty()){
           int[] cur = queue.poll();
           cur[0] = i;
           cur[1] = j;
           if (i>=0&&j>=0&&i<=grid.length&&j<=grid[0].length&&grid[i][j]=='1'){
               grid[i][j] = '0';
               queue.add(new int[]{i,j+1});
               queue.add(new int[]{i-1,j});
               queue.add(new int[]{i+1,j+1});
               queue.add(new int[]{i,j-1});
           }
       }
    }
}
