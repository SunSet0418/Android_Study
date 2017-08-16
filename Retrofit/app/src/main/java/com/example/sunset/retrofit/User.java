package com.example.sunset.retrofit;

/**
 * Created by SunSet on 2017. 8. 15..
 */

public class User {
    private String username, id, password;

    public String getusername(){
        return username;
    }

    public void setusername(String Username){
        username = Username;
    }

    public String getid(){
        return id;
    }

    public void setid(String Id){
        id = Id;
    }

    public String getpassword(){
        return password;
    }

    public void setpassword(String Password){
        password = Password;
    }

    public User(String username, String id, String password){
        this.username = username;
        this.id = id;
        this.password = password;
    }

}
