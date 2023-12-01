package 笔试;

import java.util.Arrays;
import java.util.Random;

/**
 * 功能描述
 *
 * @author: 270
 * @date: 2023年09月15日 7:58
 */
public class randomGenerrator {
    public static void main(String[] args) {
        Random random = new Random(); // 创建Random对象生成随机数
        Object[] a = new Object[8];
        //转速
        float minz = 2189;
        float maxz = 2211;
        //功率
        float ming = 238;
        float maxg = 259;
        //机油压力
        int minj = 375;
        int maxj = 585;
        //排气温度
        int minp = 295;
        int maxp = 555;
        //油耗率
        float miny = 180;
        float maxy = 225;
        //最高空车转速
        int mink = 2350;
        int maxk = 2580;
        for (int i = 0; i < 31; i++) {
            float text1 = minz + (maxz-minz)*random.nextFloat();
            a[0] = text1;
            float text2 = ming + (maxg-ming)*random.nextFloat();
            a[1] = text2;
            int text3 = (maxj -minj) + random.nextInt(370);
            a[2] = text3;
            int text4 = (maxp -minp) + random.nextInt(300);
            a[3] = text4;
            float text5 = miny + (maxy-miny)*random.nextFloat();
            a[4] = text5;
            int text6 = 2300 + random.nextInt(150);
            a[5] = text6;
            int text7 =  550 + random.nextInt(100);
            a[6] = text7;
            //产品号
            int type = random.nextInt(3)+1;
             a[7] = "\'DHP10Q1684*01\'";
            //不能直接打印
            System.out.println(Arrays.toString(a)+",");
        }
    }
}
