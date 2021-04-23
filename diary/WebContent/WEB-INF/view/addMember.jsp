<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add Memeber Form</title>
</head>
<body>
	<h1>회원가입</h1>
	<div>
		<form action="${pageContext.request.contextPath}/addMember" method="post">
			<div>ID: </div>
			<div><input type="text" name="memberId"></div>
			<div>PW: </div>
			<div><input type="password" name="memberPw"></div>
			<div>
				<button type="submit">회원가입</button>
			</div>
		</form>
	</div>

</body>
</html>