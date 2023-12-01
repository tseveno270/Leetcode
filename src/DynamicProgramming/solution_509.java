package DynamicProgramming;

public class solution_509 {

}

class Solution509 {
    public int fib(int n) {
        if(n<2){
            return n;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 1; i < n; i++) {
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
