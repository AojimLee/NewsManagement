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
        <span><a href = "addNews.jsp">添加新闻</a></span>
        <table id = "table">
            <tr>
                <td>识别码</td>
                <td>标题</td>
                <td>种类</td>
                <td>作者</td>
                <td  class="content">内容</td>
                <td>创建时间</td>
                <td>修改时间</td>
                <td>编辑内容</td>
                <td>删除</td>
            </tr>
            <c:forEach items="${list}"  var="test">
                <tr>
                        <td>${test.id}</td>
                        <td>${test.title}</td>
                        <td>${test.type}</td>
                        <td>${test.author}</td>
                        <td class="content">${test.content}</td>
                        <td>${test.time}</td>
                        <td>${test.alterTime}</td>
                    <td>
                        <a href = "/EditorStep1Servlet?id=${test.id}">编辑内容</a>
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


<%--<td><a href = "">${record.type} ${record.title} ${record.time}</a></td>--%>