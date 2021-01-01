package day23;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author leowei
 * @date 2021/1/1  - 15:21
 *  config.txt 的内容是
animal=day23.Dog
animal2=day23.Dog
 */
public class TestFactory {
    public static void main(String[] args) throws Exception {
        //Dog a =new Dog();
        //Animal a =new Dog();
       /* Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        Animal a = createAnimal(next); //  "Dog";*/

        //Animal a = createAnimalBuReflect01(); //  "Dog";
        Animal a = createAnimalBuReflect02(); //  "Dog";

        a.eat();
    }

    // 原始的创建方式
    public static Animal createAnimal0(String className) {
        if (className.equals("Dog")) {
            return new Dog();
        }
        if (className.equals("Cat")) {
            return new Cat();
        }
        return null;
    }

    // 反射创建方式  对象
    public static Animal createAnimal(String className) {
        try {
            Class c = Class.forName("day23." + className);   // 获取类对象
            Object o  = c.newInstance();
            return (Animal) o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 反射创建方式  对象  读取配置文件
    public static Animal createAnimalBuReflect01() throws IOException {
        try {
            InputStream is =new FileInputStream("config.txt");
            InputStreamReader isr =new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
           // while(true){        //只考虑一行的情况
                String result = br.readLine();
           // }

            String[] splits = result.split("=");
            Class c = Class.forName(splits[1].trim());   // 获取类对象
            Object o  = c.newInstance();
            return (Animal) o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // 反射创建方式  对象  读取配置文件
    public static Animal createAnimalBuReflect02() throws IOException {
        try {
            InputStream is =new FileInputStream("config.txt");
            Properties pro =new Properties();
             pro.load(is);
            String animal = pro.getProperty("animal");
            Class c = Class.forName(animal.trim());   // 获取类对象
            Object o  = c.newInstance();
            return (Animal) o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}


class Animal{
    public void eat(){}
}

class Dog extends Animal{
    public void eat(){
        System.out.println(" Dog eat");
    }
}
class Cat extends Animal{
    public void eat(){
        System.out.println(" Cat eat");
    }
}