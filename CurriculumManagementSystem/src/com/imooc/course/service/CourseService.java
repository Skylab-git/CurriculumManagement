package com.imooc.course.service;

import com.imooc.course.data.Course;
import com.imooc.course.data.User;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

public interface CourseService {//数据处理类

    //用户登陆
    public int login(String username, String password);

    //普通管理员添加方法
    public void addUser(String username, String password);

    //查询所有管理员
    public List<User> getAllUsers();

    //删除管理员
    public void delUser(String username);

    //添加课程
    public void addCourse(Course course);

    //查询所有课程信息
    public List<Course> getAllCourse(int page, int size, String name);
    //分页查询功能
    public int getCourseCount(String name);

    //批量导入Excel课程表数据
    public String importCourse(Map<String, FileItem> fileMap, String operator);

    //课程导出
    public void exportCourse(HttpServletResponse response);
}
