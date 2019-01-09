package com.imooc.course.servlet;

import com.imooc.course.dao.CourseDao;
import com.imooc.course.service.CourseService;
import com.imooc.course.service.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!(req.getSession().getAttribute("code").equals(req.getParameter("checkCode")))){
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        req.getSession().setAttribute("username",username);

        CourseService courseService=new CourseServiceImpl();
        int i=courseService.login(username,password);
        switch (i){
            case 1://超级管理员
                req.getRequestDispatcher("/server.jsp").forward(req,resp);
                req.getSession().setAttribute("flag",i);
                break;
            case 2://普通管理员
                req.getRequestDispatcher("/server.jsp").forward(req,resp);
                req.getSession().setAttribute("flag",i);
                break;
            case 0://登陆不成功，跳转到登陆页面
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
                break;
        }
    }
}
