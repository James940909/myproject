<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>

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
					<header class="main">
						<h2>칼로리를 직접 확인해보세요!</h2>
					</header>

					<!-- Elements -->
					<div class="row 200%">
						<div class="6u$ 12u$(medium)">
							<!-- Table -->
							<h3>칼로리</h3>

							<div class="table-wrapper">
								<table class="alt">
									<thead>
										<tr>
											<th>NO.</th>
											<th>메뉴</th>
											<th>용량</th>
											<th>단위</th>
											<th>Kcal</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="kl" items="${mdatas}">
											<tr>
												<td>${kl.m_num}</td>
												<td>${kl.m_name}</td>
												<td>${kl.m_weight}</td>
												<td>${kl.m_unit}</td>
												<td>${kl.m_kcal}</td>
											</tr>
										</c:forEach>
									</tbody>

								</table>
							</div>

						</div>
					</div>
					
					<div class="row 200%">
						<div class="6u$ 12u$(medium)">
							<ul class="pagination">
								<li><a href="selectAllMeal.do?num=${num-1}" class="button">PREV</a></li>
								<c:forEach var="p" items="${page}">
									<li><a href="selectAllMeal.do?num=${p}" class="${activeValue[p-1]}">${p}</a></li>
								</c:forEach>
								<li><a href="selectAllMeal.do?num=${num+1}" class="button">Next</a></li>
							</ul>
						</div>
					</div>
					<!-- Search -->
					<div class="row 200%">
						<div class="6u$ 12u$(medium)">
							<section id="search" class="alt">
								<form method="post" action="searchMealName.do">
									<input type="text" name="searchName" id="query" placeholder="메뉴명을 입력하세요!" />
									<input type="submit" value="검색" id="query"/>
								</form>
							</section>
						</div>
					</div>
				</section>
				
				
				<c:if test="${userInfoData.id=='admin'}">
					<section>
					<div class="6u 12u$(medium)">
							<!-- Form -->
							<h2>관리자 전용 식단 등록</h2>

							<form method="post" action="insertMeal.do">
								<div class="row uniform">
									
									<div class="6u 12u$(xsmall)">
										<input type="text" name="m_name" id="demo-name" value=""
											placeholder="식단명" />
									</div>
									
									<div class="6u 12u$(xsmall)">
										<input type="text" name="m_weight" id="demo-name" value=""
											placeholder="용량" />
									</div>
									
									<div class="6u 12u$(xsmall)">
										<div class="select-wrapper">
											<select name="m_unit" id="demo-category">
												<option>- 단위 -</option>
												<option value="ml">ml</option>
												<option value="g">g</option>
											</select>
										</div>
									</div>
									
									<div class="6u 12u$(xsmall)">
										<input type="text" name="m_kcal" id="demo-name" value=""
											placeholder="칼로리" />
									</div>

									<!-- Break -->
									<div class="12u$">
										<ul class="actions">
											<li><input type="submit" value="등록" class="special" /></li>
											<li><input type="reset" value="다시작성" /></li>
										</ul>
									</div>
								</div>
							</form>
						</div>
					</section>
				</c:if>



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