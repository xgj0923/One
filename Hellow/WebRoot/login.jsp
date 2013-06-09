<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>演示页面</title>
</head>
<body>
<h1>演示Struts2的使用方式</h1>
 <!-- 提交后，转到
         namespace="/day01"
         actionName="welcome"
  -->
<form method="post" action="/Hellow/hellow/test.action">
 姓名:<input name="username" type="text"/>
 <input type="submit" value="提交"/>
</form>










</body>
</html>