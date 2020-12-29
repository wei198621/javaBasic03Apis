package day13;



/**
 * @author leowei
 * @date 2020/12/29  - 8:53
 */
public class TestEquals {
    public static void main(String[] args) {
        System.out.println("=======      string test         =========");
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println("s1==s2: "+ s1==s2);
        System.out.println("s1.equals(s2):  "+ s1.equals(s2));
        System.out.println("=======         Employee test       =========");
        Employee liucy = new Employee("liucy", 40);
        Employee liucy2 = new Employee("liucy", 40);
        System.out.println(liucy==liucy2);
        System.out.println(liucy.equals(liucy2));

    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    //this     vs  o  比较内容
   public boolean equals(Object o){
        //1 判断 this    o  是不是同一对象  ，你媳妇 和你孩子他妈
       if(this == o ) return true;
       //2 判断o 是不是Null
       if(o ==null) return false;
       //3 判断this    o  是不是属于同一个类
       if(this.getClass() != o.getClass()) return false;
       // 4  对o 做强制类型转化，变为 Employee 类型
       Employee e =(Employee) o;
       // 5 逐个比较属性  基本类型用 == 引用类型 用equals
       if(this.age == e.age && this.name.equals(e.name)) {
           return true;
       }else{
           return false;
       }
   }






















}
