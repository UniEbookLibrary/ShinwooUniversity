<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신우대학교 메인</title>
</head>
 <body>
    <header>
        <!-- Header Start -->
        <div class="header-area">
            <div class="main-header header-sticky">
                <!-- Logo -->
                <div class="header-left">
                    <div class="logo">
                        <a href="<%= request.getContextPath() %>"><img src="assets/img/logo/logo.png" alt=""></a>
                    </div>
                    <div class="menu-wrapper  d-flex align-items-center">
                        <!-- Main-menu -->
                        <div class="main-menu d-none d-lg-block">
                            <nav>
                                <ul id="navigation">
                                    <li><a href="<%= request.getContextPath() %>/Library.Info">도서관 소개</a></li>
                                    <li><a>회원 관리</a>
                                    	<ul class="submenu">
											<li><a href="userList.ul">회원 목록 조회</a></li>
										</ul>
                                    </li>
                                    <li><a>도서 관리</a>
                                    	<ul class="submenu">
											<li><a href="<%= request.getContextPath() %>/insertForm.bo">도서 등록</a></li>
		                                    <li><a href="<%= request.getContextPath() %>/ownBookList.li">전체 도서 목록 조회</a></li>
		                                    <li><a href="<%= request.getContextPath() %>/rentalList.rt">대출 도서 목록 조회</a></li>
											<li><a href="<%= request.getContextPath() %>/reqBook.li">신청 도서 목록 조회</a></li>
										</ul>
                                    </li>
                                    <li><a href="searchBook.sr">도서 검색</a></li>
                                    <li><a href="<%= request.getContextPath() %>/reviewList.rv">독후감</a></li>
                                    <li><a href="<%= request.getContextPath() %>/questionList.li">1:1 문의 관리</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <div class="header-right d-none d-lg-block">
                    <button type="button" class="genric-btn primary circle" id="login" onclick="location.href='<%= request.getContextPath() %>/logout.me'">로그아웃</button>
				</div>
			</div>	
		</div>		
        <!-- Header End -->
    </header>
</body>
</html>