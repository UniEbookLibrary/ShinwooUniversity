<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, book.model.vo.Book, review.model.vo.PageInfo"%>
<% 	
	ArrayList<Book> list = (ArrayList)request.getAttribute("list");
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

    <title>전체 도서 목록 조회</title>
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
        
   .firstdiv{background:#6785FF; height:130px; font-size:40px; text-align:left; padding-left:60px; padding-top:35px;font-weight : bold; color:white;
    	}
    	
    #personalInf{
    	margin-left:10%; margin-right:10%; margin-top: 20px; border-radius: 2em;
    }
    
    .borrowed{
    	background:#d2e2e9; height:100px; padding-left:160px; font-size:30px; padding-top:20px;font-weight : bold; color:#404040
    }
    
    .personal{
    	font-size:20px;
    	}
    	
    
    .card img{
    	width:145px;
    }
    
    .imgdiv{
    	text-align:center; border-radius: 2em;
    	
    }
    
    .borrowed button{
    	margin-left:20px;
    	margin-top:-20px;
    	font-size:15px;
    }
    
    .bookpage{ text-align : center;
    	margin-top:40px;
    }
    
    .bookp{ display:inline-block;
    }
    #ddaydiv{background: rgba(255, 0, 0, 0.5);}
    #dday{color:red;}
    .card-title{font-size:20px;}
    .card-body{text-align:center;}
    .card-body button{margin-top:10px;}
    div.card{border-radius: 2em; margin-top:10px; opacity: 0.8; margin-left:20px; margin-right:20px;}
    .tableBody{height:60px;}
    th, td {
  		vertical-align : middle;
  		font-size: 14px;
	}
	.submitDiv1{
		padding-top: 15px;
		padding-right:100px;
		margin-right:100px;
	}
	
	#submitDiv{
		margin-top: 20px;
	}
	
	td {
		cursor: pointer;
	}
	
	.cate{float: left;}
	
	button:hover{cursor: pointer;}
	#numBtn{background: white; border: 1px solid #eee; color: gray;}
	#choosen{background: #bfccff; border: 1px solid #eee; color: black;}
	.pagingArea button{background: white; color: black;}
	.listBtn{background: #eee; border: 1px solid #eee; color: gray;}
	.fa-angle-double-left, .fa-angle-double-right, .fa-angle-left, .fa-angle-right{color: gray;}
		
	button:disabled{background: #eee; cursor: default;}
    </style>
</head>
<body>
   <%@ include file="../common/header.jsp" %>
	<div class="slider-area2 section-bg2 hero-overly" style="background-color: #6785FF; height: 100px;">
		<div class="slider-height2 d-flex align-items-center" style="background-color: #6785FF; height: 100px;">
			<h2 id="currentMenu">전체 도서 목록</h2>
		</div>
	</div>
	<form action="<%= request.getContextPath() %>/searchAdminBook.bo" method="post" id="searchAdBook" name="searchAdBook">
		<div id="personalInf">
			<div class="col-lg-4"  style="float:right; width: 200%;">
				<div class="blog_right_sidebar">
					<aside class="search_widget">
						<div class="form-group">
							<div class="input-group mb-3">
								<div style="padding-right: 10px;">
									<select name="searchAdBook">
										<option value="all">전체 검색</option>
										<option value="title">도서명</option>
										<option value="author">저자명</option>
									</select>
								</div>
								<input type="text" name="keyword" style="height: 42px;" id="shKeyword" class="form-control" placeholder='키워드를 입력하세요' onfocus="this.placeholder = ''" onblur="this.placeholder = '키워드를 입력하세요'">
								<div class="input-group-append" style="height: 42px;" id="shBtn">
									<button class="btns" type="submit">
										<i class="ti-search"></i>
									</button>
								</div>
							</div>
						</div>
					</aside>
				</div>
			</div>
		</div>
	</form>
	<br clear="all">
	<form action="<%= request.getContextPath() %>/deleteCheckedBook.bo" method="post" id="deleteChecked" name="deleteChecked" onsubmit="return deleteCheckedBook();">
		<div id="personalInf">
			<table class="table table-hover">
				<thead>
					<tr>
					<% if (list.isEmpty()) { %>
						<th scope="col"></th>
					<% } else { %>
						<th scope="col"><input type='checkbox' name='selectBook' value='all' onclick='selectAll(this);'></th>
					<% } %>
						<th scope="col">도서 번호</th>
						<th scope="col">도서명</th>
						<th scope="col">저자</th>
						<th scope="col">출판사</th>
						<th scope="col">출간일</th>
						<th scope="col">등록일</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>

					<% if (list.isEmpty()) { %>
					<tr>
						<th colspan="8">존재하는 도서가 없습니다.</th>
					</tr>
					<% } else { %>
					<% 		for (int i = 0; i < list.size(); i++) { %>
					<tr>
						<% String bookNo = list.get(i).getBookNo(); %>
						<th><input type='checkbox' name='selectBook' value='<%= bookNo %>'></th>
						<td><%=bookNo%></td>
						<td width='30%'><%=list.get(i).getBookTitle()%></td>
						<td><%=list.get(i).getAuthor()%></td>
						<td><%=list.get(i).getPublisher()%></td>
						<td><%=list.get(i).getReleaseDate()%></td>
						<td><%=list.get(i).getRegDate()%></td>
						<th><button type="button" class="genric-btn danger-border small" onclick="deleteOneBook('<%=bookNo%>');">삭제</button></th>
						<% } %>
					</tr>
					<% } %>
				</tbody>
			</table>
			<div id="submitDiv1">
				<div id="submitDiv" align="right">
					<button type="submit" class="genric-btn danger circle">일괄 삭제</button>
				</div>
			</div>
		</div>
	</form>
			<div class="pagingArea" align='center'>
				<div class="pagingArea page-item" align="center">
					<button class="listBtn" id="startBtn" onclick="location.href='<%=request.getContextPath()%>/ownBookList.li?currentPage=1'">
						<i class="fas fa-angle-double-left"></i>
					</button>
					<button class="listBtn" id="beforeBtn" onclick="location.href='<%=request.getContextPath()%>/ownBookList.li?currentPage=<%=pi.getCurrentPage() - 1%>'">
						<i class="fas fa-angle-left"></i>
					</button>
					<script>
									if(<%=pi.getCurrentPage()%> <= 1) {
										$('#beforeBtn').prop('disabled', true);
									}
									if(<%=pi.getCurrentPage()%> <= 1) {
										$('#startBtn').prop('disabled', true);
									}
								</script>
	
					<%
						for (int p = pi.getStartPage(); p <= pi.getEndPage(); p++) {
					%>
					<%
						if (p == pi.getCurrentPage()) {
					%>
					<button class="listBtn" id="choosen" disabled><%=p%></button>
					<%
						} else {
					%>
					<button class="listBtn" id="numBtn" onclick="location.href='<%=request.getContextPath()%>/ownBookList.li?currentPage=<%=p%>'"><%=p%></button>
					<%
						}
					%>
					<%
						}
					%>
	
					<button class="listBtn" id="afterBtn" onclick="location.href='<%=request.getContextPath()%>/ownBookList.li?currentPage=<%=pi.getCurrentPage() + 1%>'">
						<i class="fas fa-angle-right"></i>
					</button>
					<button class="listBtn" id="endBtn" onclick="location.href='<%=request.getContextPath()%>/ownBookList.li?currentPage=<%=pi.getMaxPage()%>'">
						<i class="fas fa-angle-double-right"></i>
					</button>
					<script>
									if(<%=pi.getCurrentPage()%> >= <%=pi.getMaxPage()%>) {
										$('#afterBtn').prop('disabled', true);
									}
									if(<%=pi.getCurrentPage()%> >= <%=pi.getMaxPage()%>) {
										$('#endBtn').prop('disabled', true);
									}
					</script>
				</div>
			</div>
		
	<%@ include file="../common/footer.jsp" %>
    <!-- Scroll Up -->
    <div id="back-top" >
   		<a title="Go to Top" href="#"> <i class="fas fa-level-up-alt"></i></a>
	</div>
    	<script>
	    $('td').on("click", function(){
	    	var num = $(this).parent().children().eq(1).text();
	    	location.href='<%= request.getContextPath() %>/bookDetail.bo?bNo=' + num;
	    });
	    
	    function deleteOneBook(bNo){
	    	var bool = confirm("정말로 삭제하시겠습니까?");
	    	if(bool == true){
	    		location.href='<%=request.getContextPath()%>/deleteOneBook.bo?bNo=' + bNo;
		    	alert('도서 번호 [' + bNo + '] 도서가 삭제되었습니다.')
	    	}
   		}
	    
	    
	    function selectAll(selectAll)  {
	    	var checkboxes = document.getElementsByName('selectBook');
	    	  
	    	checkboxes.forEach((checkbox) => {
	    	    checkbox.checked = selectAll.checked;
	    	});
	    }
	    
	    function deleteCheckedBook() {
	    	var checked = $("input:checkbox[name=selectBook]:checked").length;
	    	if(checked == 21){
	    		checked--;
	    	}
	    	
	    	var bool = confirm("정말로 삭제하시겠습니까?");
	    	if(bool == true){
		    	alert('선택된 ' + checked + '개의 도서가 삭제되었습니다.');
		    	return true;
	    	} else {
	    		return false;
	    	}
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

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
</body>
</html>