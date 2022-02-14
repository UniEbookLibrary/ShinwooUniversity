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
                                    <li><a href="searchBook.sr">도서 검색</a></li>
                                    <li><a href="<%= request.getContextPath() %>/reviewList.rv">독후감</a></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <div class="header-right d-none d-lg-block">
                    <button type="button" class="genric-btn primary circle" id="login" onclick="location.href='<%= request.getContextPath() %>/loginForm.me'">로그인</button>
				</div>
			</div>	
		</div>		
        <!-- Header End -->
    </header>
</body>
</html>