package day19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author leowei
 * @date 2020/12/30  - 16:42
 */
public class TestObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee e = new Employee("lichao", 44);
        FileOutputStream fos = new FileOutputStream("a.data");        // 1. 创建节点流
        ObjectOutputStream oos =new ObjectOutputStream(fos);                 // 2. 创建过滤流
        oos.writeObject(e);                                                  // 3. 写数据
        oos.close();                                                         // 4. 关闭节点
        System.out.println("ok");
        FileInputStream fis=new FileInputStream("a.data");
        ObjectInputStream ois =new ObjectInputStream(fis);
        Employee o = (Employee)ois.readObject();
        ois.close();
        System.out.println(o.getName()+"    ----    "+  o.getAge());
        // lichao    ----    0
        // transient int age;  age 使用transient 娶不到值 多以为空
    }
}


class Employee implements Serializable{
    String name;
    transient int age;
    //不想让属性参加序列化   -- Transient 临时属性，不参加序列化

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}