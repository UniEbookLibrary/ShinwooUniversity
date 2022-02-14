<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="book.model.vo.BookDetail"%>
<% 
	BookDetail b = (BookDetail)request.getAttribute("bookDetail");
%>
<!doctype html>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>도서 상세</title>
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
        
        #homeNav{padding-left: 150px; padding-top: 15px;}
        #homeNav>a{color: #666;}
        .bookInfo{padding-left: 150px; padding-top: 25px; position: relative;}
        #detail_simple{position: relative;}
        #detail_simple>a{position: absolute;}
        #ebookTag{
        	cursor: default;
        	font-size: 13px;
	        text-align: center; 
	        width: 75px; 
	        height: 23px; 
	        color: white; 
	        background: rgba(102, 102, 102, 0.7); 
	        z-index: 999;
        }
        #bookName{
        	padding-left: 330px; 
        	text-decoration: none; 
        	margin-bottom: 30px;
        }
        #title{color: black; margin-bottom: 0px;}
        .simpleInfo{
        	font-size: 13px; 
        	color: #666;
        	cursor: default;
        }
        #epub{
        	text-align: center;
        	display: inline-block;
        	width: 40px;
        	border-radius: 5px;
        	font-size: 8px; 
        	background: lightgray; 
        	color: black;
        	cursor: default;
        }
        #borrow{
        	text-align: center;
        	display: inline-block;
        	width: 120px;
        	height: 42px;
        	padding-top: 10px;
        	padding-bottom: 10px;
        	margin-top: 25px;
        	border-radius: 5px;
        	background: #6785FF;
        	color: white;
        	font-size: 15px;
			font-weight: bold;
			cursor: pointer;
			border: 1px solid dimgray;
        }
        #count{
        	display: inline-block;
        	text-align: center;
        	margin-left: 15px;
        	padding-top: 10px;
        	padding-bottom: 10px;
        	padding-left: 10px;
        	padding-right: 10px;
        	border-radius: 5px;
        	border: 1px solid gray;
        	font-size: 15px;
         	font-weight: bold;
         	background: lightgray;
        	color: dimgray;
        	cursor: default;
        }
        #tabBar{
        	position: relative; 
        	display: inline-block; 
        	text-align: center; 
        	margin: 0 auto;}
        #barLi{list-style: none; display: inline-block; margin: 0 auto;}
        #tab1{float: left;}
        #bookIntro{
        	display: inline-block; 
        	width: 100px;
        	padding-top: 7px;
        	padding-bottom: 7px;
        	float: left;
        	background: #6785ff;
        	color: white;
        	font-weight: bold;
        	
        	border-radius: 5px;
        	cursor: default;
        }
        #contents{
        	background: #f8f8f8;
        	color: dimgray;
        }
        #bookIntro{border: 2px solid lightgray;}
        #introduce{
        	margin-top: 30px;
        	margin-left: 150px;
        	margin-right: 150px;
        	display: flex;
  			justify-content: center;
        	padding-bottom: 25px;
        	text-align: left;
        	color: dimgray;
        	border: 0px;
        }
        #separate{
        	text-align: center;
        	margin: 0px auto;
        	width: 1000px;
        	color: #6785ff;
        }
        hr{border-bottom: #888;}
        #imgFile{
        	height: 218px;
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
                <h2 id="currentMenu">상세 보기</h2>
            </div>
        </div>

        <!--? Start Align Area -->
        <div class="whole-wrap">
            <div class="container box_1170">
                <div class="section-top-border">
                    <div class="row">
                        <div id="homeNav">
			    			<a id="btn_home" href="<%= request.getContextPath() %>/searchBook.sr" role="button">전체</a> &gt; 
			    			<a id="btn_category" role="button" name="category" href="<%= request.getContextPath() %>/searchBook.sr?categoryNo=<%= b.getCategoryNo() %>"><%= b.getCategoryName() %></a> &gt; <a>상세보기</a>
			    		</div>
			    	</div>
				   	<hr>
					<div class="row">
					   	<div id="detail_simple" class="bookInfo">
					   		<a id="bookImg"><img id="imgFile" src="<%= request.getContextPath() %>/image/<%= b.getChangeName() %>"></a>
					   		<a id="ebookTag">전자책</a>
					   	</div>
					   	<div id="bookName">
					   		<h4 id="title" name="bookTitle"><b><%= b.getBookTitle() %></b></h4>
					   		<input type="hidden" id="bookNo" name="bNo" value="<%= b.getBookNo() %>">
					   		<br>
					   		<hr style="margin-top: 0px; margin-bottom: 10px; width: 250px;">
					   		<span class="simpleInfo"><b>글쓴이 &nbsp;&nbsp; </b></span><span class="simpleInfo" id="author"><%= b.getAuthor() %></span>
					   		<br>
					   		<span class="simpleInfo"><b>출판사 &nbsp;&nbsp; </b></span><span class="simpleInfo" id="publisher"><%= b.getPublisher() %></span>
					   		<br>
					   		<span class="simpleInfo"><b>출간일 &nbsp;&nbsp; </b></span><span class="simpleInfo" id="release"><%= b.getReleaseDate() %></span>
					   		<br>
					   		<span class="simpleInfo"><b>제공형태: &nbsp;&nbsp;</b></span><span id="epub">ePUB</span>
					   		<br>
					   		<button id="borrow">대출하기</button>
				   			<input type="hidden" name="rId" value="">
					   		<div id="count">대출   &nbsp;&nbsp; <span id="currentNum"><%= request.getAttribute("currBorrow") %></span> / <%= request.getAttribute("max") %></div>
					   	</div>
					   		<br><br>
					   	<div id="tabBar" class="bookInfo">
					 		<span id="bookIntro">책 소개</span><br>
					   	</div>
					   	<fieldset>
						   	<hr id="separate">
							<div id="introduce" name="bookProfile">
								<% if(b.getBookInfo() != null) { %>
									<%= b.getBookInfo() %>
								<% } else { %>
									해당 도서 정보가 없습니다.
								<% } %>
							</div>
							<br>
					   	</fieldset>
                    </div>
                </div>
            </div>
        </div>
   		<script>
   			$('#borrow').click(function(){
   				alert('로그인 후 이용해주세요.');
   				location.href='<%= request.getContextPath() %>/loginForm.me';
   			});
   		</script>
        <!-- End Align Area -->
    </main>
	<%@ include file="../common/footer.jsp"%>
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

</body>

</html>