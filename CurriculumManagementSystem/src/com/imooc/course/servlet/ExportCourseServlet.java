package com.imooc.course.servlet;

import com.imooc.course.service.CourseServiceImpl;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExportCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseServiceImpl courseService=new CourseServiceImpl();
        Workbook workbook = courseService.export(true);//创建Excel表
        resp.setHeader("Content-Disposition", "attachment;filename=export.xlsx");//提供下载后的文件名
        ServletOutputStream outputStream = resp.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();//把流里面缓存数据输出
        //关闭流
        outputStream.close();
        workbook.close();

        req.getRequestDispatcher("/showCourse.jsp").forward(req, resp);
    }
}
