package com.imooc.course.service;

import com.imooc.course.dao.CourseDao;
import com.imooc.course.data.Course;
import com.imooc.course.data.User;
import com.imooc.course.impl.CourseDaoImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CourseServiceImpl implements CourseService {
    //创建CourseDao对象，用于调用方法的返回值。
    private CourseDao courseDao = new CourseDaoImpl();

    private static List<Course> selectList = new ArrayList();//导出Excel缓存对象

    //用户登陆
    public int login(String username, String password) {
        int i = courseDao.login(username, password);
        return i;
    }

    ;

    //普通管理员添加方法
    public void addUser(String username, String password) {
        courseDao.addUser(username, password);
    }

    ;

    //查询所有管理员
    public List<User> getAllUsers() {
        List<User> list = courseDao.getAllUsers();
        return list;

    }

    ;

    //删除管理员
    public void delUser(String username) {
        courseDao.delUser(username);
    }

    ;

    //添加课程
    public void addCourse(Course course) {
        courseDao.addCourse(course);

    }

    //查询所有课程信息
    @Override
    public List<Course> getAllCourse(int page, int size, String name) {
        List<Course> courseList = new ArrayList<>();
        if (null != name && !"".equals(name)) {
            for (Course course : courseDao.getAllCourse()) {
                //将Course课程对象的属性值放入toString里  利用String的indexOf方法查找字段名 如果不返回-1表示有该字段
                if (course.toString().indexOf(name) != -1) {
                    //查询功能：查找相应文字 如果有则放入list
                    courseList.add(course);
                    selectList.add(course);
                }
            }
        } else {
            //如果没有传入name 表示没有进行搜索 返回所有list里的Course对象
            courseList = courseDao.getAllCourse();
            selectList = courseDao.getAllCourse();

        }

        int start = (page - 1) * size;
        int end = courseList.size() >= page * size ? page * size : courseList.size();
        return courseList.subList(start, end);
    }

    ;

    // 实现分页查询 确认总数
    public int getCourseCount(String name) {

        List<Course> courseList = new ArrayList<>();
        //如果name有数值表示正进行查询功能 返回查询到的课程总数
        if (null != name && !"".equals(name)) {//如果名字不为空
            for (Course course : courseDao.getAllCourse()) {
                if (course.getCourse().contains(name)) {//如果有该课程 存入List
                    courseList.add(course);
                }
            }
            return courseList.size();
        } else {
            //如果name为空 表示进行的是所有查询 返回所有课程的总数
            return courseDao.getAllCourse().size();//否则返回全部课程的数量
        }
    }

    ;

    //批量导入Excel课程表数据
    public String importCourse(Map<String, FileItem> fileMap, String operator) {//传入
        //对Excel文件进行内容解析
        CourseDao courseDao = new CourseDaoImpl();
        //传入fileMap解析出CourseList 存放于缓存中 并返回msg信息
        String msg = courseDao.importCourse(fileMap, operator);
        return msg;
    }

    ;

    // 课程导出
    public void exportCourse(HttpServletResponse response) {

    }

    ;

    //导出Excle
    public Workbook export(boolean isXlsx) {//ture=07版Excel表格  false=03版Excel表格
        Workbook workbook;
        if (isXlsx) {//创建07版的Excel表
            workbook = new XSSFWorkbook();
        } else {//创建03版的Excel表
            workbook = new HSSFWorkbook();
        }
        Sheet sheet = workbook.createSheet("My Sheet");//创建Sheet页
        List<List<String>> content = getContent();
        for (int i = 0; i < content.size(); i++) {
            Row row = sheet.createRow(i);//创建 第i行
            List<String> rowData = content.get(i);// 行数据
            for (int j = 0; j < rowData.size(); j++) {//创建每行的单元格
                row.createCell(j).setCellValue(rowData.get(j));
            }
        }
        return workbook;
    }

    //为了创建Excecl表 创建获得二维数据的两层List
    private List<List<String>> getContent() {
        List<List<String>> result = new ArrayList<>();
        List<String> row;
        for (Course course : selectList) {
            row = new ArrayList<>();
            result.add(row);
            row.add(String.valueOf(course.getId()));
            row.add(course.getCourse());
            row.add(course.getCourseDirction());
            row.add(course.getCourseDescribe());
            row.add(course.getCourseTime());
            row.add(course.getOperator());
        }
        return result;
    }

}
