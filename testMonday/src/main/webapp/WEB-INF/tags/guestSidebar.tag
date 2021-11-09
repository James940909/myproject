<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script type="text/javascript">
	function button_warning(){
		if(confirm("로그인 후 이용바랍니다!") == true){
			location.href= "myLogin.jsp";
		}
		else{
			return;
		}
	}
</script>

<div id="sidebar">
	<div class="inner">

		<!-- Search -->
		<section id="search" class="alt">
			<form method="post" action="#">
				<input type="text" name="query" id="query" placeholder="Search" />
			</form>
		</section>

		<!-- Menu -->
		<nav id="menu">
			<header class="major">
				<h2>Menu</h2>
			</header>
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#" onclick="button_warning()">일일 식단등록</a></li>
				<li><a href="#" onclick="button_warning()">나의 식단 이행현황</a></li>
				<li><span class="opener">커뮤니티</span>
					<ul>
						<li><a href="#" onclick="button_warning()">오늘의 랭킹</a></li>
						<li><a href="#" onclick="button_warning()">칼로리 정보</a></li>
					</ul></li>
				<li><span class="opener">User</span>
					<ul>
						<li><a href="myLogin.jsp">로그인</a></li>
						<li><a href="signUp.jsp">회원가입</a></li>
					</ul></li>
			</ul>
		</nav>

		<!-- Footer -->
		<footer id="footer">
			<p class="copyright">
				&copy; Untitled. All rights reserved. Demo Images: <a
					href="https://unsplash.com">Unsplash</a>. Design: <a
					href="https://html5up.net">HTML5 UP</a>.
			</p>
		</footer>

	</div>
</div>
