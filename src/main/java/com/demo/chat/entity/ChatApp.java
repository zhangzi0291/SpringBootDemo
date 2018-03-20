package com.demo.chat.entity;


public class ChatApp {
    private Integer id;
    private String appName;

    public ChatApp setId(Integer id){
        this.id = id;
        return this;
    }
    public Integer getId(){
        return this.id;
    }

    public ChatApp setAppName(String appName){
        this.appName = appName;
        return this;
    }
    public String getAppName(){
        return this.appName;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
    	sb.append("ChatApp[");
        sb.append("id=" + id + ", ");
        sb.append("appName=" + appName + ", ");
    	sb.append("]");
        return sb.toString();
    }
}