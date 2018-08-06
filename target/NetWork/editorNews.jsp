<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 2018/7/28
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>提示</title>

  <!--使用ueditor需要导入的js-->
  <script type="text/javascript" src="common/js/ueditor/ueditor.config.js"></script>
  <script type="text/javascript" src="common/js/ueditor/ueditor.all.min.js"></script>
  <script type="text/javascript" src="common/js/ueditor/lang/zh-cn/zh-cn.js"></script>

  <style type="text/css">
    #div_1 {
      border: thin none #069;
      padding: 1px;
      float: none;
      width: 500px;
      height: 300px;
      background-color: #9C6;
    }
  </style>
</head>
<body>
<!-- 加载编辑器的容器 -->
<form action="/EditorStep2Servlet" method="post" >
  <span>作者</span><input type="text" name = "author" value = "${record.author}">
  <span>标题</span><input type="text" name = "title" value = "${record.title}">
  <span>种类</span><input type="text" name = "type" value = "${record.type}">
  <input type="hidden" name = "id" value ="${record.id}">
  <div id="container" name="content" type="text/plain"> </div>
  <input type = "submit" value = "提交">
</form>
<%--<script id="container" name="content" type="text/plain"> </script>--%>
<script type="text/javascript">
    //<!-- 实例化编辑器 -->
    var ue = UE.getEditor('container');

    function test(){
        //获取html内容，返回: <p>hello</p>
        var html = ue.getContent();
        //获取纯文本内容，返回: hello
        var txt = ue.getContentTxt();
        alert(html);
        alert(txt);
    }
</script>
</body>
</html>