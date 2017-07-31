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
<title>DeleteData</title>
</head>
<body>

<% 

 %>
<ul>
<li><p><b>删除名字:</b>
<%
// 解决中文乱码的问题
String name = new String((request.getParameter("name")).getBytes("ISO-8859-1"),"UTF-8");
%>
   <%=name%>
</p></li>
</ul> 
<h>请求信息条已删除</h>
<br>
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8"
     user="root"  password="root"/>
 

<sql:query dataSource="${snapshot}" var="result">
SELECT * from testform;
</sql:query>


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

</body>
</html>