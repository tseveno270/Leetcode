package 笔试;

public class shine1 {
    public long multipleOf7 (long l, long r) {
        // write code here
        long res = 0;
        long i = l+1;
        while(i<r){
            if (i%7==0){
                res++;
                i+=7;
            }else {
                i++;
            }
        }
        return res;
    }

}

