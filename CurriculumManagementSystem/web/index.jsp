<%@ page import="com.imooc.course.utils.CaptcahCode" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
//    //清空浏览器缓存，目的是为了清空浏览器的缓存，因为浏览器
//    //会对网站的资源文件和图像进行记忆储存，如果浏览器加载过的图片就记忆起来，记忆之后
//    //文件就不会和服务器再交互，如果我们验证不清空的话可能会造成一个问题就是：验证刷新以后没有效果
//    response.setHeader("pragma","no-cache");
//    response.setHeader("cache-control","no-cache");
//    response.setHeader("expires","0");
//
//    //调用编写的生成验证码的工具
//    String code=CaptcahCode.drawImage(response);
//    session.setAttribute("code",code);
//
//    //如何解决getOutputStream异常问题
//    out.clear();
//    out = pageContext.pushBody();
%>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录页面</title>
    <style type="text/css">
        .code {
            background: url(code_bg.jpg);
            font-family: Arial;
            font-style: italic;
            color: blue;
            font-size: 20px;
            border: 0;
            padding: 2px 3px;
            letter-spacing: 3px;
            font-weight: bolder;
            float: left;
            cursor: pointer;
            width: 40px;
            height: 20px;
            line-height: 20px;
            text-align: center;
            vertical-align: middle;
        }

        a {
            text-decoration: none;
            font-size: 12px;
            color: #288bc4;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>

</head>

<body>
<center>
    <h1>用户登录</h1>
    <form action="<%=basePath%>/LoginServlet" method="post" onsubmit="return validateCode()">
        <table width="300px" cellspacing="0px" cellpadding="0px" border="1px">
            <tr>
                <td>用户名</td>
                <td colspan="2"><input type="text" name="username" pattern="[a-zA-Z_0-9]{3,12}"
                                       placeholder="用户名为3-12位字母数字或下划线组合"></td>
            </tr>
            <tr>
                <td>密&nbsp;码</td>
                <td colspan="2"><input type="password" name="password" pattern="[a-zA-Z_0-9]{5,12}"
                                       placeholder="长度为5-12位字母数字或下划线组合"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td style="border-right-style:none;">
                    <input type="text" name="checkCode" placeholder="请输入验证码" id="inputCode">
                </td>
                <td style="border-left-style:none;">
                    <div class="code" id="checkCode"><img src="code.jsp" alt="" id="code">
                        <a href="javascript:void(0);" onclick="changeCode()">看不清？点我</a>
                    </div>
                    <script>
                        function changeCode() {
                            document.getElementById("code").src = "code.jsp?d=" + new Date().getTime()
                        }
                    </script>
                </td>
            </tr>
            <tr>
                <td colspan="3" style="text-align:center">
                    <input type="submit" value="登录">
                    <input type="reset" value="取消">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>