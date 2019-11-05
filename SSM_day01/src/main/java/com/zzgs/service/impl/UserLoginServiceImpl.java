package com.zzgs.service.impl;

import com.zzgs.dao.UserLoginDao;
import com.zzgs.domain.UserLogin;
import com.zzgs.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userloginService")
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginDao userLoginDao;
    @Override
    public UserLogin findByUserName(String name_login, String password_login) {
        return userLoginDao.findByUserName(name_login,password_login);
    }
}
