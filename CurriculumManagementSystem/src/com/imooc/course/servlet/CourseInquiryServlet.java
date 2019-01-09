package com.imooc.course.servlet;

import com.imooc.course.data.Course;
import com.imooc.course.service.CourseService;
import com.imooc.course.service.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//课程查询
public class CourseInquiryServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        CourseService courseService = new CourseServiceImpl();
        //取出课程List
//        List<Course> list = courseService.getAllCourse();


        //查找的课程名
        String name = req.getParameter("title");
        //目前页数
        String pageStr = req.getParameter("page");
        int page = 1;
        if (null != pageStr && !"".equals(pageStr)) {
            page = Integer.parseInt(pageStr);//跳转后当前页数
        }
        //取出商品列表
//        List<Product> productList = LocalCache.getProducts();

        //商品总数
//        int totalProducts = productList.size();


        int totalProducts = courseService.getCourseCount(name);
        //尾页
        int totalPage = totalProducts % 12 > 0 ? totalProducts / 12 + 1 : totalProducts / 12;

        req.setAttribute("curPage", page);
        req.setAttribute("prePage", page > 1 ? page - 1 : 1);
        req.setAttribute("nextPage", totalPage > page ? page + 1 : totalPage);
        req.setAttribute("totalPage", totalPage);
        req.setAttribute("title", name);


        req.setAttribute("courseList", courseService.getAllCourse(page, 12, name));


//        req.setAttribute("list", list);
        req.getRequestDispatcher("/showCourse.jsp").forward(req, resp);
    }
}