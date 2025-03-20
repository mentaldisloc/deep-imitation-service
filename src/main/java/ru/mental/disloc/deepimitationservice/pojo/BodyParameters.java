package ru.mental.disloc.deepimitationservice.pojo;

public class BodyParameters {

    private String height;
    private String weight;

    public BodyParameters(String height, String weight) {
        this.height = height;
        this.weight = weight;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }
}
