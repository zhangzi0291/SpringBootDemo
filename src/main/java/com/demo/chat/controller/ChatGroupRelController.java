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
import com.demo.chat.entity.ChatGroupRel;
import com.demo.chat.entity.ChatGroupRelExample;
import com.demo.chat.service.ChatGroupRelService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chatGroupRel")
public class ChatGroupRelController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private ChatGroupRelService chatGroupRelService;
    
    @RequestMapping("list.html")
    public String listHtml(){
        return "chatGroupRel/chatGroupRelList";
    }
    
    @RequestMapping("list.json")
    @ResponseBody
    public Map<String, Object> listJson(ChatGroupRel chatGroupRel, Page page){
        Map<String, Object> result = new HashMap<>();
        ChatGroupRelExample example = new ChatGroupRelExample();
        ChatGroupRelExample.Criteria criteria = example.createCriteria();
        //设置查询条件 。。。
        example.setPage(page);
        try {
            List< ChatGroupRel> list = chatGroupRelService.selectByExample(example);
            Integer count = chatGroupRelService.countByExample(example);
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
        return "chatGroupRel/chatGroupRelAdd";
    }
    
    @RequestMapping("add.json")
    @Transactional
    public String addJson(HttpServletRequest request,Map<String, Object> map, ChatGroupRel chatGroupRel ){
        try {
            Integer num = chatGroupRelService.insertSelective(chatGroupRel);
            if(num==0){
                map.put("error", "保存失败");
                return "chatGroupRel/chatGroupRelAdd";
            }
        } catch (DaoException e) {
            map.put("error", "保存失败，"+e.getMessage());
            logger.error("Exception ", e);
            return "chatGroupRel/chatGroupRelAdd";
        }
        return "redirect:list.html";
    }
    
    @RequestMapping("edit.html")
    public String editHtml(Map<String, Object> map, Long id){
        try {
            ChatGroupRel chatGroupRel = chatGroupRelService.selectByPrimaryKey(id);
            map.put("info", chatGroupRel);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return "chatGroupRel/chatGroupRelEdit";
    }
   
   	@RequestMapping("getOne.json")
    public ChatGroupRel editHtml(Long id){
        try {
            return chatGroupRelService.selectByPrimaryKey(id);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return null;
    }
   
    @RequestMapping("edit.json")
    public String editJson(Map<String, Object> map, ChatGroupRel chatGroupRel){
        try {
            Integer num = chatGroupRelService.updateByPrimaryKeySelective(chatGroupRel);
            if(num==0){
                map.put("error", "保存失败");
                return "chatGroupRel/chatGroupRelEdit";
            }
        } catch (DaoException e) {
            map.put("error", "保存失败，"+e.getMessage());
            logger.error("Exception ", e);
            return "chatGroupRel/chatGroupRelEdit";
        }
        return "redirect:list.html";
    }
    
    @RequestMapping("del.json")
    @ResponseBody
    public String delJson(Map<String, Object> map, @RequestParam("ids[]") List<Long> ids ){
        Integer num = 0;
        try {
            for(int i=0;i<ids.size();i++){
                num+=chatGroupRelService.deleteByPrimaryKey(ids.get(i));
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return num.toString();
    }
}