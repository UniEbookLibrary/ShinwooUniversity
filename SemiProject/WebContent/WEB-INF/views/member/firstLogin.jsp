<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.vo.Member"%>
<%
	Member m = (Member)request.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>회원 등록</title>
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
		#enrollTable{

	
		width:600px; height:800px;
		margin:auto;
	
		}
	
		.category{
			font-weight:bold;
			font-family: 'Gowun Dodum', sans-serif;
			width: 150px;
		}
		#notice{
			font-size:3px;
			font-family: 'Gowun Dodum', sans-serif;
		}
		.red{
			color:red;
		}
		input:read-only{background-color:#EAEAEA}
		.confirm{
			text-align:center;
			font-size:3px;
			font-family: 'Gowun Dodum', sans-serif;
		}
		#memberEnroll{
			text-align:center;
		}
		
		#notice1 {
			text-align: center;
			font-size: 3px;
			font-family: 'Gowun Dodum', sans-serif;
		}
		
		#Btns {
			text-align: center;
		}
		
		#spanAuth{
			display:none;
		}
		#emailAuth{
			display:none;
		}
		#confirmAuth{
			display:none;
		}
		#authentic{
			display:none;
		}
		#authEmail{
			display:none;
		}
    </style>
</head>

<body onload="alert('최초로 로그인하셨습니다. 정보입력이 필요합니다.')">
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
        <!--? Hero Start -->
        <div class="slider-area2 section-bg2 hero-overly" style="background-color: #6785FF; height: 150px;">
            <div class="slider-height2 d-flex align-items-center" style="background-color: #6785FF; height: 150px;">
                <h3 id="currentMenu">최초 등록</h3>
            </div>
        </div>
        <br><br>

	
		<form id="firstLoginForm" action='<%= request.getContextPath() %>/firstLogin.me' method='post'>
    	<table id ="enrollTable">
    		<tr>
    			<td width="300px" class="category">학번</td>
    			<td colspan="2">
    				<div id="studentNo"><%= m.getMemberId() %></div>
	    			<input type="hidden" name="memberId" value="<%= m.getMemberId() %>">
    			</td>
    		</tr>
    		<tr>
    			<td class="category">이름</td>
    			<td colspan="2"><div id="name"><%= m.getMemberName() %></div></td>
    		</tr>
    		<tr>
    			<td class="category">학과</td>
    			<td colspan="2" width = "200px"><div id="major"> <%= m.getDepartment() %></div></td>
    		</tr>
    		<tr>
    			<td class="category">비밀번호<span class="red">*</span></td>
    			<td colspan="3">
    				<div class="mt-10">
					<input type="password" name="password" id ="password"
					onfocus="this.placeholder = ''"  required
					class="single-input">
					</div>
					<div id="notice">영문, 숫자, 특수문자(!,@,#,$,%,^,&,*) 포함 8자리 이상 입력</div>								
    			</td>
    		</tr>
    		<tr>
    			<td class="category">비밀번호 확인<span class="red">*</span></td>
    			<td colspan="3">
    			<div class="mt-10">
					<input type="password" name="passConfirm" id ="passConfirm"
					 onblur="confirm1();" required
					class="single-input" >
				</div><div class="confirm" id="notice2"></div></td>
    		</tr>
    		<tr>
    			<td class="category">전화번호</td>
				<td width="1%">
					<div class="mt-10">
						<div class="phone" id="number1">
							<select name="number1">
								<option value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="018">018</option>
								<option value="019">019</option>
							</select>
						</div>
					</div>
				</td>
				<td colspan="2">
					<div class="mt-10">
						<input type="text" name="number2" class="single-input" placeholder="- 제외" onfocus="this.placeholder = ''" onblur="this.placeholder = '- 제외'">
					</div>
				</td>
    		</tr>
    		<tr>
    			<td class="category" width="300px">이메일 <span class="red">*</span></td>
    			<td colspan="2">
    				<div>
						<input type="text" name="email1" id="email1" required class="single-input">
					</div>
				</td>
				<td>
					<div>
						<select class="email" name="email2" id="email2" onChange="selectEmail(this)">
							<option value="@naver.com">@naver.com</option>
							<option value="@gmail.com">@gmail.com</option>
							<option value="@daum.net">@daum.net</option>
							<option value="@nate.com">@nate.com</option>
							<option value="etc">기타</option>
						</select>
						
					</div>
				</td>
				<td width="80px"><div id="isjungbok"><input type="button" class="genric-btn info-border" id="checkEmail" value="중복확인"></div></td>
			</tr>
			<tr>
				<td class="category" id="authEmail">인증하기 <span class="red">*</span></td>
				
				
				<td colspan="2">
    				<div>
						<input type="text" name="emailAuth" id="emailAuth" required class="single-input">
					</div>
				</td>
				<td id="authEmail3">
				<input type="button" id="confirmAuth" class="genric-btn info-border" value="확인" onclick="confirmAuthNum();">
				</td>
				<td id="authEmail1" class="category"><input type="button" id="spanAuth" onclick="authFunc();" value="인증하기"></td>
				<!-- <div id="pwDiv"><input type="password" name="userPwd" id="userPwd" placeholder="비밀번호 입력"><input  type="button" id="goModify" value="확인""></div> -->
			</tr>
			<script>
			
			var finalAuth;
			
			function authFunc(){
				$('#email1').attr('readonly',true);
				var email = document.getElementById("email1").value + document.getElementById("email2").value;
				$.ajax({
	  				url:'emailAuth.me',
	  				data:{userEmail : email},
	  				success:function(data){
	  					console.log(data);
	  					finalAuth = data;
	  					console.log(finalAuth);
	  					alert('인증번호가 발송되었습니다.');
	  				},
	  				error:function(data){
	  					console.log(data);
	  				}
	  			});
				
			}
			</script>
			
			 <script>
					  		$('#checkEmail').click(function(){
					  			var email = document.getElementById("email1").value + document.getElementById("email2").value;

	  							var button_joinus = document.getElementById('checkEmail');
					  			$.ajax({
					  				url:'checkEmail.me',
					  				data:{userEmail : email},
					  				success:function(data){
					  					console.log(data);
					  					if(data.trim()=='1'){
					  						alert('사용 불가능한 이메일입니다.');
					  					}else{
					  						var bool = confirm('사용가능한 이메일입니다\n인증번호를 발송하시겠습니까?');
					  						if(bool){
						  						$("#spanAuth").trigger("click");
						  							document.getElementById("spanAuth").style.display = 'none';
						  							document.getElementById("emailAuth").style.display = 'block';
						  							document.getElementById("confirmAuth").style.display = 'block';
						  							document.getElementById("authEmail").style.display = 'block';
						  							
						  							$('#checkEmail').hide();
					  						}
					  					}
					  				},
					  				error:function(data){
					  					console.log(data);
					  				}
					  			});
					  		});
					  			
					  		
  				</script>
			<script>
			var emailCheckYN = 'N';
				function confirmAuthNum(){
					var emailAuth = document.getElementById("emailAuth").value;
					
					if((emailAuth+"").trim() == (finalAuth+"").trim()){
						alert('인증되었습니다.');
						document.getElementById("emailAuth").value = '인증완료';
						emailCheckYN = 'Y';
						$('#emailAuth').attr('readonly',true);
					} else{
						alert('인증번호가 틀렸습니다.\n다시입력해주세요.');
					}
				}
			
			</script>
			<tr>
				<td class="category">주소</td>
				<td colspan="3"><input class="single-input"  type="text" name="addr1"  readonly /></td>
				<td width="100px" style="padding-left: 10px;">
					<button type="button" class="genric-btn info-border" onclick="openZipSearch()">검색</button>
				</td>
			</tr>
			<tr>
				<td class="category">상세 주소</td>
				<td colspan="4"><input class="single-input" type="text" name="addr2"/></td>
			</tr>
			
			 <script>
				function openZipSearch() {
					new daum.Postcode({
						oncomplete: function(data) {
							$('[name=zip]').val(data.zonecode); // 우편번호 (5자리)
							$('[name=addr1]').val(data.address);
							$('[name=addr2]').val(data.buildingName);
						}
					}).open();
				}
				</script>
			
			<!-- <tr>
			
				<td class="category">주소</td>
				<td>
					<div>
						<select class="address" id="address1" name="address1">
							<option>시/도</option>
							<option value="강원도">강원도</option>
							<option value="경기도">경기도</option>
							<option value="경상남도">경상남도</option>
							<option value="경상북도">경상북도</option>
							<option value="광주광역시">광주광역시</option>
							<option value="대구광역시">대구광역시</option>
							<option value="대전광역시">대전광역시</option>
							<option value="부산광역시">부산광역시</option>
							<option value="서울특별시">서울특별시</option>
							<option value="울산광역시">울산광역시</option>
							<option value="인천광역시">인천광역시</option>
							<option value="전라남도">전라남도</option>
							<option value="전라북도">전라북도</option>
							<option value="제주특별자치도">제주특별자치도</option>
							<option value="충청남도">충청남도</option>
							<option value="충청북도">충청북도</option>
						</select>
					</div>
				</td>
				
				<td colspan="2">
					<div class="mt-10">
						<input type="text" name="address2" class="single-input" placeholder="도로명 주소 입력" onfocus="this.placeholder = ''" onblur="this.placeholder = '도로명 주소 입력'">
					</div>
				</td></tr>-->
				
			
			<tr>
				<td colspan="6">
				<br><br>
				<div id="memberEnroll">
					<button type="submit" class="genric-btn info circle" onclick= "return submitAlarm();">초기설정완료</button>
				</div>
				</td>
			</tr>
   	
    	</table>
    </form>
    

     
    </main>
    <%@ include file="../common/footer.jsp" %>
    <!-- Scroll Up -->
	<div id="back-top" >
   		<a title="Go to Top" href="#"> <i class="fas fa-level-up-alt"></i></a>
	</div>
    
    
    <!-- java script -->
	<script>
	
	function selectEmail(ele){ 
  		var $ele = $(ele); 
  		var $email2 = $('input[name=email2]'); //
  		if($ele.val() == "etc"){ 
  			$email2.attr('readonly', false); 
  			$email2.val(''); 
  		} else { 
  			$email2.attr('readonly', true); 
  			$email2.val($ele.val()); 
  		} 
  	}
 
	function confirm1(){
		var pass = document.getElementsByName('password');
		var pass2 = document.getElementsByName('passConfirm');
		var notice = document.getElementById('notice2');

		
		if(pass2.value ==''|| pass2.value.length ==0){
			notice.innerText = '';
		}else if(pass.value != pass2.value){
			notice.innerText = '비밀번호가 일치하지 않습니다.';
			notice.style.color = 'red';
		}else{
			notice.innerText = '비밀번호가 일치합니다.';
			notice.style.color = 'green';
		}
	} 

	 /* 	$("#password").change(function(){
		    checkPassword($('#password').val());
		});
		function checkPassword(password){
		    
		    if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*])(?=.*[0-9]).{8,25}$/.test(password)){            
		        $('#notice').text('알맞은 비밀번호 입니다.');
		        $('#passConfirm').focus();
		        return false;
		    }    
		
		}
		
	
		
		 $('#password').on('blur', function(){
			if($('#passConfirm').val() == ''){
				$('#notice2').text('비밀번호를 한 번 더  입력하세요');		
			}else if($('#password').val() != $('#passConfirm').val()){
				$('#notice2').text('비밀번호가 일치하지 않습니다.').css('color', 'red');
			}else {
				$('#notice2').text('비밀번호가 서로 일치합니다.').css('color', 'green');
			}
		});
		 */
		function submitAlarm(){
			 var pw = $("#password").val();
			 var num = pw.search(/[0-9]/g);
			 var eng = pw.search(/[a-z]/ig);
			 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

			 if(pw.length < 8 || pw.length > 20){

			  alert("8자리 ~ 20자리 이내로 입력해주세요.");
			  return false;
			 }else if(pw.search(/\s/) != -1){
			  alert("비밀번호는 공백 없이 입력해주세요.");
			  return false;
			 }else if(num < 0 || eng < 0 || spe < 0 ){
			  alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");
			  return false;
			 }

			if(document.getElementById('password').value != document.getElementById('passConfirm').value){
				alert('비밀번호가 일치하지 않습니다.');
				$('#passConfirm').val("");
				$('#passConfirm').focus();
				return false;
			}
			if($('#email').val() == ''){
				alert('이메일이 입력되지 않았습니다.');
				$('#email').val("");
				$('#email').focus();
				return false;
				
			}
			if(emailCheckYN == 'N'){
				alert('이메일 인증이 진행되지 않았습니다.\n이메일인증을 진행해주세요.');
				$('#emailAuth').val("");
				$('#emailAuth').focus();
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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>

</html>