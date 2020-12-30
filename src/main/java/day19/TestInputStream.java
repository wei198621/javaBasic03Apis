package day19;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author leowei
 * @date 2020/12/30  - 15:02
 */
public class TestInputStream {
    public static void main(String[] args) throws Exception {
        m1();
        return;
    }

    // throw exception 的写法
    private static void m1() throws IOException {
        InputStream is = new FileInputStream("a.txt");
        //int read = is.read();   //从文件中读一个字节，返回值就是字节对应的数字 （A --> 65 ）
        while (true){
            int a= is.read();
            if(a==-1){
                break;
            }
            System.out.println("a = " + a);
            System.out.println("change type a is " + (char)a);
        }
        is.close();
    }

    // try-with-resource   写法  (自 jdk 1.7 开始 )
    private static void m2() {
        try( InputStream inputStream = new FileInputStream("a.txt")){
            while (true){
                int a= inputStream.read();
                if(a ==-1){
                    break;
                }
                System.out.println("change type a is " + (char)a);
                System.out.println("a = " + a);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
