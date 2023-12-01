import java.util.Arrays;
import java.util.Scanner;

public class Main5{
    public static int ans=0;
    public static int ans1=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int foods = sc.nextInt();
        int[][] nums = new int[amount][2];
        for (int i = 0; i < amount; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        int[] food = new int[foods+1];
        Arrays.sort(nums,(a1,a2)->a1[0]==a2[0]?a1[1]-a2[1]:a1[0]-a2[0]);
        cal(amount,foods,nums,0,food);
        System.out.println(ans1);
    }

    private static void cal(int amount, int foods, int[][] nums, int start, int[] food) {
        if (start==amount){
            ans1 = Math.max(ans1,ans);
            return;
        }
        if (nums[start][0]>foods||nums[start][1]>foods)return;
        if (food[nums[start][0]]==1||food[nums[start][1]]==1)return;
        for (int i = start;i<amount;i++){
            cal(amount,foods,nums,i+1,food);
            food[nums[start][0]]++;
            food[nums[start][1]]++;
            ans++;
            cal(amount,foods,nums,i+1,food);
            ans--;
            food[nums[start][0]]--;
            food[nums[start][1]]--;
        }
    }
}
