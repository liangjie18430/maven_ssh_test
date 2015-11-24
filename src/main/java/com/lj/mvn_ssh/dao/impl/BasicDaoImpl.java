package com.lj.mvn_ssh.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lj.mvn_ssh.dao.BasicDaoI;

public class BasicDaoImpl<T> implements BasicDaoI<T>{

	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		this.sessionFactory=sessionFactory;
	}

	private Session getCurrentSession(){
		return this.sessionFactory.openSession();
	}
	public void save(T o) {
		// TODO Auto-generated method stub
		//Transaction tx = null;
		Session ss = getCurrentSession();
		try{
		System.out.println(o.toString());
		
		//tx = ss.beginTransaction();
		ss.save(o);
		//不能提交，提交后不能回滚，spring-test测试完后不会自动回滚
		//tx.commit();
		}catch(Exception e){
			//tx.rollback();
			e.printStackTrace();
		}
		finally{
			//事务不能关闭，应该交给spring管理
			/*ss.close();
			sessionFactory.close();*/
		}
	}

}
