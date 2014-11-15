<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>  
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
${spittleName}
	<sf:form method="delete" action="/spittles">
		<table>
			<tr>
				<td>ID</td>
				<td>
					<input type="text"	name="id">
				</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td>
					<input type="text" name="text">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</sf:form>
</body>
</html>