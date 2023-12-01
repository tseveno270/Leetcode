
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        for (int i = 0; i < amount; i++) {
            int num = sc.nextInt();
            if (num % 11 != 0) {
                int count = 0;
                while (num != 0) {
                    if (num % 10 == 1) count++;
                    num /= 10;
                }
                if (count >= 2) System.out.println("yes");
                else System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }


    }


}
