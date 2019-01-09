package com.imooc.course.servlet;

import com.imooc.course.dao.CourseDao;
import com.imooc.course.dto.ImportExcelResultDto;

import com.imooc.course.impl.CourseDaoImpl;
import com.imooc.course.service.CourseService;
import com.imooc.course.service.CourseServiceImpl;
import com.imooc.course.service.ExcelService;
import com.imooc.course.utils.RequestUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ImportExcelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Servlet就负责表单提交的数据，只调用别的类实现好的方法，返回结果给页面响应就可以了

        //判断是否为enctype="multipart/form-data" 类型的表单
        if (ServletFileUpload.isMultipartContent(req)){
            Map<String, FileItem> fileMap=RequestUtil.parseParam(req);//调用工具类 从request流中解析参数与上传的文件 存入Map集合里
            String operator= (String) req.getSession().getAttribute("username");//操作人

            //对Excel文件进行内容解析 fileMap解析出CourseList 存放于缓存中 并返回msg信息
            CourseService courseService=new CourseServiceImpl();
            String msg=courseService.importCourse(fileMap,operator);

            req.setAttribute("msg",msg);
        }else {
            //req.getParameter("");
        }
        req.getRequestDispatcher("/CourseInquiryServlet").forward(req,resp);
    }
}
