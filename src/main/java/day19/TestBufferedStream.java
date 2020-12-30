package day19;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author leowei
 * @date 2020/12/30  - 15:53
 */
public class TestBufferedStream {

    public static void main(String[] args) throws IOException {
       // m1();
        m2();
    }
    // 缓冲流 标准 写法
    private static void m1() throws IOException {
        FileOutputStream fos = new FileOutputStream("a.txt");
        BufferedOutputStream out = new BufferedOutputStream(fos);
        out.write('A');
        out.write('B');
        out.write('C');
        out.write('D');
        out.flush();        //清空缓冲区， 不关闭流
        //out.close();         //关闭 BufferedOutputStream 自动 关闭  其包装的  FileOutputStream
    }

    // 缓冲流 Jdk 1.7 后的   try-with-resource  写法
    private static void m2() {
        try (FileOutputStream fos = new FileOutputStream("a.txt");
             BufferedOutputStream out = new BufferedOutputStream(fos);
        ) {
            out.write('A');
            out.write('B');
            out.write('C');
            out.write('D');
            out.flush();        //清空缓冲区， 不关闭流
            //out.close();         //关闭 BufferedOutputStream 自动 关闭  其包装的  FileOutputStream
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
