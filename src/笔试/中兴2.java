package 笔试;

import java.util.Scanner;

public class 中兴2 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String[] s = in.nextLine().split(" ");
            int[] arr = new int[s.length];
            int n = in.nextInt();
            int temp = n;
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int sum = 0,i=0;
            while(i<arr.length){
                if(temp>=arr[i]){
                    temp = temp - arr[i];
                    sum+=1;
                    i+=1;
                }else {
                    temp = n;
                    temp = temp - arr[i];
                    sum += 2*i+1;
                    i += 1;
                }
            }
            System.out.println(sum);
    }
}
