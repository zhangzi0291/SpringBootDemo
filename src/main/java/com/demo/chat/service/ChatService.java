package com.demo.chat.service;

import com.demo.chat.entity.ChatGroup;
import com.demo.chat.entity.ChatGroupRel;
import com.demo.chat.entity.ChatMsg;

import java.util.List;

/**
 * 接口的描述
 *
 * @Author zhengxiangnan
 * @Date 2018/2/23 13:43
 */
public interface ChatService {

    Long createGroup(ChatGroup chatGroup);

    boolean checkGroupId(Long groupId);

    boolean checkUserInGroup(Long groupId,Long userId);

    void saveChatMsg(ChatMsg chatMsg, Long userId);

    void addGroupUsers(Long groupId, Long[] userIds, Integer appId);

    List<ChatGroupRel> getGroupUsers (Long groupId);

    List<ChatGroupRel> getGroupUsers (Long groupId, Long userId);

    void deleteGroupUsers(Long userId, Long groupId, Integer appId);

    List<ChatGroupRel> getUnreadNum(Long[] groupIds, Long userId, Integer appId);

    List<ChatMsg> selectChatMsg(Long groupId, Long msgId, Integer limit);

    void updateReadMsg(Long groupId, Long userId);

    List<ChatMsg> selectUnreadMsg(Long groupId, Long userId, List<ChatGroupRel> relList);

    List<ChatGroupRel> getGroupByUser(Long userId, Integer appId);
}
