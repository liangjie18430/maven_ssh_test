package com.lj.mvn_ssh.dao;

import org.hibernate.SessionFactory;

public interface BasicDaoI<T> {
	public SessionFactory getSessionFactory();
	public void setSessionFactory(SessionFactory sessionFactory);
	public void save(T o);
	 

}
