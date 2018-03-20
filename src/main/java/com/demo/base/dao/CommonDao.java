package com.demo.base.dao;

public interface CommonDao {

	Integer selectSeq(String seqName);
	
	Integer selectTaskIdSeq(String seqName);
}
