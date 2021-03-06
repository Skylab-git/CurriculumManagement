<%@ page import="com.imooc.course.utils.CaptcahCode" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //清空浏览器缓存，目的是为了清空浏览器的缓存，因为浏览器
    //会对网站的资源文件和图像进行记忆储存，如果浏览器加载过的图片就记忆起来，记忆之后
    //文件就不会和服务器再交互，如果我们验证不清空的话可能会造成一个问题就是：验证刷新以后没有效果
    response.setHeader("pragma","no-cache");
    response.setHeader("cache-control","no-cache");
    response.setHeader("expires","0");

    //调用编写的生成验证码的工具
    String code=CaptcahCode.drawImage(response);
    session.setAttribute("code",code);

    //如何解决getOutputStream异常问题
    out.clear();
    out = pageContext.pushBody();
%>