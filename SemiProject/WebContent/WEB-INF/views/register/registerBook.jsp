<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>도서 등록</title>
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

        .regTitle {
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

        .filebox .upload-name {
            display: inline-block;
            height: 40px;
            padding: 0 45px;
            vertical-align: middle;
            border: none;
            width: 86%;
            color: #999999;
            background-color: #F9F9FF;
        }

        .filebox label {
            display: inline-block;
            padding: 10px 20px;
            color: #fff;
            vertical-align: middle;
            background-color: #6785FF;
            cursor: pointer;
            height: 40px;
            margin-left: 10px;
        }

        .filebox input[type="file"] {
            position: absolute;
            width: 0;
            height: 0;
            padding: 0;
            overflow: hidden;
            border: 0;
        }

        .fa-image {
            position: absolute;
            top: 50%;
            margin-top: 12px;
            margin-left: 1%;
            z-index: 1;
        }
        
        .booksearch {
        	margin-top: 3px;
        	float: right;
        }
        
        .divArea {
			margin-bottom: 15px;
		}
		
		.div1 {
			width: 1000px;
			height: 1150px;
		}
		
		.regCont {
			width: 800px;
			position: absolute;
			left: 50%;
			transform: translateX(-50%);
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
                <h2 id="currentMenu">도서 등록</h2>
            </div>
        </div>

        <!--? Start Align Area -->
        <div class="whole-wrap">
            <div class="container box_1170">
                <div class="section-top-border borderTop">
                    <div class="div1">
                        <div class="regCont">
                            <h3 class="mb-30">등록 도서 정보 입력</h3>
                            <form action="<%= request.getContextPath() %>/register.bo" id="regBook" name="regBook" method="post" encType="multipart/form-data" onsubmit="return insertImg();">
                                <div>
                                    <span class="regTitle">도서명</span>
                                    <div class="input-group-icon mt-10 bookname">
                                        <div class="icon"><i class="fa fa-book" aria-hidden="true"></i></div>
                                        <input type="text" name="bookTitle" placeholder="도서명을 입력하세요" required
                                            onfocus="this.placeholder = ''" onblur="this.placeholder = '도서명을 입력하세요'"
                                            class="single-input">
                                        <div class="booksearch"><input type="button" class="genric-btn info circle booksearch" id="searchBook" value="도서 검색"></div>
                                    </div>
                                </div>
                                <br clear="right">
                                <div class="divArea">
                                    <span class="regTitle">저자</span>
                                    <div class="input-group-icon mt-10">
                                        <div class="icon"><i class="fas fa-pencil-alt"></i></div>
                                        <input type="text" name="author" placeholder="저자를 입력하세요" required
                                            onfocus="this.placeholder = ''" onblur="this.placeholder = '저자를 입력하세요'"
                                            class="single-input">
                                    </div>
                                </div>
                                <div class="divArea">
                                    <span class="regTitle">출판사</span>
                                    <div class="input-group-icon mt-10">
                                        <div class="icon"><i class="fas fa-bookmark"></i></div>
                                        <input type="text" name="publisher" placeholder="출판사를 입력하세요" required
                                            onfocus="this.placeholder = ''" onblur="this.placeholder = '출판사를 입력하세요'"
                                            class="single-input">
                                    </div>
                                </div>
                                <div class="divArea">
                                    <span class="regTitle">카테고리</span>
                                    <div class="default-select" id="default-select">
                                        <select name = "category">
                                            <option disabled>카테고리 선택</option>
                                            <option value="100">소설/시</option>
                                            <option value="200">경제/경영</option>
                                            <option value="300">자기 계발</option>
                                            <option value="400">인문/사회</option>
                                            <option value="500">역사/종교/예술</option>
                                            <option value="600">과학/IT</option>
                                            <option value="700">취미/여행</option>
                                            <option value="800">어린이</option>
                                            <option value="900">언어</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="divArea">
                                    <span class="regTitle">출간일</span>
                                    <div class="input-group-icon mt-10">
                                        <div class="icon"><i class="fas fa-calendar-day"></i></div>
                                        <input type="date" name="releaseDate" class="single-input" required>
                                    </div>
                                </div>
                                <div class="divArea">
                                    <span class="regTitle">등록일자</span>
                                    <div class="input-group-icon mt-10">
                                        <div class="icon"><i class="fas fa-calendar-day"></i></div>
                                        <input type="date" name="regDate" readonly class="single-input">
                                    </div>
                                </div>
                                <div class="divArea">
                                    <span class="regTitle">표지 이미지</span>
                                    <div class="input-group-icon mt-10 filebox">
                                        <div class="icon"><i class="far fa-image"></i></div>
                                        <input class="upload-name" id="uploadName" value="표지 이미지를 업로드하세요" readonly placeholder="표지 이미지를 업로드하세요">
                                        <label for="file">파일 찾기</label>
                                        <input type="file" id="file" name="bookImage" accept=".gif, .jpg, .png" required>
                                    </div>
                                </div>
                                <div class="divArea">
                                    <span class="regTitle">줄거리</span>
                                    <div class="mt-10">
                                        <textarea class="single-textarea" name="bookInfo" placeholder="줄거리"
                                            onfocus="this.placeholder = ''" onblur="this.placeholder = '줄거리를 입력하세요'"></textarea>
                                    </div>
                                </div>
                                <div class="divArea">
                                    <span class="regTitle">참고사항</span>
                                    <div class="mt-10">
                                        <textarea class="single-textarea" name="refer" placeholder="참고사항을 입력하세요"
                                            onfocus="this.placeholder = ''" onblur="this.placeholder = '참고사항을 입력하세요'"></textarea>
                                    </div>
                                </div>
                                <div class="bottomBtn">
                                    <input type="submit" class="genric-btn info circle" id="regOk" value="등록">
                                    <input type="reset" class="genric-btn danger circle" id="regCancle" value="취소">
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
            $('input[name=regDate]').val(year + '-' + month + '-' + date);
            $('input[name=regDate]').css('color', 'gray');
            console.log(now);
        });

        $("#file").on('change', function () {
            var fileName = $("#file").val();
            $(".upload-name").val(fileName);
        });

        $("#regBook").submit(function(){
            alert("도서 등록이 완료되었습니다.");
        });
        
        document.getElementById('searchBook').onclick = function() {
        	window.open('searchregbook.bo', 'searchRegBook', 'width=500, height=300');
		}
        
        $("#regOk").click(function() {
        	if($("#uploadName").val() == '표지 이미지를 업로드하세요'){
        		alert('도서 이미지를 추가해 주세요');
        		
        		var offset = $("#uploadName").offset() - 50;
                $('html, body').animate({scrollTop : offset.top}, 400);

			} 
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