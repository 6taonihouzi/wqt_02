package zzgs.dao;

import zzgs.Idao.IloginDao;
import zzgs.entity.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDao implements IloginDao {
    public PreparedStatement ps=null;
    public ResultSet rs =null;
    SQLHelper sqlHelper=new SQLHelper();
    public Connection conn = null;//通过工具类直接调用getConnection方法获取jdbc连接。
    //根据名字密码查询数据
    @Override
    public login successlogin(String name, String password) {
        try {
            conn = sqlHelper.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        login log = null;
        String sql = "select * from user_login where name_login =? and password_login=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,password);
            rs=ps.executeQuery();
            if(rs.next())
            {
                log = new login();
                return log;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                sqlHelper.closeConn(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    //注册用户
    @Override
    public void addlogin(login log) {
        try {
            conn = sqlHelper.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "insert into user_login values(?,?)";
        try {
            ps =conn.prepareStatement(sql);
            ps.setString(1,log.getName_login());
            ps.setString(2,log.getPassword_login());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                sqlHelper.closeConn(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
