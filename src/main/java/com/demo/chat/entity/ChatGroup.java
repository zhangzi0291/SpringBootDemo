package com.demo.chat.entity;

import java.util.Date;

public class ChatGroup {
    private Long id;
    private String groupName;
    private String creator;
    private Date createTime;
    private Integer appId;

    public ChatGroup setId(Long id){
        this.id = id;
        return this;
    }
    public Long getId(){
        return this.id;
    }

    public ChatGroup setGroupName(String groupName){
        this.groupName = groupName;
        return this;
    }
    public String getGroupName(){
        return this.groupName;
    }

    public ChatGroup setCreator(String creator){
        this.creator = creator;
        return this;
    }
    public String getCreator(){
        return this.creator;
    }

    public ChatGroup setCreateTime(Date createTime){
        this.createTime = createTime;
        return this;
    }
    public Date getCreateTime(){
        return this.createTime;
    }

    public ChatGroup setAppId(Integer appId){
        this.appId = appId;
        return this;
    }
    public Integer getAppId(){
        return this.appId;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
    	sb.append("ChatGroup[");
        sb.append("id=" + id + ", ");
        sb.append("groupName=" + groupName + ", ");
        sb.append("creator=" + creator + ", ");
        sb.append("createTime=" + createTime + ", ");
        sb.append("appId=" + appId + ", ");
    	sb.append("]");
        return sb.toString();
    }
}