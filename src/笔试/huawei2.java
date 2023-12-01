package 笔试;

import java.util.Scanner;

public class huawei2 {
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    static int row;
    static int col;
    static int prex = 0;
    static int prey = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        char[][] block = new char[m][n];
        boolean[][] used = new boolean[m][n];
        int time = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                block[i][j] = s.charAt(j);
                if (block[i][j]=='S'){
                     x = i;
                     y = j;
                }
            }
        }
        dfs(block,used,x,y,0);
    }
    private static void dfs(char matrix[][],boolean[][] isVis,int x,int y,int cost) {
        if (x>=row||x<0||y>=col||y<0||'X'==(matrix[x][y])||isVis[x][y])return;
        isVis[x][y]=true;
        if ('E'==(matrix[x][y])){
            System.out.println(cost);
        }
        for (int[] dir:dirs){
            int dx = x + dir[0];
            int dy = y+dir[1];
            if (prex!=-1&&prey!=-1){
                cost+=Math.abs((dy-y)/(dx-x))==Math.abs((prey-y)/(prex-x))?0:1;
            }
            prey = y;
            prex =x;
            dfs(matrix,isVis,dx,dy,cost);
            isVis[x][y] = false;
        }
    }
}
