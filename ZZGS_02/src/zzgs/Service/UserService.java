package zzgs.Service;

import zzgs.dao.UserDao;
import zzgs.entity.User;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();
   //查询所有对象
    public List<User> getListAll(){
        List<User> list = userDao.getListAll();
        return list;
    }
    //增加对象
    public void addUser(User user) {
     userDao.addUser(user);
    }
    //删除对象
    public boolean delete(int id){
        if(id != 0)
        {
            userDao.delete(id);
        }
        return false;
    }
    //根据id查询对象
    public User getdateById(int id) {
        if(id!=0)
        {
           return userDao.getdateById(id);
        }else {
            return null;
        }
    }
    //修改对象
    public void updateUser(User user) {
        userDao.update(user);
    }
}
