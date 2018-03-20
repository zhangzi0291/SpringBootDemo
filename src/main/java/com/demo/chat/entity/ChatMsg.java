package com.demo.chat.entity;

import java.util.Date;

public class ChatMsg {
    private Long id;
    private Long groupId;
    private Date sendTime;
    private String sender;
    private String content;

    public ChatMsg setId(Long id){
        this.id = id;
        return this;
    }
    public Long getId(){
        return this.id;
    }

    public ChatMsg setGroupId(Long groupId){
        this.groupId = groupId;
        return this;
    }
    public Long getGroupId(){
        return this.groupId;
    }

    public ChatMsg setSendTime(Date sendTime){
        this.sendTime = sendTime;
        return this;
    }
    public Date getSendTime(){
        return this.sendTime;
    }

    public ChatMsg setSender(String sender){
        this.sender = sender;
        return this;
    }
    public String getSender(){
        return this.sender;
    }

    public ChatMsg setContent(String content){
        this.content = content;
        return this;
    }
    public String getContent(){
        return this.content;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
    	sb.append("ChatMsg[");
        sb.append("id=" + id + ", ");
        sb.append("groupId=" + groupId + ", ");
        sb.append("sendTime=" + sendTime + ", ");
        sb.append("sender=" + sender + ", ");
        sb.append("content=" + content + ", ");
    	sb.append("]");
        return sb.toString();
    }
}