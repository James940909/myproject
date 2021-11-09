<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	function button_signUp(){
		alert('회원가입 완료!');
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


					<!-- Elements -->
					<div class="row 200%">

						<!-- Form -->
						<div class="row uniform">

						<form method="post" action="insertUsers.do" enctype="multipart/form-data">
							<div>
								<h2>회원가입</h2>
							</div>
							<div>
								<input type="file" name="fileUpload" />
							</div>
							<table>
								<tr>
									<td>
										아이디
										<div class="6u 12u$(xsmall)">
											<input type="text" name="id" id="demo-name" value=""
											placeholder="아이디" />
										</div>
									</td>
								</tr>
								<tr>
									<td>
										비밀번호
										<div class="6u 12u$(medium)">
											<input type="password" name="pw" id="demo-name" value=""
											placeholder="비밀번호" />
										</div>
									</td>
								</tr>
								<tr>
									<td>
										비밀번호 확인
										<div class="6u 12u$(medium)">
											<input type="password" name="demo-name" id="demo-name" value=""
											placeholder="비밀번호 확인" />
										</div>
									</td>
								</tr>
								<tr>
									<td>
										이름
										<div class="6u 12u$(medium)">
											<input type="text" name="u_name" id="demo-name" value=""
											placeholder="이름" />
										</div>
									</td>
								</tr>
								<tr>
									<td>
										성별
										<div class="6u$ 12u$(medium)">
											<div class="select-wrapper">
												<select name="u_gender" id="demo-category">
													<option>- 성별 -</option>
													<option value="남성">남성</option>
													<option value="여성">여성</option>
												</select>
											</div>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										신체정보
										<div class="6u 12u$(xsmall)">
											<input type="text" name="u_height" id="demo-name" value=""
											placeholder="키" />
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="6u 12u$(xsmall)">
											<input type="text" name="u_weight" id="demo-name" value=""
											placeholder="몸무게" />
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="12u$">
									<textarea name="demo-message" id="demo-message"
										placeholder="Enter your message" rows="6">
										■ 개인정보의 수집 및 이용목적 회사는 수집한 개인정보를 다음의 목적을 위해 활용합니다.
										- 서비스 제공에 관한, 서비스 제공에 따른 요금정산 콘텐츠 제공 , 구매 및 요금 결제 - 고객
										관리: 고객 서비스 이용에 따른 본인확인 , 개인 식별 , 불량회원의 부정 이용 방지와 비인가 사용 방지 , 가입
										의사 확인 , 불만처리 등 민원처리 , 고지사항 전달 - 마케팅 및 광고에 활용 : 이벤트 등
										광고성 정보 전달, 접속 빈도 파악 또는 회원의 서비스 이용에 대한 통계 ■
										수집하는 개인정보 항목 회사는 정보주체가 고객서비스(상담신청, 상담, 서비스 신청 등)를 이용하기 위하여 고객의
										개인 정보를 제공할 때의 서비스 제공을 위한 필수 정보와, 보다 향상된 서비스 제공을 위한 선택정보를 온라인상
										입력방법을 통하여 수집하고 있습니다. 수집하는 개인정보의 범위는 아래와 같습니다. 개인정보
										수집항목 - 필수항목: 이름, 전화번호 , 이메일, 주소 -자동수집 항목 : 접속로그( 주소,
										전화번호, 결제내역 ) 개인정보 수집방법 정보주체는 웹사이트 또는 서면 절차를 통하여 개인정보처리방침과 이용약관
										각각의 내용을 확인하고 ‘동의’ 또는 ‘동의하지 않는다’ 문구를 선택 할 수 있습니다. 정보 주체가 ‘동의’ 문구를
										선택한 경우에는 개인정보 수집에 동의한 것으로 봅니다.	
									
									</textarea>
										
								</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="6u 12u$(small)">
											<input type="checkbox" id="demo-copy" name="demo-copy">
											<label for="demo-copy">동의</label>
										</div>
										<div class="6u$ 12u$(small)">
											<input type="checkbox" id="demo-human" name="demo-human"
											checked> <label for="demo-human">비동의</label>
										</div>
									</td>
								</tr>
								<tr>
									<td>
										<div class="12u$">
											<ul class="actions">
												<li><input type="submit" value="회원가입" onclick="button_signUp()" class="special" /></li>
												<li><input type="reset" value="Reset" /></li>
											</ul>
										</div>
									</td>
								</tr>
							</table>
							
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