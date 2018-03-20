package com.demo.base.service.impl;

import com.demo.base.dao.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.base.service.CommonService;




@Service("commonService")
public class CommonServiceImpl implements CommonService{
	
	@Autowired
	private CommonDao commonDao;

	@Override
	public Integer selectSeq(String seqName) {
		Integer id=commonDao.selectSeq(seqName);
		return id;
	}

}
