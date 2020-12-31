package day21;
import java.util.concurrent.*;
/**
 * @author leowei
 * @date 2020/12/31  - 16:40
 */
public class TestExecutor {
    public static void main(String[] args) {

        // Executors 是工具类 （有很多的静态方法）  用于生产
        ExecutorService exeService = Executors.newFixedThreadPool(2);
        //ExecutorService exeService2 = Executors.newCachedThreadPool();

        TaskA3 a3 = new TaskA3();    //1. 创建任务对象
        exeService.submit(a3);       //2. 将任务对象提交给线程池

        TaskB3 b3 = new TaskB3();
        exeService.submit(b3);

        // 默认写法
        TaskC3 c3 = new TaskC3();
        exeService.submit(c3);

      /*  // 匿名内部类写法
        exeService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("task4 i=  " + i);
                }
            }
        });*/
      /*  //labmda 表达式写法
        exeService.submit(()->{
            for (int i = 0; i < 10000; i++) {
                System.out.println("task5 i=  " + i);
            }
        });*/

        // exeService.shutdown();  关闭线程池 ，平时不用
    }
}



//class TaskA3 extends Thread{
class TaskA3 implements Runnable{
    @Override
    public void run() {

        int count=10000;
        for (int i = 0; i < count; i++) {
            System.out.println("TaskA ..."+ i + Thread.currentThread().getName());
        }
    }
}
class TaskB3 implements Runnable{

    @Override
    public void run() {
        int count=10000;
        for (int i = 0; i < count; i++) {
            System.out.println("TaskB..."+ i+ Thread.currentThread().getName());
        }
        System.out.println();
    }
}

class TaskC3 implements Runnable{

    @Override
    public void run() {
        int count=10000;
        for (int i = 0; i < count; i++) {
            System.out.println("TaskC..."+ i+ Thread.currentThread().getName());
        }
        System.out.println();
    }
}