package com.demo.sys.service;

import com.demo.base.exception.DaoException;
import com.demo.base.service.BaseService;
import com.demo.sys.entity.SysResource;
import com.demo.sys.entity.SysResourceExample;
import com.demo.sys.entity.SysRole;

import java.util.List;

public interface SysResourceService extends BaseService<SysResource, SysResourceExample> {

    List<SysResource> getAllResource() ;

    List<SysResource> getMenus(String username) ;

}