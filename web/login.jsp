<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 2018/7/29
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登陆页面</title>
  </head>
  <body>
    <form action = "/LoginServlet" method = "post">
        <p>账户</p><input type = "text" name = "email">
        <p>密码</p><input type = "password" name = "password">
        <input type="submit" value = "登陆">
    </form>
  <%--前台传参   email、password--%>
    <san>${wrongWarning}</san>
  </body>
</html>
