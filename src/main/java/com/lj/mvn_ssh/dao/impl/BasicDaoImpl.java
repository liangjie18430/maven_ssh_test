package com.lj.mvn_ssh.dao.impl;

import java.io.Serializable;

import net.sf.ehcache.hibernate.HibernateUtil;

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
		Transaction tx = null;
		Session ss = getCurrentSession();
		try{
		System.out.println(o.toString());
		
		tx = ss.beginTransaction();
		ss.save(o);
		tx.commit();
		}catch(Exception e){
			tx.rollback();
		}
		finally{
			ss.close();
			sessionFactory.close();
		}
	}

}
