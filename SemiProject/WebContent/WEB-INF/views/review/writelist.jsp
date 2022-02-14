<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.ArrayList, review.model.vo.*, member.vo.*"%>
<% 	ArrayList<Review> list = (ArrayList)request.getAttribute("list");
//Member loginUser= (Member)session.getAttribute("loginUser");
PageInfo pi = (PageInfo)request.getAttribute("pi");
%>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="./js/jquery-3.6.0.min.js"></script>
<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

<!-- CSS here -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="assets/css/slicknav.css">
<link rel="stylesheet" href="assets/css/flaticon.css">
<link rel="stylesheet" href="assets/css/progressbar_barfiller.css">
<link rel="stylesheet" href="assets/css/gijgo.css">
<link rel="stylesheet" href="assets/css/animate.min.css">
<link rel="stylesheet" href="assets/css/animated-headline.css">
<link rel="stylesheet" href="assets/css/magnific-popup.css">
<link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="assets/css/themify-icons.css">
<link rel="stylesheet" href="assets/css/slick.css">
<link rel="stylesheet" href="assets/css/nice-select.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/css/all.min.css">

<title>독후감</title>
<style>
#currentMenu {
	color: white;
	padding: 20px;
	padding-left: 2.5%;
	font-size: 30px;
	font-weight: 700;
}

#login {
	margin: 20px;
}

.reqTitle {
	padding-top: 10px;
	padding-bottom: 3px;
	display: block;
}

.bottomBtn {
	float: right;
	padding-top: 20px;
}

.bottomBtn input {
	margin: 10px;
}

.noneList {
	list-style: none;
}

.fa-check-circle {
	color: #6785FF;
}

.section-top-border {
	padding: 40px;
}

.invId {
	display: none;
}

.firstdiv {
	background: #6785FF;
	height: 130px;
	font-size: 40px;
	text-align: left;
	padding-left: 60px;
	padding-top: 35px;
	font-weight: bold;
	color: white;
}

#personalInf {
	border-radius: 2em;
}

.borrowed {
	background: #d2e2e9;
	height: 100px;
	padding-left: 160px;
	font-size: 30px;
	padding-top: 20px;
	font-weight: bold;
	color: #404040
}

.personal {
	font-size: 20px;
}

.card img {
	width: 145px;
}

.imgdiv {
	text-align: center;
	border-radius: 2em;
}

.borrowed button {
	margin-left: 20px;
	margin-top: -20px;
	font-size: 15px;
}

.bookpage {
	text-align: center;
	margin-top: 40px;
}

.bookp {
	display: inline-block;
}

#ddaydiv {
	background: rgba(255, 0, 0, 0.5);
}

#dday {
	color: red;
}

.card-title {
	font-size: 20px;
}

.card-body {
	text-align: center;
}

.card-body button {
	margin-top: 10px;
}

div.card {
	border-radius: 2em;
	margin-top: 10px;
	opacity: 0.8;
	margin-left: 20px;
	margin-right: 20px;
}

.tableBody {
	height: 60px;
}

th, td {
	vertical-align: middle;
}

td 	{
	cursor: pointer;
}

th.returnBook, td.returnBook {
	text-align: center;
}

.submitDiv1 {
	padding-right: 100px;
	margin-right: 100px;
}

