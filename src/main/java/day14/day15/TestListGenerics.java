package day14.day15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author leowei
 * @date 2020/12/29  - 19:26
 */
public class TestListGenerics {
    public static void main(String[] args) {
        method1();
    }

    private static void method1() {
        List ls=new ArrayList();
        ls.add("abc");
        ls.add("xyz");
        ls.add(22);

        Object o = ls.get(0);   // 没有使用泛型，取到的值是Object  
    }


    private static void method2() {
        List<String> ls=new ArrayList<String>();
        List<String> ls2=new ArrayList<>();   // 语法糖   泛型自动推断   来自jdk 1.7  
        ls.add("abc");
        ls.add("xyz");

         String s = ls.get(0);  // 使用泛型，取到的值是 对应的泛型

       for( int i=0;i<ls.size();i++){
           String str = ls.get(i);
           System.out.println("s.toUpperCase() = " + str.toUpperCase());
       }

        Iterator<String> iterator = ls.iterator();
       while (iterator.hasNext()){
           String next = iterator.next();
           System.out.println("next.toUpperCase() = " + next.toUpperCase());
       }

        for (String str : ls) {
            System.out.println("s.toUpperCase() = " + str.toUpperCase());
        }


        ls.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("s.toUpperCase() = " + s.toUpperCase());
            }
        });

       ls.forEach(x-> System.out.println("x = " + x.toUpperCase()));


    }
    
    
    
}
