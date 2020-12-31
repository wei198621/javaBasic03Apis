package day20;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author leowei
 * @date 2020/12/31  - 13:00
 */
public class TestReaderWriter02 {
    // 读 a.txt 四行数据
    // 将 a.txt 行倒置   输出到 b.txt
    public static void main(String[] args) throws Exception {
        //从 a.txt 中去读数据写入到 list
        FileInputStream fis = new FileInputStream("a.txt");
        Reader sr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(sr);
        List<String> list =new ArrayList<String>();
        while(true){
            String s = br.readLine();
            if(s==null) {
                break;
            }
            list.add(s);
        }
        br.close();

        System.out.println(list.size());

        Collections.reverse(list);
        //从 list 中去读数据写入到b.txt
        FileOutputStream fos= new FileOutputStream("b.txt");
        Writer writer = new OutputStreamWriter(fos);
        PrintWriter printWriter = new PrintWriter(writer,false);
        for (String s : list) {
            printWriter.println(s);

        }
        printWriter.close();
    }
}
