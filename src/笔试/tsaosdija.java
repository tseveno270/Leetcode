package 笔试;

public class tsaosdija {
    public static void main(String[] args) {
        System.out.println(15/7);
    }
    public long multipleOf7 (long l, long r) {
        // write code here

      return r%7==0?(r/7)-(l/7)-1:(r/7)-(l/7);

    }
}
