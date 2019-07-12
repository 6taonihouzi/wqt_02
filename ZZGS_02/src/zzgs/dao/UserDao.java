package zzgs.dao;

import zzgs.Idao.IUserDao;
import zzgs.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {

    public ResultSet rs =null;
    public PreparedStatement ps=null;
    SQLHelper sqlHelper=new SQLHelper();
    public Connection conn = null;//通过工具类直接调用getConnection方法获取jdbc连接。
     //查询方法
    @Override
    public List<User> getListAll() {
        List<User> list = new ArrayList<User>();//创建list集合,用户保持User对象
        try {
            conn = sqlHelper.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
             String sql = " select * from userinfo ";//创建sql语句
             ps=conn.prepareStatement(sql);
             rs = ps.executeQuery();
            while(rs.next())
            {
                User user = new User();//创建User对象用于保持从数据库查出来的对象
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSex(rs.getString(3));
                user.setAge(rs.getInt(4));
                user.setPalce(rs.getString(5));
                user.setCtrate_time(rs.getTimestamp(6));
                user.setModify_time(rs.getTimestamp(7));
                list.add(user);
            }
        }catch (SQLException e){
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
        return list;
    }
   //添加方法
    @Override
    public void addUser(User user) {
        try {
            conn = sqlHelper.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql = "insert into userinfo(name,sex,age,place,ctrate_time,modify_time) values (?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,user.getName());
            ps.setString(2,user.getSex());
            ps.setInt(3,user.getAge());
            ps.setString(4,user.getPalce());
            ps.setDate(5, new java.sql.Date(user.getCtrate_time().getTime()));
            ps.setDate(6, new java.sql.Date(user.getModify_time().getTime()));
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
    //根据id删除数据
    @Override
    public int delete(int id){
        int i =0;
        try {
            conn = sqlHelper.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String sql = "delete from userinfo where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            i=ps.executeUpdate();
            if(i==1)
            {
                return i;
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
       return i;
    }
    //根据id查询数据
    @Override
    public User getdateById(int id){
        try {
            conn = sqlHelper.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = null;
        String sql = "select * from userinfo where id=?";
        if(id>0)
        {
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1,id);
                rs=ps.executeQuery();
                if(rs.next())
                {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setSex(rs.getString("sex"));
                    user.setAge(rs.getInt("age"));
                    user.setPalce(rs.getString("place"));
                    user.setCtrate_time(rs.getTimestamp("ctrate_time"));
                    user.setModify_time(rs.getTimestamp("modify_time"));
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
        }
      return user;
    }
    //修改信息对象
    @Override
    public void update(User user) {
        try {
            conn = sqlHelper.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
           String sql = "update userinfo set name=?,sex=?,age=?,place=?,ctrate_time=?,modify_time=? where id =?";
        try {
            ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,user.getName());
            ps.setString(2,user.getSex());
            ps.setInt(3,user.getAge());
            ps.setString(4,user.getPalce());
            ps.setDate(5, new java.sql.Date(user.getCtrate_time().getTime()));
            ps.setDate(6, new java.sql.Date(user.getModify_time().getTime()));
            ps.setInt(7,user.getId());
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
    //获取总记录数
    @Override
    public int findtotalCount() {
        try {
            conn = sqlHelper.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "select count(*) from userinfo";
        int totalCount = 0;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next())
            {
                totalCount = rs.getInt(1);
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
        return totalCount;
    }
    //返回每页的总记录数
    @Override
    public List<User> findByPage(int start, int rows) {
        List<User> list = new ArrayList<User>();
        try {
            conn = sqlHelper.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql = "select * from userinfo limit ?,?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,start);
            ps.setInt(2,rows);
            rs = ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSex(rs.getString(3));
                user.setAge(rs.getInt(4));
                user.setPalce(rs.getString(5));
                user.setCtrate_time(rs.getTimestamp(6));
                user.setModify_time(rs.getTimestamp(7));
                list.add(user);
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
        return list;
    }
}
