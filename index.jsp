<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1 style="color:green">
<u><i>Company Share List</i></u>
</h1>
<br/>
<h3 style="color:magenta">
<a href="company-enlist">Enlist a new Company</a>
</h3>
<h3>
<table border="2">
<tr>
<th>COMPANY ID</th>
<th>COMPANY NAME</th>
<th>SHARE PRICE</th>
<th>Actions</th>
</tr>
<c:forEach items="${companyList}" var="companyShare">
<tr>
<td>${companyShare.companyId}</td>
<td>${companyShare.companyName}</td>
<td>${companyShare.sharePrice}</td>
<td>
<a href="edit-company/${companyShare.companyId}">Edit Share Price</a>
&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete-company/${companyShare.companyId}">Delete Company</a>
</td>
</tr>
</c:forEach>
</table>
</h3>
</div>
</body>
</html>