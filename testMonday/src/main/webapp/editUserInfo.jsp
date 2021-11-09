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
														<div>
															<a class="image"><img alt="프로필사진" src="images/${userInfoData.u_profile}" style="width:500px; height:400px;"></a>
														</div>
														<br>
														<div class="row uniform">
															<table>
															
															
															<tr>
																<td>
																	<div class="6u 12u$(xsmall)">
																		아이디
																		<input type="text" name="demo-name" id="demo-name" value="${ userInfoData.id }" placeholder="아이디" />
																	</div>
																</td>
															</tr>
															
															<tr>
																<td>
																	<div class="6u 12u$(xsmall)">
																		비밀번호
																		<input type="password" name="demo-name" id="demo-name" value="${ userInfoData.pw }" placeholder="비밀번호" />
																	</div>
																</td>
															</tr>
															
															<tr>
																<td>
																	<div class="6u 12u$(xsmall)">
																		비밀번호 확인
																		<input type="password" name="demo-name" id="demo-name" value="${ userInfoData.pw }" placeholder="비밀번호 확인" />
																	</div>
																</td>
															</tr>
															
															<tr>
																<td>
																	이름
																	<input type="text" name="demo-name" id="demo-name" value="${ userInfoData.u_name }" placeholder="이름" />
																</td>
															</tr>
															
															<tr>
																<td>
																	성별
																	<div class="6u 12u$(xsmall)">
																		<div class="select-wrapper">
																			<select name="demo-category" id="demo-category">
																				<option>${ userInfoData.u_gender }</option>
																				<option value="">남성</option>
																				<option value="">여성</option>
																			</select>
																		</div>
																	</div>
																</td>
															</tr>
															
															<tr>
																<td>
																	<div class="6u 12u$(xsmall)">
																		신체 정보
																		<div class="6u 12u$(xsmall)">
																			<input type="text" name="demo-name" id="demo-name" value="${ userInfoData.u_height }" placeholder="키" readonly/>
																			<input type="text" name="demo-name" id="demo-name" value="${ userInfoData.u_weight }" placeholder="몸무게" />
																		</div>
																	</div>
																</td>
															</tr>
															<!-- Break -->
															<tr>
																<td>
																	<div class="12u$">
																		<ul class="actions">
																			<li><input type="submit" value="변경하기" class="special" /></li>
																			<li><input type="reset" value="다시 작성" /></li>
																		</ul>
																	</div>
																</td>
															</tr>
														</table>
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