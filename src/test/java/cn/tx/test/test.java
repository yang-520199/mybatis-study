package cn.tx.test;

public class test {
    public  static  void main(String[]args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("failed");
            e.printStackTrace();
        }
    }
}
