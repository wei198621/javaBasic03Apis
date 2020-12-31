package day22;

import day20.TestReaderWriter02;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author leowei
 * @date 2020/12/31  - 21:42
 */
public class TestSynchronized {
    public static void main(String[] args) throws InterruptedException {

       // test01();
        // test02();
        test03();
    }

    //最简单的打印语句
    private static void test01() {
        MyList list = new MyList();
        list.add('C');
        list.add('D');
        list.print();
    }

    //添加语句放在  thread 线程里面  ，不是test01 里面的顺序添加
    //猜测 结果可能是  ABCD  ABDC
    //实际        ABD    C 不见了
    private static void test02() throws InterruptedException {
        MyList list = new MyList();
        Thread t1 = new Thread() {
            public void run() {
                list.add('C');
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                list.add('D');
            }
        };
        t1.start();
        t2.start();
        t1.join();      //主线程等待t1结束
        t2.join();
        list.print();
    }


    //添加语句放在  thread 线程里面  ，不是test01 里面的顺序添加
    //猜测 结果可能是  ABCD  ABDC
    private static void test03() throws InterruptedException {
        MyList list = new MyList();
        Thread t1 = new Thread() {
            public void run() {
                synchronized (list){   //对list 加锁
                    list.add('C');
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                synchronized (list) { //对list 加锁
                    list.add('D');
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();      //主线程等待t1结束
        t2.join();
        list.print();
    }

}

class MyList{
    private char[] data={'A','B',' ',' ',' '};
    private int index = 2;
    public void add(char c){
        data[index]=c;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        index++;
    }

    public void print() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(i + ":" + data[i] + "\t");
        }
    }
}
