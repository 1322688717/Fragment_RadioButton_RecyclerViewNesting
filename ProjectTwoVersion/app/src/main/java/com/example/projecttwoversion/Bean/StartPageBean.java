package com.example.projecttwoversion.Bean;

/**
 * desc: 第一页数据
 */
public class StartPageBean {
    private String name;
    private String type;

    public StartPageBean(String name, String type){
        this.name = name;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}