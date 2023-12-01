package 笔试;


import java.util.Arrays;
import java.util.Scanner;

public class sddas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        String[] s2 = scanner.nextLine().split(" ");
        int[] table = new int[n];
        for (int i = 0; i < s2.length; i++) {
            table[i] = Integer.parseInt(s2[i]);
        }
        if (n==k){
            System.out.println(0);
            return;
        }
        Arrays.sort(table);
        int num = k/2;
        int rest = k%2;
        double temp = 0;
        for (int i = 0; i < num; i++) {
            temp+=table[i];
            temp+=table[n-1-i];
        }
        if (rest==1){
            double average1 = (temp+table[num])/k;
            double average2 = (temp+table[n-1-num])/k;
            double res = Math.min(compare(average1,table[num+1],table[n-1-num]),compare(average2,table[num],table[n-2-num]));
            System.out.println(res);
        }else {
            double average = temp/k;
            System.out.println(compare(average,table[num],table[n-1-num]));
        }
        return;

    }
    public static double compare(double a,double b,double c){
        return Math.max(Math.max(Math.abs(a-b),Math.abs(a-c)),Math.abs(b-c));
        }
}