button:hover{cursor: pointer;}
	#numBtn{background: white; border: 1px solid #eee; color: gray;}
	#choosen{background: #bfccff; border: 1px solid #eee; color: black;}
	.pagingArea button{background: white; color: black;}
	.pagingArea {padding: 10px;}
	.listBtn{background: #eee; border: 1px solid #eee; color: gray;}
	.fa-angle-double-left, .fa-angle-double-right, .fa-angle-left, .fa-angle-right{color: gray;}
		
	button:disabled{background: #eee; cursor: default;}
	
	#writeRv{
		height: 35px;
		width: 90px;
		border: 0px;
		background: #6785FF;
		border-radius: 20px;
		float: right;
		color: white;
	}
</style>
</head>
<body>
	<!-- <header><a href ="http://www.naver.com">   신우대학교</a>
		<input type ="submit" value = "로그인" style=" float:right; width : 80px; height : 40px;
		 background-color : #5D5E60; color : white; font-weight : bold; border-radius: 5px;" >
		<a href ="http://www.naver.com"></a>
	</header>
	
	<nav class='bar'>	
		<ul>
			<li class = "header-item"><a href ="http://www.naver.com">도서관 소개</a></li>
			<li class = "header-item"><a href ="http://www.naver.com">도서신청</a></li>
			<li class = "header-item"><a href ="http://www.naver.com">마이페이지</a></li>
		</ul>
	</nav>-->

	<%@ include file="../common/header.jsp"%>
	<main>
		<!--? Hero Start -->
		<div class="slider-area2 section-bg2 hero-overly" style="background-color: #6785FF; height: 100px;">
			<div class="slider-height2 d-flex align-items-center" style="background-color: #6785FF; height: 100px;">
				<h2 id="currentMenu">독후감</h2>
			</div>
		</div>
		<div class="whole-wrap">
			<div class="container box_1170">
				<div class="section-top-border borderTop">
					<div class="row">
						<div>
							<div id="personalInf">
								<table class="table table-hover">
									<thead>
										<tr>
											<th scope="col">제목</th>
											<th scope="col">도서명</th>
											<th scope="col">작성자</th>
											<th scope="col">조회수</th>
											<th scope="col">등록일자</th>
											<% if(loginUser != null && loginUser.getMemberId().equals("admin")){ %>
											<th scope="col">삭제</th>
											<%} %>
										</tr>
									</thead>
									<tbody>

										<% if(list.isEmpty()){ %>
										<tr>
											<th colspan="5">존재하는 독후감이 없습니다.</th>
										</tr>
										<% } else{%>

										<%		String bookName = null;
													for(int i = 0; i < list.size(); i++){ %>
										<tr>
											<% 		if(list.get(i).getBookName().length()>12){
														bookName = list.get(i).getBookName().substring(0, 12);
														}else{
														bookName = list.get(i).getBookName();
														}%>
											<%
															String title = null;
															if(list.get(i).getReviewTitle().length() > 30){
																title = list.get(i).getReviewTitle().substring(0, 30);
															}else{
																title = list.get(i).getReviewTitle();
															}
														%>
											<td class="invId"><%= list.get(i).getReviewNo() %></td>
											<td><%= title %></td>
											<td><%= bookName %></td>
											<td><%= list.get(i).getReviewWriter() %></td>
											<td><%= list.get(i).getViews() %></td>
											<td><%= list.get(i).getReviewDate() %></td>
											<% if(loginUser != null && loginUser.getMemberId().equals("admin")){ %>
											<th><button type="button" class="genric-btn danger-border small" onclick="deleteReview(<%= list.get(i).getReviewNo() %>);">삭제</button></th>
											<script>
													function deleteReview(reviewNo){
												    	var bool = confirm( "정말로 삭제하시겠습니까?");
												    	if(bool == true){
													    	$.ajax({
												  				url:'deleteReviewAdmin.rv',
												  				data:{rNo : reviewNo},
												  				success:function(data){
												  					console.log(data);
												  					if(data.trim()=='1'){
												  						alert('성공적으로 삭제되었습니다.');
												  						location.reload();
												  					}else{
												  						alert('삭제실패!');
												  					}
												  				},
												  				error:function(data){
												  					console.log(data);
												  					
												  				}
												  			});
												    	}
												   	}
												</script>
											<%} %>
										</tr>
										<%		} %>
										<% } %>


	<script>
	    $('td').on("click", function(){
	    	var num = $(this).parent().children().eq(0).text();
	    	location.href='<%= request.getContextPath() %>/detail.rv?rId=' + num;
	    });
    </script>
									</tbody>
								</table>
								<div class="pagingArea" align='center'>
									<!-- 맨처음으로 -->
									<button class="listBtn" id="startBtn" onclick="location.href='<%= request.getContextPath() %>/reviewList.rv?currentPage=1'">
										<i class="fas fa-angle-double-left"></i>
									</button>
									<!-- 이전 페이지로 -->
									<button class="listBtn" id="beforeBtn" onclick="location.href='<%= request.getContextPath() %>/reviewList.rv?currentPage=<%= pi.getCurrentPage()-1 %>'">
										<i class="fas fa-angle-left"></i>
									</button>
									<script>
										if(<%= pi.getCurrentPage() %> <= 1){
											$('#beforeBtn').prop('disabled', true);
										}
									</script>
									<!-- 숫자버튼 -->
									<% for(int p = pi.getStartPage(); p<=pi.getEndPage(); p++){ %>
									<% 		if(p == pi.getCurrentPage()){ %>
									<button class="listBtn" id="choosen" disable><%= p %></button>
									<%		}else{ %>
									<button class="listBtn" onclick="location.href='<%= request.getContextPath() %>/reviewList.rv?currentPage=<%= p %>'"><%= p %></button>
									<% 			} %>
									<% } %>
									<!-- 다음페이지로 -->
									<button class="listBtn" id="afterBtn" onclick="location.href='<%= request.getContextPath() %>/reviewList.rv?currentPage=<%= pi.getCurrentPage()+1 %>'">
										<i class="fas fa-angle-right"></i>
									</button>
									<script>
										if(<%= pi.getCurrentPage() %> >= <%= pi.getMaxPage() %>){
											$('#afterBtn').prop('disabled',true);
										}
									</script>
									<!-- 맨끝으로 -->
									<button class="listBtn" id="endBtn" onclick="location.href='<%= request.getContextPath() %>/reviewList.rv?currentPage=<%= pi.getMaxPage() %>'">
										<i class="fas fa-angle-double-right"></i>
									</button>
								</div>
								<% if(loginUser != null){ %>
								<div id="submitDiv1">
									<div id="submitDiv" align="right">
										<input id="writeRv" type="button" value="작성" onclick="location.href='<%= request.getContextPath() %>/writeReviewForm.rv'">
									</div>
								</div>
								<% } %>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="../common/footer.jsp"%>
	<!-- Scroll Up -->
	<div id="back-top">
		<a title="Go to Top" href="#">
			<i class="fas fa-level-up-alt"></i>
		</a>
	</div>
	<!-- JS here -->
	<script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
	<script src="./assets/js/popper.min.js"></script>
	<script src="./assets/js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script src="./assets/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="./assets/js/owl.carousel.min.js"></script>
	<script src="./assets/js/slick.min.js"></script>
	<!-- One Page, Animated-HeadLin -->
	<script src="./assets/js/wow.min.js"></script>
	<script src="./assets/js/animated.headline.js"></script>
	<script src="./assets/js/jquery.magnific-popup.js"></script>

	<!-- Date Picker -->
	<script src="./assets/js/gijgo.min.js"></script>
	<!-- Nice-select, sticky -->
	<script src="./assets/js/jquery.nice-select.min.js"></script>
	<script src="./assets/js/jquery.sticky.js"></script>

	<!-- counter , waypoint,Hover Direction -->
	<script src="./assets/js/jquery.counterup.min.js"></script>
	<script src="./assets/js/waypoints.min.js"></script>
	<script src="./assets/js/jquery.countdown.min.js"></script>
	<script src="./assets/js/hover-direction-snake.min.js"></script>

	<!-- contact js -->
	<script src="./assets/js/contact.js"></script>
	<script src="./assets/js/jquery.form.js"></script>
	<script src="./assets/js/jquery.validate.min.js"></script>
	<script src="./assets/js/mail-script.js"></script>
	<script src="./assets/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="./assets/js/plugins.js"></script>
	<script src="./assets/js/main.js"></script>
	<script src="./assets/js/all.min.js"></script>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</body>
</html>