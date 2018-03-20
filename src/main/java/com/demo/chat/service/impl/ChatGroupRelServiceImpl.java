package com.demo.chat.service.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.demo.base.dao.BaseDao;
import com.demo.base.service.impl.BaseServiceImpl;
import com.demo.base.exception.DaoException;
import com.demo.chat.dao.ChatGroupRelDao;
import com.demo.chat.entity.ChatGroupRel;
import com.demo.chat.entity.ChatGroupRelExample;
import com.demo.chat.service.ChatGroupRelService;

@Service("ChatGroupRelService")
public class ChatGroupRelServiceImpl extends BaseServiceImpl<ChatGroupRel, ChatGroupRelExample> implements ChatGroupRelService{

    @Resource
    private ChatGroupRelDao dao;

    @Override
    public BaseDao<ChatGroupRel, ChatGroupRelExample> getDao() throws DaoException {
        return dao;
    }
    
    
}
