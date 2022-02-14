<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>도서 신청</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
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

        .borderTop {
            border-top: 1px solid #eee;
        }
        
        .booksearch {
        	margin-top: 3px;
        	float: right;
        }
		
		.divArea {
			margin-bottom: 15px;
		}
		
		.reqCont {
			width: 800px;
			position: absolute;
			left: 50%;
			transform: translateX(-50%);
		}
		
		.div1 {
			width: 1000px;
			height: 130px;
		}
		
		.div2 {
			width: 1000px;
			height: 800px;
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
                <h2 id="currentMenu">도서 신청</h2>
            </div>
        </div>

        <!--? Start Align Area -->
        <div class="whole-wrap">
            <div class="container box_1170">
                <div class="section-top-border">
                    <div class="div1">
                        <div class="reqCont">
                            <h3 class="mb-20">도서 신청 시 유의 사항</h3>
                            <div>
                                <ul class="noneList">
                                    <li><i class="fas fa-check-circle"></i> 희망 도서 신청 권수</li>
                                    <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1인당 월 1권, 1년에 10권으로 제한</li>
                                    <li><i class="fas fa-check-circle"></i> 희망 도서 진행 절차</li>
                                    <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;신청한 도서가 절차를 거쳐 신청이 승인되는 경우 신청자에게 대출 우선권 부여</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="section-top-border borderTop">
                    <div class="div2">
                        <div class="reqCont">
                            <h3 class="mb-30">신청 도서 정보 입력</h3>
                            <form action="<%= request.getContextPath() %>/request.bo" id="reqBook" name="reqBook" onsubmit="return alreadyHave();" method="post">
                                <div>
                                    <span class="reqTitle">도서명</span>
                                    <div class="input-group-icon mt-10">
                                        <div class="icon"><i class="fa fa-book" aria-hidden="true"></i></div>
                                        <input type="text" id="title" name="bookTitle" placeholder="도서명을 입력하세요" required
                                            onfocus="this.placeholder = ''" onblur="this.placeholder = '도서명을 입력하세요'"
                                            class="single-input">
                                        <div id="message"></div>
                                        <div class="booksearch"><input type="button" class="genric-btn info circle booksearch" id="searchBook" value="도서 검색"></div>
                                    </div>
                                </div>
                                <br clear="right">
                                <div class="divArea">
                                    <span class="reqTitle">저자</span>
                                    <div class="input-group-icon mt-10">
                                        <div class="icon"><i class="fas fa-pencil-alt"></i></div>
                                        <input type="text" id="author" name="author" placeholder="저자를 입력하세요" required
                                            onfocus="this.placeholder = ''" onblur="this.placeholder = '저자를 입력하세요'"
                                            class="single-input">
                                    </div>
                                </div>
                                <div class="divArea">
                                    <span class="reqTitle">출판사</span>
                                    <div class="input-group-icon mt-10">
                                        <div class="icon"><i class="fas fa-bookmark"></i></div>
                                        <input type="text" id="publisher" name="publisher" placeholder="출판사를 입력하세요" required
                                            onfocus="this.placeholder = ''" onblur="this.placeholder = '출판사를 입력하세요'"
                                            class="single-input">
                                    </div>
                                </div>
                                <div class="divArea">
                                    <span class="reqTitle">출간일</span>
                                    <div class="input-group-icon mt-10">
                                        <div class="icon"><i class="fas fa-calendar-day"></i></div>
                                        <input type="date" name="releaseDate" class="single-input" required>
                                    </div>
                                </div>
                                <div class="divArea">
                                    <span class="reqTitle">신청 일자</span>
                                    <div class="input-group-icon mt-10">
                                        <div class="icon"><i class="fas fa-calendar-day"></i></div>
                                        <input type="text" name="reqDate" readonly class="single-input">
                                    </div>
                                </div>
                                <div class="divArea">
                                    <span class="reqTitle">신청의견</span>
                                    <div class="mt-10">
                                        <textarea class="single-textarea" placeholder="신청 이유를 입력하세요" name="reqComment"
                                            onfocus="this.placeholder = ''" onblur="this.placeholder = '신청 이유를 입력하세요'"></textarea>
                                    </div>
                                </div>
                                <div class="bottomBtn">
                                    <input type="submit" class="genric-btn info circle" value="신청">
                                    <input type="reset" class="genric-btn danger circle" value="취소">
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- End Align Area -->
    </main>
    <%@ include file="../common/footer.jsp" %>
    <script>
        $(function () {
            var now = new Date();
            var year = now.getFullYear();
            var month = now.getMonth() + 1;
            var date = now.getDate();
            $('input[name=reqDate]').val(year + '-' + month + '-' + date);
            $('input[name=reqDate]').css('color', 'gray');
            console.log(now);
        });

        document.getElementById('searchBook').onclick = function() {
        	var w = window.open('searchreqbook.bo', 'searchReqBook', 'width=500, height=300');
        	
        	w.onbeforeunload = checkBook;

		}
        
        $('#title').on("propertychange change keyup paste input", checkBook);
        $('#author').on("propertychange change keyup paste input", checkBook);
        $('#publisher').on("propertychange change keyup paste input", checkBook);
        
        var flag = true;
        
        function checkBook() {
        	var title = $('#title').val();
        	var author = $('#author').val();
        	var publisher = $('#publisher').val();
			$.ajax({
				url: 'checkExistBook.bo',
				data: {title:title, author:author, publisher:publisher},
				success: function(data) {
					var isHave = data.trim();
					console.log(data);
					if(isHave == 'have'){
						$('#message').css({'color':'red', 'font-size':'12px'});
						
						$('#message').html('&nbsp;&nbsp;&nbsp;<i class="fas fa-exclamation-triangle"></i> 이미 소장 중인 도서입니다.');
						flag = false;
					} else {
						$('#message').html('');
						flag = true;
					}
				},
				error: function(data) {
					console.log(data);
				}
			});
		}
        
        function alreadyHave() {
        	if(flag){
        		alert("도서 신청이 완료되었습니다.");
        	} else {
        		alert("소장 중인 도서는 신청할 수 없습니다.");
        		$('#title').focus();
        	}
        	return flag;
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

</body>
</html>