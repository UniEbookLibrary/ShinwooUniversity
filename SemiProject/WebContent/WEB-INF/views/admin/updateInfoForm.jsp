<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="admin.model.vo.UserList"%>
<% 
   UserList ul = (UserList)request.getAttribute("ul");
%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원 정보 변경</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <style>
    .input-form {
      margin-top: 80px;
      padding: 28px;
      background: #fff;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    }
    .updateInfo{
       background: white;
      border: none;
      color: blue;
      text-align: center;
      text-decoration: none;
    }
   table{
      text-align: center;
   }
   #id{
      border:none;
      text-align: center;
   }
   .text{
      text-align: center;
   }
  </style>
</head>

<body>
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">회원 정보 변경</h4>
        <form action="<%= request.getContextPath() %>/userInfoUpdate.ui" method="post" class="validation-form" novalidate>
         <table class="table">
             <thead>
                 <tr align="center">  
                       <th scope="col">아이디</th>
                   <th scope="col">이름</th>
                   <th scope="col">학과</th>
                   <th scope="col" width="200px">전화번호</th>
                   <th scope="col" width="300px">주소</th>
                   <th scope="col">이메일</th>
                   <th scope="col" width="80px">변경</th>  
                 </tr>  
              </thead>
              <tbody>
                 <tr>
                    <td><input type="text" name="id" id="id" size="5" value="<%= ul.getMemberId() %>" readonly></td>
                    <td><input type="text" name="name" class="text" size="5" value="<%= ul.getMemberName()%>"></td>
                    <td><input type="text" name="department" class="text" value="<%= ul.getDepartment() %>"></td>
                    <td>
                       <% String phone = ul.getPhone();
                          if(phone == null){
                             phone = "-";
                          }
                       %>
                     <%= phone %>
                    </td>
                    <td>
                       <%  String newAddr = "";
                          if(ul.getAddress() != null){
                             String[] addr = ul.getAddress().split("&&", -1); 
                             for(int a = 0; a < addr.length; a++){
                                if(a != 0){
                                   newAddr += " ";
                                } 
                                newAddr += addr[a];
                             }
                          } else {
                             newAddr = "-";
                          }
                       %>
                     <%= newAddr %>
                    </td>
                    <td><input type="text" name="email" class="text" value="<%= ul.getEmail() %>"></td>
                    <td><button class="updateInfo" id="updateInfo" type="submit">완료</button></td>
                 </tr>
              </tbody>
           </table> 
        </form>
      </div>
    </div>
  </div>

</body>
</html>