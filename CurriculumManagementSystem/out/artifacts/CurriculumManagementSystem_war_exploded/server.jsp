<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <base href="<%=basePath%>">
    <title>课程后台管理系统${username}</title>
</head>
<frameset rows="20%,*">
    <frame src="./top.jsp"></frame>
    <frameset cols="15%,*">
        <frame src="./left.jsp"></frame>
        <frame name="main"></frame>
    </frameset>
</frameset>
</html>