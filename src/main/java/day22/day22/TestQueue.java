package day22.day22;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author leowei
 * @date 2021/1/1  - 0:22
 */
public class TestQueue {
    public static void main(String[] args) {
        m1();

    }

    private static void m1() {
        Queue<Object> queue = new LinkedList<>();
        queue.offer("liucy");
        queue.offer("weilei");
        queue.offer("wxj");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    private static void m2() {
        Queue<Object> queue = new ConcurrentLinkedQueue<>();
        queue.offer("liucy");
        queue.offer("weilei");
        queue.offer("wxj");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
