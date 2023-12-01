package 笔试;

import java.util.Scanner;

 class youxiangtu {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int m = sc.nextInt();
         AMGraph graph = new AMGraph(n, m);
         graph.dFSTraverse();
     }
 }
class AMGraph {
    //点集信息
    private String[] vexs = null;
    //边集信息
    private int[][] arcs = null;
    private boolean[] visited = null; //false表示该位置的顶点未访问，true表示已访问

    public AMGraph(int vexNum, int arcNum) { //输入点的个数和边的个数
        this.vexs = new String[vexNum];
        this.arcs = new int[vexNum][vexNum];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < vexNum; i++) { //根据输入建立点集
            this.vexs[i] = sc.next();
        }

        for (int i = 0; i < vexNum; i++) {  //初始化边集
            for (int j = 0; j < vexNum; j++) {
                this.arcs[i][j] = 0; //0表示该位置所对应的两顶点之间没有边
            }
        }
        start:
        for (int i = 0; i < arcNum; i++) { //开始建立边集
            sc = new Scanner(System.in);
            int vex1Site = 0;
            int vex2Site = 0;
            String vex1 = null;
            String vex2 = null;
            vex1 = sc.next();
            vex2 = sc.next();
            if (this.arcs[vex1Site][vex2Site] != 0) {  //检测该边是否已经输入
                System.out.println("该边已存在！");
                i--;
                continue start;
            } else {
                this.arcs[vex1Site][vex2Site] = 1;  //1表示该位置所对应的两顶点之间有边
                this.arcs[vex2Site][vex1Site] = 1;  //对称边也置1
            }
        }
    }
    //深度优先搜索遍历
    public void dFSTraverse() {

        this.visited = new boolean[this.vexs.length];  //初始化访问标志数组
        for(int i = 0; i < this.visited.length; i++) {
            this.visited[i] = false;
        }

        for(int i = 0; i < this.visited.length; i++) {
            if(!this.visited[i]) { //对未访问的顶点调用深度优先遍历算法
                dFS_AM(i);
            }
        }
    }

    public void dFS_AM(int site) { //输入深度优先遍历的开始顶点
        System.out.println(this.vexs[site]); //输出该顶点
        this.visited[site] = true;  //置访问标志为true
        for(int i = 0; i < this.vexs.length; i++) {  //依次查找未访问邻接点，并以该邻接点为始点调用深度优先遍历算法
            if(this.arcs[site][i] != 0 && !this.visited[i]) {
                this.dFS_AM(i);
            }
        }
    }
}


