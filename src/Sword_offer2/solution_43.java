package Sword_offer2;

public class solution_43 {
}

class Solution43 {
    public int countDigitOne(int n) {
        int digit = 1;
        int res = 0;
        int high = n/10;
        int cur = n%10;
        int low = 0;
        while(high!=0 || cur!=0){
            if (cur==0){res+=high*digit;}
            else if(cur == 1)res += high*digit +low + 1;
            else res+=(high+1)*digit;
            low += cur*digit;
            high /= 10;
            cur = high%10;
            digit *= 10;
        }
        return res;

    }
}
