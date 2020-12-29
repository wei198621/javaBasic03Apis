package day14;

import java.util.Objects;
import java.util.Scanner;

/**
 * @author leowei
 * @date 2020/12/29  - 11:46
 */
public class User {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String next1 = scanner.next();
        String next2 = scanner.next();

    }

    private String username;
    private String password;
    private String tel;

    public String toString(){
        return "username:"+username+"; password:"+password+"; tel:"+tel;
    }

    public boolean equals22(Object o){
        //对象相等       返回 true
        // o null       返回  false ;
        // class  不同   返回 false ;
        // 强转后单个比较
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        User u = (User)o ;
        if(Objects.equals(this.username,u.username) && Objects.equals(this.password,u.password) && Objects.equals(this.tel,u.tel)){
            return true;
        }else{
            return false;
        }

       /* if(   this.getUsername().equals(u.getUsername())
                && this.getPassword().equals(u.getPassword())
                && this.getTel().equals(u.getPassword())     )   {
            return true;
        }else{
            return false;
        }*/
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(tel, user.tel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, password, tel);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
