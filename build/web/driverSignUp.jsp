<%-- 
    Document   : confirm
    Created on : Mar 7, 2023, 9:46:28 AM
    Author     : Minh Bui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Brab</title>
        <link rel="icon" href="img/favicon.png">
        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
              rel="stylesheet">     
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/confirm.css" type="text/css">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3">
                    <div class="header__logo">
                        <a href="<%=request.getContextPath()%>/homepage"><img src="img/header_logo.png" alt=""></a>
                    </div>
                </div>
            </div>
            <div class="canvas__open"><i class="fa fa-bars"></i></div>
        </div>
        <!-- Header section ends -->                            

        <c:set var="c" value="${requestScope.current}"/>
        
        <form action="becomepartner" method="post">
            <div class="col-6 container login-window">
                <p style="color: #e53637">*Kiểm tra và điền lại thông tin của bạn. Tất cả thông tin sẽ được sử dụng sau này.</p>
                <input type="hidden" id="customer_id" name="customer_id" value="${c.customer_id}">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" placeholder="${c.username}" disabled>
                <br>
                <label for="name">Name</label>
                <input type="text" id="name" name="name" placeholder="${c.name}">
                <br>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="${c.email}" disabled>
                <br>
                <label for="phonenumber">Phone Number:</label>
                <input type="tel" id="phonenumber" name="phonenumber" placeholder="${c.phone_number}" pattern="\(?\+[0-9]{1,3}\)? ?-?[0-9]{1,3} ?-?[0-9]{3,5} ?-?[0-9]{4}( ?-?[0-9]{3})? ?([\w\,\@\^]{1,10}\s?\d{1,10})?" required>
                <br>
                <input type="checkbox" id="agree" required>
                <label for="agree">Tôi đồng ý với tất cả các<a target="_blank" href="rules.jsp"> điều khoản</a></label>
                <br>
                <p style="color: #e53637">*Vui lòng đăng nhập lại sau khi tham gia. </p><br>
                <button type="submit">Submit</button><br>
                <div class="right-link">
                    <a  href="<%=request.getContextPath()%>/homepage">May be later. &nbsp;</a>
                </div>
            </div>
        </form>
    </body>
</html>
