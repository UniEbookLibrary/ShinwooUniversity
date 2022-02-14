<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.vo.Member,java.util.ArrayList,review.model.vo.*"%>
 <%
	//Member loginUser= (Member)session.getAttribute("loginUser");
 	ArrayList<ReviewBook> list = (ArrayList)request.getAttribute("list"); 
%>
<!doctype html>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>독후감 </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
            font-size: 40px;
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
        
        
        tbody, tr, td{
        	color:white;
        	background:#A4A7B3;
        }
		#chooseBook{
			margin-top:20px;
			margin-right:30px;
			margin-bottom:30px;
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
    
    <main>
       
		<div class="slider-area2 section-bg2 hero-overly" style="background-color: #6785FF; height: 100px;">
            <div class="slider-height2 d-flex align-items-center" style="background-color: #6785FF; height: 100px;">
                <h2 id="currentMenu">책 검색</h2>
            </div>
        </div>
        
        <!-- Static Table Start -->
       
        <div style="width :300px; height : 200pxpx; background : bule;"></div>
        <div class="data-table-area mg-b-15;" >
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="sparkline13-list">
                            <div class="sparkline13-hd">
                            </div>
                            <div class="sparkline13-graph">
                              <div class="datatable-dashv1-list custom-datatable-overright">
                                    
                                    <table id="table" data-toggle="table" data-pagination="true" data-search="true" data-show-columns="false" data-show-pagination-switch="true" data-show-refresh="true" data-key-events="false" data-show-toggle="false" data-resizable="false" data-cookie="false"
                                        data-cookie-id-table="saveId" data-show-export="false" data-click-to-select="false" data-toolbar="#toolbar" style="text-align : center;">
                                        <thead  style="text-align : center;">
                                            <tr>
                                                <th data-field="state" data-select="false"></th>
                                                <th data-field="photo" data-editable="false">책 사진</th>
                                                <th data-field="name" data-editable="false">책명</th>
                                                <th data-field="email" data-editable="false">카테고리</th>
                                                <th data-field="phone" data-editable="false">저자</th>
                                                <th data-field="task" data-editable="false">출판사 </th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                             <% if(list.isEmpty()){ %>
											<tr>
												<td colspan="5">존재하는 책이 없습니다.</td>
											</tr>
											<% } else{%>
													
											<%		String bookName = null;
													for(int i = 0; i < list.size(); i++){ %>
											<tr><% 		if(list.get(i).getBookTitle().length()>20){
														bookName = list.get(i).getBookTitle().substring(0, 20);
														}else{
														bookName = list.get(i).getBookTitle();
														}%>
											
												<td style="vertical-align:middle"><input type="radio" name="book" value="<%= list.get(i).getBookTitle() %>,<%= list.get(i).getAuthor()%>,<%= list.get(i).getImageFile() %>,<%= list.get(i).getBookNo() %>"></td>
												<td><img height="150px" id="titleImg" name="titleImg" src="<%= request.getContextPath() %>/<%= list.get(i).getImageFile() %>"></td>
												<td><%= bookName %></td>
												<td><%= list.get(i).getCateName() %></td>
												<td><%= list.get(i).getAuthor() %></td>
												<td><%= list.get(i).getPublisher() %></td>
											</tr>
											<%		} %>
											<% } %>
                                           
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       
  	

 <div class="floating"><input type="button" id="chooseBook" value="선택하기" class="btn btn-dark" onclick="confirm();" style="float: right; margin-left: 10px;"></div>       
    

<script>
	function confirm(){
		 var obj_length = document.getElementsByName("book").length;
		  var bookValue;
	        for (var i=0; i<obj_length; i++) {
	            if (document.getElementsByName("book")[i].checked == true) {
	               	bookNo = document.getElementsByName("book")[i].value;
	               	var bookArr = bookNo.split(',');
	               	
	              	opener.document.commentForm.uploadName.value=bookArr[0];
	              	opener.document.commentForm.uploadName2.value=bookArr[1];
	              	opener.document.commentForm.bookImg.src=bookArr[2];
	              	opener.document.commentForm.uploadName3.value=bookArr[3];
	              	
	               	window.close();
	            }
	        }
	        
	}
	

</script>        
        

    <!-- Scroll Up -->
   
    <script>
        $(function () {
            var now = new Date();
            var year = now.getFullYear();
            var month = now.getMonth() + 1;
            var date = now.getDate();
            $('input[name=reqDate]').val(year + '-' + month + '-' + date);
            console.log(now);
        });
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