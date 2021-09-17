<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
	function newUser(){
		window.open("insertUser.html","회원가입","width=500, height=200");
	}
</script>
</head>
<body>

<div class="myMain">

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

<h4>~~회원 목록~~</h4>
<ol>
	<c:forEach var="u" items="${newUsers}">
		<li><a href="control.jsp?action=main&mcnt=${mcnt}&selUser=${u.userid}">${u.name}</a>님, 환영!!</li>
	</c:forEach>
</ol>

<hr>

<h2>전체목록</h2>
<c:forEach var="v" items="${datas}">
	<c:set var="m" value="${v.m}"/>
	<h3>[${m.userid}] ${m.msg} &gt;&gt; [좋아요 ${m.favcount} | 댓글 ${m.replycount}]<mytag:like mid="${m.mid}" userid="${m.userid}" /><mytag:delete type="deleteM" mid="${m.mid}" userid="${m.userid}" /></h3>
	
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
<hr>
<h2>게시물 등록</h2>
<form method="post" action="control.jsp">
	<input type="hidden" name="action" value="newmsg">
	<input type="hidden" name="userid" value="${seUser}">
	<mytag:insert type="msg" />
	<input type="hidden" name="mcnt" value="${mcnt}">
	<input type="hidden" name="selUser" value="${selUser}">
</form>

</div>

<div class="ad">
	<ul>
		<li><a href="https://map.naver.com/v5/entry/place/1554777942?c=14141583.8008938,4508803.5237554,17,0,0,0,dh"><img alt="광고_킹콩부대찌개" src="img/부대찌개.png" style="width:200px;height:200px;"></a></li>
		<li>&gt;&gt;킹콩 부대찌개</li>
		<li><a href="https://map.naver.com/v5/entry/place/1633831850?c=14141533.5290118,4508891.7102786,16,0,0,0,dh"><img alt="광고_원가네해장국" src="img/해장국.png" style="width:200px;height:200px;"></a></li>
		<li>&gt;&gt;원가네 해장국</li>
		<li><a href="https://www.yanadoo.co.kr/"><img alt="광고_야나두" src="img/야나두.png" style="width:200px;height:200px;"></a></li>
		<li>&gt;&gt;야나두!</li>
	</ul>
</div>

</body>
</html>