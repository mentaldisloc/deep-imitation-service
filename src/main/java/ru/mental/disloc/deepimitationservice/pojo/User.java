package ru.mental.disloc.deepimitationservice.pojo;

public class User {
    private String name;
    private UserInfo info;

    public User(String name, UserInfo info) {
        this.name = name;
        this.info = info;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(UserInfo info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public UserInfo getInfo() {
        return info;
    }
}
