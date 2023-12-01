package 笔试;

import java.util.Scanner;

public class 华为2迷宫 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }
    /**
     * 规定：
     * 1.如果小球能到map[6][5]这个位置，说明通路找到
     * 2.map[i][j]的值： 0 未走过
     *                   1 墙
     *                   2 起点
     *                   3 终点
     *                   4 陷阱
     *                   6 炸弹
     *                   7 未走过
     *                   8 已经走过
     *3.在走迷宫时，需要确定一个策略: 优先级从高到低依次为：
     *    下 —— 右 —— 上 —— 左
     *    如果该点走不通，再回溯
     * @param map 地图
     * @param i   起点横坐标
     * @param j   起点纵坐标
     * @return 找到通路返回true，反之false
     */
    public static boolean setWay(int[][] map,int i,int j,int endi,int endj){
        if(map[endi][endj]==8){
            //说明走到终点
            return true;
        }else{
            if(map[i][j] != 7){
                //如果当前这个点还没有走过
                //假定当前这个点可以走通
                map[i][j] = 8;
                if(setWay(map, i+1, j,endi,endj)){
                    //向下走
                    return true;
                }else if(setWay(map,i,j+1, endi, endj)){
                    //向右走
                    return true;
                }else if(setWay(map,i-1,j, endi, endj)){
                    //向上走
                    return true;
                }else if (setWay(map,i,j-1,endi,endj)){
                    //向左走
                    return true;
                }else{
                    //说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            }else{
                //如果当前点不为0
                return false;
            }
        }
    }

    /**
     * 将找路策略改为： 上 —— 右 —— 下 —— 左
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay1(int[][] map,int i,int j){
        if(map[6][5] == 2){
            //说明道路已经找到
            return true;
        }else{
            if(map[i][j] == 0){
                //如果当前这个点还没有走过
                //假定当前这个点可以走通
                map[i][j] = 2;
                if(setWay1(map, i-1, j)){
                    //向上走
                    return true;
                }else if(setWay1(map,i,j+1)){
                    //向右走
                    return true;
                }else if(setWay1(map,i+1,j)){
                    //向下走
                    return true;
                }else if (setWay1(map,i,j-1)){
                    //向左走
                    return true;
                }else{
                    //说明该点走不通
                    map[i][j] = 3;
                    return false;
                }
            }else{
                //如果当前点不为0
                return false;
            }
        }
    }

}
