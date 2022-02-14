<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, book.model.vo.Book, review.model.vo.PageInfo"%>
    
<%
	ArrayList<Book> bList = (ArrayList<Book>)request.getAttribute("bList");
	Book b = (Book)request.getAttribute("b");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int categoryNo = 0;
	categoryNo = (int)request.getAttribute("categoryNo");
	String category = (String)request.getAttribute("category");
	String kword = (String)request.getAttribute("kword");
	int listCountTotal = (int)request.getAttribute("listCount");
	
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>

<!doctype html>
<html class="no-js" lang="zxx">
<head>
  <meta charset="utf-8">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
  <title>도서 검색</title>
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
        
        .searchResults{
        	float: left;
        	padding-top: 50px;
        	padding-left: 100px;
        } 
        
      	.deleteButton{
      		float: left;
			padding-left: 5%;
			padding-top: 110px;
      	}
		
		.container{
			padding-top: 50px;
		}
		       
        .result{
        	width: 800px;
        	display: inline-block;
        }
        
        .category{
	        width:20%;
	        float: right;
	        position: absolute;
	        top:350px;
	        right:0px;
	        min-height:1px;
	        padding-right:15px;
	       	display: inline-block;
        }
         
        .paging{
         	float: left;
         	padding-left: 40%;
         }
         
        .bookName{
         	text-decoration: none;
         	color: black;
        }
        .image{
         	width: 230px;
         	height: 400px;
        }
         
        .totalBook{
         	margin-top: 100px;
         	width: 800px;
         	height: 400px;
         	
        }
        textarea {
		    width: 100%;
		    height: 6.25em;
		    border: none;
		    resize: none;
		}
		.list-display{
		  	display: inline-block;
		}
		.whole{
		  	width: 1500px;
		  	height: 400px;
		  	margin-left: 100px;
		}
 		#titleImg{ 
			margin-bottom: 170px;
		} 
		.titleA:hover {color: #6785FF;}
		.titleA{color : black;}
		  
		  
		button:hover{cursor: pointer;}
  		#numBtn{background: white; border: 1px solid #eee; color: gray;}
   		#choosen{background: #bfccff; border: 1px solid #eee; color: black;}
  		.pagingArea button{background: white; color: black;}
   		.pagingArea {padding: 10px;}
   		.listBtn{background: #eee; border: 1px solid #eee; color: gray;}
   		.fa-angle-double-left, .fa-angle-double-right, .fa-angle-left, .fa-angle-right{color: gray;}
      
 		button:disabled{background: #eee; cursor: default;}
 		
 		.cateNo{
 			cursor: pointer;
 		}
 		
  </style>
</head>
<body>
	<!-- ? Preloader Start -->
	<div id="preloader-active">
		<div class="preloader d-flex align-items-center justify-content-center">
			<div class="preloader-inner position-relative">
				<div class="preloader-circle">
					<div class="preloader-img pere-text">
						<img src="assets/img/logo/loder.png" alt="">
					</div>
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
				<h2 id="currentMenu">도서 검색</h2>
			</div>
		</div>
		<div class="container">
			<div class="searchResults">
				<h3 class="mb-20">검색 결과</h3>
				<ul class="noneList">
				<% if(kword != null){ %>
					<li><i class="fas fa-check-circle"></i> '<%= kword %>' 검색 결과</li>
				<% } %>
					<li><i class="fas fa-check-circle"></i> 총 <%= listCountTotal %>개의 검색 결과가 있습니다.</li>
				</ul>
				<hr>
			</div>
			<div>
			<form action="deleteBook.db" id="deleteBook" name="deleteBook" method="post">
	     	<% 	for (int i = 0; i < bList.size(); i++) { %>
	 		<div >	
			 <div class="list-display whole">
	     	 		<div class="list-display image">
	     	 			<h2>
	     	 				<a href='<%= request.getContextPath() %>/bookDetail.bo?bNo=<%= bList.get(i).getBookNo() %>'><img height="270px" width="180px" id="titleImg" name="titleImg" src="<%= request.getContextPath() %>/image/<%= bList.get(i).getChangeName() %>">
	     	 			</h2>
	     	 		</div>
     	 			<div class="list-display totalBook">
	     	 			<ul>
	     	 				<li><h2 id="bookTitle"><a class="titleA" href='<%= request.getContextPath() %>/bookDetail.bo?bNo=<%= bList.get(i).getBookNo() %>'><%= bList.get(i).getBookTitle() %><br><br></a></h2></li>
	     	 				<li><%= bList.get(i).getBookNo() %></li>
	     	 				<li><%= bList.get(i).getAuthor() %> | <%= bList.get(i).getPublisher() %> | <%= bList.get(i).getReleaseDate() %><br><br></li>
	     	 				<% if(bList.get(i).getBookInfo() != null){ %>	
	     	 					<li><textarea readonly><%= bList.get(i).getBookInfo() %></textarea></li>	
	     	 				<% } else {  %>
	     	 						<li><textarea readonly style="cursor: default;"> 책 정보 없음 </textarea></li>
	     	 				<% } %>	
	     	 				<li>
	     	 			</ul>
					</div>
			     </div>
				</div>
	         <% 	} %>
			</form>
             </div>
		 </div>
		<aside>
		<div class="category">
			<div class="blog_right_sidebar">
				<aside class="single_sidebar_widget search_widget">
							<div class="form-group">
								<div class="input-group mb-3">
								<input type="text" class="form-control" name="q" placeholder='도서명을 입력하세요.' id="combine"
								onfocus="this.placeholder = ''" onblur="this.placeholder = '도서명을 입력하세요.'">
									<div class="input-group-append">
									
									</div>
								</div>
							</div>
						<button class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn"
						type="button" onclick="combineSearch();">검색</button>
				<script>
					function combineSearch(){
						var keyword = document.getElementById("combine").value;
						location.href='<%= request.getContextPath()%>/searchBook.sr?category=book_title&&kword=' +  keyword;
					}
				</script>
				
				</aside>
				<aside class="single_sidebar_widget post_category_widget">
					<h4 class="widget_title" style="color: #2d2d2d; cursor: default;">Category</h4>
					<ul class="list cat-list">
						<li>
							<a href="<%= request.getContextPath() %>/searchBook.sr" class="d-flex"><p>전체</p></a>
						</li>
						<li>
							<a onclick="category(100);" class="cateNo"><p>소설/시</p></a>
						</li>
						<li>
							<a onclick="category(200);" class="cateNo"><p>경제/경영</p></a>
						</li>
						<li>
							<a onclick="category(300);" class="cateNo"><p>자기계발</p></a>
						</li>
						<li>
							<a onclick="category(400);" class="cateNo"><p>인문/사회</p></a>
						</li>
						<li>
							<a onclick="category(500);" class="cateNo"><p>역사/종교/예술</p></a>
						</li>
						<li>
							<a onclick="category(600);" class="cateNo"><p>과학/IT</p></a>
						</li>
						<li>
							<a onclick="category(700);" class="cateNo"><p>취미/여행</p></a>
						</li>
						<li>
							<a onclick="category(800);" class="cateNo"><p>어린이</p></a>
						</li>
						<li>
							<a onclick="category(900);" class="cateNo"><p>언어</p></a>
						</li>
					</ul>
				</aside>
				<script>
				function category(num){
					
					location.href="<%= request.getContextPath()%>/searchBook.sr?categoryNo=" + num;
					
				}
				</script>
				
			</div>
		</div>
		<!-- sidebar end -->
		
		</aside>
		
		
		<% if(categoryNo == 0){ %>
				<%if(category != null){ %>
					<div class="pagingArea page-item" align="center">
		        <!-- 맨처음으로 -->
		        <button class="listBtn" id="startBtn" onclick="location.href='<%= request.getContextPath() %>/searchBook.sr?currentPage=1&&category=<%= category %>&&kword=<%= kword %>'"><i class="fas fa-angle-double-left"></i></button>
		        <!-- 이전 페이지 -->
		        <button class="listBtn" id="beforeBtn" onclick="location.href='<%=request.getContextPath()%>/searchBook.sr?currentPage=<%= pi.getCurrentPage()-1 %>&&category=<%= category %>&&kword=<%= kword %>'"><i class="fas fa-angle-left"></i></button>
		        <script>
		        	if(<%= pi.getCurrentPage()%> <=1 ){
		        		$('#beforeBtn').prop('disabled', true);
		        	}
		        </script>
				<!-- 숫자버튼 -->
				<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
				<%		if(p == pi.getCurrentPage()) { %>
							<button class="listBtn" id="choosen" disabled><%= p %></button>
				<% 		} else {%>
							<button class="listBtn" id="numBtn" onclick="location.href='<%= request.getContextPath()%>/searchBook.sr?currentPage=<%= p %>&&kword=<%= kword %>&&category=<%= category%>'"><%= p %></button>
				<%		} %>
				<%	}	 %>
				<!-- 다음페이지로 -->
				<button class="listBtn" id="afterBtn" onclick="location.href='<%= request.getContextPath()%>/searchBook.sr?currentPage=<%= pi.getCurrentPage()+1 %>&&kword=<%= kword %>&&category=<%= category%>'"><i class="fas fa-angle-right"></i></button>
				<script>
					if(<%= pi.getCurrentPage() %> >= <%= pi.getMaxPage() %>){
						$('#afterBtn').prop('disabled', true);
					}
				</script>
				<!-- 맨 끝으로 -->
				<button class="listBtn" id="endBtn" onclick="location.href='<%= request.getContextPath() %>/searchBook.sr?currentPage=<%=pi.getMaxPage() %>&&kword=<%= kword %>&&category=<%= category%>'"><i class="fas fa-angle-double-right"></i></button>
		       </div>
			<%}else{ %>
        <div class="pagingArea page-item" align="center">
        <!-- 맨처음으로 -->
        <button class="listBtn" id="startBtn" onclick="location.href='<%= request.getContextPath() %>/searchBook.sr?currentPage=1'"><i class="fas fa-angle-double-left"></i></button>
        <!-- 이전 페이지 -->
        <button class="listBtn" id="beforeBtn" onclick="location.href='<%=request.getContextPath()%>/searchBook.sr?currentPage=<%= pi.getCurrentPage()-1 %>'"><i class="fas fa-angle-left"></i></button>
        <script>
        	if(<%= pi.getCurrentPage()%> <=1 ){
        		$('#beforeBtn').prop('disabled', true);
        	}
        </script>
		<!-- 숫자버튼 -->
		<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
		<%		if(p == pi.getCurrentPage()) { %>
					<button class="listBtn" id="choosen" disabled><%= p %></button>
		<% 		} else {%>
					<button class="listBtn" id="numBtn" onclick="location.href='<%= request.getContextPath()%>/searchBook.sr?currentPage=<%= p %>'"><%= p %></button>
		<%		} %>
		<%	}	 %>
		<!-- 다음페이지로 -->
		<button class="listBtn" id="afterBtn" onclick="location.href='<%= request.getContextPath()%>/searchBook.sr?currentPage=<%= pi.getCurrentPage()+1 %>'"><i class="fas fa-angle-right"></i></button>
		<script>
			if(<%= pi.getCurrentPage() %> >= <%= pi.getMaxPage() %>){
				$('#afterBtn').prop('disabled', true);
			}
		</script>
		<!-- 맨 끝으로 -->
		<button class="listBtn" id="endBtn" onclick="location.href='<%= request.getContextPath() %>/searchBook.sr?currentPage=<%=pi.getMaxPage() %>'"><i class="fas fa-angle-double-right"></i></button>
       </div>
       
       		<% } %>
     
       
		<% } if(categoryNo != 0){ %>
        <div class="pagingArea page-item" align="center">
        <!-- 맨처음으로 -->
        <button class="listBtn" id="startBtn" onclick="location.href='<%= request.getContextPath() %>/searchBook.sr?currentPage=1&&categoryNo=<%= categoryNo %>'"><i class="fas fa-angle-double-left"></i></button>
        <!-- 이전 페이지 -->
        <button class="listBtn" id="beforeBtn" onclick="location.href='<%=request.getContextPath()%>/searchBook.sr?currentPage=<%= pi.getCurrentPage()-1 %>&&categoryNo=<%= categoryNo %>'"><i class="fas fa-angle-left"></i></button>
        <script>
        	if(<%= pi.getCurrentPage()%> <=1 ){
        		$('#beforeBtn').prop('disabled', true);
        	}
        </script>
		<!-- 숫자버튼 -->
		<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++) { %>
		<%		if(p == pi.getCurrentPage()) { %>
					<button class="listBtn" id="choosen" disabled><%= p %></button>
		<% 		} else {%>
					<button class="listBtn" id="numBtn" onclick="location.href='<%= request.getContextPath()%>/searchBook.sr?currentPage=<%= p %>&&categoryNo=<%= categoryNo %>'"><%= p %></button>
		<%		} %>
		<%	}	 %>
		<!-- 다음페이지로 -->
		<button class="listBtn" id="afterBtn" onclick="location.href='<%= request.getContextPath()%>/searchBook.sr?currentPage=<%= pi.getCurrentPage()+1 %>&&categoryNo=<%= categoryNo %>'"><i class="fas fa-angle-right"></i></button>
		<script>
			if(<%= pi.getCurrentPage() %> >= <%= pi.getMaxPage() %>){
				$('#afterBtn').prop('disabled', true);
			}
		</script>
		<!-- 맨 끝으로 -->
		<button class="listBtn" id="endBtn" onclick="location.href='<%= request.getContextPath() %>/searchBook.sr?currentPage=<%=pi.getMaxPage() %>&&categoryNo=<%= categoryNo %>'"><i class="fas fa-angle-double-right"></i></button>
       </div>
       
       <%} %>
       
                      
	</main>
	<!-- Blog Area End -->
	
	<%@ include file="../common/footer.jsp" %>
	
	
	<!-- Scroll Up -->
	<div id="back-top" >
	 <a title="Go to Top" href="#"> <i class="fas fa-level-up-alt"></i></a>
	</div>
	

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