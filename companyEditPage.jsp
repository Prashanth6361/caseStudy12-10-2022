<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1 style="color:red">
<u><i>Share Price updation</i></u>
</h1>
<br/>
<form:form method="post" action="company-edit" modelAttribute="companyRecord">
<h2>
Company Id<form:input type="text" path="companyId" readonly="readonly"/>
<br/><br/>
Company Name:<form:input type="text" path="companyName" readonly="readonly"/>
<br/><br/>
Enter New Share Price:<form:input type="text" path="sharePrice"/>
<br/><br/>
<button type="submit">Submit</button>
<br/><br/>
</h2>
</form:form>
</div>
</body>
</html>