/**
 * @author 270
 */
public class solution_29 {
    public static void main(String[] args) {
        Solution29 solution = new Solution29();
        int i = solution.divide(100, 7);
        System.out.println(i);
    }
}
class Solution29 {
    public int divide(int dividend, int divisor) {
        //被除数为零，返回零
        if (dividend == 0){return 0;}
        //除数为1，返回被除数
        if (divisor  == 1){return dividend;}
        //当除数为-1，被除数为Integer.MIN_VALUE,因为溢出，返回MAX_VALUE
        if (divisor == -1 &&dividend ==Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        //当被除数为Integer.MIN_VALUE时，防止溢出将其转换为long类型正数
        if(dividend<0&&divisor<0){
            return div(-(long)dividend,-(long)-divisor);
        }else if(dividend<0||divisor<0){
            return -div(Math.abs((long)dividend),Math.abs((long)divisor));
        }else{
            return div((long)dividend,(long)divisor);
        }
    }

    /**
     * count表示递归中使用了多少个除数
     * sum表示
     * @param a
     * @param b
     * @return
     */
    int div(long a, long b){  // 似乎精髓和难点就在于下面这几句
        if(a<b) return 0;
        long count = 1;
        long tb = b;
        while((tb+tb)<=a){
            count = count + count;
            tb = tb+tb;
        }
        return (int)count + div(a-tb,b);
    }
}
