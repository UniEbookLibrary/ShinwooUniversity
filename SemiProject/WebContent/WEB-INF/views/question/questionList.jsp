<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="question.model.vo.Question, review.model.vo.PageInfo, java.util.ArrayList"%>
<%
	ArrayList<Question> qList = (ArrayList)request.getAttribute("qList");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	boolean isAdmin = (Boolean)request.getAttribute("isAdmin");
%>
<!doctype html>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>1:1 문의</title>
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
        
        .req{margin-left: 200px; margin-right: 200px;}
        
		.inquiry, .answer{
			cursor: pointer;
			border: 1px solid #DCDDDD;
			padding: 10px;
		}
		.answer{display: none;}
		
		.writer, .date{font-size: 9px; color: gray;}
		
		#writeQst{
			height: 35px;
			width: 90px;
			border: 0px;
			background: #6785FF;
			border-radius: 20px;
			float: right;
		}
		
		#writeAns{
			height: 35px;
			width: 90px;
			border: 0px;
			background: #6785FF;
			border-radius: 20px;
			float: right;
		}
		
		#insertAns{
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
		
		button:hover{cursor: pointer;}
		#numBtn{background: white; border: 1px solid #eee; color: gray;}
		#choosen{background: #bfccff; border: 1px solid #eee; color: black;}
		.pagingArea button{background: white; color: black;}
		.listBtn{background: #eee; border: 1px solid #eee; color: gray;}
		.fa-angle-double-left, .fa-angle-double-right, .fa-angle-left, .fa-angle-right{color: gray;}
		
		button:disabled{background: #eee; cursor: default;}
		
		.ansTextarea {
			width: 100%;
			border: none;
			resize: none;
		}
		
		#inserBtnArea{
			display: none;
		}
		
		.inserBtnArea::after{
			content:'';
   			display:block;
   			clear:both;
		}

		.writeBtnArea::after{
			content:'';
   			display:block;
   			clear:both;
		}
		
		.writeBtnArea, .inserBtnArea{
			margin-top: 10px;
		}
		
		#ansYN {
			color: red;
			font-weight: bolder;
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
                <h2 id="currentMenu">1:1 문의</h2>
            </div>
        </div>

        <!--? Start Align Area -->
        <div class="whole-wrap">
            <div class="container box_1170">
                <div class="section-top-border">
                    <div class="req">
                    	<% if (qList.isEmpty()) { %>
                    		<div class="emptyList">등록된 1:1 문의가 없습니다.</div>
                    	<% } else { %>
                    		<% for(Question q : qList) { %>
                    		<% 		String answer = q.getAnswer() == null ? "아직 답변이 등록되지 않았습니다." : q.getAnswer(); %>
								<div class="inquiry" id="quest_Cont">
									<% if(q.getAns_YN().equals("Y")) { %>
										<span id="ansYN">[답변 완료]</span>
									<%} %>
									<%= q.getQuest_cont() %>
									<input type="hidden" id="quest_No" value="<%= q.getQuest_No() %>">
									<br>
									<span class="writer" id="quest_Id"><%= q.getQuest_name() %></span>&nbsp;<span class="date" id="quest_Date"><%= q.getQuest_date() %></span>
								</div>
								<div class="answer" id="answer">
									<% if(isAdmin) { %>
										<form action="<%= request.getContextPath() %>/answerQuestion.li" method="post" onsubmit="return send();">
											<input type="hidden" name="questNo" value="<%= q.getQuest_No() %>">
											<div>
												<textarea class="ansTextarea" name="answerContent" readonly><%= answer %></textarea>
												<input type="hidden" id="noUpdateText" value="<%= answer %>">	
											</div>
											<% if(q.getAns_YN().equals("N")) { %>
												<div class="writeBtnArea"><button id="writeAns" class="writeAns">답변 작성</button></div>
												<div id="inserBtnArea" class="inserBtnArea"><button id="insertAns" class="insertAns" type="submit">답변 등록</button></div>
											<%} %>
										</form>
									<%} else { %>
										<div><%= answer %></div>
									<%} %>
								</div>
							<%} %>
						<%} %>
						<br>
						<% if(!isAdmin){ %>
							<button id="writeQst" onclick="location.href='<%= request.getContextPath() %>/questionWriteForm.in'">문의 작성</button>
						<%} %>
						<br clear="all">
						<div class="pagingArea page-item" align="center">
							<button class="listBtn" id="startBtn" onclick="location.href='<%= request.getContextPath() %>/questionList.li?currentPage=1'"><i class="fas fa-angle-double-left"></i></button>
							<button class="listBtn" id="beforeBtn" onclick="location.href='<%= request.getContextPath() %>/questionList.li?currentPage=<%= pi.getCurrentPage() - 1 %>'"><i class="fas fa-angle-left"></i></button>
							<script>
								if(<%= pi.getCurrentPage() %> <= 1) {
									$('#beforeBtn').prop('disabled', true);
								}
								if(<%= pi.getCurrentPage() %> <= 1) {
									$('#startBtn').prop('disabled', true);
								}
							</script>
							
							<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++){ %>
							<%		if(p == pi.getCurrentPage()){ %>
										<button class="listBtn" id="choosen" disabled><%= p %></button>
							<%		} else{ %>
										<button class="listBtn" id="numBtn" onclick="location.href='<%= request.getContextPath() %>/questionList.li?currentPage=<%= p %>'"><%= p %></button>
							<% 		} %>
							<%	} %>
							
							<button class="listBtn" id="afterBtn" onclick="location.href='<%= request.getContextPath() %>/questionList.li?currentPage=<%= pi.getCurrentPage() + 1 %>'"><i class="fas fa-angle-right"></i></button>
							<button class="listBtn" id="endBtn" onclick="location.href='<%= request.getContextPath() %>/questionList.li?currentPage=<%= pi.getMaxPage() %>'"><i class="fas fa-angle-double-right"></i></button>
							<script>
								if(<%= pi.getCurrentPage() %> >= <%= pi.getMaxPage() %>) {
									$('#afterBtn').prop('disabled', true);
								}
								if(<%= pi.getCurrentPage() %> >= <%= pi.getMaxPage() %>) {
									$('#endBtn').prop('disabled', true);
								}
							</script>
						</div>
						<script>
							count = 0;
							
							$('.inquiry').click(function(){
								$(this).next().slideToggle();
								var ansArea = $(this).next().children().children().eq(1).children();
								var writeBtn = $(this).next().children().children().eq(2).children();
								var insertBtn = $(this).next().children().children().eq(3);
								ansArea.val(ansArea.next().val());
								ansArea.css({'border':'none'});
								writeBtn.css({'display': 'block'});
								ansArea.attr('readonly', 'true');
								
								if(count % 2 == 1){
									insertBtn.css({'display': 'none'});
								} else{
									writeBtn.css({'display': 'block'});
								}
								
								count++;
								
							});
							
							flag = false;
							
							$('.writeAns').click(function() {
								var answer = $(this).parent().prev().children().eq(0);
								var insertArea = $(this).parent().next();
								answer.removeAttr('readonly');
								answer.val('');
								answer.attr('placeholder', '답변을 입력하세요.');
								answer.css({'border':'1px solid #eee'});
								answer.focus();
								$(this).css({'display': 'none'});
								insertArea.css({'display': 'block'});
								flag = false;
							});
							
							$('.insertAns').click(function() {
								flag = true;
							});
							
							function send() {
								if(flag){
									return true;
								} else{
									return false;
								}
							}
							
						</script>
                   	</div>
                </div>
            </div>
        </div>
        <!-- End Align Area -->
    </main>
    <%@ include file="../common/footer.jsp" %>
    <!-- Scroll Up -->
    <div id="back-top" >
   		<a title="Go to Top" href="#"> <i class="fas fa-level-up-alt"></i></a>
	</div>
    <script>
        $(function () {
            var now = new Date();
            var year = now.getFullYear();
            var month = now.getMonth() + 1;
            var date = now.getDate();
            $('input[name=reqDate]').val(year + '-' + month + '-' + date);
            console.log(now);
        });
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