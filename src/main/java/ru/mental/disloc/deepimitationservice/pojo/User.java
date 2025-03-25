package ru.mental.disloc.deepimitationservice.pojo;

import com.fasterxml.jackson.annotation.JsonKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String name;
    private UserInfo info;

    public User(String name, UserInfo info) {
        this.name = name;
        this.info = info;
    }

    @Getter
    @Setter
    static class UserInfo {

        private String sex;
        private BodyParameters bodyParams;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class BodyParameters {

        private int height;
        private int weight;
    }
}
