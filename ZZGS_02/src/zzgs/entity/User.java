package zzgs.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private  static  final long serialVersionUID = 1L;
    public  User(){

    }
    private int id;
    private  String name;
    private  String sex;
    private  int age;
    private String palce;
    private Date ctrate_time;
    private  Date modify_time;

    public User(int id, String name, String sex, int age, String palce, Date ctrate_time, Date modify_time) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.palce = palce;
        this.ctrate_time = ctrate_time;
        this.modify_time = modify_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPalce() {
        return palce;
    }

    public void setPalce(String palce) {
        this.palce = palce;
    }

    public Date getCtrate_time() {
        return ctrate_time;
    }

    public void setCtrate_time(Date ctrate_time) {
        this.ctrate_time = ctrate_time;
    }

    public Date getModify_time() {
        return modify_time;
    }

    public void setModify_time(Date modify_time) {
        this.modify_time = modify_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", palce='" + palce + '\'' +
                ", ctrate_time=" + ctrate_time +
                ", modify_time=" + modify_time +
                '}';
    }
}
