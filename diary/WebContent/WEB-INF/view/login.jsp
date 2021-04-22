<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<!-- 로그인 전 -->
	<c:if test="${sessionMember == null}">
		<h1>login</h1>
		<form action="${pageContext.request.contextPath}/login" method="post">
		<div>
			<div>ID: </div>
			<div><input type="text" name="memberId" value="goodee@naver.com"></div>
			<div>PW: </div>
			<div><input type="password" name="memberPw" value="1234"></div>
			<div><button type="submit">로그인</button></div>
		</div>
		</form>
		<div>
			<a href="${pageContext.request.contextPath}/insertMember">회원가입</a>
		</div>
	</c:if>
	<!-- 로그인 후 -->
	<c:if test="${sessionMember != null}">
		<div>${sessionMember.memberId} 님 반값습니다.</div>
		<div><a href="/auth/">다이어리</a></div>
		<div><a href="${pageContext.request.contextPath}/auth/updateMemberPw">비밀번호 변경</a></div>
		<div><a href="${pageContext.request.contextPath}/auth/logout">로그아웃</a></div>
	</c:if>
</body>
</html>