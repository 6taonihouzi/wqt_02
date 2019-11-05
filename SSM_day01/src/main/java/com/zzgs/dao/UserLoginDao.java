package com.zzgs.dao;

import com.zzgs.domain.UserLogin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginDao {
    @Select("select * from user_login where name_login = #{name_login} and password_login = #{password_login}")
    public UserLogin findByUserName(@Param("name_login") String name_login, @Param("password_login") String password_login);
}
