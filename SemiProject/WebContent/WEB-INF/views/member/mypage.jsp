<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="member.vo.Member" import="member.vo.Member,java.util.ArrayList,review.model.vo.*,reqBook.model.vo.*, bookRental.model.vo.*"%>
<%
	//Member loginUser= (Member)session.getAttribute("loginUser");
 	ArrayList<ReqBook> list = (ArrayList)request.getAttribute("list"); 
 	ArrayList<BookRental> rentalList = (ArrayList)request.getAttribute("rentalList");
%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="./js/jquery-3.6.0.min.js"></script>
<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

<!-- favicon
		============================================ -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
<!-- Google Fonts
		============================================ -->
<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
<!-- Bootstrap CSS
		============================================ -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Bootstrap CSS
		============================================ -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- owl.carousel CSS
		============================================ -->
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/owl.theme.css">
<link rel="stylesheet" href="css/owl.transitions.css">
<!-- animate CSS
		============================================ -->
<link rel="stylesheet" href="css/animate.css">
<!-- normalize CSS
		============================================ -->
<link rel="stylesheet" href="css/normalize.css">
<!-- meanmenu icon CSS
		============================================ -->
<link rel="stylesheet" href="css/meanmenu.min.css">
<!-- main CSS
		============================================ -->
<link rel="stylesheet" href="css/main.css">
<!-- educate icon CSS
		============================================ -->
<link rel="stylesheet" href="css/educate-custon-icon.css">
<!-- morrisjs CSS
		============================================ -->
<link rel="stylesheet" href="css/morrisjs/morris.css">
<!-- mCustomScrollbar CSS
		============================================ -->
<link rel="stylesheet" href="css/scrollbar/jquery.mCustomScrollbar.min.css">
<!-- metisMenu CSS
		============================================ -->
<link rel="stylesheet" href="css/metisMenu/metisMenu.min.css">
<link rel="stylesheet" href="css/metisMenu/metisMenu-vertical.css">

<!-- normalize CSS
		============================================ -->
<link rel="stylesheet" href="css/data-table/bootstrap-table.css">
<link rel="stylesheet" href="css/data-table/bootstrap-editable.css">
<!-- style CSS
		============================================ -->
<link rel="stylesheet" href="style.css">
<!-- responsive CSS
		============================================ -->
<link rel="stylesheet" href="css/responsive.css">
<!-- modernizr JS
		============================================ -->
<script src="js/vendor/modernizr-2.8.3.min.js"></script>

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

<title>마이페이지</title>
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
	
	.firstdiv {
		background: #6785FF;
		height: 100px;
		font-size: 30px;
		text-align: left;
		padding-left: 2.5%;
		padding-top: 20px;
		font-weight: 700;
		color: white;
	}
	
	#personalInf {
		margin-left: 13%;
		margin-right: 13%;
		margin-top: 15px;		
		border: 1px solid #eee;
		padding: 2%;
	}
	
	.borrowed {
		height: 100px;
		padding-left: 10%;
		font-size: 26px;
		padding-top: 40px;
		font-weight: bold;
		color: gray;
	}
	
	.personal {
		font-size: 18px;
		color: black;
	}
	
	.imgdiv {
		text-align: center;
		padding-top: 20px;
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
	
	.card img {
		width: 145px;
	}
	
	.card {
		width: 160px;
	}
	
	.card-title {
		color: black;
		font-size: 20px;
	}
	
	.card-text {
		color: black;
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
		border: none;
 		background: #eee; 
	}
	
	div.card:hover {
		box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px
			rgba(0, 0, 0, 0.22);
		transform: scale(1.08);
		top: 0;
		left: 0;
		opacity: 1;
	}
	
	div.card1:hover {
		box-shadow: 0 0px 0px rgba(0, 0, 0, 0), 0 0px 0px rgba(0, 0, 0, 0);
		transform: scale(1);
		top: 0;
		left: 0;
		opacity: 6;
	}
	
	#my_modal {
		display: none;
		width: 300px;
		padding: 20px 60px;
		background-color: #fefefe;
		border: 1px solid #888;
		border-radius: 3px;
	}
	
	#my_modal .modal_close_btn {
		position: absolute;
		top: 10px;
		right: 10px;
	}
	
	#pwDiv {
		width: 500px;
		display: none;
	}
	
	.row {
		width: 1100px;
		display: inline-block;
	}
	
	.container-fluid {
		width: 100%;
		text-align: center;
	}
	
	.displayDiv {
		font-size: 10;
	}
	
	.rentalList {
		padding: 10px;
	}
	
	.deck-margin {
		margin-left: 15%;
		margin-right: 15%;
	}
	
	.moreInfo{
		background: white;
		border: none;
		float: right;
		color: gray;
	}
	
	.infoBtn{
		margin-left: 18%;
		margin-right: 18%;
		height: 20px;
	}
	
	.whole-wrap{background: white;}
	footer{background: white;}
	a:hover{cursor: pointer;}
	h5:hover{color: #93a7fb;}
	
	.display-2 {
		color: #93a7fb;
		margin-bottom: 20px;
	}
	
	#userPwd{
		background: #f0e9ff;
		border: 1px solid #eee;
	}
	
