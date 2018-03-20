package com.demo.sys.service.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.demo.base.dao.BaseDao;
import com.demo.base.service.impl.BaseServiceImpl;
import com.demo.base.exception.DaoException;
import com.demo.sys.dao.SysRoleResourceDao;
import com.demo.sys.entity.SysRoleResource;
import com.demo.sys.entity.SysRoleResourceExample;
import com.demo.sys.service.SysRoleResourceService;

@Service("SysRoleResourceService")
public class SysRoleResourceServiceImpl extends BaseServiceImpl<SysRoleResource, SysRoleResourceExample> implements SysRoleResourceService{

    @Resource
    private SysRoleResourceDao dao;

    @Override
    public BaseDao<SysRoleResource, SysRoleResourceExample> getDao() throws DaoException {
        return dao;
    }
    
    
}
