<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="review.model.vo.*, member.vo.*"%>
<%
	//Member loginUser= (Member)session.getAttribute("loginUser");
	Review r = (Review)request.getAttribute("r");
	ReviewBook rb = (ReviewBook)request.getAttribute("rb");
	
	
%>
<!doctype html>
<html class="no-js">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>독후감</title>
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
		padding-top: 30px;
		padding-bottom: 30px;
		width: 1000px;
		height: 400px;
	}
	
	td {
		text-align: left !important;
		height: 40px;
	}
	
	#bookInfoDiv {
		margin-top: 30px;
	}
	
	#detailDiv {
		margin-top: 80px;
		margin-right: 240px;
	}
	
	.bookInfo {
		position: relative;
		padding-left: 150px;
		padding-top: 25px;
		width: 1200px;
		left: 50%;
		transform: translateX(-50%);
	}
	
    .detailImg {
    	position: absolute;
    	padding-right: 30px;
    	padding-bottom: 100px;
    	width: 180px;
    	margin-left: 130px;
    	margin-top: 50px;
    }
    
	.simpleInfo {
		font-size: 13px;
		color: #666;
		cursor: default;
	}
	
	#bookName {
		text-decoration: none;
		display: inline-block;
		padding-top: 50px;
		padding-left: 340px;
	}
	
	#title {
		color: black;
	}
	
	#epub {
		text-align: center;
		display: inline-block;
		width: 40px;
		border-radius: 10%;
		font-size: 8px;
		background: lightgray;
		color: black;
		cursor: default;
	}
    
    #imgFile{
    	height: 218px;
    }
    
    #wrap {
    	clear: all;
    } 
    
    .writeForm {
    	padding-left: 10%;
    	padding-top: 10px;
    }
    
    #tableDiv1{
    	width: 900px;
    	min-height: 800px;
    }
    
    #tableDiv2{
		width: 900px;
		position: relative;
		left: 50%;
		transform: translateX(-50%);
		margin-left: 70px;
    } 
    
    table{
    	position: absolute;
		left: 50%;
		transform: translateX(-50%);
		margin-left: 250px;
    }
    
	footer, main{
		background: white;
	}
	
	.btn3{
		background: #6785FF;
		color: white;
		border-style: none;
	}
	
	#recommBtn{
		color: black;
		cursor: pointer;
	}
	
	textarea{
		background: #f9f9ff;
		border: 1px solid #eee;
	}
	
	.boldTitle {
		color: #6785FF;
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
	<%@ include file="../common/header.jsp"%>
	<main>
		<!--? Hero Start -->
		<div class="slider-area2 section-bg2 hero-overly" style="background-color: #6785FF; height: 100px;">
			<div class="slider-height2 d-flex align-items-center" style="background-color: #6785FF; height: 100px;">
				<h2 id="currentMenu">독후감 상세</h2>
			</div>
		</div>

		<form action="<%= request.getContextPath() %>/updateReview.rv?rId=<%= r.getReviewNo() %>" method="post">
			<!-- Static Table Start -->
			<div class="whole-wrap">
				<div class="container box_1170">
					<div class="section-top-border">
						<div class="row">
							<div id="detail_simple" class="bookInfo">
								<div class="detailImg">
								<a id="bookImg">
									<img id="imgFile" src="<%= request.getContextPath() %>/image/<%= rb.getImageFile() %>">
								</a>
								</div>
								<input type="hidden" name="bookImg" value="<%= rb.getImageFile() %>">
								<div id="bookName">
									<input type="hidden" name="bookTitle" value="<%= rb.getBookTitle() %>">
									<input type="hidden" name="author" value="<%= rb.getAuthor() %>">
									<h4 id="title" name="bookTitle">
										<b><%= rb.getBookTitle() %></b>
									</h4>
									<input type="hidden" id="bookNo" name="bNo" value="<%= rb.getBookNo() %>">
									<br>
									<hr style="margin-top: 0px; margin-bottom: 10px; width: 250px;">
									<span class="simpleInfo"><b>글쓴이 &nbsp;&nbsp; </b></span><span class="simpleInfo" id="author"><%= rb.getAuthor() %></span> <br> 
									<span class="simpleInfo"><b>출판사 &nbsp;&nbsp; </b></span><span class="simpleInfo" id="publisher"><%= rb.getPublisher() %></span> <br>
									<span class="simpleInfo"><b>출간일 &nbsp;&nbsp; </b></span><span class="simpleInfo" id="release"><%= rb.getReleaseDate() %></span> <br> 
									<span class="simpleInfo"><b>제공형태: &nbsp;&nbsp;</b></span><span id="epub">ePUB</span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<hr style="color: lightgray;">
			<div class="whole-wrap">
				<div class="container box_1170">
					<div id="tableDiv1">
						<div id="tableDiv2">
							<table style="width: 1000px; height: 500px;">
								<tr>
									<td width="100px;">
										<b class="boldTitle"><i class="fas fa-pen-nib"></i> &nbsp;제목</b>
									</td>
									<td><%= r.getReviewTitle() %></td>
									<input type="hidden" name="reviewTitle" value="<%= r.getReviewTitle() %>">
								</tr>
								<tr>
									<td>
										<b class="boldTitle"><i class="fas fa-user-edit"></i> &nbsp;작성자</b>
									</td>
									<td><%= r.getReviewWriter() %></td>
									<input type="hidden" name="reviewWriter" value="<%= r.getReviewWriter() %>">
								</tr>
								<tr>
									<td>
										<b class="boldTitle"><i class="fas fa-clock"></i> &nbsp;작성시간</b>
									</td>
									<td><%= r.getReviewDate() %></td>
									<input type="hidden" name="reviewDate" value="<%= r.getReviewDate() %>">
								</tr>
								<tr>
									<td>
										<b class="boldTitle"><i class="fas fa-eye"></i> &nbsp;조회수</b>
									</td>
									<td><%= r.getViews() %></td>
								</tr>
								<tr>
									<td>
										<b class="boldTitle"><i class="fas fa-heart"></i> &nbsp;추천수</b>
									</td>
									<td>
										<%= r.getRecommend() %>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<b class="boldTitle"><i class="fas fa-edit"></i> &nbsp;내용</b>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<textarea cols="100" rows="24" readonly style="resize: none;"><%= r.getReviewContent() %></textarea>
									</td>
									<input type="hidden" name="reviewContent" value="<%= r.getReviewContent() %>">
									<input type="hidden" name="bookId" value="<%= rb.getBookNo() %>">
									<input type="hidden" name="reviewNo" value="<%= r.getReviewNo() %>">
								</tr>
								<tr>
									<% if(loginUser != null){ %>
									<td colspan="2">
										<a id="recommBtn" onclick="recommendRev(<%= r.getReviewNo() %>);">추천하기 <i class="far fa-thumbs-up" style="color: #6785FF;"></i></a>
									</td>
									<%} %>
								</tr>
							</table>
								<script>
					                <% 
					                String memberId = null;
					                if(loginUser!=null){
					                	memberId = loginUser.getMemberId(); 
					                }
					                %>
					                function recommendRev(reviewNo){
					        			$.ajax({
					        				url: 'checkRecommend.rv',
					        				data: {cId:<%= memberId %>, rNo:reviewNo},
					        				success:function(data){
					        					console.log(data);
					        					if(data.trim()=='1'){
					    	  						alert('게시글이 추천되었습니다.');
					    	  						location.reload();
					    	  					}else{
					    	  						alert('한번 추천한 게시물은 더이상 추천할 수 없습니다.');
					    	  					}
					        				},
					        				error:function(data){
					        					console.log(data);
					        				}
					        			});
					                }
	                			</script>
						</div>
					</div>
					<div id="btnDiv">
						<div id="Btns">
							<div id="detailDiv">
								<% if(loginUser != null && loginUser.getMemberId().equals(r.getMemberId())){ %>
								<input class="genric-btn btn3 circle" type="submit" value="수정" style="float: right; margin-left: 10px;">
								<input class="genric-btn btn3 circle" type="button" value="글 삭제" onclick="deleteBoard();" style="float: right; margin-left: 10px;">
								<% } %>
								<input class="genric-btn btn3 circle" type="button" value="목록으로" onclick="location.href='<%= request.getContextPath() %>/reviewList.rv'" style="float: right; margin-left: 10px;">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>

	</main>
	<%@ include file="../common/footer.jsp"%>
	<div id="back-top">
		<a title="Go to Top" href="#">
			<i class="fas fa-level-up-alt"></i>
		</a>
	</div>
	<script>
       function deleteBoard(){
		var bool = confirm('정말 삭제하시겠습니까?');
		if(bool){
			location.href='<%= request.getContextPath() %>/deleteReview.rv?rId=<%= r.getReviewNo() %>';
		}
	}
       </script>

	<!-- JS here -->

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