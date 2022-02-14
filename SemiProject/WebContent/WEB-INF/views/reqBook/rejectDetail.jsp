<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="reqBook.model.vo.*"%>
 <%
 	ReqBook rb = (ReqBook)request.getAttribute("rb"); 
%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
		.area {
			margin-top: 30px;
		}
		
		.reject {
			color: red;
		}
		
		.lead {
			font-size: 15px;
		}
		
		.container{
			text-align: center;
		}
	</style>
  </head>
  <body bgcolor='lightgray'>
	<div class="area">
  <div class="container">
    <h1 class="reject"><i class="fas fa-times-circle"></i> 도서 신청이 거절되었습니다.</h1><br>
    <p class="lead"><i class="fas fa-edit"></i> <b>신청 의견</b> : <%= rb.getReqBookContent() %></p>
    <p class="lead"><i class="fas fa-frown-open"></i> <b>거절 사유</b> : <%= rb.getReqBookReason() %></p><br>
    <input type="button"  onclick="window.close();" class="genric-btn info-border circle small" value="닫기">
  </div>
</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>

