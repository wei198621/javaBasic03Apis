package day19;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author leowei
 * @date 2020/12/30  - 13:54
 */
public class TestOutputStream {
    public static void main(String[] args) throws IOException {
        m1();
        //m1_1();
        //m2();
        return;
    }

    private static void m1() throws IOException {
        FileOutputStream os = new FileOutputStream("a20201230.txt");  //放到根目录下 ，替换
        os.write('A');       // 输出流
        os.close();              // 关闭流
    }

    private static void m1_1() throws IOException {
        FileOutputStream os = new FileOutputStream("a20201230-01.txt");  //放到根目录下 ，替换
        os.write('百');       // 输出流  ，用字节流写 百 这个字符，无法正常写入 ，后面讲
        os.close();              // 关闭流
    }

    private static void m2() throws IOException {
        FileOutputStream os = new FileOutputStream("a20201230-02.txt",true);  //放到根目录下 ,追加
        os.write('A');       // 输出流   --
        os.close();              // 关闭流
    }
}
