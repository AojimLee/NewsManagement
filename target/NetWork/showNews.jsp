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
    <%--<title>新闻</title>--%>
  <%--</head>--%>
  <%--<body>--%>
  <%--<ul>--%>
    <%--<c:forEach items="${list}"  var="test">--%>
      <%--<li>【${test.type}】${test.time}<a href = "/ShowContentServlet?id=${test.id}">${test.title}</a></li>--%>
    <%--</c:forEach>--%>
  <%--</ul>--%>
  <%--</body>--%>
<%--</html>--%>
<html>
<head>
  <meta charset="UTF-8">
  <title>classify</title>
  <meta name="viewport" content="width=device-width,height=device-height,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <link type="text/css" rel="stylesheet" href="common/css/classify.css" />
  <link type="text/css" rel="stylesheet" href="common/css/reset.css" />
</head>
<body>
<div class="search">
  <div class="publicwidth">
    <div class="logo fl"></div>
    <p class="fl">聆听世界的声音</p>
  </div>
</div>
<div >
  <div class="publicwidth">
    <div class="type">
      <p>综合</p>
    </div>
    <div class="news_list">
      <ul>
        <c:forEach items="${list}"  var="test">
          <li>【${test.type}】<span>${test.time}</span><a href = "/ShowContentServlet?id=${test.id}">${test.title}</a></li>
        </c:forEach>
      </ul>
    </div>
  </div>
</div>
<div class="foot">
  <div class="publicwidth">
    <p class="fl">&nbsp;&nbsp;&nbsp;&nbsp;&copy;2018-07-31 恒之工作室</p>
  </div>
</div>
</body>
</html>