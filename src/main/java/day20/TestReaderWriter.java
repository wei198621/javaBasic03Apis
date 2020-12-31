package day20;

import java.io.*;

/**
 * @author leowei
 * @date 2020/12/31  - 9:12
 */
public class TestReaderWriter {
    public static void main(String[] args) throws IOException {
        doByZiFu();

       // doByZiJie();

        //平时用 第二种方式
       // 如果直接 用 字节流，采用平台默认的编解码方式处理
        // 采用字节流转字符流的方式，可以在桥转换类  OutputStreamWriter/InpuStreamReader 中指定字符集
        return;
    }
    //字节方式
    private static void doByZiJie() throws IOException {
        OutputStream fos=new FileOutputStream("a.txt");    //  文件字节流
        Writer fw = new OutputStreamWriter(fos);                  // （桥转换类）字节流转字符流
        PrintWriter out = new PrintWriter(fw);                    //
        out.println("春风杨柳万千条");
        out.println("六亿深圳尽舜尧");
        out.println("红雨随心翻作浪");
        out.println("青山着意化为桥");
        out.println("天连五岭银锄落");
        out.println("地动三河铁臂摇");
        out.println("借问瘟君欲何往");
        out.println("纸船明灯照天烧");
        out.println("");
        out.close();

        FileInputStream fis=new FileInputStream("a.txt");   //字节流  节点流
        Reader fr = new InputStreamReader(fis);                    //字节流转  字符流  节点流
        BufferedReader in = new BufferedReader(fr);               //过滤流    缓冲流
        while(true){
            String s = in.readLine();
            if(s==null) {
                break;
            }
            System.out.println(s);
        }
        in.close();
    }


    //字符方式
    private static void doByZiFu() throws IOException {
        FileWriter fw=new FileWriter("a.txt");
        PrintWriter out = new PrintWriter(fw);
       /*  BufferedWriter 方式
        BufferedWriter out = new BufferedWriter(fw);
        out.write("春风杨柳万千条");
        out.write("\n");
        out.write("六亿深圳尽舜尧3344");*/
        out.println("春风杨柳万千条");
        out.println("六亿深圳尽舜尧");
        out.println("红雨随心翻作浪");
        out.println("青山着意化为桥");
        out.println("天连五岭银锄落");
        out.println("地动三河铁臂摇");
        out.println("借问瘟君欲何往");
        out.println("纸船明灯照天烧");
        out.println("");
        out.close();

        FileReader fr=new FileReader("a.txt");
        BufferedReader in = new BufferedReader(fr);
        while(true){
            String s = in.readLine();
            if(s==null) {
                break;
            }
            System.out.println(s);
        }
        in.close();
    }
}
