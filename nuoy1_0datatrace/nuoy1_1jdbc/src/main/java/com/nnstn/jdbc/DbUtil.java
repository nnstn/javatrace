package com.nnstn.jdbc;

import java.sql.*;

class DbUtil {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/javatrace?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static Connection conn = null;

    static{
        System.out.println("数据库连接工具加载");
    }
    /**
     * 打开数据库连接
     */
    public static Connection open(){
        try {
            //1.加载驱动程序
            Class.forName(DRIVER);
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭数据库连接
     */
    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT user_name, age FROM imooc_goddess");
        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println(rs.getString("user_name")+" 年龄："+rs.getInt("age"));
        }
    }
}
