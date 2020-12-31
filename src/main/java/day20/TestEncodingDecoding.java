package day20;

import java.io.UnsupportedEncodingException;

/**
 * @author leowei
 * @date 2020/12/31  - 8:19
 */
public class TestEncodingDecoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="xuzhoushijinshanqiaokaofaqu徐州市金山桥开发区11-1号55505室,中关村软件园";
        System.out.println(str);
        byte[] bytes = str.getBytes("GBK");     //编码   按照GBK方式编码
        String strResult1 = new String(bytes,"big5");    //解码    如果不写  jdk 默认 forName("UTF-8");
        System.out.println("strResult1 = " + strResult1);

        byte[] big5s = strResult1.getBytes("Big5");
        String str3 = new String(big5s,"GBK");
        System.out.println("str3 = " + str3);

        //

    }
}
