package day19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author leowei
 * @date 2020/12/30  - 15:21
 */
public class TestFileCopy {

    public static void main(String[] args)   {
        long startTime = System.nanoTime();
        System.out.println("startTime = " + startTime);
        FileInputStream is=null;
        FileOutputStream os=null;
        String fileName="BaiduNetdisk_7.0.5.9.exe";  //  BaiduNetdisk_7.0.5.9.exe  a.txt
        String fileOutName= "out"+fileName;
        try {
            is=new FileInputStream(fileName);
            os = new FileOutputStream(fileOutName);
            while(true) {
                int read = is.read();
                if (read == -1) {
                    break;
                }
                os.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                os.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            long endTime = System.nanoTime();
            System.out.println("endTime = " + endTime);
            System.out.println(" 复制"+fileName+  "，耗时  总时间 = " + (endTime - startTime));
        }



    }
}
