package com.zzgs.domain;

public class UserLogin {
    private String name_login;
    private String password_login;

//    public String getNameLogin() {
//        return nameLogin;
//    }
//
//    public void setNameLogin(String nameLogin) {
//        this.nameLogin = nameLogin;
//    }
//
//    public String getPasswordLogin() {
//        return passwordLogin;
//    }
//
//    public void setPasswordLogin(String passwordLogin) {
//        this.passwordLogin = passwordLogin;
//    }
//
//    @Override
//    public String toString() {
//        return "UserLogin{" +
//                "nameLogin='" + nameLogin + '\'' +
//                ", passwordLogin='" + passwordLogin + '\'' +
//                '}';
//    }

    public String getName_login() {
        return name_login;
    }

    public void setName_login(String name_login) {
        this.name_login = name_login;
    }

    public String getPassword_login() {
        return password_login;
    }

    public void setPassword_login(String password_login) {
        this.password_login = password_login;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "name_login='" + name_login + '\'' +
                ", password_login='" + password_login + '\'' +
                '}';
    }
}
