package day20;

/**
 * @author leowei
 * @date 2020/12/30  - 17:45
 */
public class TestClone {
    public static void main(String[] args) {

        Teacher t = new Teacher("hxz", 44);
        Student s = new Student("weilie", 22,t);
        System.out.println("s = " + s);
        Student s2 =(Student)s.Clone();
        System.out.println("s2 = " + s2);   //Student implements  Cloneable{  正常clone

        System.out.println("s== s2 = " + (s == s2));  //  false 不是同一个对象
        System.out.println(s.getTeacher()==s2.getTeacher()) ;  //true
        //System.out.println(s.getName() == s2.getName());     //true


    }
}

class Student implements  Cloneable{
    private String name;
    private int age;
    private Teacher teacher;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Student(String name, int age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    // 浅拷贝
    //1. 覆盖object类的clone方法，将访问修饰符从Protected提高为public
    // 2. 需要克隆的类，必须实现Cloneable接口，
   public Object Clone(){
       try {
           return super.clone();
       } catch (CloneNotSupportedException e) {
           e.printStackTrace();
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

class Teacher{
    private String name;
    private int age;

    public Teacher(String name, int age) {
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