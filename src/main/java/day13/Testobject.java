package day13;

/**
 * @author leowei
 * @date 2020/12/29  - 7:50
 */
public class Testobject {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();


        //判断 a1  a2 类型是否一致 方式一  ，很难懂 如果类型再多一些就吊了
        if((a1 instanceof  Dog && a2 instanceof Dog) || (a1 instanceof Cat && a2 instanceof Cat)){

            System.out.println("true");
        }else{

            System.out.println("false");
        }

        System.out.println("======================================");
        //判断 a1  a2 类型是否一致 方式二
        if(a1.getClass() == a2.getClass()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        System.out.println(a1.getClass());  //class day13.Dog

        System.out.println("======================");

      fn();

      System.gc();  //呼吁垃圾回收器，开始收集垃圾


        System.out.println("============toString==========");
        Worker laoli = new Worker("laoli", 33);
        String laoliString = laoli.toString();
        System.out.println("laoli = " + laoli);
        System.out.println("laoliString = " + laoliString);


    }
    static void fn(){
        StudentB a = new StudentB();
        System.out.println(a.getClass());
        //a=null;
    }

}


class Worker{
    private String name;
    private int age;

    public Worker(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


/**
 * 在finalize 中释放连接等是不合适的，因为finalize的调用不可知，理论上System.gc();不一定执行垃圾回收
 * 胡老师的观点：
 * 刘春阳 被判死刑 两年后执行 ，法警问有什么要说的，刘春阳说 “要跟老婆离婚，让她重新找人”
 * 胡老师认为这样不对，应该在判死刑时候就说这个话，这两年刘春阳 占着茅坑不拉屎，哈哈，太逗了
 */
class StudentB{
    //new jdbc连接
    public void finalize(){
        //释放jdbc连接
        System.out.println("8888");
    }
}

class Animal{}
class Dog extends  Animal{}
class Cat extends  Animal{}

class DogA extends Dog{}
class DogB extends Dog{}
