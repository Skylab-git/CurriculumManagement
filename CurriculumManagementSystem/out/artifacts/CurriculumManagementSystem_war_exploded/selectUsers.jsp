<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>管理员查询</title>
</head>
<body>
<center>
    <h1>管理员查询</h1>
    <hr>
    <table cellspacing="0px" cellpadding="0px" border="1px" width="600px">
        <thead>
        <tr>
            <th>用户名</th>
            <th>密码</th>
            <th>类型</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="user">
            <tr>
                <td>${user.userName}</td>
                <td>${user.password}</td>
                <td>${user.type}</td>
                <td><a href="${basePath}/delete?username=${user.userName}">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>
</body>
</html>