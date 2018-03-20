package com.demo.sys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.demo.base.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.demo.utils.CamelToUnderlineUtil;

import com.demo.base.Page;
import com.demo.base.exception.DaoException;
import com.demo.sys.entity.SysRoleResource;
import com.demo.sys.entity.SysRoleResourceExample;
import com.demo.sys.service.SysRoleResourceService;

@RestController
@RequestMapping("sysRoleResource")
public class SysRoleResourceController {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SysRoleResourceService sysRoleResourceService;
    
    @RequestMapping("list")
    @ResponseBody
    public R listJson(SysRoleResource sysRoleResource, Page page){
        SysRoleResourceExample example = new SysRoleResourceExample();
        SysRoleResourceExample.Criteria criteria = example.createCriteria();
        //设置查询条件 。。。
        example.setPage(page);
        if(!StringUtils.isEmpty(page.getOrder())&&!StringUtils.isEmpty(page.getSortCol())){
            example.setOrderByClause(CamelToUnderlineUtil.camelToUnderline(page.getSortCol())+" "+page.getOrder());
        }
        try {
            List< SysRoleResource> list = sysRoleResourceService.selectByExample(example);
            Integer count = sysRoleResourceService.countByExample(example);
            return R.ok().putObject("rows",list).putObject("total", count);
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return R.error("无数据");
    }
    
    @RequestMapping("add")
    @Transactional
    public R addJson(SysRoleResource sysRoleResource ){
    	Integer num = 0;
        try {
            num = sysRoleResourceService.insertSelective(sysRoleResource);
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
            return R.ok("data",sysRoleResourceService.selectByPrimaryKey(id));
        } catch (DaoException e) {
            logger.error("Exception ", e);
        }
        return R.error("无数据");
    }
   
    @RequestMapping("edit")
    public R editJson(Map<String, Object> map, SysRoleResource sysRoleResource){
   		Integer num = 0;
        try {
            num = sysRoleResourceService.updateByPrimaryKeySelective(sysRoleResource);
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
                num+=sysRoleResourceService.deleteByPrimaryKey(ids.get(i));
            }
        } catch (DaoException e) {
            logger.error("Exception ", e);
            return R.error("保存失败,出现异常");
        }
        return R.ok("data",num);
    }
}