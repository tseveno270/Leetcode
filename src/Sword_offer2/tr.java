package Sword_offer2;

public class tr {
}
    class Main{
        public static void main(String[] args) {
            int a = test1();
            System.out.println(a);
            int b = test2();
            System.out.println(b);
            int c = test3();
            System.out.println(c);
            int d = test4();
            System.out.println(d);
            int e = test5();
            System.out.println(e);
        }
        public static int test1(){
            int a = 1;
            try{
                a = 2;
                return a;
            }catch(Exception e){
                System.out.println("hello,test1");
                a = 3;
            }finally{
                a = 4;
            }
            return a;
        }
        //输出 2
        public static int test2(){
            int a = 1;
            try{
                a = 2;
                return a;
            }catch(Exception e){
                System.out.println("hello,test2");
                a = 3;
                return a;
            }finally{
                a = 4;
            }
        }
//输出 2
        public static int test3(){
            int a = 1;
            try{
                a = 2/0;
                return a;
            }catch(Exception e){
                System.out.println("hello,test3");
                a = 3;
            }finally{
                a = 4;
            }
            return a;
        }
        //输出 hello,test3
// 4
        public static int test4(){
            int a = 1;
            try{
                a = 2/0;
                return a;
            }catch(Exception e){
                System.out.println("hello,test4");
                a = 3;
                return a;
            }finally{
                a = 4;
            }
        }
        //输出 hello,test4
// 3
        public static int test5(){
            int a = 1;
            try{
                a = 2/0;
                return a;
            }catch(Exception e){
                a = 3;
                return a;
            }finally{
                a = 4;
                return a;
            }
        }
//输出 4
    }

