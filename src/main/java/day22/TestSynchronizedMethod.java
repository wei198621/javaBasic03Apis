package day22;

/**
 * @author leowei
 * @date 2020/12/31  - 23:49
 */
public class TestSynchronizedMethod {

    public static void main(String[] args) throws InterruptedException {
        test02();
    }

    //正常打印 ABCD
    private static void test02() throws InterruptedException {
        MyList2 list = new MyList2();
        Thread t1 = new Thread() {
            public void run() {
                list.add('C');   //add 方法已经增加 synchronized标记
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                list.add('D');   //add 方法已经增加 synchronized标记
            }
        };
        t1.start();
        t2.start();
        t1.join();      //主线程等待t1结束
        t2.join();
        list.print();
    }

}




class MyList2{
    private char[] data={'A','B',' ',' ',' '};
    private int index = 2;
    public synchronized void add(char c){
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
