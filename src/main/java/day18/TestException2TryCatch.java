package day18;


import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author leowei
 * @date 2020/12/30  - 9:42
 * main      ---- 总理
 * mProvince  --- 省长
 * mCity     ---- 市长
 * mVillage  ---- 村长
 */
public class TestException2TryCatch {
    public static void main(String[] args) throws Throwable  {
        System.out.println("main 1 ------------------");
        mProvince(2222);
        System.out.println("main 2 ------------------");
        System.out.println("main 3 ------------------");
    }

    // 省长
    static void mProvince(int i) {
        System.out.println("ma 1  =========");

        try {
            mCity(i);
            System.out.println("ma 2  =========");
            return;              //不管有无异常 ，虽然此处return 了，但是finally还是会执行的
        } catch (IOException e) {
           // e.printStackTrace();    // 打印异常栈追踪信息
            System.out.println("IOException");
        } catch (MyException2 myException2) {
           // myException2.printStackTrace();
            System.out.println("printStackTrace");
        }finally {
            System.out.println(" 无论是否异常，我finally都会执行 ，我通常用于释放资源 ");
        }

        System.out.println("ma 3  =========");
    }
    //市长
    static void mCity(int i) throws IOException,MyException2{
        System.out.println("mb 1 ~~~~");
        mVillage(i);
        System.out.println("mb 2 ~~~~");
        System.out.println("mb 3 ~~~~");
    }

    //村长
    static void mVillage(int i) throws EOFException,FileNotFoundException,MyException2{
        System.out.println("mc 1");
        if (i == 0) throw new NullPointerException("模拟空指针异常，夫妻吵架，村长处理");
        if (i == 1) throw new EOFException("EOF  文件以外终止，旱灾 村长不处理，报告县长");
        if (i == 2) throw new FileNotFoundException("文件没有找到,洪灾 村长不处理，报告县长");
        if (i == 3) throw new MyException2("我自己定义的异常 ,遇到疫情 村长不处理，报告县长");
        System.out.println("mc 2");
        System.out.println("mc 3");
    }
}

//自定义异常类
class MyException2 extends Exception{
    public MyException2(){}
    public MyException2(String msg){
        super(msg);
    }
}


