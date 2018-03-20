package com.demo.chat.service.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.demo.base.dao.BaseDao;
import com.demo.base.service.impl.BaseServiceImpl;
import com.demo.base.exception.DaoException;
import com.demo.chat.dao.ChatAppDao;
import com.demo.chat.entity.ChatApp;
import com.demo.chat.entity.ChatAppExample;
import com.demo.chat.service.ChatAppService;

@Service("ChatAppService")
public class ChatAppServiceImpl extends BaseServiceImpl<ChatApp, ChatAppExample> implements ChatAppService{

    @Resource
    private ChatAppDao dao;

    @Override
    public BaseDao<ChatApp, ChatAppExample> getDao() throws DaoException {
        return dao;
    }
    
    
}
