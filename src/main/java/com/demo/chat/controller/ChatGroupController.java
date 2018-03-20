package com.demo.chat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.base.Page;
import com.demo.base.exception.DaoException;
import com.demo.chat.entity.ChatGroup;
import com.demo.chat.entity.ChatGroupExample;
import com.demo.chat.service.ChatGroupService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chatGroup")
public class ChatGroupController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private ChatGroupService chatGroupService;
    
    @RequestMapping("list.html")
    public String listHtml(){
        return "chatGroup/chatGroupList";
    }
    
    @RequestMapping("list.json")
    @ResponseBody
    public Map<String, Object> listJson(ChatGroup chatGroup, Page page){
        Map<String, Object> result = new HashMap<>();
        ChatGroupExample example = new ChatGroupExample();
        ChatGroupExample.Criteria criteria = example.createCriteria();
        //设置查询条件 。。。
        example.setPage(page);
        try {
            List< ChatGroup> list = chatGroupService.selectByExample(example);
            Integer count = chatGroupService.countByExample(example);
            result.put("rows", list);
            result.put("total", count);
            return result;
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return null;
    }
    
    @RequestMapping("add.html")
    public String addHtml(){
        return "chatGroup/chatGroupAdd";
    }
    
    @RequestMapping("add.json")
    @Transactional
    public String addJson(HttpServletRequest request,Map<String, Object> map, ChatGroup chatGroup ){
        try {
            Integer num = chatGroupService.insertSelective(chatGroup);
            if(num==0){
                map.put("error", "保存失败");
                return "chatGroup/chatGroupAdd";
            }
        } catch (DaoException e) {
            map.put("error", "保存失败，"+e.getMessage());
            logger.error("Exception ", e);
            return "chatGroup/chatGroupAdd";
        }
        return "redirect:list.html";
    }
    
    @RequestMapping("edit.html")
    public String editHtml(Map<String, Object> map, Long id){
        try {
            ChatGroup chatGroup = chatGroupService.selectByPrimaryKey(id);
            map.put("info", chatGroup);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return "chatGroup/chatGroupEdit";
    }
   
   	@RequestMapping("getOne.json")
    public ChatGroup editHtml(Long id){
        try {
            return chatGroupService.selectByPrimaryKey(id);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return null;
    }
   
    @RequestMapping("edit.json")
    public String editJson(Map<String, Object> map, ChatGroup chatGroup){
        try {
            Integer num = chatGroupService.updateByPrimaryKeySelective(chatGroup);
            if(num==0){
                map.put("error", "保存失败");
                return "chatGroup/chatGroupEdit";
            }
        } catch (DaoException e) {
            map.put("error", "保存失败，"+e.getMessage());
            logger.error("Exception ", e);
            return "chatGroup/chatGroupEdit";
        }
        return "redirect:list.html";
    }
    
    @RequestMapping("del.json")
    @ResponseBody
    public String delJson(Map<String, Object> map, @RequestParam("ids[]") List<Long> ids ){
        Integer num = 0;
        try {
            for(int i=0;i<ids.size();i++){
                num+=chatGroupService.deleteByPrimaryKey(ids.get(i));
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return num.toString();
    }
}