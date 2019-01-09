package com.imooc.course.impl;

import com.imooc.course.dao.CourseDao;
import com.imooc.course.data.Course;
import com.imooc.course.data.User;
import com.imooc.course.dto.ImportExcelResultDto;
import com.imooc.course.service.ExcelService;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class CourseDaoImpl implements CourseDao {
    //用户表
    private static final Map<String, User> usersTable = new HashMap<>();

    //课程表
    private static final List<Course> coursesTable = new ArrayList<>();

    static {//用户添加超级管理员imooc到usersTable中
        usersTable.put("imooc", new User("imooc", "imooc", "超级管理员"));
    }

    public static Map<String, User> getUsersTable() {
        return usersTable;
    }

    public static List<Course> getCoursesTable() {
        return coursesTable;
    }

    @Override
    public int login(String username, String password) {
        //取出用户表
        Map<String, User> usersTable = CourseDaoImpl.getUsersTable();
        Iterator<Map.Entry<String, User>> it = usersTable.entrySet().iterator();
        while (it.hasNext()) {//循环输出用户表
            Map.Entry<String, User> entry = it.next();
            User user = entry.getValue();
            if ("imooc".equals(username) && user.getPassword().equals(password)) {
                System.out.println("return 1");
                return 1;//超级管理员
            } else if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                System.out.println("return 2");
                return 2;//普通管理员
            }
        }
        System.out.println("return 0");
        return 0;//账号不正确
    }

    //普通管理员添加方法
    public void addUser(String username, String password) {
        Map<String, User> usersTable = CourseDaoImpl.getUsersTable();
        usersTable.put(username, new User(username, password, "普通管理员"));
    }

    ;

    //查询所有管理员
    public List<User> getAllUsers() {
        List list = new ArrayList(usersTable.values());
        return list;
    }

    ;

    //删除管理员
    public void delUser(String username) {
        Map map = CourseDaoImpl.getUsersTable();
        map.remove(username);
    }

    ;

    //添加课程
    public void addCourse(Course course) {
        coursesTable.add(course);
    }

    ;

    //查询所有课程信息
    public List<Course> getAllCourse() {
        return coursesTable;
    }

    ;

    //批量导入Excel课程表数据
    public String importCourse(Map<String, FileItem> fileMap, String operator) {
        //对Excel文件进行内容解析
        ExcelService service=new ExcelService();
        //把resultDto传输对象响应给页面
        ImportExcelResultDto resultDto=service.imp(fileMap.get("file1"),operator);

        CourseDao courseDao=new CourseDaoImpl();
        courseDao.getAllCourse().addAll(resultDto.getCourseList());
        String msg=resultDto.getMsg();
        return msg;
    }

    ;

    //课程导出
    public void exportCourse(HttpServletResponse response) {

    }

    ;

}
