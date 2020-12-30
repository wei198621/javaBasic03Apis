package day19;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author leowei
 * @date 2020/12/30  - 15:21
 */
public class TestFileCopyByBuffered {

    public static void main(String[] args)   {
        long startTime = System.nanoTime();
        System.out.println("startTime = " + startTime);
        FileInputStream is=null;
        FileOutputStream os=null;
        BufferedInputStream bis =null;
        BufferedOutputStream bos = null;
        String fileName="BaiduNetdisk_7.0.5.9.exe";  //  BaiduNetdisk_7.0.5.9.exe  a.txt
        String fileOutName= "out"+fileName;
        try {
            is=new FileInputStream(fileName);
            bis = new BufferedInputStream(is);
            os = new FileOutputStream(fileOutName);
            bos =new BufferedOutputStream(os);
            while(true) {
                int read = bis.read();
                if (read == -1) {
                    break;
                }
                bos.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();

            try {
                // os.close(); //只关闭最外部的流就可以了
                bos.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                //is.close();   //只关闭最外部的流就可以了
                bis.close();
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
