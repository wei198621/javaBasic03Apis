package day17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author leowei
 * @date 2020/12/29  - 23:08
 */
public class TestSales {
 private static double result2=0;

    public static void main(String[] args) {
        Set<Sales> hs=new HashSet<>();
        hs.add(new Sales("zhangsan",20.5,"deptA"));
        hs.add(new Sales("lisi",23.5,"deptA"));
        hs.add(new Sales("zhaoliang",22.5,"deptC"));
        hs.add(new Sales("gousheng",25.5,"deptB"));
        hs.add(new Sales("wangyan",26.5,"deptC"));

        hs.forEach(s-> System.out.println(s));

        double result=0;
        for (Sales sales : hs) {
            result+=sales.getSale();
        }
        System.out.println(result);

        hs.forEach(s->result2+=s.getSale());
        System.out.println(result2);

        System.out.println("=========");
        StringBuilder sb = new StringBuilder();
        for (Sales sale : hs) {
            sb.append(sale.getName()).append(",");
        }
        String name = sb.toString();
        String substring = name.substring(0, name.length() - 1);
        System.out.println("substring = " + substring);


        System.out.println("=================过滤重复元素=============");
        String  str= "ABCDEFGJAKLMKBOPQRASTUFVWXYAB";
        String strReturn="";
        Set<Character> sets=new HashSet<>();
        for(int i=0;i<str.length();i++){
            boolean addResult = sets.add(str.charAt(i));
            if(addResult==false){
                strReturn+=str.charAt(i);
            }
        }
        System.out.println("以上字符串重复字符是： "+ strReturn);

        System.out.println("=====================");
        HashMap<String, String> users = new HashMap<>();
        String strUsers="lichao=123,liming=234,hurui=123434";
        String[] ss = strUsers.split(",");
        for (String s : ss) {
            String[] user = s.split("=");
            users.put(user[0],user[1]);
        }

        Scanner scanner = new Scanner(System.in);
        String user = scanner.next();    //输入lichao  输出  123
        System.out.println(users.get(user));


    }
}

class  Sales{
    private String name;
    private double sale;
    private String dept;

    public Sales(String name, double sale, String dept) {
        this.name = name;
        this.sale = sale;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public double getSale() {
        return sale;
    }

    public String getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "name='" + name + '\'' +
                ", sale=" + sale +
                ", dept='" + dept + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return Double.compare(sales.sale, sale) == 0 &&
                Objects.equals(name, sales.name) &&
                Objects.equals(dept, sales.dept);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, sale, dept);
    }
}
