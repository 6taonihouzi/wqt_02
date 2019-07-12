package zzgs.Service;

import zzgs.dao.UserDao;
import zzgs.entity.Pagebean;
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
     //查询分页方法
     public Pagebean findUserByPage(String currentpage, String rows) {
         int Currentpage = Integer.parseInt(currentpage);
         int Rows = Integer.parseInt(rows);
         if(Currentpage<=0)
         {
             Currentpage=1;
         }
         //1.创建一个空的Pagebean对象
         Pagebean<User> pagebean =new Pagebean<User>();
         //2.调用userDao查找总记录数
         int totalCount = userDao.findtotalCount();
         //3.计算总页码数
         int totalPage =(int)Math.ceil((double) totalCount/(double) Rows);
         //4.计算用userDao查询list集合
         int Start = (Currentpage-1)*Rows;
         List<User> list = userDao.findByPage(Start,Rows);
         if(Currentpage>=totalPage)
         {
            Currentpage=totalPage;
         }
         //5.设置参数
         pagebean.setCurrentpage(Currentpage);
         pagebean.setRows(Rows);
         pagebean.setTotalCount(totalCount);
         pagebean.setList(list);
         pagebean.setTotalpage(totalPage);
         //6.返回对象
         return pagebean;
     }
}
