<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function newUser(){
		window.open("insertUser.html","회원가입","width=500, height=200");
	}
</script>
</head>
<body>

<ol>
	<li><a href="control.jsp?action=main">전체목록보기</a></li>
</ol>

<ol>
	<li><a href="javascript:newUser()">회원가입</a></li>
</ol>

<ol>
	<li><a href="control.jsp?action=main&mcnt=${mcnt+1}&selUser=${selUser}">펼쳐보기</a></li>
</ol>

<hr>

<mytag:login /> 

<h2>전체목록</h2>
<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.m}"/>
	<h3>[${m.userid}] ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글 ${m.replycount}]<mytag:delete type="deleteM" mid="${m.mid}" userid="${m.userid}" /></h3>
	
		<form method="post" action="control.jsp">
			<input type="hidden" name="action" value="newrp">
			<input type="hidden" name="userid" value="${seUser}">
			<input type="hidden" name="mid" value="${m.mid}">
			
			<mytag:insert type="rmsg" />

			<input type="hidden" name="mcnt" value="${mcnt}">
			<input type="hidden" name="selUser" value="${selUser}">	
		</form>
		
		<ol><c:forEach  var="r" items="${v.rlist}">
			<li>${r.userid} >> ${r.rmsg}<mytag:delete type="deleteR" rid="${r.rid}" userid="${r.userid}" /></li>
		</c:forEach></ol>
		
		
</c:forEach>


<form method="post" action="control.jsp">
	<input type="hidden" name="action" value="newmsg">
	<input type="hidden" name="userid" value="${seUser}">
	<mytag:insert type="msg" />
	<input type="hidden" name="mcnt" value="${mcnt}">
	<input type="hidden" name="selUser" value="${selUser}">
</form>




</body>
</html>