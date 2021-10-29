<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script type="text/javascript">
	function button_logout(){
		
		if(confirm("로그아웃 하시겠습니까?") == true){
			location.href= "logout.do";
		}
		else{
			return;
		}
	}
	function button_dropOut(url){
		
		if(confirm("회원탈퇴를 하시겠습니까?") == true){
			location.href= url;
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
				<li><a href="insertMeal.do">일일 식단등록</a></li>
				<li><a href="myMealInfo.jsp">나의 식단 이행현황</a></li>
				<li><span class="opener">커뮤니티</span>
					<ul>
						<li><a href="ranking.jsp">오늘의 랭킹</a></li>
						<li><a href="selectAllMeal.do">칼로리 정보</a></li>
						<li><a href="#">게시판</a></li>
					</ul></li>
				<li><span class="opener">User</span>
					<ul>
						<li><a href="#" onclick="button_logout()">로그아웃</a></li>
						<li><a href="editUserInfo.jsp">회원정보 변경</a></li>
						<li><a href="myPage.jsp">Mypage</a></li>
						<li><a href="#" onclick="button_dropOut('deleteUsers.do?u_num=${userInfoData.u_num}')">회원탈퇴</a></li>
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
