package Javachat.ChatCommon;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userId;//用户名
    private String passwd;//用户密码;

    private boolean USER_REGISTERED = false; //为了便于服务器识别是否为用户注册

    public void setUSER_REGISTERED(boolean b){
        USER_REGISTERED = b;
    }

    public boolean isUSER_REGISTERED(){
        return USER_REGISTERED;
    }

    public User(){}

    public User(String s, String s1) {
        setUserId(s);
        setPasswd(s1);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}