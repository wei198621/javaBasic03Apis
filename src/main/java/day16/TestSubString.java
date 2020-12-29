package day16;

/**
 * @author leowei
 * @date 2020/12/29  - 14:18
 */
public class TestSubString {
    public static void main(String[] args) {
        String str="ABCaDEFGHaIJKLMNaOPQabcd";

        boolean start = str.startsWith("ABCD");
        System.out.println("str = " + start);

        boolean abc = str.endsWith("ABC");
        System.out.println("abc = " + abc);
        boolean con = str.contains("abc");
        System.out.println("con = " + con);
        int index = str.indexOf("JKL");
        System.out.println("index = " + index);
        int index2 = str.indexOf("JKL", 8);
        System.out.println("index2 = " + index2);
        int indexOf = str.lastIndexOf("ABC");
        System.out.println("indexOf = " + indexOf);

        String substring = str.substring(2);
        System.out.println("substring = " + substring);
        str.substring(2,8);
        System.out.println("substring = " + substring);

        String substring1 = str.substring(0, str.length());
        System.out.println("substring1 = " + substring1);
        String substring2 = str.substring(0, str.length() - 1);
        System.out.println("substring2 = " + substring2);

        String bc = str.replace("BC", ":");
        System.out.println("bc = " + bc);

        String[] as = str.split("a");
        for (String a : as) {
            System.out.println("a = " + a);
        }


        // 1. StratWith(String str)
        // 2. endsWith (String str)
        // indexof(String str)
        // lastIndexof(String str)
        // substring(int fromIndex)
        // substring(int fromIndex,int endIndex) 找出从fromIndex开始到endIndex结束的子串，包含fromIndex,不包含endIndex;
        //
        //
        //
        // err





    }
}
