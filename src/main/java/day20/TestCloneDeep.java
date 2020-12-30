package day20;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author leowei
 * @date 2020/12/30  - 17:45
 */
public class TestCloneDeep {
    public static void main(String[] args) {

        Teacher2 t = new Teacher2("hxz", 44);
        Student2 s = new Student2("weilie", 22,t);
        System.out.println("s = " + s);
        //Student2 s2 =(Student2)s.Clone();
        Student2 s2 =(Student2)s.ClonePlus();
        System.out.println("s2 = " + s2);   //Student implements  Cloneable{  正常clone

        System.out.println("s== s2 = " + (s == s2));  //  false 不是同一个对象
        System.out.println(s.getTeacher()==s2.getTeacher()) ;  //false
        System.out.println(s.getName() == s2.getName());     //false

    }
}

class Student2 implements  Serializable{
    private String name;
    private int age;
    private Teacher2 teacher;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Teacher2 getTeacher() {
        return teacher;
    }

    public Student2(String name, int age, Teacher2 teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    // 深拷贝
    //1. 当前对象要实现 implements  Cloneable ,Serializable 两个接口

   public Object Clone() {
        //将当前Student对象 放到a.data目录  a.data 在本地，涉及到 虚拟机向本地数据的存储
       try (FileOutputStream fos = new FileOutputStream("a.dat");
            ObjectOutputStream out = new ObjectOutputStream(fos);) {
           out.writeObject(this);
       } catch (Exception e) {
       }
       //将a.data目录数据取出  反序列化到Student对象
       try (FileInputStream fis = new FileInputStream("a.dat");
            ObjectInputStream in = new ObjectInputStream(fis);) {
           Object o = in.readObject();
           return o;
       } catch (Exception e) {
           return null;
       }
   }

    // 深拷贝
    //1. 当前对象要实现 implements  Cloneable ,Serializable 两个接口
    //ByteArrayInputStream   ByteArrayOutputStream

    public Object ClonePlus() {
        //将当前Student对象  byte[] bs  bs在虚拟机中，所以很快
        byte[] bs =null ;
        try ( ByteArrayOutputStream bos =new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos);) {
            out.writeObject(this);
            bs = bos.toByteArray();
        } catch (Exception e) {
        }
        //将byte[] bs   反序列化到Student对象
        try ( ByteArrayInputStream bis =new ByteArrayInputStream(bs);
             ObjectInputStream in = new ObjectInputStream(bis);) {
            Object o = in.readObject();
            return o;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }
}

class Teacher2 implements Serializable{
    private String name;
    private int age;

    public Teacher2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}