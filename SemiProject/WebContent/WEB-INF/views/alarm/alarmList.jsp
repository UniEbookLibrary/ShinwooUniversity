<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="question.model.vo.Question, alarm.model.vo.*, java.util.ArrayList"%>
<%
	ArrayList<Alarm> aList = (ArrayList)request.getAttribute("aList");
%>
<!doctype html>
<html class="no-js">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>알림</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
		padding-top: 5px;
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
		padding-top: 30px;
		padding-bottom: 30px;
	}
	
	.inquiry, .answer {
		cursor: pointer;
		border: 1px solid #DCDDDD;
		padding: 10px;
	}
	
	.answer {
		display: none;
	}
	
	.writer, .date {
		font-size: 9px;
		color: gray;
	}
	
	#writeQst {
		height: 35px;
		width: 90px;
		border: 0px;
		background: #6785FF;
		border-radius: 20px;
		float: right;
	}
	
	#writeAns {
		height: 35px;
		width: 90px;
		border: 0px;
		background: #6785FF;
		border-radius: 20px;
		float: right;
	}
	
	#insertAns {
		height: 35px;
		width: 90px;
		border: 0px;
		background: #6785FF;
		border-radius: 20px;
		float: right;
	}
	
	.emptyList {
		display: flex;
		justify-content: center;
	}
	
	button:hover {
		cursor: pointer;
	}
	
	#numBtn {
		background: white;
		border: 1px solid #eee;
		color: gray;
	}
	
	#choosen {
		background: #bfccff;
		border: 1px solid #eee;
		color: black;
	}
	
	.pagingArea button {
		background: white;
		color: black;
	}
	
	.listBtn {
		background: #eee;
		border: 1px solid #eee;
		color: gray;
	}
	
	.fa-angle-double-left, .fa-angle-double-right, .fa-angle-left,
		.fa-angle-right {
		color: gray;
	}
	
	button:disabled {
		background: #eee;
		cursor: none;
	}
	
	.ansTextarea {
		width: 100%;
		border: none;
		resize: none;
	}
	
	#inserBtnArea {
		display: none;
	}
	
	.inserBtnArea::after {
		content: '';
		display: block;
		clear: both;
	}
	
	.writeBtnArea::after {
		content: '';
		display: block;
		clear: both;
	}
	
	.writeBtnArea, .inserBtnArea {
		margin-top: 10px;
	}
	
	#ansYN {
		color: red;
		font-weight: bolder;
	}
	
	.req {
		width: 500px;
	}
	
	.statusDiv {
		font-size: 6px;
		margin-left: 50px;
		margin-top: 50px;
	}
</style>
</head>

<body>

	<div class="req">
		<% if (aList.isEmpty()) { %>
		<div class="emptyList">알림이 없습니다.</div>
		<% } else { %>
		<% for(Alarm a : aList) { %>
		<% if(a.getAlarmPt() == 1){ %>
		<div class="inquiry" id="pt1" onclick="confirmAl(<%= a.getAlarmNo() %>);">
			<%}else{ %>
			<div class="inquiry" id="pt2" onclick="confirmAl(<%= a.getAlarmNo() %>);">
				<%} %>
				<input type="hidden" value="<%= a.getAlarmNo() %>">
				<%= a.getAlarmCont() %>

				<br>

			</div>

			<%} %>
			<%} %>

		</div>
	</div>

	<script>
		$('#pt1').mouseenter(function(){
			$(this).css({'background':'lightblue', 'cursor':'pointer'});
		}).mouseout(function(){
			$(this).css({'background':'none'});
		});
		
		$('#pt2').mouseenter(function(){
			$(this).css({'background':'lightgray', 'cursor':'pointer'});
		}).mouseout(function(){
			$(this).css({'background':'none'});
		});
		</script>
	<script>
		function confirmAl(no){
			$.ajax({
  				url:'confirmAlarm.al',
  				data:{alarmNo : no},
  				success:function(data){
  					console.log(data);
  					if(data.trim()=='1'){
  						console.log('확인됨');
  						location.reload();
  					}else{
  					}
  				},
  				error:function(data){
  					console.log(data);
  					
  				}
  			});
		}
	</script>

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

</body>

</html>