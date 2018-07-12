package com.yilin.app.domain;

/**
 * Created by Administrator on 2018/7/11.
 */
public class User {

    int id;
    //用户姓名
    String name;
    //用户登录名
    String login_name;
    //用户密码
    String login_pwd;
    //用户支付密码
    String pay_pwd;
    //用户性别
    String sex;
    //用户角色
    int roles_id;
    //手机号码
    int phone;
    //微信号
    int wx_num;
    //身份证号
    int id_num;
    //头像
    String head_img;

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

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getLogin_pwd() {
        return login_pwd;
    }

    public void setLogin_pwd(String login_pwd) {
        this.login_pwd = login_pwd;
    }

    public String getPay_pwd() {
        return pay_pwd;
    }

    public void setPay_pwd(String pay_pwd) {
        this.pay_pwd = pay_pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(int roles_id) {
        this.roles_id = roles_id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getWx_num() {
        return wx_num;
    }

    public void setWx_num(int wx_num) {
        this.wx_num = wx_num;
    }

    public int getId_num() {
        return id_num;
    }

    public void setId_num(int id_num) {
        this.id_num = id_num;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }
}
