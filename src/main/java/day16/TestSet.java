package day16;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author leowei
 * @date 2020/12/29  - 20:14
 */
public class TestSet {
    public static void main(String[] args) {
        String s1 = new String("Li1");
        String s2 = new String("Li2");
        String s3 = new String("Li3");
        String s4= new String("Li4");
        String s5 = new String("Li3");
        String s6 = new String("Li3");

        HashSet<String> hs = new HashSet<>();
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);
        hs.add(s5);
        hs.add(s6);

        hs.forEach(s-> System.out.println("s = " + s));

        System.out.println(" ============================================= ");
        Student std1 = new Student("lili", 40);
        Student std2 = new Student("lili", 40);
        Student std3 = new Student("lili", 40);  // student  如果不重写hashcode 默认new 不同Student 时候，hashCode 不一样 ,所以都会放到hsStu这个HashSet 里面
        Student std4 = new Student("lili4", 404);
        Student std5 = new Student("lili5", 405);

        HashSet<Student> hsStu = new HashSet<>();
        hsStu.add(std1);
        hsStu.add(std2);
        hsStu.add(std3);
        hsStu.add(std4);
        hsStu.add(std5);
        hsStu.forEach(stu-> System.out.println("stu = " + stu.toString()));


    }
}

class Student{

    private String name;
    private int age;

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

    public Student(String name, int age) {
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

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    public boolean equals(Object o){
        System.out.println("equals is running .... ");
        if(this==o) return true;
        if(o==null) return false;
        if(this.getClass()!=o.getClass()) return  false;
        Student stu = (Student) o;
        if(this.getName().equals(((Student) o).getName()) && this.getAge()== stu.getAge()){
            return  true;
        }else{
            return false;
        }
    }
}
