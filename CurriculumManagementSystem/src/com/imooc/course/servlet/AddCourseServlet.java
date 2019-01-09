package com.imooc.course.servlet;

import com.imooc.course.data.Course;
import com.imooc.course.impl.CourseDaoImpl;
import com.imooc.course.service.CourseService;
import com.imooc.course.service.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCourseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseId=Integer.valueOf(req.getParameter("courseId"));//课程ID
        String courseName = req.getParameter("courseName");//课程名
        String courseType = req.getParameter("courseType");//课程方向
        String description = req.getParameter("description");//课程描述
        String courseTime = req.getParameter("courseTime");//课程时长
        String operator = req.getParameter("operator");//操作人



        CourseService courseService = new CourseServiceImpl();
        courseService.addCourse(new Course(courseId, courseName, courseType, description, courseTime, operator));
        System.out.println("AddCourseServlet : CourseDaoImpl.getCoursesTable().size()="+ CourseDaoImpl.getCoursesTable().size());
        req.getRequestDispatcher("/CourseInquiryServlet").forward(req, resp);
    }
}
