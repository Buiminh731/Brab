<%-- 
    Document   : addCar
    Created on : Mar 8, 2023, 10:22:18 AM
    Author     : Minh Bui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Brab</title>
        <link rel="icon" href="img/favicon.png">
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
        <!-- Header Section Begin -->
        <%@include file="header.jsp" %>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-3">
                        <div class="header__logo">
                            <a href="<%=request.getContextPath()%>/homepage"><img src="img/header_logo.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li><a href="<%=request.getContextPath()%>/homepage">Home</a></li>
                                <li><a href="<%=request.getContextPath()%>/booking">Booked</a></li>
                                <c:if test="${c.is_driver}"><li><a href="<%=request.getContextPath()%>/addcar">Add Car</a></li></c:if>
                                <c:if test="${c.is_driver}"><li><a href="<%=request.getContextPath()%>/drivercontrol">Order</a></li></c:if>
                                <li><a href="<%=request.getContextPath()%>/yourinfo">Your Info</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3 col-md-3">
                        <div class="header__nav__option">
                            <a href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a>
                            <a href="#"><img src="img/icon/heart.png" alt=""></a>
                            <a href="#"><img src="img/icon/cart.png" alt=""> <span>0</span></a>
                            <div class="price">$0.00</div>
                        </div>
                    </div>
                </div>
                <div class="canvas__open"><i class="fa fa-bars"></i></div>
            </div>
        </header>
        <!-- Header Section End -->
        <form enctype="multipart/form-data" action="addcar" method="post">
            <div class="col-6 container login-window">
                <p style="color: #e53637">*Điền đầy đủ thông tin phương tiện của bạn.</p>
                <input type="hidden" id="customer_id" name="customer_id" value="${c.customer_id}">
                <label for="model">Model:</label>
                <input type="text" id="Model" name="model" placeholder="Car Brand">
                <br>
                <label for="plate">Plate</label>
                <input type="text" id="plate" name="plate" placeholder="99A 99999">
                <br>
                <label for="image">Image:</label><br>
                <input type="file" id="image" name="image" >
                <br>
                <input type="checkbox" id="agree">
                <label for="agree">Tôi đồng ý với tất cả các<a target="_blank" href="rules.jsp"> điều khoản</a></label>
                <br>
                <button type="submit">Submit</button><br>
                <div class="right-link">
                    <a  href="<%=request.getContextPath()%>/homepage">May be later. &nbsp;</a>
                </div>
            </div>
        </form>
    </body>
</html>
