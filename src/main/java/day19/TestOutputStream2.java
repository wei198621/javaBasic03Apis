package day19;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author leowei
 * @date 2020/12/30  - 14:45
 */
public class TestOutputStream2 {
    public static void main(String[] args) {
       /* OutputStream os=null;
        try {
            os =new FileOutputStream("a.txt");
            os.write('D');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(os!=null){
                    os.close();//关闭流
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
       // 用下面的语句替换上面的语句
       //放入 try 块的所有资源必须实现 AutoCloseable接口
       try(OutputStream os=new FileOutputStream("a.txt")) {
           os.write('D');
       }catch(IOException e){
           e.printStackTrace();
       }

    }
}
