<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="empJoin.em" method="post" name="frm">
	<table border= 1>
		<tr><td>사원번호</td>
		<td>
			<input type="number" name="employeeId" value="${empNo}"/>
		</td></tr>
		<tr><td>사원아이디</td>
		<td>
			<input type="text" name="empUserid">
		</td></tr>
		<tr><td>비밀번호</td>
		<td>
			<input type="password" name="empPw">
		</td></tr>
		<tr><td>비밀번호 확인</td>
		<td>
			<input type="text" name="pwCon">
		</td></tr>
		<tr><td>이름</td>
		<td>
			<input type="text" name="empName">
		</td></tr>
		<tr><td>입사일</td>
		<td>
			<input type="text" name="hireDate">
		</td></tr>
		<tr><td>직무</td>
		<td>
			<input type="text" name="jobId">
		</td></tr>
		<tr><td>연락처</td>
		<td>
			<input type="text" placeholder="010-1234-1234" name="phNumber">
		</td></tr>
		<tr><td>사무실번호</td>
		<td>
			<input type="text" placeholder="02-1234-1234" name="officeNumber">
		</td></tr>
		<tr><td>이메일</td>
		<td>
			<input type="text" name="email">
		</td></tr>
		<tr><td>사무실주소</td>
		<td>
			<input type="text" name="empAddress">
		</td></tr>
		<tr><td colspan="2">
			<input type="submit" value="등록">
		</td></tr>
	</table>
</form>
</body>
</html>