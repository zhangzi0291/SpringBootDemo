package com.demo.sys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.demo.base.R;
import com.demo.sys.entity.*;
import com.demo.sys.service.SysResourceService;
import com.demo.sys.service.SysRoleResourceService;
import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.utils.CamelToUnderlineUtil;

import com.demo.base.Page;
import com.demo.base.exception.DaoException;
import com.demo.sys.service.SysRoleService;

@RestController
@RequestMapping("sys/role")
public class SysRoleController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysRoleResourceService sysRoleResourceService;
    @Resource
    private SysResourceService sysResourceService;
    
    @RequestMapping("list")
    @ResponseBody
    public R listJson(SysRole sysRole, Page page){
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        //设置查询条件 。。。
        example.setPage(page);
        example.setOrderByClause(" id ");
        if(!StringUtils.isEmpty(page.getOrder())&&!StringUtils.isEmpty(page.getSortCol())){
            example.setOrderByClause(CamelToUnderlineUtil.camelToUnderline(page.getSortCol())+" "+page.getOrder());
        }
        if(!StringUtils.isEmpty(sysRole.getRoleName())){
            criteria.andRoleNameLike("%"+sysRole.getRoleName()+"%");
        }
        try {
            List< SysRole> list = sysRoleService.selectByExample(example);
            Integer count = sysRoleService.countByExample(example);
            return R.ok().putObject("rows",list).putObject("total", count);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return R.error("无数据");
    }

    @RequestMapping("selectOptions")
    @ResponseBody
    public R selectOptions(SysRole sysRole){
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        //设置查询条件 。。。

        try {
            List< SysRole> list = sysRoleService.selectByExample(example);
            List<Map<String,Object>> options = new ArrayList<>();
            list.forEach(role->{
                Map<String,Object> map = new HashMap<>();
                map.put("name",role.getRoleName());
                map.put("value",role.getId());
                options.add(map);
            });
            return R.ok().putObject("data",options);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return R.error("无数据");
    }

    @RequestMapping("add")
    @Transactional
    public R addJson(SysRole sysRole ,String resources){
    	Integer num = 0;
        try {
            num = sysRoleService.insertSelective(sysRole);
            List<Integer> resourceIdList = getResourceIdList(JSONArray.parseArray(resources,SysResource.class));
            sysRoleResourceService.insertRoleResource(sysRole.getId(), resourceIdList);
            if(num==0){
                return R.error("保存失败,无数据");
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
            return R.error("保存失败,出现异常");
        }
        return R.ok("data",num);
    }
    
   	@RequestMapping("get")
    public R get(Integer id){
        try {
            List<SysRoleResource> rrlist =  sysRoleResourceService.getResourceByRoleId(id);
            List<SysResource> list = sysResourceService.getResourceMenus(null);
            List<SysResourceDto> options = setChildNood(list,rrlist);
            return R.ok("data",sysRoleService.selectByPrimaryKey(id)).putObject("options",options);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return R.error("无数据");
    }


    private List<SysResourceDto> setChildNood(List<SysResource> list,List<SysRoleResource> rrlist) {
        List<SysResourceDto> options = new ArrayList<>();
        list.forEach(r -> {
            SysResourceDto dto = new SysResourceDto();
            BeanUtils.copyProperties(r, dto);
            if(!CollectionUtils.isEmpty(rrlist)) {
                for (SysRoleResource rr : rrlist){
                    if (rr.getResourceId() == r.getId()) {
                        dto.setChecked(true);
                        break;
                    }else{
                        dto.setChecked(false);
                    }

                }
            }else{
                dto.setChecked(false);
            }
            if (!CollectionUtils.isEmpty(r.getChild())) {
                dto.setChildren(setChildNood(r.getChild(),rrlist));
            }
            options.add(dto);
        });

        return options;
    }

    @RequestMapping("edit")
    public R editJson(SysRole sysRole,String resources){
   		Integer num = 0;
        try {
            num = sysRoleService.updateByPrimaryKeySelective(sysRole);
            List<Integer> resourceIdList = getResourceIdList(JSONArray.parseArray(resources,SysResource.class));
            sysRoleResourceService.updateRoleResource(sysRole.getId(), resourceIdList);
            if(num==0){
                return R.error("保存失败,无数据");
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
            return R.error("保存失败,出现异常");
        }
        return R.ok("data",num);
    }
    
    @RequestMapping("del")
    @ResponseBody
    public R delJson(Map<String, Object> map, @RequestParam("ids") List<Integer> ids ){
        Integer num = 0;
        try {
            for(int i=0;i<ids.size();i++){
                num+=sysRoleService.deleteByPrimaryKey(ids.get(i));
                sysRoleResourceService.deleteRoleResource(ids.get(i));
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
            return R.error("保存失败,出现异常");
        }
        return R.ok("data",num);
    }


    private List<Integer> getResourceIdList(List<SysResource> resourceList){
        List<Integer> resourceIdList = new ArrayList<>();
        resourceList.forEach(resource ->{
            resourceIdList.add(resource.getId());
        });
        return resourceIdList;
    }
}