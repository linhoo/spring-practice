<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
${spittleName}
	<form method="post" action="/spittles">
		<input type="hidden" name="_method" value="put">
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
	</form>
</body>
</html>