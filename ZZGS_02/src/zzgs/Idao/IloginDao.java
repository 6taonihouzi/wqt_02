package zzgs.Idao;

import zzgs.entity.login;

public interface IloginDao {

    login successlogin(String name,String password);

    void addlogin(login log);
}
