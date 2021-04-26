<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>todoOne</title>
</head>
<body>
<div><a href="${pageContext.request.contextPath}/auth/diary">다이어리</a></div>
	<h1>todoOne</h1>
	
	<div>
		todoTitle : ${todoOne.todoTitle}
	</div>
	<div>
		todoDate : ${todoOne.todoDate}
	</div>
	<div>
		todoContent : ${todoOne.todoContent}
	</div>
	<div>
		todoFontColor : ${todoOne.todoFontColor} <input type="color" value="${todoOne.todoFontColor}" readonly="readonly" disabled="disabled">
	</div>
	
	<div>
		<a href="${pageContext.request.contextPath}/auth/removeTodo?todoNo=${todoOne.todoNo}&todoDate=${todoOne.todoDate}">
			삭제
		</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/auth/modifyTodo?todoNo=${todoOne.todoNo}">
			수정
		</a>
	</div>

</body>
</html>