<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인 안되었을 때 -->
	<c:if test="${empty authInfo}">
	<form action="login.sm" method="post" name="frm">
	<table border = 1>
		<tr><td colspan="3">아이디 저장 | 자동로그인</td></tr>
		<tr><td>아이디</td>
			<td><input type="text" name="userId"><span>${userFail}</span></td>
			<td rowspan="2">
				<input type="image" src="login.png" width="60" alt="login">
			</td></tr>
		<tr><td>비밀번호</td>
			<td><input type="password" name="userPw"><span>${pwFail}</span></td></tr>
		<tr><td colspan="3">
			<a href="#">아이디</a><a href="#">비밀번호 찾기</a>
			<a href="memAgree.mem">회원가입</a>
		</td></tr>
	</table>
	</c:if>
	</form>
	<!-- 로그인 되었을 때-->
	<c:if test="${!empty authInfo }">
	<c:if test="${authInfo.grade == 1 }">
   <!-- 일반회원 -->
   <a href="myPage.mem">myPage</a>
   </c:if>
	<c:if test="${authInfo.grade != 1 }">
   <!-- 직원 -->
   <!-- 관리자 -->
   <a href="empPage.em">MyPage</a>
   <a href="memList.mem">회원 리스트</a>
   <a href="empList.em">직원 리스트</a>
   </c:if>
   
   

   <a href="logout.sm">logout</a>
</c:if>
</body>
</html>