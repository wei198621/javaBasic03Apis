package day21;

/**
 * @author leowei
 * @date 2020/12/31  - 14:24
 */
public class TestThread {
    public static void main(String[] args) {
        Runnable taskA = new TaskA();    // 创建任务对象
        Thread t1 = new Thread(taskA);   // 创建线程对象
        t1.start();                      // 创建线程

        Runnable taskB = new TaskB();
        Thread t2 = new Thread(taskB);
        t2.start();
    }
}

class TaskA implements Runnable{
    @Override
    public void run() {
        System.out.println("TaskA .... ");
    }
}
class TaskB implements Runnable{

    @Override
    public void run() {
        int count=10000;
        for (int i = 0; i < count; i++) {
            System.out.println("TaskB"+ i);
        }
        System.out.println();
    }
}