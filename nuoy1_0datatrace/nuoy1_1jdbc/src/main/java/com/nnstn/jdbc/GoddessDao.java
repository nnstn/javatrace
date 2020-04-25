package com.nnstn.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoddessDao {

    //增加
    public void addGoddess(Goddess g) throws SQLException {
        //获取连接
        Connection conn = DbUtil.open();
        //sql
        String sql = "INSERT INTO goddess(user_name, sex, age, birthday, email, mobile,"+
            "create_user, create_date, update_user, update_date, isdel)"
                +"values("+"?,?,?,?,?,?,?,CURRENT_DATE(),?,CURRENT_DATE(),?)";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行

        //传参
        ptmt.setString(1, g.getUserName());
        ptmt.setInt(2, g.getSex());
        ptmt.setInt(3, g.getAge());
        ptmt.setDate(4, new Date(g.getBirthday().getTime()));
        ptmt.setString(5, g.getEmail());
        ptmt.setString(6, g.getMobile());
        ptmt.setString(7, g.getCreateUser());
        ptmt.setString(8, g.getUpdateUser());
        ptmt.setInt(9, g.getIsDel());

        //执行
        ptmt.execute();
        DbUtil.close(conn);
    }

    public void updateGoddess(Goddess g) throws SQLException {

        //获取连接
        Connection conn = DbUtil.open();
        //sql, 每行加空格
        String sql = "UPDATE goddess" +
                " set user_name=?, sex=?, age=?, birthday=?, email=?, mobile=?,"+
                " update_user=?, update_date=CURRENT_DATE(), isdel=? "+
                " where id=?";
        //预编译
        PreparedStatement ptmt = conn.prepareStatement(sql); //预编译SQL，减少sql执行

        //传参
        ptmt.setString(1, g.getUserName());
        ptmt.setInt(2, g.getSex());
        ptmt.setInt(3, g.getAge());
        ptmt.setDate(4, new Date(g.getBirthday().getTime()));
        ptmt.setString(5, g.getEmail());
        ptmt.setString(6, g.getMobile());
        ptmt.setString(7, g.getUpdateUser());
        ptmt.setInt(8, g.getIsDel());
        ptmt.setInt(9, g.getId());

        //执行
        ptmt.execute();
        DbUtil.close(conn);
    }

    public void delGoddess(int id) throws SQLException {
        //获取连接
        Connection conn = DbUtil.open();
        //sql, 每行加空格
        String sql = "delete from goddess where id=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);

        //传参
        ptmt.setInt(1, id);

        //执行
        ptmt.execute();
        DbUtil.close(conn);
    }

    public List<Goddess> query() throws SQLException {
        Connection conn = DbUtil.open();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT user_name, age FROM goddess");

        List<Goddess> gs = new ArrayList<Goddess>();
        Goddess g = null;
        while(rs.next()){
            g = new Goddess();
            g.setUserName(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));

            gs.add(g);
        }
        DbUtil.close(conn);
        return gs;
    }

    public Goddess get(int id) throws SQLException {
        Goddess g = null;
        //获取连接
        Connection conn = DbUtil.open();
        //sql, 每行加空格
        String sql = "select * from  goddess where id=?";
        //预编译SQL，减少sql执行
        PreparedStatement ptmt = conn.prepareStatement(sql);
        //传参
        ptmt.setInt(1, id);
        //执行
        ResultSet rs = ptmt.executeQuery();
        while(rs.next()){
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUserName(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreateDate(rs.getDate("create_date"));
            g.setCreateUser(rs.getString("create_user"));
            g.setUpdateDate(rs.getDate("update_date"));
            g.setUpdateUser(rs.getString("update_user"));
            g.setIsDel(rs.getInt("isdel"));
        }
        DbUtil.close(conn);
        return g;
    }
}