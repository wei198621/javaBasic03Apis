package day16;

/**
 * @author leowei
 * @date 2020/12/29  - 14:06
 */
public class TestString {
    public static void main(String[] args) {
        String s= "HelloWorld";

        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]>'a' && chars[i]<'z'){
                chars[i]-=32;
            }
        }
        String s1 = new String(chars);
        System.out.println("s1 = " + s1);

        String s2 = s.toUpperCase();
        System.out.println("s2 = " + s2);





    }
}
