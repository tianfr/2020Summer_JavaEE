package com.xjtuse.summerproject.mapper;

import com.xjtuse.summerproject.controllerEntity.GetStudentHomeworkDetailInfo;
import com.xjtuse.summerproject.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TeacherMapper {

    //查询课程
    @Select("select *  from courses where courses.course_id IN ( \n" +
            "        SELECT \n" +
            "            teachers_courses.course_id \n" +
            "        FROM \n" +
            "            teachers_courses \n" +
            "        WHERE \n" +
            "            teacher_id = #{teacher_id} \n" +
            "    )")
    List<Course> findAllCourseById(String teacher_id);


    @Select("select * from teachers where teacher_username=#{teacher_username}")
    Teacher findByUsername(String teacher_username);

    @Select("select max(teacher_id) from teachers")
    String findMaxId();

    @Insert("insert into teachers(teacher_id, teacher_name, teacher_age, teacher_email, teacher_gender, teacher_phone, teacher_content, teacher_username, teacher_password, insert_date) values(#{teacher_id}, #{teacher_name}, #{teacher_age}, #{teacher_email}, #{teacher_gender}, #{teacher_phone}, #{teacher_content}, #{teacher_username}, #{teacher_password}, #{insert_date}) ")
    void insertTeacher(Teacher teacher);

    //修改密码
    @Update("update teachers set teacher_password=#{teacher_password} where teacher_username=#{teacher_username}")
    void updateTeacherPasswordByUsername(Teacher teacher);

    //6.18 老师查看所有已提交作业
    @Select("SELECT * FROM course_${course_id}_homework WHERE homework_id = #{homework_id} AND is_draft = 'no';")
    List<CourseHomework> getStudentHomeworks(SendHomework sendHomework);

    //6.17 教师getPrevCourses
    @Select("SELECT courses.* FROM courses, teachers_courses WHERE " +
            "teachers_courses.teacher_id=#{teacher_id} AND teachers_courses.course_id = courses.course_id")
    List<Course> getprevCourses(String teacher_id);

    //老师根据课程号和作业号查询已提交作业
    @Select("SELECT * from course_${course_id}_homework WHERE homework_id = #{homework_id}")
    List<CourseHomework> getSubmittedHomework(SendHomework sendHomework);

    @Select("select * from course_${course_id}_homework WHERE homework_id = #{homework_id} and student_id = #{student_id}")
    CourseHomework getHomeworkDetail(GetStudentHomeworkDetailInfo info);
}
