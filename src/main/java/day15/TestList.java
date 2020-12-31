package day15;

import javax.lang.model.SourceVersion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author leowei
 * @date 2020/12/29  - 16:18
 */
public class TestList {

    private static String result="";
    public static void main(String[] args) {

        //原始数据
       // MyList list = new MyList();       // 自定义List类
        ArrayList list = new ArrayList();  //
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("gousheng");    //大于三个自动扩容
        list.add("xiaoli");
        list.add(0,"huhu");
        System.out.println(list.indexOf("gousheng"));
        list.remove(2);
        System.out.println(list.indexOf("gousheng"));



        //list  的四种遍历方式

        System.out.println("==============下标遍历==================");
        //方式一    下标遍历  （可以遍历List 不可以遍历Set ,因为set 没有下标 ）
        for(int i=0;i<list.size();i++){
            Object o = list.get(i);
            System.out.println("  o = " + o);
        }

        //方式二 迭代方式遍历    自jdk1.2 方式出现的迭代方式
        System.out.println("===============迭代方式遍历=============");
        Iterator it = list.iterator();
        while(it.hasNext()){
            Object next = it.next();
            String s =(String) next;
            System.out.println("  s = " + s);
        }

        //方式三 for-Each   自jdk1.5 方式出现的迭代方式
         System.out.println("===========for-Each 遍历 ============");
        for(Object o: list){
            String s=(String)o;
            System.out.println("s = " + s);
        }

        //方式四 forEach 自遍历   自jdk 8 开始
         System.out.println("===========forEach 自遍历 1 接口回调 ============");
        class MyConsumer implements Consumer{
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        }
        // 接口回调
        list.forEach(new MyConsumer());


        System.out.println("===========forEach 自遍历2  匿名内部类 ============");
        //方式4.1
        list.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });

        System.out.println("===========forEach 自遍历 3 lambda ============");
        //方式4.2  lambda 把代码当做参数传递
        list.forEach(x-> System.out.println("x = " + x));

        /*
        o = huhu     o = zhangsan   o = lisi
        o = wangwu   o = gousheng   o = xiaoli
        * */

        // final String  result="";//result 外部类的局部变量
        // lambda 中不能改变 外部类的局部变量
        // lambda 访问外部类的局部变量的时候默认增加 final  ，final 限定不可以改值，所以要将result放到外部，作为成员变量，供lambda表达式访问


        System.out.println("===========forEach  使用成员变量  ============");

        list.forEach(x-> result+=x );
        System.out.println("result = " + result);
    }
}

class  MyList{
    private Object[] os =new Object[3];
    private int index;  //数组中有效元素的个数，也是元素下标范围  0 -  index-1 ;

    //添加到元素末尾
    public void add(Object o){
       if(os.length==index){
           expand();
       }
       os[index]=o;
       index++;
    }

    //添加元素到指定pos下标
    public void add(int pos,Object o){
        if(os.length==index){
            expand();
        }
        for(int i=index;i>pos;i--){
            os[i]=os[i-1];
        }
        os[pos]=o;
        index++;

    }

    //数组扩容 2 倍
    public  void expand(){
        Object[] os2 = new Object[os.length * 2];
        for(int i=0;i<os.length;i++){
            os2[i]=os[i];
        }
        os=os2;
    }


    public int size(){
      return index;
    }

    public Object get(int pos){
        return os[pos];
    }
}