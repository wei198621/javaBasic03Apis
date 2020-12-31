package day21;

import java.util.Scanner;

/**
 * @author leowei
 * @date 2020/12/31  - 14:49
 */
public class TestThread2 {
    public static void main(String[] args) {

        System.out.println( "------ threadname is: "+ Thread.currentThread().getName());
        TaskA2 taskA2 = new TaskA2();
        TaskB2 taskB2 = new TaskB2();



        taskA2.start();
        taskB2.start();
        System.out.println( "------ threadname is: "+ Thread.currentThread().getName());

    }
}
class TaskA2 extends Thread{
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("waiting for import ... ");
        String next = scanner.next();
        System.out.println("next = " + next);

        int count=10;
        for (int i = 0; i < count; i++) {
            System.out.println("TaskA ..."+ i + Thread.currentThread().getName());
        }
    }
}
class TaskB2 extends Thread{

    @Override
    public void run() {
        int count=10;
        for (int i = 0; i < count; i++) {
            System.out.println("TaskB..."+ i+ Thread.currentThread().getName());
        }
        System.out.println();
    }
}