package com.lj.mvn_ssh.service;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lj.mvn_ssh.pojo.Student;

public class TestHibernate {
	@Test
    public void testHibernateEnv(){
        //加载指定目录下的配置文件，得到configuration对象
        Configuration cfg = new Configuration().configure("classpath:hibernate.cfg.xml");
        //根据configuration对象得到session工厂对象
        SessionFactory factory = cfg.buildSessionFactory();
        //使用工厂类打开一个session
        Session session = factory.openSession();
        //开启事务
        Transaction tx = session.beginTransaction();
        //创建待插入数据库的对象
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Student p = (Student) context.getBean("person");
        p.setId(UUID.randomUUID().toString());
        p.setName("xxx");
        //保存对象
        session.save(p);
        //提交事务
        tx.commit();
        //关闭资源
        session.close();
        factory.close();
    }

}
