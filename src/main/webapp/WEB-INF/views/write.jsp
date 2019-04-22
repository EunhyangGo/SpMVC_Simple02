<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 입력값을 보내주기 위해 필수로 적어야 하는것 
	 근데 아무런 값을 입력하지 않으면 자기자신에게 보내는것과 마찬가지. 즉, 아무 의미 없음
	 method=POST를 입력하면 내가 보내려는 값은 보이지 않게 된다. 반드시 post를 작성해야함
	 그래야지 내용물이 안전하게 감. -->
	<form action="write" method="POST"> 
		<input type="text" name="num1">
		<input type="text" name="op">
		<input type="text" name="num2">
		<button>전송</button>
	</form>
</body>
</html>