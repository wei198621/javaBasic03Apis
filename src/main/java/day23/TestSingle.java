package day23;

import javax.lang.model.element.VariableElement;

/**
 * @author leowei
 * @date 2021/1/1  - 14:33
 */
public class TestSingle {
    public static void main(String[] args) {
        ClassA classA = ClassA.newInstance();
        ClassA classA1 = ClassA.newInstance();
        // ClassA classA2 = new ClassA();    //不允许通过构造器创建对象

        {
          /*  ClassB.newInstance();
            ClassB.newInstance();  //顺序执行，只会创建一次*/
        }
      /*  {
            new Thread(() -> ClassB.newInstance()).start();
            new Thread(() -> ClassB.newInstance()).start();   // 多线程执行，会创建多次
        }*/

        {
            new Thread(() -> ClassB2.newInstance()).start();
            new Thread(() -> ClassB2.newInstance()).start();   // 多线程执行，不会创建多次
        }
    }
}

/**
 * 单例模式  饿汉模式
 * 单例模式 创建步骤
 * 1.创建一个私有 静态 属性 ，是本类的对象
 * 2.创建一个公开 静态方法，用于获得此对象
 * 3.将构造方法私有
 */
class ClassA{
    private static ClassA instance= new ClassA();  // 静态属性，全类共有，只有一份
    public static ClassA newInstance(){          // 公开静态方法
        return instance;
    }
    private ClassA(){  // 构造方法默认 public 的，此处改为private  ，不让用户通过new ClassA() 创建对象
    }
}

/**
 * 单例模式  懒汉模式  多线程 可能会有问题
 */
class ClassB{
    private static ClassB instance= null ;  // 静态属性，全类共有，只有一份
    public static ClassB newInstance(){          // 公开静态方法
        if(instance ==null){
            instance =new ClassB();
        }
        return instance;
    }
    private ClassB(){  // 构造方法默认 public 的，此处改为private  ，不让用户通过new ClassA() 创建对象
        System.out.println("new ClassB ");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



/**
 * 单例模式  懒汉模式  多线程不会有问题
 */
class ClassB2{
    private static ClassB2 instance= null ;  // 静态属性，全类共有，只有一份
    public static synchronized ClassB2 newInstance(){          // 公开静态方法
        if(instance ==null){
            instance =new ClassB2();
        }
        return instance;
    }
    private ClassB2(){  // 构造方法默认 public 的，此处改为private  ，不让用户通过new ClassA() 创建对象
        System.out.println("new ClassB ");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// 第三种单例模式  百知特有，虽然调用实际，但是貌似有多了一个类
//
class ClassC{
     private static class Holder{        //创建一个静态内部类 ，包含后一个静态属性
        static ClassC instance =new ClassC();
    }

    public static ClassC newInstance(){
        return Holder.instance;
    }

    private ClassC(){
        System.out.println("new Class C  ");

    }
}