package day18;

/**
 * @author leowei
 * @date 2020/12/30  - 12:15
 */
public class TestFinally {
    public static void main(String[] args) {
        System.out.println(fn(2));   //结果 2    不管错还是对 都执行 finnally 的语句
        System.out.println("---------------------------------");
        System.out.println(fn(0));   //结果 2     不管错还是对 都执行 finnally 的语句
    }
    static int fn(int n){
        try {
            int a=6/n;
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            return 2;
        }
    }
}
