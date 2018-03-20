package com.demo.chat.service.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.demo.base.dao.BaseDao;
import com.demo.base.service.impl.BaseServiceImpl;
import com.demo.base.exception.DaoException;
import com.demo.chat.dao.ChatGroupDao;
import com.demo.chat.entity.ChatGroup;
import com.demo.chat.entity.ChatGroupExample;
import com.demo.chat.service.ChatGroupService;

@Service("ChatGroupService")
public class ChatGroupServiceImpl extends BaseServiceImpl<ChatGroup, ChatGroupExample> implements ChatGroupService{

    @Resource
    private ChatGroupDao dao;

    @Override
    public BaseDao<ChatGroup, ChatGroupExample> getDao() throws DaoException {
        return dao;
    }
    
    
}
