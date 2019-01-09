package com.imooc.course.servlet;

import com.imooc.course.data.User;
import com.imooc.course.service.CourseService;
import com.imooc.course.service.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class SelectUsersServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseService courseService = new CourseServiceImpl();
        if (Objects.equals("/SelectUsers", req.getServletPath())) {
            List<User> list=courseService.getAllUsers();
            req.setAttribute("list", list);
            req.getRequestDispatcher("/selectUsers.jsp").forward(req, resp);
        } else if (Objects.equals("/delete", req.getServletPath())) {
            String username = req.getParameter("username");
            courseService.delUser(username);
            req.getRequestDispatcher("/SelectUsers").forward(req,resp);
        }

    }

}
