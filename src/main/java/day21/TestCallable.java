package day21;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author leowei
 * @date 2020/12/31  - 17:25
 */
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Callable
        ExecutorService es = Executors.newFixedThreadPool(2);
        TaskA4 taskA4 = new TaskA4();
       Future<Integer> f1=  es.submit(taskA4);       //线程启动时候拿到future对象
        TaskB4 taskB4 = new TaskB4();
        Future<Integer> f2=  es.submit(taskB4);

        // 能取到就取到，不能取到就等待
        Integer int1 = f1.get();
        Integer int2 = f2.get();
        System.out.println( int1 + int2 );

    }
}

// 奇数相加
class TaskA4 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        Integer result=0;
        for(int i=1;i<=10000;i+=2){
            result+=i;
        }
        return result;
    }
}

// 偶数相加
class TaskB4 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        Integer result=0;
        for(int i=2;i<=10000;i+=2){
            result+=i;
        }
        return result;
    }
}
