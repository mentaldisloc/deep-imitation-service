package ru.mental.disloc.deepimitationservice.pojo;

public class UserInfo {

    private String sex;
    private BodyParameters bodyParams;
    private String lastAction;

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBodyParams(String height, String weight) {
        this.bodyParams = new BodyParameters(height, weight);
    }

    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
    }

    public String getSex() {
        return sex;
    }

    public BodyParameters getBodyParams() {
        return bodyParams;
    }

    public String getLastAction() {
        return lastAction;
    }
}
