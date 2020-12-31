package day20;

import java.io.File;
import java.io.IOException;

/**
 * @author leowei
 * @date 2020/12/31  - 11:41
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        File file = new File("1.txt");  //file 既可以表示文件，也可以表示目录
        //file.createNewFile();
        //file.delete();
        file.mkdir();
        System.out.println(file.exists());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.lastModified());
        System.out.println(file.length());
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isFile()){
                System.out.println("文件："+file1.getName());
            }
            if(file1.isDirectory()){
                System.out.println("目录："+ file1.getName());
            }
        }

    }
}
