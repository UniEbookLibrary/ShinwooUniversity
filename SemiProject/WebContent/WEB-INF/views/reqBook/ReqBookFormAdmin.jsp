<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, reqBook.model.vo.ReqBook,member.vo.Member"%>
<%
	ReqBook r = (ReqBook)request.getAttribute("r"); 
	String writer = (String)request.getAttribute("writer");
	ArrayList<ReqBook> list = (ArrayList)request.getAttribute("list");
%>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>도서 신청 사유</title>
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
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
<style>
	h2 {
		margin-top: 10px;
		color: #6785FF;
	}
	
	.tableArea {
		display: flex;
		justify-content: center;
	}
	
	textarea {
		background: #f9f9ff;
		border: solid 1px #eee;
	}
	
	th, td {
		padding-top: 10px;
	}
</style>

</head>
<body>
		<h2 align="center">신청도서 상세 페이지</h2>
		<div class="tableArea">
				<table style="border:1">
					<tr>
						<th>제목</th>
						<td colspan="3" width="300px">
							<%= r.getReqBookTitle() %>
							<input type="hidden" size="50" name="title">
						</td>				
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<%= r.getReqBookWriter() %>
							<input type="hidden" name="nickName">
						</td>
						<th>작성일</th>
						<td>
							<%= r.getReqBookDate() %>
							<input type="hidden" name="date">
						</td>
					</tr>
					<tr>
						<th colspan="4"><h3 align="center">도서 신청 사유 </h3></th>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="content" cols="60" rows="5" style="resize:none;"  readonly><%= r.getReqBookComment() %></textarea> 
							<input type="hidden" name="no" >
						</td>
					</tr>
				</table>
		</div>	
		<br>
		<form action="<%= request.getContextPath() %>/reqBook.def" method="post">
		<h3 align="center">도서 신청 거절 사유 </h3>
		<div class="tableArea">
				<table>
					<tr>
						<td><textarea id="reason1" name="reason" cols="60" rows="5" style="resize:none;" placeholder="거절사유를 입력하세요"></textarea></td>
					</tr>
				</table>
		</div>
		<br>
		<div class="bottomBtn" align="center">
    	<input type="button" class="genric-btn info-border circle small" value="승인" onclick="permit();">
    	<input type="button" class="genric-btn danger-border circle small" value="거절" onclick="reject();">
    	</div>
 		</form>
 
		<script>
			function reject (){
				var Rreason = document.getElementById('reason1').value;
				location.href='<%= request.getContextPath() %>/reqBook.def?reqNo=<%= r.getReqBookNo() %>&&reason=' + Rreason + "&&writer=<%= writer %>&&bookName=<%= r.getReqBookTitle() %>";
			
			}
			
			function permit() {
				var permitR = document.getElementById('reason1');
				if(permitR.value.trim() != ''){
					alert('승인 시에는 거절 메시지를 입력할 수 없습니다.');
					permitR.value = '';
				} else{
					location.href='<%= request.getContextPath() %>/reqBook.confi?reqNo=<%= r.getReqBookNo()%>&&writer=<%= writer %>&&bookName=<%= r.getReqBookTitle() %>';
				}
			}
		</script>
		
</body>

</html>
