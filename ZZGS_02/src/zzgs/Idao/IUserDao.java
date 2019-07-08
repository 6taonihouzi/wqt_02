package zzgs.Idao;

import zzgs.entity.User;

import java.util.List;

public interface IUserDao {
    /*
    * 获取所有用户
    * */
    List<User> getListAll();
    //添加数据方法
    void addUser(User user);
    //删除数据方法
    int delete(int id);
    //根据id查询一条数据
    User getdateById(int id);
    //修改数据
    void update(User user);
}
