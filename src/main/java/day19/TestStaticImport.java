package day19;
import com.sun.media.sound.SoftTuning;

import java.nio.channels.Pipe;

import static java.lang.Math.*;//  静态引入，访问Math所有的静态成员时候，可以不写类名
/**
 * @author leowei
 * @date 2020/12/30  - 7:21
 */
public class TestStaticImport {
    public static void main(String[] args) {
        //System.out.println(Math.PI);   //import static java.lang.Math.* ; Math 可以不写
        System.out.println(PI);
        System.out.println(Math.random());
        System.out.println(Math.E);


        fn();
        fn(1);
        fn(1,2);
        fn(1,2,3,4,5,6,7,8,9,0);


    }
    //a: 0-n个参数
    // 可变长参数相当于数组参数，int... a 相当于  int[] a
    // 一个函数的参数表中，只能有一个可边长参数，且必须是参数表的最后一个参数
    static void fn(int ... a){   //等同于  static void fn(int[] a){  }
        for (int i:a){
            System.out.println(i);
        }
    }



}
