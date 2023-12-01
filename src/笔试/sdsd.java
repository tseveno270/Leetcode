package 笔试;


class test{
    public static void main(String[] args){
        String s1 = new String("a") + new String("b");
        String s2 = "ab";
        String s3 = s1.intern();
        System.out.println(s1.hashCode() == s2.hashCode());
        System.out.println(s1==s3);
    }
}

