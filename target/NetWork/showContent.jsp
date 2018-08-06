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
    <%--<title>${record.title}</title>--%>
  <%--</head>--%>
  <%--<body>--%>
  <%--<h1>${record.title}</h1>--%>
  <%--<span>${record.type}</span>--%>
  <%--<span>${record.time}</span>--%>
  <%--<span>${record.author}</span>--%>
  <%--<p>${record.content}</p>--%>
  <%--</body>--%>
<%--</html>--%>
<html>
<head>
  <meta charset="UTF-8">
  <title>${record.title}</title>
  <link href="common/css/specific.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="search">
  <div class="publicwidth">
    <div class="logo fl"></div>
    <p class="fl">聆听世界的声音</p>
  </div>
</div>
<div class="division">
  <div class="publicwidth">
    <p>阅读新闻</p>
  </div>
</div>
<div>
  <div class="publicwidth">
    <div class="Articletitle">
      <h1>${record.title}</h1>
      <p>${record.type}</p>
      <p>${record.author}</p>
      <span>${record.time}</span>
      <p>${record.content}</p>
    </div>
  </div>
</div>
</body>
</html>
