package com.imooc.course.dao;

import com.imooc.course.data.Course;
import com.imooc.course.data.User;
import org.apache.commons.fileupload.FileItem;

import java.util.List;
import java.util.Map;

//数据处理类
public interface CourseDao {
    //用户登录
    public int login(String username, String password);

    //普通管理员添加方法
    public void addUser(String username, String password);

    //查询所有管理员
    public List<User>  getAllUsers();

    //删除管理员
    public void delUser(String username);

    //添加课程
    public void addCourse(Course couse);

    //查询所有课程信息
    public List<Course> getAllCourse();

    //批量导入Excel课程表数据
    public String importCourse(Map<String,FileItem> fileMap, String operator);
}
