package com.zzgs.service;

import com.zzgs.domain.UserLogin;

public interface UserLoginService {
    //登录判断
    public UserLogin findByUserName(String name_login,String password_login);
}
