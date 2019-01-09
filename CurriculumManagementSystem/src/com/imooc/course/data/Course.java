package com.imooc.course.data;

public class Course {
    int id;//课程id
    String course;//课程名
    String courseDirction;//课程方向
    String courseDescribe;//课程描述
    String courseTime;//课程时长
    String operator;//操作人

    public Course() {

    }

    public Course(int id, String course, String courseDirction, String courseDescribe, String courseTime, String operator) {
        this.id = id;
        this.course = course;
        this.courseDirction = courseDirction;
        this.courseDescribe = courseDescribe;
        this.courseTime = courseTime;
        this.operator = operator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourseDirction() {
        return courseDirction;
    }

    public void setCourseDirction(String courseDirction) {
        this.courseDirction = courseDirction;
    }

    public String getCourseDescribe() {
        return courseDescribe;
    }

    public void setCourseDescribe(String courseDescribe) {
        this.courseDescribe = courseDescribe;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return id +
                course +
                courseDirction +
                courseDescribe +
                courseTime +
                operator;
    }
}
