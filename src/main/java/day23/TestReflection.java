package day23;

import com.sun.media.sound.SoftTuning;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author leowei
 * @date 2021/1/1  - 13:22
 */
public class TestReflection {
    public static void main(String[] args) throws Exception {
        // m1();
        // m2();
        // m3();
        m4();

    }

    private static void m1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class  c1 = Class.forName("day23.Student");
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method.getName());
        }

        System.out.println("===================================");
        // c1.newInstance()  通过“类对象”创建“类的对象”
        Object o = c1.newInstance();
        System.out.println( o instanceof Student);   // o 是不是 student 对象
    }

    //  反射方式的类获取
    private static void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("=============一行代码创建一个student ====================");
        Student student = new Student();

        System.out.println("==============两行代码创建一个student =====================");
        Class  c1 = Class.forName("day23.Student");   //优点是可以创建任何类对象
        Object o = c1.newInstance(); // c1.newInstance()  通过“类对象”创建“类的对象”

        System.out.println("=================================================");

        System.out.println(student instanceof  Student);
        System.out.println( o instanceof Student);   // o 是不是 student 对象
        System.out.println("=================================================");

        Scanner sc = new Scanner(System.in);   //day23.Student  day23.Teacher
        String next = sc.next();
        Class cls = Class.forName(next);
        Object o2 = cls.newInstance();
    }



    // 反射方式的方法调用  11
    private static void m3() throws Exception {
        System.out.println("=============一行代码创建一个student ====================");
        Student student = new Student();
        student.Study();

        System.out.println("==============两行代码创建一个student =====================");
        Class  cls = Class.forName("day23.Student");   //优点是可以创建任何类对象
        Object obj = cls.newInstance(); // c1.newInstance()  通过“类对象”创建“类的对象”

        //Method study = cls.getMethod("Study",int.class,double.class);  //如果study 有多个方法
        Method study = cls.getMethod("Study");
        study.invoke(obj);                  // 注意此处是invoke (object)
        System.out.println("=================================================");
    }



    // 反射方式的方法调用 2
    // getMethod    vs  getDeclaredMethod
    private static void m4() throws Exception {
        System.out.println("=============一行代码创建一个student ====================");
        Student student = new Student();
        //student.StudyPrivate();     //无法访问

        System.out.println("==============两行代码创建一个student =====================");
        Class  cls = Class.forName("day23.Student");   //优点是可以创建任何类对象
        Object obj = cls.newInstance(); // c1.newInstance()  通过“类对象”创建“类的对象”

        //
        //Method m = cls.getMethod("StudyPrivate");  //NoSuchMethodException: day23.Student.StudyPrivate()
        //
        Method m = cls.getDeclaredMethod("StudyPrivate");  //java.lang.IllegalAccessException: Class day23.TestReflection can not access a member of class day23.Student with modifiers "private"
        m.setAccessible(true);         // 设置私有方法为public，可以访问 ，就 不报上面的 IllegalAccessException 异常了
        //
        m.invoke(obj);                  // 注意此处是invoke (object)
        System.out.println("=================================================");
    }

}


class Student{
    public Student(){

        System.out.println("I am a student ");
    }

    public void Study(){
        System.out.println("Student study ");
    }
    private void StudyPrivate(){
        System.out.println("Student study private ");
    }
    public void Eat(){
        System.out.println(" Student eat ");
    }
}

class Teacher{
    public Teacher(){
        System.out.println("I am a Teacher");
    }

    public void teach(){
        System.out.println("teacher teaching ");
    }
}