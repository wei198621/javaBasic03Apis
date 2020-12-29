package day16;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Objects;

/**
 * @author leowei
 * @date 2020/12/29  - 14:38
 */
public class TestString2 {
    public static void main(String[] args) {

        //1.判断一个字符串是否为回文字符串     abcdcba  --》  abcdcba
        //huiwen01();                 //方式一
        boolean b = huiwen02();      //方式二
        System.out.println("b = " + b);
        boolean b1 = huiwen03();    //方式三
        System.out.println("b1 = " + b1);


        //2. 在一个字符串“ABCDIFGABC234BC23432BAC2343ABCD”中找出所有的“BC”字符串

        String strAll="ABCDIFGABC234BC23432BAC2343ABCD";
        String strSubStr="BC";
        AllIndexOf(strAll,strSubStr);

    }

    private static void huiwen01() {
        String strInput="abcdcba";
        char[] chars = strInput.toCharArray();
        int len =  chars.length-1;
        String strOutput="";
        for(int i=len;i>=0; i--){
            strOutput+=chars[i];
         }
        System.out.println(strOutput);

        if(Objects.equals(strInput,strOutput)){
            System.out.println("ok");
        }else{
            System.out.println(" false");
        }
    }

    /**
    0 1 2 3 4
    A B C B A
    0  4        for(int i=o i< 2;i++)   a[i]  vs a[4-i]
    1  3
    2


     0 1 2 3 4
     A B C B A
     0  5         for(int i=o i< 3;i++)   a[i]  vs a[5-i]
     1  4
     2  3

     */
    private static boolean huiwen02() {
        String strInput="abcddcba";  //abcdcba   abcba  abba  都可以
        char[] chars = strInput.toCharArray();
        int len =  chars.length-1 ;
        int lenMid =  chars.length /2 ;
        System.out.println("lenMid = " + lenMid);
        for(int i=0;i< lenMid; i++){
           if(chars[i] != chars[len-i]){
               return false;
           }
        }
        return true;
    }

    private static boolean huiwen03() {
        String strInput="abcdefggfedcba";  //abcdcba   abcba  abba  都可以

        for(int i=0;i< strInput.length()/2; i++){
           if(strInput.charAt(i)!=strInput.charAt(strInput.length()-1-i)) return  false;
        }
        return true;
    }


    private static  void AllIndexOf(String s,String str){
        int start=0;
        while(true){
            int indexOf = s.indexOf(str, start);
            if(indexOf==-1) break;
            System.out.println(indexOf);
            start = indexOf + str.length();

        }
    }

}
