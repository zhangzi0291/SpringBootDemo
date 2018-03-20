package com.demo.chat.service.impl;

import com.demo.chat.entity.ChatGroup;
import com.demo.chat.entity.ChatGroupRel;
import com.demo.chat.entity.ChatMsg;
import com.demo.chat.service.ChatService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类的描述
 *
 * @Author zhengxiangnan
 * @Date 2018/2/23 13:43
 */
@Service("ChatService")
public class ChatServiceImpl implements ChatService{
    @Override
    public Long createGroup(ChatGroup chatGroup) {
        return null;
    }

    @Override
    public boolean checkGroupId(Long groupId) {
        return false;
    }

    @Override
    public boolean checkUserInGroup(Long groupId, Long userId) {
        return false;
    }

    @Override
    public void saveChatMsg(ChatMsg chatMsg, Long userId) {

    }

    @Override
    public void addGroupUsers(Long groupId, Long[] userIds, Integer appId) {

    }

    @Override
    public List<ChatGroupRel> getGroupUsers(Long groupId) {
        return null;
    }

    @Override
    public List<ChatGroupRel> getGroupUsers(Long groupId, Long userId) {
        return null;
    }

    @Override
    public void deleteGroupUsers(Long userId, Long groupId, Integer appId) {

    }

    @Override
    public List<ChatGroupRel> getUnreadNum(Long[] groupIds, Long userId, Integer appId) {
        return null;
    }

    @Override
    public List<ChatMsg> selectChatMsg(Long groupId, Long msgId, Integer limit) {
        return null;
    }

    @Override
    public void updateReadMsg(Long groupId, Long userId) {

    }

    @Override
    public List<ChatMsg> selectUnreadMsg(Long groupId, Long userId, List<ChatGroupRel> relList) {
        return null;
    }

    @Override
    public List<ChatGroupRel> getGroupByUser(Long userId, Integer appId) {
        return null;
    }
}
