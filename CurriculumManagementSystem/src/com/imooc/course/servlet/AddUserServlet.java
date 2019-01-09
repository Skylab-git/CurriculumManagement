package com.imooc.course.servlet;

import com.imooc.course.service.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //添加管理员账号
        CourseServiceImpl courseServiceImpl = new CourseServiceImpl();
        courseServiceImpl.addUser(username, password);
        req.getRequestDispatcher("/SelectUsers").forward(req, resp);
    }
}
