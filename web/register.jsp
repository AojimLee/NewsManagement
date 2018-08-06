<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册页面</title>
  </head>
  <body>
    <div>
      <form action = "/RegisterServlet" method="post">
        <p>用户名</p><input type = "text" name = "name">
        <p>密码</p><input type = "text" name = "password">
        <p>手机号</p><input type = "text" name = "phone">
        <p>邮箱</p><input type = "text" name = "email">
        <input type="submit" value = "注册">
      </form>
    </div>
  </body>
</html>
