<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 2018/7/30
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新闻网站后台管理页面</title>
    <link type = "text/css" href = "common/css/table.css" rel = "stylesheet"/>
</head>
<body>
<center>
    <div>
        <h1>新闻管理</h1>
        <table id = "table">
            <tr>
                <td>识别码</td>
                <td>标题</td>
                <td style = "width:150px;">种类</td>
                <td style = "width:150px;">作者</td>
                <td style = "width:200px;">内容</td>
                <td style = "width:150px;">创建时间</td>
                <td style = "width:150px;">修改时间</td>
                <td>编辑基本信息</td>
                <td>编辑内容</td>
                <td>删除</td>
            </tr>
            <c:forEach items="${list}"  var="test">
                <tr>
                    <form action = "/NewsAlterServlet" method="post">
                        <td><input style = "width: 20px;" type = "text" name = "id" value = ${test.id}>${test.id}</td>
                        <td><input type = "text" name = "title" value = ${test.title}>${test.title}</td>
                        <td><input type = "text" name = "type" value = ${test.type}>${test.type}</td>
                        <td><input type = "text" name = "author" value = ${test.author}>${test.author}</td>
                        <td><input type = "text" name = "content" value = ${test.content}>${test.content}</td>
                        <td>${test.time}</td>
                        <td>${test.alterTime}</td>
                        <td><input type = "submit" value = "编辑基本信息"></td>
                    </form>
                    <td>
                        <a href = "/EditorServlet?id=${test.id}">编辑内容</a>
                    </td>
                    <td>
                        <a href = "/NewsDeleteServlet?id=${test.id}&currentPage=${currentPage}">删除</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
        <div class = "page">
            <span>当前为第${currentPage}页，共${pageAmount}页</span>
            <a href="http://localhost:8080/NewsManagementServlet?currentPage=${currentPage-1}" id="currentPage"><上一页</a>
            <a href="http://localhost:8080/NewsManagementServlet?currentPage=${currentPage+1}" id="currentPage">下一页></a>
            <form>
                跳转至
                <input style = "width:80px;" type ="text" name = currentPage>页
                <input type = "submit" value = "提交">
            </form>
        </div>
    </div>
</center>
</body>
</html>