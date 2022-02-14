<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.vo.Member"%>


<!doctype html>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>독후감 작성</title>
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

        .reviewTitle {
            padding-bottom: 10px;
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
            padding: 0 10px;
            vertical-align: middle;
            border: none;
            width: 86%;
            color: black;
            background-color: #ffffff00;
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

        #imagePreview {
            margin-top: 20px;
            border: 1px solid #eee;
        }

        #imageP {
            margin-top: 20px;
            visibility: hidden;
        }
        
       	.div1{
        	width: 800px;
        	height: 1200px;
        }
        
        .div2{
			width: 800px;
			position: absolute;
			left: 50%;
			transform: translateX(-50%);
        }
        
        #bookSh {
        	display: none;
        }
        
        #title:focus, #content:focus{
           border: 1px solid #6785FF;
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
                <h2 id="currentMenu">독후감 작성</h2>
            </div>
        </div>
        <!-- Hero End -->
        <!--? Blog Area Start -->
        <div class="whole-wrap">
            <div class="container box_1170">
                <div class="section-top-border borderTop">
                    <div class="row">
                        <div class="div1">
                            <div class="div2">
                                <form class="form-contact comment_form" action="<%= request.getContextPath() %>/insertReview.rv" id="commentForm" name="commentForm"
                                   method="post">
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="form-group">
                                                <span class="reviewTitle">독후감 제목</span>
                                                <input class="form-control" name="title" id="title" type="text"
                                                    placeholder="독후감 제목을 입력하세요" required>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <span class="reviewTitle">작성자</span>
                                                <input class="form-control" name="userId" id="userId" type="text"
                                                    value="<%= loginUser.getMemberName() %>" readonly>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <span class="reviewTitle">작성일자</span>
                                                <input class="form-control" name="reviewDate" id="reviewDate"
                                                    type="text" readonly="" class="single-input">
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <div class="form-group">
                                                <span class="reviewTitle">독후감 내용</span>
                                                <textarea class="form-control w-100" name="content" id="content"
                                                    cols="30" rows="20" placeholder="글 내용을 입력하세요" required></textarea>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="input-group-icon mt-10 filebox">
                                            	<table id="bookSh">
	                                                <tr>
	                                                	<td><img height="300px" id="bookImg" name="bookImg"></td>
	                                                </tr>
	                                                <tr>
	                                                	<td width="800px">책 제목:<input type="text" class="upload-name" id="uploadName" name="uploadName" readonly></td>
	                                                	
	                                                </tr>
	                                                <tr>
	                                                <td>저자:<input type="text" class="upload-name" id="uploadName2" name="uploadName2" readonly></td>
	                                                </tr>
                                                </table>
                                                <input type="hidden" id="uploadName3" name="uploadName3">
                                                <button type="button" class="genric-btn success circle" id="findBook">책 찾기</button>
                                               
                                                <div id="imageP">
                                                    <span>사진 미리보기</span>
                                                    <div id="imagePreview">
                                                        <img id="img" />
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="bottomBtn">
                                        <input type="submit" class="genric-btn info circle" value="등록">
                                        <input type="button"  onclick="history.back(-1);" class="genric-btn danger circle" value="취소">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Blog Area End -->
    </main>
    
    <script>
    document.getElementById('findBook').onclick = function(){
		window.open('findBook.rv', 'findBookForm', 'width=1550,height=1020');
		$('#bookSh').css("display", "block");
	}
    
    //function doornot(){
    //	console.log(document.getElementById('uploadName3').value);
    //}
    
    </script>
    
	<%@ include file="../common/footer.jsp"%>
	<div id="back-top">
		<a title="Go to Top" href="#">
			<i class="fas fa-level-up-alt"></i>
		</a>
	</div>
    <script>
        $(function () {
            var now = new Date();
            var year = now.getFullYear();
            var month = now.getMonth() + 1;
            var date = now.getDate();
            $('input[name=reviewDate]').val(year + '-' + month + '-' + date);
            $('input[name=reviewDate]').css('color', 'gray');
        });

        $("#file").on('change', readInputFile);

        function readInputFile(e) {
            var fileInput = document.getElementsByClassName("ex_file");
            var name = document.getElementById("uploadName").value;
            var area = document.getElementById("uploadName");

            var sel_files = [];

            sel_files = [];

            var files = e.target.files;
            var fileArr = Array.prototype.slice.call(files);
            var index = 0;

            fileArr.forEach(function (f) {
                if (!f.type.match("image/.*")) {
                    alert("이미지 확장자만 업로드 가능합니다.");
                    return;
                };
                if (files.length < 4) {
                    sel_files.push(f);
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        var html = `<a id=img_id_${index}><img width=33% src=${e.target.result} data-file=${f.name} /></a>`;
                        $('#imagePreview').append(html);
                        index++;
                    };
                    reader.readAsDataURL(f);
                    $('#imagePreview').empty();
                    $("#imageP").css("visibility", "visible");
                    area.value = "";

                    for (var i = 0; i < fileInput.length; i++) {
                        if (fileInput[i].files.length > 0) {
                            for (var j = 0; j < fileInput[i].files.length; j++) {
                                if (j == 0) {
                                    area.value += fileInput[i].files[j].name;
                                } else {
                                    area.value += ", " + fileInput[i].files[j].name;
                                }
                            }
                        }
                    }
                }
            })
            if (files.length > 4) {
                alert("최대 3장까지 업로드 할 수 있습니다.");
            }
        }

        $("#commentForm").submit(function () {
            alert("글 작성이 완료되었습니다.");
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