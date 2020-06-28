package com.hwadee.hello.dao;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.hwadee.hello.entity.Student;

public class StudentDaoTest {
	
	private StudentDao dao = new StudentDao();

	@Test
	public void testInsert() {
		Student stu = new Student();
		stu.setStuName("王五");
		stu.setStuSex("男");
		stu.setStuAge(18);
		stu.setStuPro("计科");
		
		int rows = dao.insert(stu);
		
		System.out.println("stu_id=" + stu.getStuId() );
		
		Assert.assertEquals(1, rows);
	}
	@Test
	public void testDelete() {
		int rows = dao.delete(2);
		Assert.assertEquals(1, rows);
	}
	@Test
	public void testUpdate() {
		Student stu = new Student();
		stu.setStuName("张三");
		stu.setStuSex("女");
		stu.setStuAge(19);
		stu.setStuPro("软件");
		stu.setStuId(1);
		
		int rows = dao.update(stu);
		Assert.assertEquals(1, rows);
	}
	@Test
	public void testFindById() {
		Student stu = dao.findById( 1 );
		System.out.println( stu );
		Assert.assertNotNull(stu);
	}
	@Test
	public void testFindAll() {
		List<Student> list = dao.findAll();
		System.out.println(list);
		Assert.assertFalse(list.isEmpty());
	}

}
