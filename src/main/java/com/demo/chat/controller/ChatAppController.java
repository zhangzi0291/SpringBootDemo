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
import com.demo.chat.entity.ChatApp;
import com.demo.chat.entity.ChatAppExample;
import com.demo.chat.service.ChatAppService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chatApp")
public class ChatAppController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private ChatAppService chatAppService;
    
    @RequestMapping("list.html")
    public String listHtml(){
        return "chatApp/chatAppList";
    }
    
    @RequestMapping("list.json")
    @ResponseBody
    public Map<String, Object> listJson(ChatApp chatApp, Page page){
        Map<String, Object> result = new HashMap<>();
        ChatAppExample example = new ChatAppExample();
        ChatAppExample.Criteria criteria = example.createCriteria();
        //设置查询条件 。。。
        example.setPage(page);
        try {
            List< ChatApp> list = chatAppService.selectByExample(example);
            Integer count = chatAppService.countByExample(example);
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
        return "chatApp/chatAppAdd";
    }
    
    @RequestMapping("add.json")
    @Transactional
    public String addJson(HttpServletRequest request,Map<String, Object> map, ChatApp chatApp ){
        try {
            Integer num = chatAppService.insertSelective(chatApp);
            if(num==0){
                map.put("error", "保存失败");
                return "chatApp/chatAppAdd";
            }
        } catch (DaoException e) {
            map.put("error", "保存失败，"+e.getMessage());
            logger.error("Exception ", e);
            return "chatApp/chatAppAdd";
        }
        return "redirect:list.html";
    }
    
    @RequestMapping("edit.html")
    public String editHtml(Map<String, Object> map, Integer id){
        try {
            ChatApp chatApp = chatAppService.selectByPrimaryKey(id);
            map.put("info", chatApp);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return "chatApp/chatAppEdit";
    }
   
   	@RequestMapping("getOne.json")
    public ChatApp getOne(Integer id){
        try {
            return  chatAppService.selectByPrimaryKey(id);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return null;
    }
   
    @RequestMapping("edit.json")
    public String editJson(Map<String, Object> map, ChatApp chatApp){
        try {
            Integer num = chatAppService.updateByPrimaryKeySelective(chatApp);
            if(num==0){
                map.put("error", "保存失败");
                return "chatApp/chatAppEdit";
            }
        } catch (DaoException e) {
            map.put("error", "保存失败，"+e.getMessage());
            logger.error("Exception ", e);
            return "chatApp/chatAppEdit";
        }
        return "redirect:list.html";
    }
    
    @RequestMapping("del.json")
    @ResponseBody
    public String delJson(Map<String, Object> map, @RequestParam("ids[]") List<Integer> ids ){
        Integer num = 0;
        try {
            for(int i=0;i<ids.size();i++){
                num+=chatAppService.deleteByPrimaryKey(ids.get(i));
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return num.toString();
    }
}