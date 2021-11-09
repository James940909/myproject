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
<script type="text/javascript">
	function button_delete(url){
		if(confirm("삭제 하시겠습니까?") == true){
			location.href= url;
		}
		else{
			return;
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
						<h1>일일 식단관리</h1>
					</header>

					<!-- Elements -->
					<div class="row 200%">

						<div class="6u 12u$(medium)">
							<!-- Form -->
							<h2>하루식단</h2>

							<form method="post" action="insertDayMeal.do">
								<div class="row uniform">
									<div class="6u 12u$(xsmall)">
										<div class="select-wrapper">
											<select name="d_category" id="d_category">
												<option value="아침">아침</option>
												<option value="점심">점심</option>
												<option value="저녁">저녁</option>
												<option value="식사 외" selected>식사 외</option>
											</select>
										</div>
									</div>

									<!-- Break -->
									<div class="12u$">
										<div class="select-wrapper">
											<select name="d_name" id="d_name">
												<option>- Menu -</option>
												<c:forEach var="ml" items="${mdatas}">
													<option value="${ml.m_name}">${ml.m_name}</option>
												
												</c:forEach>
											</select>
										</div>
									</div>
									
									<div class="6u 12u$(xsmall)">
										<input type="text" name="d_weight" id="demo-name" value=""
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
					
						<div class="6u$ 12u$(medium)">
							<!-- Table -->
							<form method="post" action="totalDayMeal.do?totalKcal=${totalKcal}">
							<h3>Total</h3>
							<div class="table-wrapper">
								<table class="alt">
									<thead>
										<tr>
											<th>Category</th>
											<th>메뉴</th>
											<th>용량</th>
											<th>Kcal</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="m" items="${morning}">
											<tr>
												<td>${m.d_category}</td>
												<td>${m.d_name}</td>
												<td>${m.d_weight}&nbsp;&nbsp;(g/ml)</td>
												<td>${m.d_userskcal}</td>
												<td>
													<input type="button" value="삭제" class="button small" onclick="button_delete('deleteDayMeal.do?d_num=${m.d_num}')"/>
													<input type="button" value="수정" class="button small"/>
												</td>
											<tr>
										</c:forEach>
										<c:forEach var="l" items="${lunch}">
											<tr>
												<td>${l.d_category}</td>
												<td>${l.d_name}</td>
												<td>${l.d_weight}&nbsp;&nbsp;(g/ml)</td>
												<td>${l.d_userskcal}</td>
												<td>
													<input type="button" value="삭제" class="button small" onclick="button_delete('deleteDayMeal.do?d_num=${l.d_num}')"/>
													<input type="button" value="수정" class="button small"/>
												</td>
											<tr>
										</c:forEach>
										<c:forEach var="d" items="${dinner}">
											<tr>
												<td>${d.d_category}</td>
												<td>${d.d_name}</td>
												<td>${d.d_weight}&nbsp;&nbsp;(g/ml)</td>
												<td>${d.d_userskcal}</td>
												<td>
													<input type="button" value="삭제" class="button small" onclick="button_delete('deleteDayMeal.do?d_num=${d.d_num}')"/>
													<input type="button" value="수정" class="button small"/>
												</td>
											<tr>
										</c:forEach>
										<c:forEach var="o" items="${other}">
											<tr>
												<td>${o.d_category}</td>
												<td>${o.d_name}</td>
												<td>${o.d_weight}&nbsp;&nbsp;(g/ml)</td>
												<td>${o.d_userskcal}</td>
												<td>
													<input type="button" value="삭제" class="button small" onclick="button_delete('deleteDayMeal.do?d_num=${o.d_num}')"/>
													<input type="button" value="수정" class="button small"/>
												</td>
											<tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<td colspan="4"></td>
											<td>총칼로리 : ${totalKcal}</td>
										</tr>
									</tfoot>
								</table>
								<div class="12u$">
									<ul class="actions">
										<li><input type="submit" value="등록" class="special" /></li>
									</ul>
								</div>
							</div>
						</form>

						</div>
						
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