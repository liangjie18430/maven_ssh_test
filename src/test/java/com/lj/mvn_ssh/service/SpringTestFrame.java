package com.lj.mvn_ssh.service;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lj.mvn_ssh.pojo.Student;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class SpringTestFrame {
	@Autowired
	TestServiceI testService;
	
	
	@Test
	@Transactional
    public void test() {  
       /* ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] { "classpath:spring/applicationContext.xml" });  
        TestService userService = (TestServiceImpl) ac.getBean("testService"); */
        Student st = new Student();
      //  st.setId(UUID.randomUUID().toString());
        /*st.setName("test2");
        st.setAge(20);*/
        testService.save(st);
    }  

}
