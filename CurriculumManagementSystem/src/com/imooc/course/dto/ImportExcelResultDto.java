package com.imooc.course.dto;

import com.imooc.course.data.Course;

import java.util.List;

public class ImportExcelResultDto {
    private List<Course> courseList;//解析Fileteam对象取出的 Student对象信息
    private String msg;//异常信息

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
