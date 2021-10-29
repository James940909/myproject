<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>

<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
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
										<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
										<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
										<li><a href="#" class="icon fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
										<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
										<li><a href="#" class="icon fa-medium"><span class="label">Medium</span></a></li>
									</ul>
								</header>

							<!-- Content -->
								<section>
									

									<!-- Elements -->
										<div class="row 200%">
											
												<!-- Form -->

													<form method="post" action="updateUsers.do">
														<div>
															<h2>회원정보변경</h2>
														</div>
														
														
														<div class="row uniform">
															<ul>아이디</ul>
															<div class="6u 12u$(xsmall)">
																<input type="text" name="demo-name" id="demo-name" value="${ userInfoData.id }" placeholder="아이디" />
															</div>
															<div class="6u$ 12u$(xsmall)">
																<div class="select-wrapper">
																	<select name="demo-category" id="demo-category">
																		<option value="">- 이메일선택 -</option>
																		<option value="1">@naver.com</option>
																		<option value="1">@nate.com</option>
																		<option value="1">@daum.com</option>
																		<option value="1">@google.com</option>
																	</select>
																</div>
															</div>
															
															
															<ul>비밀번호</ul>
														
															
															<div class="6u 12u$(xsmall)">
																<input type="password" name="demo-name" id="demo-name" value="${ userInfoData.pw }" placeholder="비밀번호" />
															</div>
															
															<div class="6u 12u$(xsmall)">
																<input type="password" name="demo-name" id="demo-name" value="${ userInfoData.pw }" placeholder="비밀번호 확인" />
															</div>
															
															<ul>성별</ul>
															<div class="6u 12u$(xsmall)">
																<div class="select-wrapper">
																	<select name="demo-category" id="demo-category">
																		<option>${ userInfoData.u_gender }</option>
																		<option value="">남성</option>
																		<option value="">여성</option>
																	</select>
																</div>
															</div>
															<ul>몸상태</ul>
															<div class="6u 12u$(xsmall)">
																<input type="text" name="demo-name" id="demo-name" value="${ userInfoData.u_height }" placeholder="키" />
															</div>
															<div class="6u 12u$(xsmall)">
																<input type="text" name="demo-name" id="demo-name" value="${ userInfoData.u_weight }" placeholder="몸무게" />
															</div>
															<div class="6u 12u$(xsmall)">
																<input type="text" name="demo-name" id="demo-name" value="${ userInfoData.id }" placeholder="하루 권장 칼로리" readonly/>
															</div>
															<!-- Break -->
															<div class="12u$">
																<ul class="actions">
																	<li><input type="submit" value="변경하기" class="special" /></li>
																	<li><input type="reset" value="다시 작성" /></li>
																</ul>
															</div>
														</div>
													</form>
											
											
										</div>

								</section>
								
								

						</div>
					</div>

				<!-- Sidebar -->
					<mytag:sidebar />

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>