<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>菜鸟教程(runoob.com)</title>
</head>
<body>
<h1>HTML跳转到JSP，保存输入信息</h1>
<ul>
<li><p><b>名字:</b>
<%
// 解决中文乱码的问题
String name = new String((request.getParameter("name")).getBytes("ISO-8859-1"),"UTF-8");
%>
   <%=name%>
</p></li>
<li><p><b>年龄:</b>
   <%= request.getParameter("url")%>
</p></li>
</ul>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="root"/>
 
<sql:query dataSource="${snapshot}" var="result">
SELECT * from testform;
</sql:query>
<h1>JSP 数据库实例 - 菜鸟教程</h1>
<table border="1" width="100%">
<tr>
   <th>姓名</th>
   <th>年龄</th>   
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
   <td><c:out value="${row.name}"/></td>
   <td><c:out value="${row.age}"/></td>   
</tr>
</c:forEach>
</table>

<br>

<center>
<form action="Tp22" method="post">  
       <input type="text" name="name" placeholder="请输入要删除的姓名">  
       <input type="submit" value="确1定">  
   </form>
</center>




</body>
</html>