package com.demo.chat.controller;

import com.demo.base.R;
import com.demo.chat.entity.ChatGroup;
import com.demo.chat.entity.ChatGroupRel;
import com.demo.chat.entity.ChatMsg;
import com.demo.chat.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Component
@RequestMapping("chat")
public class ChatController {
	
	private static Logger logger= LoggerFactory.getLogger(ChatController.class);
	
	@Resource
	private ChatService chatService;

	/**
	 * 创建群组
	 * @param chatGroup
	 * @return
	 */
	@RequestMapping("createGroup")
	@ResponseBody
	public R createGroup(ChatGroup chatGroup){
		if(StringUtils.isEmpty(chatGroup.getGroupName())){
			return R.error("组名为空");
		}
		if(null == chatGroup.getAppId()){
			return R.error("appId为空");
		}
		
		try {
			Long groupId = chatService.createGroup(chatGroup);
			return R.ok().putObject("groupId", groupId);
		} catch (Exception e) {
			logger.error("creatGroup error",e);
			return R.error("服务器异常");
		}
	}
	
	/**
	 * 保存聊天信息
	 * @param chatMsg
	 * @param userId
	 * @return
	 */
	@RequestMapping("saveChatMsg")
	@ResponseBody
	public R saveChatMsg(ChatMsg chatMsg, Long userId){
		if(null == chatMsg.getGroupId()){
			return R.error("groupId 为空");
		}
		if(StringUtils.isEmpty(chatMsg.getContent())){
			return R.error("content 为空");
		}
		if(null == userId){
			return R.error("userId 为空");
		}
		if(!chatService.checkGroupId(chatMsg.getGroupId())){
			return R.error("groupId 不存在");
		}
		if(!chatService.checkUserInGroup(chatMsg.getGroupId(), userId)){
			return R.error("用户不在该群组中");
		}
		try {
			chatService.saveChatMsg(chatMsg, userId);
			return R.ok("保存成功");
		} catch (Exception e) {
			logger.error("saveChatMsg error",e);
			return R.error("服务器异常");
		}
	}
	
	/**
	 * 批量添加聊天组成员
	 * @param groupId
	 * @param userIds
	 * @param appId
	 * @return
	 */
	@RequestMapping("addGroupUser")
	@ResponseBody
	public R addGroupUser(Long groupId, Long[] userIds, Integer appId){
		if(null == groupId){
			return R.error("groupId为空");
		}
		if(!chatService.checkGroupId(groupId)){
			return R.error("groupId 不存在");
		}
		if(null != userIds&&userIds.length == 0){
			return R.error("userIds为空");
		}
		if(null == appId){
			return R.error("appId为空");
		}
		for(Long userId : userIds){
			if(chatService.checkUserInGroup(groupId, userId)){
				return R.error("userId" + userId + "已在群组中");
			}
		}
		try {
			chatService.addGroupUsers(groupId, userIds, appId);
			return R.ok("添加人员成功");
		} catch (Exception e) {
			logger.error("addGroupUser error",e);
			return R.error("服务器异常");
		}
	}
	
	/**
	 * 获取聊天组全部成员Id
	 * @param groupId
	 * @return
	 */
	@RequestMapping("getGroupUsers")
	@ResponseBody
	public R getGroupUsers(Long groupId){
		if(null == groupId){
			return R.error("groupId为空");
		}
		if(!chatService.checkGroupId(groupId)){
			return R.error("groupId 不存在");
		}
		List<ChatGroupRel> list = chatService.getGroupUsers(groupId,null);
		return R.ok().putObject("data", list);
	}
	
	/**
	 * 删除聊天组成员
	 * @param userId
	 * @param groupId
	 * @param appId
	 * @return
	 */
	@RequestMapping("deleteGroupUsers")
	@ResponseBody
	public R deleteGroupUser(Long userId, Long groupId, Integer appId){
		if(null != userId && groupId == null){
			if(null == appId){
				return R.error("appId为空");
			}
		}
		if(null!=groupId){
			if(!chatService.checkGroupId(groupId)){
				return R.error("groupId 不存在");
			}
		}
		if(userId == null && groupId == null){
			return R.error("userId或groupId为空");
		}
		try {
			chatService.deleteGroupUsers(userId, groupId, appId);
			return R.ok("删除成功");
		} catch (Exception e) {
			logger.error("deleteGroupUser error",e);
			return R.error("服务器异常");
		}
	}
	
	/**
	 * 获取未读消息数
	 * @param groupIds
	 * @param userId
	 * @return
	 */
	@RequestMapping("getUnreadNum")
	@ResponseBody
	public R getUnreadNum(Long[] groupIds, Long userId, Integer appId){
		if(null == groupIds || groupIds.length == 0){
			if(null == appId){
				return R.error("appId为空");
			}
		}
		if(null == userId){
			return R.error("userId为空");
		}
		List<ChatGroupRel> list = chatService.getUnreadNum(groupIds, userId, appId);
		return R.ok().putObject("data", list);
	}
	
	/**
	 * 分页查询历史消息
	 * @param groupId
	 * @return
	 */
	@RequestMapping("getChatMsg")
	@ResponseBody
	public R getChatMsg(Long groupId, Long userId, Long msgId, Integer limit){
		if(null == groupId){
			return R.error("groupId为空");
		}
		if(null == userId){
			return R.error("userId为空");
		}
		if(null == limit){
			return R.error("limit为空");
		}
		try {
			List<ChatMsg> list = chatService.selectChatMsg(groupId, msgId,limit);
			if(msgId == null){
				chatService.updateReadMsg(groupId, userId);
			}	
			return R.ok().putObject("data", list);
		} catch (Exception e) {
			logger.error("getChatMsg error",e);
			return R.error("服务器异常");
		}
		
	}
	
	/**
	 * 查询未读消息
	 * @param groupId
	 * @param userId
	 * @return
	 */
	@RequestMapping("getUnreadMsg")
	@ResponseBody
	public R getUnreadMsg(Long groupId, Long userId){
		if(null == groupId){
			return R.error("groupId为空");
		}
		if(null == userId){
			return R.error("userId为空");
		}

		try {
			List<ChatGroupRel> relList = chatService.getGroupUsers(groupId, userId);
			if(null!=relList&&relList.size()>0){
				List<ChatMsg> list = chatService.selectUnreadMsg(groupId, userId, relList);
				chatService.updateReadMsg(groupId, userId);
				return R.ok().putObject("data", list);
			}else{
				return R.error("用户不在该群组");
			}	
		} catch (Exception e) {
			logger.error("getUnreadMsg error",e);
			return R.error("服务器异常");
		}
	}
	
	/**
	 * 根据用户id查询其所在群组
	 * @param userId
	 * @param appId
	 * @return
	 */
	@RequestMapping("queryGroup")
	@ResponseBody
	public R getGroupByUser(Long userId, Integer appId){
		if(null == userId){
			return R.error("userId为空");
		}
		if(null == appId){
			return R.error("appId为空");
		}
		
		List<ChatGroupRel> list = chatService.getGroupByUser(userId, appId);
		return R.ok().putObject("data", list);
	}
}
