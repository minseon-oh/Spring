<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {border: 1px solid #777}
	tr td {width: 120px; border: 1px solid #777 ; height: 50px ; text-align: center ;padding: 0px 10px}
</style>
</head>
<body>
<h2 align = "center"> [ ${id } ] 회원가입 완료</h2>
<h3 align = "center"> [ ${id } ]님의 가입정보</h3>
	
	<table align ="center">
		<tbody>
		<tr>
				<td><b>ID</b></td>
				<td>${id}</td>
		</tr>
		<tr>
				<td><b>PW</b></td>
				<td>${pw}</td>
		</tr>
		<tr>
				<td><b>NAME</b></td>
				<td>${name}</td>
		</tr>
		<tr>
				<td><b>EMAIL</b></td>
				<td>${email}</td>
		</tr>
	
		</tbody>
	</table>
</body>
</html>