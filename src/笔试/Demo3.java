package 笔试;


import java.util.Scanner;

/**
 * 高优先权优先调度算法（抢占式）
 *
 * 该程序的思想：将所有进程信息存入数组中，先找出最早到达的进程，将进程状态标记为运行，表示运行该进程；
 * 每个进程的优先权为开始时自动设置的一个10~20的随机数；
 * currentTime表示当前时间，随着循环的进行而增加；
 * 数组中同时只有一个进程的状态为运行，当进程的状态为运行时，进程的优先权随着时间的增加而减少；
 * 当需要运行下一个进程时，将下一个将要运行的进程的状态标记为运行，并进入下一轮循环；
 * 当进程的状态发生改变时，输出数组中的进程信息；
 * 进程剩余服务时间等于0后，进程的状态改为完成，当所有进程的状态为完成后，退出循环；
 *
 */
public class Demo3 {

    public static void main(String[] args) {
        PCB2[] a = new PCB2[10];

        // input方法用于输入进程信息，返回输入进程的总数
        int k = input(a);

        // 输出初始作业状态
        System.out.println("初始作业状态：");
        // 遍历输出数组
        output(a, k);


        int f = 0; // 用于记录已经完成调度的进程个数
        // 找出最早到达的进程，先执行
        int m1 = firstArrive(a, k);
        // 当前时间设为第一个到达进程的到达时间
        double currentTime = a[m1].getArriveTime();
        a[m1].setCondition(1); // 将进程m1的状态改为运行


        while (f < k){

            int m = 0;
            // 找出需要运行的进程
            for (int i = 0; i < k; i++) {
                if (a[i].getCondition() == 1){
                    m = i;
                    break;
                }
            }
            // beginTime默认为-1
            if (a[m].getBeginTime() == -1){
                a[m].setBeginTime(currentTime);
            }
            System.out.println("当前时间：" + currentTime);
            output(a, k);

            // 循环一次时间加1
            for (int i = 0; i < a[m].getServiceTime2(); i++) {
                currentTime = currentTime + 1;
                a[m].setServiceTime(a[m].getServiceTime() - 1);
                a[m].setDibs(a[m].getDibs() - 1);


                // 进程执行完成
                if (a[m].getServiceTime() == 0){
                    a[m].setCondition(2); // 将进程m的状态改为完成
                    a[m].setFinishTime(currentTime);
                    f = f + 1;
                    // 进程全部执行完毕后退出循环
                    if (f == k){
                        break;
                    }

                    // 利用进程的状态标记下一个需要运行的进程
                    PCB2 max1 = new PCB2();
                    int n1 = -1;
                    for (int j = 0; j < k; j++) {
                        if (currentTime >= a[j].getArriveTime() && (a[j].getCondition() != 2)){
                            if (a[j].getDibs() > max1.getDibs()){
                                max1 = a[j];
                                n1 = j;
                            } else if (a[j].getDibs() == max1.getDibs() && a[j].getArriveTime() < max1.getArriveTime()){
                                max1 = a[j];
                                n1 = j;
                            }
                        }
                    }
                    // 将下一个运行的进程状态变为运行
                    if (n1 != -1){
                        a[n1].setCondition(1);
                    } else{
                        int m2 = firstArrive(a, k);
                        currentTime = a[m2].getArriveTime();
                        a[m2].setCondition(1);
                    }
                    break;


                } else {
                    // 如果当前进程没有执行完成，并且等待队列中存在优先权更高的进程
                    // 阻塞当前进程，标记优先权更高的进程
                    PCB2 max2;
                    max2 = a[m];
                    int n2 = m;
                    for (int j = 0; j < k; j++) {
                        if (currentTime >= a[j].getArriveTime() && (a[j].getCondition() != 2)){
                            if (max2.getDibs() < a[j].getDibs()){
                                max2 = a[j];
                                n2 = j;
                            } else if (a[j].getDibs() == max2.getDibs() && a[j].getArriveTime() < max2.getArriveTime()){
                                max2 = a[j];
                                n2 = j;
                            }

                        }
                    }
                    if (n2 != m) {
                        a[m].setCondition(0);
                        a[n2].setCondition(1);
                        break;
                    }
                }


            }

        }

        System.out.println("最终结果：");
        System.out.println("当前时间：" + currentTime);
        for (int i = 0; i < k; i++) {
            a[i].setCyclingTime(a[i].getFinishTime() - a[i].getArriveTime());
            double time = a[i].getCyclingTime() / a[i].getServiceTime2();
            a[i].setFloat_Wi(Double.parseDouble(String .format("%.2f", time)));
            System.out.println(a[i]);
        }

    }

    /**
     * 该方法用于遍历输出数组
     * @param a
     * @param k
     */
    public static void output(PCB2[] a, int k){
        for (int i = 0; i < k; i++) {
            System.out.println(a[i]);
            if (i == k - 1){
                System.out.println();
            }
        }
    }


