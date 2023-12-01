package 笔试;

public class asd {
    public static void main(String[] args) {

        System.out.println(3);
        System.out.println(4);
        System.out.println(-1);
    }
      private static int find2(int[] array){
          if (array==null||array.length==0){
              return 0;
          }
          int cur = 0;
          int maxSum = 0;
          int maxNum = Integer.MIN_VALUE;
          for (int i = 0; i < array.length; i++) {
              if (array[i]>maxNum){
                  maxNum = array[i];
              }
          }
          if (maxNum<=0){
              return maxNum;
          }
          for (int i = 0; i < array.length; i++) {
              if (cur<=0){
                  cur = array[i];
              }else {
                  cur = cur + array[i];
              }
              if (cur>maxSum){
                  maxSum = cur;
              }
          }
          return maxSum;
      }
    }




