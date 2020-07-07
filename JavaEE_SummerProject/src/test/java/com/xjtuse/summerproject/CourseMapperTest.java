package com.xjtuse.summerproject;

import com.xjtuse.summerproject.controllerEntity.Issue;
import com.xjtuse.summerproject.entity.CourseContent;
import com.xjtuse.summerproject.entity.Temp;
import com.xjtuse.summerproject.mapper.CourseMapper;
import com.xjtuse.summerproject.mapper.IssueMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;

public class CourseMapperTest {
    private InputStream in;
    private SqlSession sqlSession;
    private CourseMapper courseMapper;

    @Before
    public void init() throws Exception{

        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.使用工厂生产SqlSession对象
        sqlSession = factory.openSession();
        //4.使用SqlSession创建Mapper接口的代理对象
        courseMapper = sqlSession.getMapper(CourseMapper.class);
    }

    @After
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }


    @Test
    public void testFindUpcomingIssue() throws Exception{
        List<CourseContent> courseContents = courseMapper.findUpcomingIssue("course_demo001_content");
        for(CourseContent courseContent : courseContents) {
            System.out.println("courseContent = " + courseContent);
        }
        Date date = new Date(System.currentTimeMillis());
        System.out.println("date = " + date);
    }
}