    /**
     * 该方法用于找出除运行完成的进程之外的最早到达的进程的下标
     * @param a
     * @param k
     * @return 除运行完成的进程之外的最早到达的进程的下标
     */
    public static int firstArrive(PCB2[] a, int k){

        PCB2 min = new PCB2();
        int m = 0;
        // 找出一个未完成的进程赋给min
        for (int i = 0; i < k; i++) {
            if (a[i].getCondition() != 2){
                min = a[i];
                m = i;
                break;
            }
        }

        for (int i = 0; i < k; i++) {

            if (a[i].getArriveTime() < min.getArriveTime() && (a[i].getCondition() != 2)){
                min = a[i];
                m = i;
            } else if(a[i].getArriveTime() == min.getArriveTime() && a[i].getDibs() >= min.getDibs() && (a[i].getCondition() != 2)){
                min = a[i];
                m = i;
            }
        }
        return m;
    }

    /**
     * 该方法用于输入进程信息
     * @param a
     * @return 输入进程的个数
     */
    public static int input(PCB2[] a){

        Scanner scanner = new Scanner(System.in);

        int k = 0; // 初始化,k记录总进程数
        System.out.println("请一次输入两个整数，之间用空格隔开,输入负数结束输入");

        // 重复输入进程信息
        while (true){
            System.out.printf("请输入第%d进程到达时间、服务时间（整数）：", k);
            // 将进程id设置为k
            double arriveTime = scanner.nextDouble();
            if (arriveTime < 0){
                System.out.println("输入结束");
                break;
            }
            int serviceTime = 0;
            try {
                serviceTime = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("服务时间应该为整数!");
                e.printStackTrace();
            }
            int dibs = (int) (Math.random() * 10 + 10); // 生成一个10~20的随机数，设置为进程的初始优先度
            a[k] = new PCB2(k,arriveTime, serviceTime, dibs); // 利用构造方法初始化数据
            k ++;
            if (serviceTime < 0){
                System.out.println("输入结束");
                break;
            }
        }
        scanner.close(); // 释放scanner

        return k;
    }


    public static class PCB2 {

        private int id;
        private double beginTime; // 开始执行时间
        private double arriveTime; // 到达时间
        private int serviceTime; // 剩余服务时间
        private int serviceTime2; // 服务时间
        private double finishTime; // 完成时间
        private double cyclingTime; // 周转时间
        private double float_Wi; // 带权周转时间
        private int dibs; // 优先权
        private int condition; // 进程状态，0表示等待，1表示运行，2表示完成

        public int getServiceTime2() {
            return serviceTime2;
        }

        public void setServiceTime2(int serviceTime2) {
            this.serviceTime2 = serviceTime2;
        }

        public double getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(double beginTime) {
            this.beginTime = beginTime;
        }

        public int getCondition() {
            return condition;
        }

        public void setCondition(int condition) {
            this.condition = condition;
        }

        public int getDibs() {
            return dibs;
        }

        public void setDibs(int dibs) {
            this.dibs = dibs;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getArriveTime() {
            return arriveTime;
        }

        public void setArriveTime(double arriveTime) {
            this.arriveTime = arriveTime;
        }

        public int getServiceTime() {
            return serviceTime;
        }

        public void setServiceTime(int serviceTime) {
            this.serviceTime = serviceTime;
        }

        public double getFinishTime() {
            return finishTime;
        }

        public void setFinishTime(double finishTime) {
            this.finishTime = finishTime;
        }

        public double getCyclingTime() {
            return cyclingTime;
        }

        public void setCyclingTime(double cyclingTime) {
            this.cyclingTime = cyclingTime;
        }

        public double getFloat_Wi() {
            return float_Wi;
        }

        public void setFloat_Wi(double float_Wi) {
            this.float_Wi = float_Wi;
        }

        public PCB2() {
        }

        public PCB2(int id, double arriveTime, int serviceTime, int dibs) {
            this.id = id;
            this.arriveTime = arriveTime;
            this.serviceTime = serviceTime;
            this.serviceTime2 = serviceTime;
            this.dibs = dibs;
            this.beginTime = -1; // 默认开始执行时间为-1
        }

        @Override
        public String toString() {
            String condition1;
            if (condition == 0) {
                condition1 = "等待";
            } else if (condition == 1) {
                condition1 = "运行";
            } else {
                condition1 = "完成";
            }
            return "进程信息：" +
                    "id=" + id +
                    ", 到达时间=" + arriveTime +
                    ", 剩余服务时间=" + serviceTime +
                    ", 服务时间=" + serviceTime2 +
                    ", 开始执行时间=" + beginTime +
                    ", 完成时间=" + finishTime +
                    ", 周转时间=" + cyclingTime +
                    ", 带权周转时间=" + float_Wi +
                    ", 优先权=" + dibs +
                    ", 进程状态：" + condition1;
        }

    }
}

