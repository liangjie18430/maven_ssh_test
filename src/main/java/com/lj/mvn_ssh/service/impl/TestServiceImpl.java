package com.lj.mvn_ssh.service.impl;

import org.apache.log4j.Logger;

import com.lj.mvn_ssh.dao.BasicDaoI;
import com.lj.mvn_ssh.pojo.Tuser;
import com.lj.mvn_ssh.service.TestServiceI;

public class TestServiceImpl implements TestServiceI{

	private static final Logger logger = Logger.getLogger(TestServiceImpl.class);
	
	private BasicDaoI<Tuser> basicDao;

	public BasicDaoI<Tuser> getBasicDao() {
		return basicDao;
	}




	public void setBasicDao(BasicDaoI<Tuser> basicDao) {
		this.basicDao = basicDao;
	}


	public void save(Tuser o) {
		// TODO Auto-generated method stub
		//System.out.println("执行存储");
		basicDao.save(o);
	}






}
