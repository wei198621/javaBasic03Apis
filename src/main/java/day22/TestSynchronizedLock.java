package day22;

/**
 * @author leowei
 * @date 2021/1/1  - 9:35
 */
public class TestSynchronizedLock {
    public static void main(String[] args) {
        System.out.println(" start  ...........................");
        Object a ="A";
        Object b="B";
        Thread tAB = new Thread(new syncThread(a, b), "tAB");
        Thread tBA = new Thread(new syncThread(b,a), "tBA");

        tAB.start();
        tBA.start();

        System.out.println(" end ...........................");
    }


}

class syncThread implements Runnable{

    private Object obj1;
    private Object obj2;

    public syncThread(Object o1,Object o2){
        this.obj1=o1;
        this.obj2=o2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + obj1);
        System.out.println( threadName + obj2);

        synchronized (obj1){
            synchronized (obj2){
                for (int i = 0; i < 100000; i++) {
                    System.out.println(" print int  "+ obj1 + " , "+ obj2 + " :"+ i);
                    if(i/10==0){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}
