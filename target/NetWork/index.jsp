<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 2018/7/29
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html>--%>
  <%--<head>--%>
    <%--<title>新闻网站后台管理页面</title>--%>
  <%--</head>--%>
  <%--<body>--%>
  <%--<a href = "login.jsp">登录</a>--%>
  <%--<a href = "register.jsp">注册</a>--%>
  <%--<a href = "/ShowByTypeServlet?type=音乐">音乐</a>--%>
  <%--<form action = "/SearchServlet" method = post>--%>
    <%--<input type="text" name = "search">--%>
    <%--<input type = "submit" value = "查询">--%>
  <%--</form>--%>
  <%--<ul>--%>
    <%--<c:forEach items="${list1}"  var="test1">--%>
      <%--<li><a href ="/ShowContentServlet?id=${test1.id }"><img src = "${test1.src}">${test1.title}</a></li>--%>
    <%--</c:forEach>--%>

    <%--<c:forEach items="${list2}"  var="test2">--%>
      <%--<li><a href ="/ShowContentServlet?id=${test2.id }">${test2.title}${test2.time}</a></li>--%>
    <%--</c:forEach>--%>
  <%--</ul>--%>
  <%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width,height=device-height,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

  <title>欢迎使用本系统</title>

  <link type="text/css" href="common/css/index_style.css" rel="stylesheet" />
  <link type="text/css" href="common/css/broadcast.css" rel="stylesheet" />
  <script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.js"></script>
  <script type="text/javascript">
      window.onload = function changelanding(){
          var username = document.getElementById("landing_input").value;
          if(username!=''){
              document.getElementById("unlanding").style.display = "none";
              document.getElementById("landing").style.display = "block";
          }
      }

      function turnoffuser(){
          document.getElementById("landing_input").value = '';
          document.getElementById("unlanding").style.display = "block";
          document.getElementById("landing").style.display = "none";
      }
  </script>
</head>

<body>

<div class="function_list">
  <div class="publicwidth">
    <div class="fr">
      <div id="unlanding">
        <a href="login.jsp">登陆</a>
        <a>&nbsp;&nbsp;|&nbsp;&nbsp;</a>
        <a href="register.jsp">注册</a>
      </div>

      <div id="landing">
        <a onclick="turnoffuser()">退出登陆</a>
        <input  value="${name}" id="landing_input">&nbsp;&nbsp;欢迎您。
        <!--用于用户名的切换-->
      </div>
    </div>

    <div class="fl">
      <a>本站导航</a>
    </div>
  </div>
</div>
<!--首页第一部分，用于登陆和注册-->

<div class="search">
  <div class="publicwidth">
    <form action = "/SearchServlet" method = post>
    <input type="text" name = "search" id="search_input">
    <input type = "submit" value = "查询" class="fr find">
    </form>
    <div class="logo fl"></div>
    <p class="fl">聆听世界的声音</p>
  </div>
</div>

