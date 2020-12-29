package day16;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author leowei
 * @date 2020/12/29  - 22:24
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();   // 集合中装对象 ，无法装基本类型，所以Integer  不是int
        map.put(2020 ,"东京");
        map.put(2024 ,"巴黎");
        map.put(2028 ,"洛杉矶");
        map.put( 2016,"里约热内卢");
        map.put(2012 ,"伦敦");
        // ....
        map.put( 1984,"洛杉矶");
        map.put(1980 ,"莫斯科");
        map.put( 1948 ,"伦敦");
        map.put( 1936 ,"柏林");
        //map.put(   ," ");




        System.out.println("============================================");
        String s = map.get(2008);
        System.out.println("s = " + s);

        System.out.println(map.containsKey(1940));
        System.out.println(map.containsValue("洛杉矶"));

        System.out.println(map.get(2020));    //东京
        map.put(2020,"驻马店");
        System.out.println(map.get(2020));    //新的值 驻马店 替换 东京

        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            System.out.println("value = " + map.get(key));
        }
        // keys 是个set 是无序的，所以无法使用下面方式进行遍历
        for (int i = 0; i < keys.size(); i++) {
        }
        keys.forEach(x-> System.out.println("key = " + x));
        System.out.println("============================================");

        Collection<String> values = map.values();
        values.forEach(value -> System.out.println("valueByLambda = " + value));

        for (String value : values) {
            System.out.println("value By for  = " + value);
        }
        System.out.println("============================================");

        map.forEach((k,v)-> System.out.println("k = " + k + " ; v ="+ v));

    }
}
