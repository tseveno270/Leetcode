package 笔试;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(getres(arr,m));
    }
    private static int getres(int[] nums,int m){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        int count = 0;
        int mod = 1000000007;
        for(int i:nums)pq.offer(i);
        while(pq.size()>=m){
            int[] cur = new int[m];
            for (int i = 0;i<m;i++){
                cur[i] = pq.poll();
            }
            int min = cur[m-1];
            count+=min%mod;
            count%=mod;
            for (int i:cur){
                int n = i - min;
                if (n>0)pq.offer(n);
            }
        }
        return count;
    }
}
