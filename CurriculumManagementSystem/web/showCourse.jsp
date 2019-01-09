<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>课程查询</title>
    <!-- 分页查看 -->
    <link rel="stylesheet" type="text/css" href="resources/js/dataTable/jquery.dataTables.min.css">
    <script type="text/javascript" src="resources/js/dataTable/jquery.js"></script>
    <script type="text/javascript" src="resources/js/dataTable/jquery.dataTables.min.js"></script>
    <script type="text/javascript">
        function bodyInit() {
            if ('${result.msg}') {
                alert('${result.msg}');
            }
        }

    </script>
    <form id="searchForm" method="post" action="/CourseInquiryServlet">
        <div class="search">
            <input type="hidden" name="page" value="1">
            <input type="text" name="title" class="search_input" value="${title}">
            <input type="submit" class="search_submit" value="">
        </div>
    </form>
</head>
<body onload="bodyInit();">
<center>
    <h1>课程查询</h1>
    <hr>
    <div align="rigth">
        <%--                <a href="/product/list.do?page=1">首页</a>
                        <a href="/product/list.do?page=${prePage}">上一页</a>
                        <a href="/product/list.do?page=${nextPage}">下一页</a>
                        <a href="/product/list.do?page=${totalPage}">尾页</a>
        --%>
        <form method="post" action="/CourseInquiryServlet" style="display: inline">
            <input type="hidden" name="page" value="1">
            <input type="hidden" name="title" value="${title}">
            <input type="submit" value="首页">
        </form>
        <form method="post" action="/CourseInquiryServlet"style="display: inline">
            <input type="hidden" name="page" value="${prePage}">
            <input type="hidden" name="title" value="${title}">
            <input type="submit" value="上一页">
        </form>
        <form method="post" action="/CourseInquiryServlet" style="display: inline">
            <input type="hidden" name="page" value="${nextPage}">
            <input type="hidden" name="title" value="${title}">
            <input type="submit" value="下一页">
        </form>
        <form method="post" action="/CourseInquiryServlet" style="display: inline">
            <input type="hidden" name="page" value="${totalPage}">
            <input type="hidden" name="title" value="${title}">
            <input type="submit" value="尾页">
        </form>


        第${curPage}页/共${totalPage}页
    </div>

    <table cellspacing="0px" cellpadding="0px" border="1px" width="100%" class="tablelist" id="example">
        <thead>
        <tr>
            <th>课程ID</th>
            <th>课程名</th>
            <th>方向</th>
            <th>描述</th>
            <th>时长(小时)</th>
            <th>操作人</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="course" items="${courseList}">
            <tr>
                <td>${course.id}</td>
                <td>${course.course}</td>
                <td>${course.courseDirction}</td>
                <td>${course.courseDescribe}</td>
                <td>${course.courseTime}</td>
                <td>${course.operator}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>

</body>
</html>