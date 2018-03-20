package com.demo.chat.service.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.demo.base.dao.BaseDao;
import com.demo.base.service.impl.BaseServiceImpl;
import com.demo.base.exception.DaoException;
import com.demo.chat.dao.ChatMsgDao;
import com.demo.chat.entity.ChatMsg;
import com.demo.chat.entity.ChatMsgExample;
import com.demo.chat.service.ChatMsgService;

@Service("ChatMsgService")
public class ChatMsgServiceImpl extends BaseServiceImpl<ChatMsg, ChatMsgExample> implements ChatMsgService{

    @Resource
    private ChatMsgDao dao;

    @Override
    public BaseDao<ChatMsg, ChatMsgExample> getDao() throws DaoException {
        return dao;
    }
    
    
}
