package day18;


import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author leowei
 * @date 2020/12/30  - 9:42
 * main      ---- 总理
 * mProvince  --- 省长
 * mCity     ---- 市长
 * mVillage  ---- 村长
 */
public class TestException {
    public static void main(String[] args) throws Throwable  {
        System.out.println("main 1 ------------------");
        mProvince(2);
        System.out.println("main 2 ------------------");
        System.out.println("main 3 ------------------");
    }

    // 省长
    static void mProvince(int i) throws Exception {
        System.out.println("ma 1  =========");
        mCity(i);
        System.out.println("ma 2  =========");
        System.out.println("ma 3  =========");
    }
    //市长
    static void mCity(int i) throws IOException,MyException{
        System.out.println("mb 1 ~~~~");
        mVillage(i);
        System.out.println("mb 2 ~~~~");
        System.out.println("mb 3 ~~~~");
    }

    //村长
    static void mVillage(int i) throws EOFException,FileNotFoundException,MyException {
        System.out.println("mc 1");
        if (i == 0) throw new NullPointerException("模拟空指针异常，夫妻吵架，村长处理");
        if (i == 1) throw new EOFException("EOF  文件以外终止，旱灾 村长不处理，报告县长");
        if (i == 2) throw new FileNotFoundException("文件没有找到,洪灾 村长不处理，报告县长");
        if (i == 3) throw new MyException("我自己定义的异常 ,遇到疫情 村长不处理，报告县长");
        System.out.println("mc 2");
        System.out.println("mc 3");
    }
}

//自定义异常类
class MyException extends Exception{
    public MyException(){}
    public MyException(String msg){
        super(msg);
    }
}


class A {
    public void method() throws IOException{}
}
class B extends A{
    //public void method() throws IOException ,MyException{}  //不可以有MyException  方法覆盖时，子类不能比父类抛出更多的异常
    public void method() throws EOFException,FileNotFoundException{}  // ok     EOFException,FileNotFoundException 范围在 IOException 内部
}
