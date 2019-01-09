<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录页面</title>
    <style type="text/css">
        .c1 {
            width: 300px;
            cursor: pointer;
        }

        .c2 {
            width: 300px;
            padding-left: 30px;
        }
    </style>
</head>
<body>
<%
        int flag = (int)request.getSession().getAttribute("flag");
        if (flag == 1) {


    %>
    <div class="c1">
        <h3 onclick="show1()">用户管理</h3>
        <div class="c2" id="menu1" style="display:none;">
            <p><a href="<%=basePath%>/addUser.jsp" target="main">添加管理员</a></p>
            <p><a href="<%=basePath%>/SelectUsers" target="main">查询管理员</a></p>
        </div>
    </div>

    <%
    } else {%>
    <h3>用户管理</h3>
    <% }
    %>
<div class="c1">
    <h3 onclick="show2()">课程管理</h3>
    <div class="c2" id="menu2" style="display:none;">
        <p><a href="<%=basePath%>/addCourse.jsp" target="main">课程添加</a></p>
        <p><a href="<%=basePath%>/courseImport.jsp" target="main">课程批量导入(Excel)</a></p>
        <p><a href="<%=basePath%>/ExportCourseServlet" target="main">课程导出</a></p>
        <p><a href="<%=basePath%>/CourseInquiryServlet" target="main">课程查询</a></p>
    </div>
</div>
<script type="text/javascript">
    function show1() {
        var menu = document.getElementById("menu1");
        var displayStyle = menu.style.display;
        if (displayStyle == "none") {
            menu.style.display = "block";
        } else {
            menu.style.display = "none";
        }
    }

    function show2() {
        var menu = document.getElementById("menu2");
        var displayStyle = menu.style.display;
        if (displayStyle == "none") {
            menu.style.display = "block";
        } else {
            menu.style.display = "none";
        }
    }
</script>
</body>
</html>