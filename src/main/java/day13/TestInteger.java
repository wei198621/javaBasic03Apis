package day13;

/**
 * @author leowei
 * @date 2020/12/29  - 11:09
 */
public class TestInteger {
    public static void main(String[] args) {
        int i=12;
        Integer i1=new Integer(i);
        Integer i2 =new Integer(i);
        System.out.println(i1==i2);   //false;

        Integer j1 = Integer.valueOf(i);
        Integer j2 = Integer.valueOf(i);
        System.out.println(j1==j2);  //true ;


        int test1=10;
        Integer test2 =Integer.valueOf(test1);    //变量转为包装类
        test1 =test2;                             //
        test1 =test2.intValue();                  //包装类  转换为 变量

        System.out.println("==============");
        BaizhiStudent bStudent = new BaizhiStudent();
        System.out.println(bStudent.score1);  //0
        System.out.println(bStudent.score2);  //null


        System.out.println("=================================");
        int a1=new Integer(128);
        int a2=new Integer(128);
        System.out.println(a1== a2);              //true  比较的是值 所以 true

        Integer integer1 = Integer.valueOf(a1);
        Integer integer2 = Integer.valueOf(a2);  //a1  a2 都不影响结果
        System.out.println(integer1==integer2);  //false  比较的是对象  且128 不在-128~127  需要单独创建

        Integer int1=new Integer(120);
        Integer int2=new Integer(120);
        System.out.println(int1==int2);          //false  比较对象

        Integer integer11 = Integer.valueOf(int1);
        Integer integer12 = Integer.valueOf(int2);//int1 int2  都不影响结果
        System.out.println(integer11==integer12);  //true   在-128~127  无需单独创建

        Integer int3 = new Integer(128);
        Integer int4 = new Integer(128);
        System.out.println(int3==int4);            //false  比较对象
        System.out.println("=================================");
    }
}

class BaizhiStudent{
    int score1;           // 如果用基本类型定义分数，无法区分，此学生是考了0分，还是没有参加考试
    Integer score2;       //用包装类可以区分  ，包装类==类  没有初始化（没有考试），返回null ;
}
