<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>로그인</title>
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
      #logintable{
     	font-family: 'Gowun Dodum', sans-serif;
      }
   
      #logintable th{
         color: #93a7fb;
         text-align: left;
         padding-right: 10px;
         
      }
      #text{
         margin-top:-10px;
         color: #93a7fb;
         text-align:right;
         font-size:3px;
         font-weight:bold;
      }
      
      table {
  		margin-left:auto; 
	    margin-right:auto;
	  }
	  
	  #memberBtn {
	  	text-align: center;
	  }
	  
	  #memberEnroll {
	  	float: right;
 	  	width: 70%;
 	  	margin-top: 10px;
	  }
	  
	  #findPwBtn {
	  	padding-top: 10px;
	  	text-align: right;
	  	font-family: 'Gowun Dodum', sans-serif;
	  }
	  
    </style>
</head>

<body>
   <!-- ? Preloader Start -->
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
   <!-- Preloader Start -->
	<%@ include file="../common/header.jsp" %>
	<main>
		<!--? Hero Start -->
		<div class="slider-area2 section-bg2 hero-overly" style="background-color: #6785FF; height: 100px;">
			<div class="slider-height2 d-flex align-items-center" style="background-color: #6785FF; height: 100px;">
				<h3 id="currentMenu">로그인</h3>
			</div>
		</div>
		<br> <br>
		<section>
			<form action="<%=request.getContextPath()%>/login.me" method="post">
				<table id="logintable">
					<tr id="id" height="70px">
						<th>ID</th>
						<td>
							<input type="text" name="userNo" placeholder="학번 입력" onfocus="this.placeholder = ''" onblur="this.placeholder = '학번 입력'" required class="single-input">
						</td>
					</tr>
					<tr id="password">
						<th>Password</th>
						<td>
							<input type="password" name="userPwd" required class="single-input" placeholder="비밀번호 입력" onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호 입력'">
						</td>
					</tr>
					<tr>
						<td colspan="2" id="text">초기 비밀번호는 주민번호 앞자리 8자리 입니다.</td>
					</tr>
					<tr>
						<td colspan="2" id="findPwBtn">	
							<a onclick="location.href='<%=request.getContextPath()%>/findPwdForm.lo'" class="genric-btn link-border small" id="fPwd">비밀번호 찾기</a>
						</td>
					</tr>
				</table>
				<div id="memberBtn">
					<div id="memberEnroll">
						<button class="genric-btn info-border circle" type="submit">로그인</button>
					</div>
				</div>
			</form>
		</section>

	</main>
	<%@ include file="../common/footer.jsp" %>
   <!-- java script -->

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