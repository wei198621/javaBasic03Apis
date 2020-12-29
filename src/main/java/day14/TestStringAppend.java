package day14;

/**
 * @author leowei
 * @date 2020/12/29  - 15:27
 */
public class TestStringAppend {
    public static void main(String[] args) {
        //testStringPool01();
        stringAppend();
        stringBuildAppend();
    }

    private static void testStringPool01() {
        CharSequence  ss ;

        String s1 = "ABC";
        String s2 = "ABC";
        System.out.println("s1 =  s2 :" + s1 == s2);            //false why???
        System.out.println("s1 =  s2 :" + (s1 == s2));            //true
        System.out.println("s1.equals(s2) = " + s1.equals(s2));  //true
        System.out.println("s2.equals(s1) = " + s2.equals(s1));  //true

        String s3 = new String("ABC");     //堆空间中分配
        String s4 = new String("ABC");     //堆空间中分配
        System.out.println("s3==s4 = " + (s3 == s4));  //false

        String temp3 = s3.intern();  //串池中指向ABC
        String temp4 = s4.intern();  //串池中指向ABC
        System.out.println("temp3==temp4  " + (temp3==temp4));  //true
    }


    static long stringAppend(){
        long timeS = System.nanoTime();
        String s="";
        int count=10000;
        for(int i=0;i<count;i++){
            s+="A";
        }
        long timeE = System.nanoTime();
        System.out.println(timeE - timeS);
        return timeE -timeS;

    }

    static long stringBuildAppend(){
        long timeS = System.nanoTime();
        String s="";
        StringBuilder sb=new StringBuilder(s);
        int count=10000;
        for(int i=0;i<count;i++){
          sb.append("A");
        }
        s =sb.toString();
        long timeE = System.nanoTime();
        System.out.println(timeE - timeS);
        return timeE -timeS;
    }
}
