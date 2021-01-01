package day22;

import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author leowei
 * @date 2021/1/1  - 11:44
 */
public class TestClass {
    public static void main(String[] args) throws Exception {

        //类对象获取方式1
        Class c1 = ArrayList.class;

        //类对象获取方式2
        ArrayList list = new ArrayList();
        Class c2 = list.getClass();

        //类对象获取方式3
        String className="java.util.ArrayList";
        Class c3 = Class.forName(className);

        System.out.println(c1==c2);
        System.out.println(c2==c3);

        System.out.println("---------------------类相关信息----------------------");
        System.out.println(c1.getName());   // 获取类名
        System.out.println(c1.getSuperclass().getName());  //获取父类的类对象
        Class[] interfaces = c1.getInterfaces();           //获取所有接口的类对象
        for (Class c : interfaces) {
            System.out.println("c.getName() = " + c.getName());
        }

        System.out.println("---------------------方法相关信息----------------------");
        Method[] methods = c1.getMethods();                 //获取类中所有公开方法的Method对象，
        for (Method method : methods) {
            System.out.println("method = " + method.getName());
        }
        System.out.println("------------");
        Method[] declaredMethods = c1.getDeclaredMethods(); //获取本类中所有方法的Method对象
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod.getName());
        }
        
        // c1.getMethod()  c1.getDeclaredMethod()  
        
        System.out.println();
    }
}
