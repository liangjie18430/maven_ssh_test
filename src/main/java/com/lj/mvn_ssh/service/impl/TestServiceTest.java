package com.lj.mvn_ssh.service.impl;

import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lj.mvn_ssh.pojo.Student;
import com.lj.mvn_ssh.service.TestService;

public class TestServiceTest {
	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "classpath:applicationContext.xml" });  
        TestService userService = (TestServiceImpl) ac.getBean("testService"); 
        Student st = new Student();
        st.setId(UUID.randomUUID().toString());
        /*st.setName("test2");
        st.setAge(20);*/
        userService.save(st);
		
	}

}
