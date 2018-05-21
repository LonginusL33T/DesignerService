package com.aolc.designer.mesh.bean;

public class UserNode {
    private String name;
    private String user_introduction;
    private String brand_introduction;
    private String user_background;

    public String getUser_background() {
        return user_background;
    }

    public void setUser_background(String user_background) {
        this.user_background = user_background;
    }

    public UserNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_introduction() {
        return user_introduction;
    }

    public void setUser_introduction(String user_introduction) {
        this.user_introduction = user_introduction;
    }

    public String getBrand_introduction() {
        return brand_introduction;
    }

    public void setBrand_introduction(String brand_introduction) {
        this.brand_introduction = brand_introduction;
    }
}