</style>
</head>
<body>
	<div id="preloader-active">
		<div class="preloader d-flex align-items-center justify-content-center">
			<div class="preloader-inner position-relative">
				<div class="preloader-circle"></div>
				<div class="preloader-img pere-text">
					<img src="assets/img/logo/loder.png" alt="">
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../common/header.jsp"%>
	<main>
		<!--? Hero Start -->
		<div class="slider-area2 section-bg2 hero-overly" style="background-color: #6785FF; height: 100px;">
			<div class="slider-height2 d-flex align-items-center" style="background-color: #6785FF; height: 100px;">
				<h2 id="currentMenu">마이페이지</h2>
			</div>
		</div>
		<div class="whole-wrap">
			<div class="borrowed">
				<i class="fas fa-book"></i>&nbsp;
				대출 도서 목록
			</div>
			<div class="infoBtn">
				<button type="button" onclick="location.href='<%= request.getContextPath() %>/borrowList.br'" class="moreInfo">더 보기 <i class="fas fa-angle-right"></i></button>
			</div>
			<div class="rentalList">

				<% if(rentalList.isEmpty()){ %>
				<div class="card-deck">
					<div style="margin-left: 50px; margin-top: 10px;">
						<p class="personal">아직 대출한 도서가 없습니다.</p>
					</div>

				</div>
				<%}else{ %>
				<div class="card-deck deck-margin">
					<% 		for(int i = 0; i < rentalList.size(); i++){ %>
					<% if(i == 3){ %>
				</div>
				<p></p>
				<div class="card-deck deck-margin">
					<% } %>
					<% String bookT = rentalList.get(i).getBookTitle(); %>
					<div class="card">
						<div class="imgdiv">
							<img src="<%= request.getContextPath() %>/image/<%= rentalList.get(i).getImg() %>" class="card-img-top" alt="...">
						</div>
						<div class="card-body">
							<a href='<%= request.getContextPath() %>/bookDetail.bo?bNo=<%= rentalList.get(i).getBookNo() %>'>
								<h5 class="card-title" <% if(rentalList.get(i).getDateCal() <= 1){ %> id="dday" <%} %>><%= bookT %></h5>
							</a>
							<p class="card-text" <% if(rentalList.get(i).getDateCal() <= 1){ %> id="dday" <%} %> align='center'>
								D-<%= rentalList.get(i).getDateCal() %><br>
								<button type="button" class="genric-btn <%if(rentalList.get(i).getDateCal() <= 1){ %> danger-border <%} else{ %> info-border <%} %>" onclick="returnBtn(<%= rentalList.get(i).getRentalCode() %>, '<%= rentalList.get(i).getBookTitle() %>')">반납하기</button>
							</p>
						</div>
					</div>


					<%} %>
					<% for(int i = 0; i < 6-rentalList.size(); i++){ %>
					<% if(i == 3 - rentalList.size()){ %>
				</div>
				<p></p>
				<div class="card-deck">
					<%} %>
					<div class="card card1"></div>
					<% } %>
				</div>
				<%} %>
				<script>
				   	function returnBtn(rCode, bookName){
				    	var bool = confirm(bookName + "을(를)\n반납하시겠습니까?");
				    	if(bool == true){
					    	$.ajax({
				  				url:'returnBook.br',
				  				data:{rentCode : rCode},
				  				success:function(data){
				  					console.log(data);
				  					if(data.trim()=='1'){
				  						alert('반납되었습니다.');
				  						location.reload();
				  					}else{
				  						alert('반납실패!');
				  					}
				  				},
				  				error:function(data){
				  					console.log(data);
				  					
				  				}
				  			});
				    	}
				   	}
			    </script>
			</div>
				<br>
		<div class="borrowed">
			<i class="fas fa-book"></i>&nbsp;
			신청 도서 목록
		</div>
		<div class="data-table-area mg-b-15">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="sparkline13-list">
							<div class="sparkline13-graph">
								<div class="datatable-dashv1-list custom-datatable-overright">
									<table id="table" data-toggle="table" data-pagination="true" data-search="false" data-show-columns="false" data-show-pagination-switch="false" data-show-refresh="false" data-key-events="false" data-show-toggle="false" data-resizable="false" data-cookie="false" data-cookie-id-table="saveId" data-show-export="false" data-click-to-select="false" data-toolbar="#toolbar" style="text-align: center;">
										<thead style="text-align: center;">
											<tr>
												<th data-field="id">신청번호</th>
												<th data-field="name" data-editable="false">신청도서명</th>
												<th data-field="email" data-editable="false">저자</th>
												<th data-field="phone" data-editable="false">신청일</th>
												<th data-field="task" data-editable="false">승인상태</th>

											</tr>
										</thead>

										<tbody>
											<% if(list.isEmpty()){ %>
											<tr>
												<td colspan="5">아직 신청한 도서가 없습니다.</td>
											</tr>
											<%} else{ %>
											<%		for(int i = 0; i < list.size(); i++){ %>
											<tr>
												<td><%= list.get(i).getReqBookNo() %></td>
												<td><%= list.get(i).getReqBookTitle() %></td>
												<td><%= list.get(i).getReqBookAuthor() %></td>
												<td><%= list.get(i).getReqBookDate() %></td>
												<% String status = null; %>
												<% if(list.get(i).getStatus() == 0){ 
                                                	status = "대기";%>
												<td>
													<a onclick="openInfo('<%= list.get(i).getReqBookPub() %>', '<%= list.get(i).getReqBookContent() %>');">
														<u><%= status %></u>
													</a>
												</td>
												<%    }else if(list.get(i).getStatus() == 1){
                                                		status = "승인";%>
												<td>
													<a onclick="openInfo('<%= list.get(i).getReqBookPub() %>', '<%= list.get(i).getReqBookContent() %>');">
														<u><%= status %></u>
													</a>
												</td>
												<%}else{ 
                                                		status = "거절";%>
												<td>
													<a onclick="window.open('rejectDetail.rb?rno=<%= list.get(i).getReqBookNo() %>', 'rejectDetail', 'width=400, height=200');">
														<u><%= status %></u>
													</a>
												</td>
												<%	}%>



											</tr>
											<%		} %>
											<%} %>
										</tbody>
									</table>
									<script>
                                    	function openInfo(pub, comment){
                                    		alert('출판사 : ' + pub + '\n신청이유 : ' + comment);
                                    	}
                                    </script>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div id="my_modal">
			<br>
			<p>
				<b>거절 사유</b><br> : 이미 소장하고 있는 책임.
			</p>
			<br>
			<a class="modal_close_btn">닫기</a>
		</div>
		<script>
		    function modal(id) {
		        var zIndex = 9999;
		        var modal = $('#' + id);
		
		        // 모달 div 뒤에 희끄무레한 레이어
		        var bg = $('<div>')
		            .css({
		                position: 'fixed',
		                zIndex: zIndex,
		                left: '0px',
		                top: '0px',
		                width: '100%',
		                height: '100%',
		                overflow: 'auto',
		                // 레이어 색갈은 여기서 바꾸면 됨
		                backgroundColor: 'rgba(0,0,0,0.4)'
		            })
		            .appendTo('body');
		
		        modal
		            .css({
		                position: 'fixed',
		                boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',
		
		                // 시꺼먼 레이어 보다 한칸 위에 보이기
		                zIndex: zIndex + 1,
		
		                // div center 정렬
		                top: '50%',
		                left: '50%',
		                transform: 'translate(-50%, -50%)',
		                msTransform: 'translate(-50%, -50%)',
		                webkitTransform: 'translate(-50%, -50%)'
		            })
		            .show()
		            // 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
		            .find('.modal_close_btn')
		            .on('click', function() {
		                bg.remove();
		                modal.hide();
		            });
		    }
		
		    $('#popup_open_btn').on('click', function() {
		        // 모달창 띄우기
		        modal('my_modal');
		    });
	    </script>
		<p>
			<br>
		<div class="borrowed">
			<i class="fas fa-edit"></i>&nbsp;
			개인 정보 수정
		</div>
		<div id="personalInf">
			<h2 class="display-2">
				안녕하세요,
				<%= loginUser.getMemberName().substring(0, 1) + "**" %>님!
			</h2>
			<p class="lead" style="font-size: 12px; color: #93a7fb;">개인 정보 수정은 비밀번호 입력 후 가능합니다.</p>
			<div id="pwDiv">
				<input type="password" name="userPwd" id="userPwd" placeholder="비밀번호 입력">
				<input type="button" id="goModify" class="genric-btn default-border small" value="확인">
			</div>
			<hr class="my-4">
			<br>
			<p class="personal">
				학번 :
				<%= loginUser.getMemberId().substring(0, 4) + "*****" %></p>
			<%
							   String phone = null;
							   if(loginUser.getPhone() == null){
									phone = "미등록";
							   }else{
								    phone = loginUser.getPhone();
							   }
						   %>
			<p class="personal">
				휴대전화 :
				<% if(loginUser.getPhone() != null){%><%= phone.substring(0,3) + "-" + phone.substring(4,5) + "***"+ "-" + phone.substring(7,8) + "***" %>
				<%}else{%><%= phone %>
				<%} %>
			</p>
			<p class="personal">
				이메일 :
				<%= loginUser.getEmail().substring(0,4) + "***" + "@naver.com" %></p>
			<br>
			<a class="genric-btn info-border circle" role="button" href="javascript:confirmPw();">개인 정보 변경</a>


			<script>
		  		function confirmPw(){
		  			alert('개인정보수정을 위해 비밀번호가 필요합니다.\n확인을 누르고 비밀번호를 입력해주세요');
		  			document.getElementById("pwDiv").style.display = 'block';
		  			document.getElementById("userPwd").focus();
		  		}
		  		
		  		$('#goModify').click(function(){
		  			var userPassword = $('#userPwd');
		  			$.ajax({
		  				url:'checkPwd.me',
		  				data:{userPwd : userPassword.val()},
		  				success:function(data){
		  					console.log(data);
		  					if(data.trim()=='1'){
		  						location.href='<%= request.getContextPath() %>/modifyForm.info';
		  					}else{
		  						alert('비밀번호가 틀립니다.');
		  					}
		  				},
		  				error:function(data){
		  					console.log(data);
		  					
		  				}
		  			});
		  		});
		  </script>
		</div>
		</div>
	</main>
	<%@ include file="../common/footer.jsp"%>
	<div id="back-top">
		<a title="Go to Top" href="#">
			<i class="fas fa-level-up-alt"></i>
		</a>
	</div>

	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<!-- bootstrap JS
	============================================ -->
	<script src="js/bootstrap.min.js"></script>
	<!-- wow JS
	
	============================================ -->
	<script src="js/jquery-price-slider.js"></script>
	<!-- meanmenu JS
	============================================ -->
	<script src="js/jquery.meanmenu.js"></script>
	<!-- owl.carousel JS
	============================================ -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- sticky JS
	============================================ -->
	<script src="js/jquery.sticky.js"></script>
	<!-- scrollUp JS
	============================================ -->
	<script src="js/jquery.scrollUp.min.js"></script>
	<!-- mCustomScrollbar JS
	============================================ -->

	<!-- data table JS
	============================================ -->
	<script src="js/data-table/bootstrap-table.js"></script>
	<script src="js/data-table/tableExport.js"></script>
	<script src="js/data-table/data-table-active.js"></script>
	<script src="js/data-table/bootstrap-table-editable.js"></script>
	<script src="js/data-table/bootstrap-editable.js"></script>
	<script src="js/data-table/bootstrap-table-resizable.js"></script>
	<script src="js/data-table/colResizable-1.5.source.js"></script>
	<script src="js/data-table/bootstrap-table-export.js"></script>
	<!--  editable JS
	============================================ -->
	<script src="js/editable/jquery.mockjax.js"></script>
	<script src="js/editable/mock-active.js"></script>
	<script src="js/editable/select2.js"></script>
	<script src="js/editable/moment.min.js"></script>
	<script src="js/editable/bootstrap-datetimepicker.js"></script>
	<script src="js/editable/bootstrap-editable.js"></script>
	<script src="js/editable/xediable-active.js"></script>

	<!-- data table JS
	============================================ -->
	<script src="js/data-table/bootstrap-table.js"></script>
	<script src="js/data-table/tableExport.js"></script>
	<script src="js/data-table/data-table-active.js"></script>
	<script src="js/data-table/bootstrap-table-editable.js"></script>
	<script src="js/data-table/bootstrap-editable.js"></script>
	<script src="js/data-table/bootstrap-table-resizable.js"></script>
	<script src="js/data-table/colResizable-1.5.source.js"></script>
	<script src="js/data-table/bootstrap-table-export.js"></script>


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
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</body>
</html>