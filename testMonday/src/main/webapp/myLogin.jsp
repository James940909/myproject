<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>

<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<script type="text/javascript">
	function button_login(){
		if(data==null){
			alert('해당 회원이 없습니다!');
			history.go(-1);
		}
		else{
			alert('환영합니다!');
		}
	}
</script>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<body>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<ul class="icons">
						<li><a href="#" class="icon fa-twitter"><span
								class="label">Twitter</span></a></li>
						<li><a href="#" class="icon fa-facebook"><span
								class="label">Facebook</span></a></li>
						<li><a href="#" class="icon fa-snapchat-ghost"><span
								class="label">Snapchat</span></a></li>
						<li><a href="#" class="icon fa-instagram"><span
								class="label">Instagram</span></a></li>
						<li><a href="#" class="icon fa-medium"><span
								class="label">Medium</span></a></li>
					</ul>
				</header>

				<!-- Content -->
				<section>


					<!-- Elements -->
					<div class="row 200%">

						<!-- Form -->

						<form method="post" action="myLogin.do">
							<div>
								<h2>로그인</h2>
							</div>
							<div class="row uniform">

								<div class="6u 12u$(xsmall)">
									<input type="text" name="id" placeholder="아이디" />
								</div>

								<!-- <div class="6u 12u$(xsmall)">
																<div class="select-wrapper">
																	<select name="demo-category" id="demo-category">
																		<option value="">- 이메일선택 -</option>
																		<option value="">@naver.com</option>
																		<option value="">@nate.com</option>
																		<option value="">@daum.com</option>
																		<option value="">@google.com</option>
																	</select>
																</div>
															</div> -->
								<div class="6u 12u$(medium)">
									<input type="password" name="pw" placeholder="비밀번호" />
								</div>
								<!-- Break -->
								<div class="12u$">
									<ul class="actions">
										<li><input type="submit" id="myLogin" value="로그인" onclick="button_login()" class="special" /></li>
										<li><a href="signUp.jsp">회원가입</a></li>
									</ul>
								</div>
							</div>
						</form>


					</div>

				</section>



			</div>
		</div>

		<!-- Sidebar -->
		<c:choose>
			<c:when test="${userInfoData!=null}">
				<mytag:sidebar />
			</c:when>
		</c:choose>

		<c:choose>
			<c:when test="${userInfoData==null}">
				<mytag:guestSidebar />
			</c:when>
		</c:choose>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>

</body>
</html>