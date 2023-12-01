import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(Solu(n,m,arr));
    }
    public static int Solu(int n,int m,int[] arr){
        int cnt[] = new int[n+1];
        int ans =0;
        int cur = 1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            cnt[arr[i]]++;
        }
        for (int i = 0; i < m; i++) {
            if (arr[i]!=cur){
                cnt[arr[i]]--;
            }else {
                for (int j = 0; j < cnt.length; j++) {
                    if (min>cnt[j]){
                        min = cnt[j];
                        cur = j;
                    }
                }
                cnt[arr[i]]--;
                ans++;
            }
        }
        return ans;
    }
}
