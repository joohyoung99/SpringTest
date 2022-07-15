<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리 1</title>
</head>
<body>

	<h2>1.JSTL core 변수</h2>
	<c:set var="number1" value="36"/>
	<h5>첫번째 숫자: ${number1 }</h5>
	
	<c:set var="number2" value ="3"/>
	<h5>두번째 숫자 : ${number2 }</h5>
	
	<h2>2.JSTL core 연산</h2>
	
	<h5>더하기: ${number1 + number2 }</h5>
	<h5>빼기: ${number1 - number2 }</h5>
	<h5>곱하기: ${number1 * number2 }</h5>
	<h5>나누기: ${number1 / number2 }</h5>
	
	<h2>3.JSTL core out</h2>
	
	<c:out value="<title>core out</title>"/>
	
	<h2>4.core if</h2>
	<c:set var="average" value="${(number1 + number2)/2}"/>
	<c:if test="${average >= 10 }">
		<h1>${average }</h1>
	</c:if>
	
	<c:if test="${average < 10 }">
		<h3>${average }</h3>
	</c:if>
	
	<h2>5.core if</h2>
	<c:if test="${number1 * number2 > 100 }">
		<c:out value="<script>alert('너무 큰 수 입니다.')</script>" escapeXml="false"/>
	</c:if>
	
	
</body>
</html>