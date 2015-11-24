package com.lj.mvn_ssh.action.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.lj.mvn_ssh.action.TestActionI;
import com.lj.mvn_ssh.pojo.Student;
import com.lj.mvn_ssh.service.TestServiceI;

public class TestActionImpl extends BaseAction implements TestActionI {
	private TestServiceI testService;
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public TestServiceI getTestService() {
		return testService;
	}

	public void setTestService(TestServiceI testService) {
		this.testService = testService;
	}

	public String test() {
		if (testService == null) {
			System.out.println("testService为空了");
			return "failed";
		} else {
			System.out.println("获取到的数据：" + student.toString());
			testService.save(student);
			return "success";
		}
	}
}
