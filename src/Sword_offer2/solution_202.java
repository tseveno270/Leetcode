package Sword_offer2;

import java.util.HashSet;
import java.util.Set;

public class solution_202 {

}
class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> set  = new HashSet<>();
        //如果n==1说明是快乐数，如果集合存在n说明进入重复，无法变为1
        while(n!=1&&!set.contains(n)){
            set.add(n);
            n = getResult(n);
        }
        return n==1;
    }

    private Integer getResult(int n) {
        int res = 0;
        while (n>0){
            int temp = n%10;
            res += temp*temp;
            n = n/10;
        }
        return res;
    }
}
