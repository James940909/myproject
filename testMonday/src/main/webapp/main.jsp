<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
</head>
<body>

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<c:if test="${userInfoData!=null}">
						<h3>${userInfoData.u_name}님, 환영합니다!</h3>
					</c:if>
					
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

				<!-- Banner -->
				<section id="banner">
					<div class="content">
						<header>
							<h1>
								철저한 식단 <br />관리를 통해, <br />건강을<br /> 유지하세요!
							</h1>
							<p>건강 관리에서 가장 중요한 것은 식단 관리입니다.</p>
						</header>
						<p>저희와 함께 체계적이고 철저한 식단 관리를 성공하고, 새로운 삶을 누리세요!</p>
						<c:if test="${userInfoData!=null}">
							<ul class="actions">
								<li><a href="insertMeal.jsp" class="button big">식단 등록</a></li>
							</ul>
						</c:if>
					</div>
					<span class="image object"> <img src="images/titleimg.jpg"
						alt="메인화면 이미지" />
					</span>
				</section>


				<!-- Section -->
				<section>
					<header class="major">
						<h2>오늘의 건강 뉴스</h2><h3>from Naver</h3>
					</header>
					<div class="posts">
						<c:forEach var="t" items="${title}" varStatus="status" begin="0" end="5">
							<article>
								<a href="${imgUrl[status.index]}" class="image"><img src="${newsImg[status.index]}" alt="썸네일" /></a>
								<h3>${title[status.index]}</h3>
								<p>${content[status.index]}</p>
								
							</article>
						</c:forEach>
						
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