<div class="main">
  <div class="publicwidth">
    <div class="nav_list">
      <ul>
        <li>
          <a href = "/ShowByTypeServlet?type=综合">综合</a>
        </li>
        <li>|</li>
        <li>
          <a href = "/ShowByTypeServlet?type=娱乐">娱乐</a>
        </li>
        <li>|</li>
        <li>
          <a href = "/ShowByTypeServlet?type=历史">历史</a>
        </li>
        <li>|</li>
        <li>
          <a href = "/ShowByTypeServlet?type=旅游">旅游</a>
        </li>
        <li>|</li>
        <li>
          <a href = "/ShowByTypeServlet?type=军事">军事</a>
        </li>
        <li>|</li>
        <li>
          <a href = "/ShowByTypeServlet?type=国际">国际</a>
        </li>

      </ul>
    </div>
    <!--导航条-->
  </div>

  <div class="publicwidth">
    <div class="banner_box">
      <div class="banner_images">
        <div class="banner_img">
          <a href="/ShowContentServlet?id=${list1[0].id }"><img src="${list1[0].src}" alt="bannerOne"></a>
        </div>
        <div class="banner_img">
          <a href="/ShowContentServlet?id=${list1[1].id }"><img src="${list1[1].src}" alt="bannerTwo"></a>
        </div>
        <div class="banner_img">
          <a href="/ShowContentServlet?id=${list1[2].id }"><img src="${list1[2].src}" alt="bannerThree"></a>
        </div>
        <div class="banner_img">
          <a href="/ShowContentServlet?id=${list1[3].id }"><img src="${list1[3].src}" alt="bannerFour"></a>
        </div>
      </div>

      <div class="switcher">
        <p class="prev">←</p>
        <p class="next">→</p>
      </div>

      <ul class="points">
        <li class="point_on"></li>
        <li></li>
        <li></li>
        <li></li>
      </ul>
    </div>
  </div>


  <script type="text/javascript">

      $(function() {
          var img_length = $('.banner_img').length; //图片的张数
          var i = 1;

          function banner() { //轮播函数
              if(i < 0) {
                  i = img_length - 1;
              }
              if(i > img_length - 1) {
                  i = 0;
              }
              $('.banner_images').animate({
                  'left': (-i * 100) + '%'
              });
              $('.points li').eq(i).addClass('point_on').siblings().removeClass();
              i++;
          }
          var banner_timer = setInterval(banner, 3000);

          $('.switcher p').hover(function() { //鼠标移入左右切换箭头清除定时器使轮播停止
              clearInterval(banner_timer);
          }, function() { //鼠标移出切换箭头还原定时器，这里为避免定时器重复 还将定时器赋值给上边定义的banner_timer变量
              banner_timer = setInterval(banner, 3000);
          });

          $('.switcher p').click(function() { //点击左右箭头使图片左右切换
              if($(this).attr('class') == 'prev') {
                  i -= 2;
                  banner();
              } else {
                  i += 2;
                  banner();
              }
          })

          $('.points li').click(function() { //点击相应的焦点跳转到对应图片
              i = $(this).index();
              banner();
          });
      });
  </script>
  <!--轮播图js代码，带有jqury部分-->

  <div class="publicwidth">
    <div class="news2_header fl">
      <p class="fl">新闻故事</p>
      <p class="fr p2"><a href="#">更多&gt;&gt;</a></p>
    </div>

    <div class="news2_main fl">
      <div class="news2_n1">
        <a href="/ShowContentServlet?id=${list1[4].id }"><img src="${list1[4].src}">
          <p>标题:${list1[4].title}</p></a>
      </div>

      <div class="news2_n1">
        <a href="/ShowContentServlet?id=${list1[5].id }"><img src="${list[5].src}">
          <p>标题:${list1[5].title}</p></a>
      </div>

      <div class="news2_n1">
        <a href="/ShowContentServlet?id=${list1[6].id }"><img src="${list1[6].src}">
          <p>标题:${list1[6].title}</p></a>
      </div>


      <div class="news2_n1">
        <a href="/ShowContentServlet?id=${list1[7].id }"><img src="${list1[7].src}">
          <p>标题:${list1[7].title}</p></a>
      </div>
    </div>
    <!--第二部分新闻，在轮播图下，要图片，标题，作者-->
    <div class="news3_header fr">
      <p>新闻列表</p>
    </div>
    <div class="news3_list ">
      <ul>
        <c:forEach items="${list2}"  var="test2">
          <li><a href ="/ShowContentServlet?id=${test2.id }">${test2.title}${test2.time}</a></li>
        </c:forEach>
      </ul>
    </div>
  </div>
  <!--这里开始底部-->
  <div class="footer">
    <div class="publicwidth">
      <p class="fl">&nbsp;&nbsp;&nbsp;&nbsp;&copy;2018-07-31 恒之工作室</p>
    </div>
  </div>
</body>

</html>





















