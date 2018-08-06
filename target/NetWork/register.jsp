<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
  <%--<head>--%>
    <%--<title>注册页面</title>--%>
  <%--</head>--%>
  <%--<body>--%>
    <%--<div>--%>
      <%--<form action = "/RegisterServlet" method="post">--%>
        <%--<p>用户名</p><input type = "text" name = "name">--%>
        <%--<p>密码</p><input type = "text" name = "password">--%>
        <%--<p>手机号</p><input type = "text" name = "phone">--%>
        <%--<p>邮箱</p><input type = "text" name = "email">--%>
        <%--<input type="submit" value = "注册">--%>
      <%--</form>--%>
    <%--</div>--%>
  <%--</body>--%>
<%--</html>--%>
<html>
<head>
  <meta charset="UTF-8">
  <title>注册一个新用户</title>
  <link type="text/css"  href="common/css/register.css" rel="stylesheet"/>
  <link type="text/css"  href="common/css/reset.css" rel="stylesheet"/>
  <script type="text/javascript" src="common/js/register.js"></script>
</head>
<body>
<div class="title">
  <div class="nav">
    <div class="publicwidth">
      <div class="logo fl ">
      </div>
      <div class="nav_list ">
        <li>
          <a href="#">帮助</a>
        </li>
        <li>
          <a href="#">问题反馈</a>
        </li>
        <li>
          <a href="index.html">返回首页</a>
        </li>
      </div>
    </div>
  </div>
</div>
<div class="main">
  <div class="publicwidth">
    <div class="form2_header">
      <p>注册一个新用户</p>
    </div>
    <div class="form2">
      <p class="p1">欢迎注册</p>
      <p class="p2 ">————新日从此启，便知天下闻。</p>
      <form action = "/RegisterServlet" method="post">
        <span>用户名</span>
        <input placeholder="请设置用户名" id="username" name = "name"/>
        <span>密码</span><input  placeholder="请设置登陆密码" type = "password" name = "password" id="password1">
        <span>确认密码</span><input placeholder="请再次输入密码" type = "password" id="password2" onblur="showwarming()" onfocus="hidewarming()"/>
        <div id="warming">
          <p>请确认密码！</p>
        </div>
        <span>手机号</span><input  placeholder="可用于找回密码" name = "phone" id="phonenumber"
            onblur="testphonenum()" onfocus="turnoffwarming()"/>
        <div id ="phonewarming">
          <p>请输入正确的手机号</p>
        </div>
        <span>邮箱</span><input  placeholder="用于登陆账户" name = "email"/>
        <div  class="form2btn" >
          <input type="submit" value="点击注册" />
        </div>
        <div class="fr form2img"><img src="common/img/logo.jpg" width="250px" height="250ox"></div>
      </form>
    </div>
  </div>
</div>
</body>
</html>