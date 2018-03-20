package com.demo.chat.entity;


public class ChatGroupRel {
    private Long id;
    private Long groupId;
    private Long userId;
    private Long lastMsgId;
    private Integer unreadNum;
    private Integer appId;

    public ChatGroupRel setId(Long id){
        this.id = id;
        return this;
    }
    public Long getId(){
        return this.id;
    }

    public ChatGroupRel setGroupId(Long groupId){
        this.groupId = groupId;
        return this;
    }
    public Long getGroupId(){
        return this.groupId;
    }

    public ChatGroupRel setUserId(Long userId){
        this.userId = userId;
        return this;
    }
    public Long getUserId(){
        return this.userId;
    }

    public ChatGroupRel setLastMsgId(Long lastMsgId){
        this.lastMsgId = lastMsgId;
        return this;
    }
    public Long getLastMsgId(){
        return this.lastMsgId;
    }

    public ChatGroupRel setUnreadNum(Integer unreadNum){
        this.unreadNum = unreadNum;
        return this;
    }
    public Integer getUnreadNum(){
        return this.unreadNum;
    }

    public ChatGroupRel setAppId(Integer appId){
        this.appId = appId;
        return this;
    }
    public Integer getAppId(){
        return this.appId;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
    	sb.append("ChatGroupRel[");
        sb.append("id=" + id + ", ");
        sb.append("groupId=" + groupId + ", ");
        sb.append("userId=" + userId + ", ");
        sb.append("lastMsgId=" + lastMsgId + ", ");
        sb.append("unreadNum=" + unreadNum + ", ");
        sb.append("appId=" + appId + ", ");
    	sb.append("]");
        return sb.toString();
    }
}