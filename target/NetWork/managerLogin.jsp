<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 2018/7/29
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
  <%--<title>管理员登陆页面</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action = "/ManagerLoginServlet" method = "post">--%>
  <%--<p>账户</p><input type = "text" name = "email">--%>
  <%--<p>密码</p><input type = "password" name = "password">--%>
  <%--<input type="submit" value = "登陆">--%>
<%--</form>--%>
<%--&lt;%&ndash;前台传参   email、password&ndash;%&gt;--%>
<%--<span>${wrongWarning}</span>--%>
<%--</body>--%>
<%--</html>--%>
<html>
<head>
  <meta charset="UTF-8">

  <title>登陆到用户</title>
  <meta name="viewport" content="width=device-width,height=device-height,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link type="text/css" href="common/css/reset.css" rel="stylesheet" />
  <link type="text/css" href="common/css/login.css" rel="stylesheet" />
</head>

<body>
<div class="title">
  <div class="nav">
    <div class="publicwidth">
      <div class="logo fl ">
        <!--<img src="img/logo2.jpg" width="180px" height="55px"/>-->
      </div>
      <div class="nav_list ">
        <li>
          <a href="#">更多</a>
        </li>
        <li>
          <a href="#"></a>
        </li>
        <li>
          <a href="index.jsp">返回首页</a>
        </li>
      </div>
    </div>
  </div>
</div>
<!--这里开始注册页面的主体部分-->
<div class="mainbox">
  <div class="publicwidth">
    <div class="fr" id="form">
      <div class="form_header">
        <button onclick="switchform()" >普通登陆</button>
        <button onclick="switchform2()" >管理员登陆</button>
      </div>
      <form action = "/LoginServlet" method = "post">
        <div id="warming">
          <p>邮箱或密码不能为空！</p>
        </div>
        <div class="inputbox">
          <input placeholder="邮箱" name = "email" value="" id="input1" onblur="showwarming()" onfocus="hidewarming()" />
        </div><br />
        <div class="inputbox">
          <input placeholder="密码" name = "password" value="" id="input2" onblur="showwarming()" onfocus="hidewarming()" />
        </div>
        <div class="btnbox">
          <input type="submit" value="立即登陆" />
        </div>
      </form>
      <span>${wrongWarning}</span>
      <div class="fr getnewuser">
        <a href="register.jsp">注册用户</a>
      </div>
    </div>
    <div class="fr" id="form2" style = "display:none;">
      <div class="form_header">
        <button onclick="switchform()">普通登陆</button>
        <button onclick="switchform2()">管理员登陆</button>
      </div>
      <form action = "/ManagerLoginServlet" method = "post">
        <div id="warming">
          <p>邮箱或密码不能为空！</p>
        </div>
        <div class="inputbox">
          <input placeholder="管理员账号" name = "email" value="" id="input1" onblur="showwarming()" onfocus="hidewarming()" />
        </div><br />
        <div class="inputbox">
          <input placeholder="管理员密码" name = "password" value="" id="input2" onblur="showwarming()" onfocus="hidewarming()" />
        </div>
        <div class="btnbox">
          <input type="submit" value="立即登陆" />
        </div>
      </form>
      <span>${wrongWarning}</span>
    </div>

    <script type="text/javascript">
        function switchform(){
            document.getElementById("form").style.display = "block";
            document.getElementById("form2").style.display = "none";
        }
        function switchform2(){
            document.getElementById("form2").style.display = "block";
            document.getElementById("form").style.display = "none";
        }
    </script>
    <div class="bgimg fl">
      <img src="common/img/img2.jpg " width="520px" height="400px" />
    </div>

  </div>
</div>

<div class="publicfooter">
  <div class="publicwidth">
    <div class="foot">
      <div class="foot_list fl">
        <ul>
          <li>
            <a href="#">关于我们</a>
          </li>
          <li>|</li>
          <li>
            <a href="#">服务条款</a>
          </li>
          <li>|</li>
          <li>
            <a href="#">联系我们</a>
          </li>
          <li>|</li>
          <li>
            <a href="#">帮助中心</a>
          </li>
        </ul>
      </div>
      <p class="fl">&nbsp;&nbsp;&nbsp;&nbsp;&copy;2018-07-31 恒之工作室</p>

    </div>
  </div>
</div>

<script type="text/javascript">
    function showwarming() {
        var a = document.getElementById("input1").value;
        var b = document.getElementById("input2").value;

        if(a == "" || b == "") {
            document.getElementById("warming").style.visibility = "visible";
        }
    }
    function hidewarming() {
        document.getElementById("warming").style.visibility = "hidden";
    }
</script>
</body>
</html>