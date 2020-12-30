package day19;

/**
 * @author leowei
 * @date 2020/12/30  - 7:34
 */
public class TestAnnotation {
    // 标注
    // 普通注释： 给人看的
    // 标注：     描述代码的代码  给机器看的
    // 标注使用场景：
    //           用在 包、类、属性、方法、构造函数等程序组件声明之前
    //@标注名（属性1=值1，... 属性n=值n);
    // 标记标注   没有属性   ()可以省略          @Override
    // 单值标注   只有一个属性 如果属性名为value ，value 可以省略 直接写 @标注名(值)
    // 普通标注   有属性
    //



    public static void main(String[] args) {
        Student student = new Student("lili", 25);
        System.out.println("student  = " + student);
    }
}
class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    // 我要覆盖
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}