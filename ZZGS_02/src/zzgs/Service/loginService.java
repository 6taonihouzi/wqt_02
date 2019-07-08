package zzgs.Service;

import zzgs.dao.loginDao;
import zzgs.entity.login;

public class loginService {
    loginDao ld = new loginDao();
    //判断登录逻辑
    public login successlogin(String name, String password)
    {
        return ld.successlogin(name,password);
    }
    //注册用户方法
    public void addlogin(login lo){
        ld.addlogin(lo);
    }
}
