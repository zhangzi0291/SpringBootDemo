package com.demo.sys.service.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.demo.base.dao.BaseDao;
import com.demo.base.service.impl.BaseServiceImpl;
import com.demo.base.exception.DaoException;
import com.demo.sys.dao.SysUserDao;
import com.demo.sys.entity.SysUser;
import com.demo.sys.entity.SysUserExample;
import com.demo.sys.service.SysUserService;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service("SysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, SysUserExample> implements SysUserService{

    @Resource
    private SysUserDao dao;

    @Override
    public BaseDao<SysUser, SysUserExample> getDao() throws DaoException {
        return dao;
    }

    @Override
    public SysUser findByName(String username) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        criteria.andusernameEqualTo(username);
        List<SysUser> userList = dao.selectByExample(example);
        if(!CollectionUtils.isEmpty(userList)){
            return userList.get(0);
        }
        return null;
    }
}
