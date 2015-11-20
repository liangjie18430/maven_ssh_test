package com.lj.mvn_ssh.service;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lj.mvn_ssh.pojo.Student;
import com.lj.mvn_ssh.service.impl.TestServiceImpl;

public class TestSpring {
	 
	//出现了找不到驱动包的错误，最好查找出是因为dataSource.properties下后面有俩个空格，但是console下输出的空格又不清楚，找了很久
	@Test
	    public void test() {  
	        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "classpath:applicationContext.xml" });  
	        TestService userService = (TestServiceImpl) ac.getBean("testService"); 
	        Student st = new Student();
	        //st.setId(UUID.randomUUID().toString());
	        /*st.setName("test2");
	        st.setAge(20);*/
	        userService.save(st);
	    }  
	 
	
	 public void testMysql(){
		 ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "classpath:applicationContext.xml" });
		 SessionFactory sf = (SessionFactory) ac.getBean("sessionFactory");
		 System.out.println("获取成功");
	 }
}
