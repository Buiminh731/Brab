<%-- 
    Document   : confirm
    Created on : Mar 7, 2023, 9:46:28 AM
    Author     : Minh Bui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
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
        <link rel="stylesheet" href="css/book.css" type="text/css">
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
                            <li class="active"><a href="<%=request.getContextPath()%>/booking">Booked</a></li>
                            <c:if test="${c.is_driver}"><li><a href="<%=request.getContextPath()%>/addcar">Add Car</a></li></c:if>
                            <c:if test="${c.is_driver}"><li><a href="<%=request.getContextPath()%>/drivercontrol">Order</a></li></c:if>
                            <li><a href="./contact.html">Your Info</a></li>
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


    <div class="col-8 container login-window">
        <label>Confirmed:</label>
        <br>
            <c:forEach var="b" items="${requestScope.listB}">
                <c:forEach var="c" items="${requestScope.listC}">
                    <c:if test="${b.is_confirm}">
                        <c:if test="${b.car_id eq c.car_id}">
                            <div class="container">    
                            <div class="row book-window">
                                <div class="col-md-3">    
                                    <img class="img-window" src="data:image/jpeg;base64,${c.encodedImg}">
                                </div><!-- comment -->
                                <div class="col-md-4">
                                    <h6>Model: ${c.model}<h6>
                                    <h6>Plate: ${c.plate}<h6> 
                                    <h6>Contact info:<h6>
                                            <c:forEach var="cus" items="${requestScope.listCus}">
                                                <c:if test="${cus.customer_id eq c.customer_id}">
                                                    <h6>Name: ${cus.name}</h6>
                                                    <h6>Tel: ${cus.phone_number}<h6>  
                                                    <h6>Email: ${cus.email}<h6>
                                                </c:if>
                                            </c:forEach>
                                </div>
                                <div class="col-md-4">
                                    <h6>Pick Location: ${b.pick_location}<h6>
                                    <h6>Drop Location: ${b.drop_location}<h6>    
                                    <h6>Pick Time: ${b.pick_time}<h6>
                                    <h6>Price:<b style="color: #EE4D2D"> ${b.price}</b></h6>
                                    <h6>Status:<b style="color: #04AA6D"> Confirmed</b></h6>
                                </div>
                            </div>
                        </div><br>       
                        </c:if>
                    </c:if>    
                </c:forEach>
            </c:forEach>
        <br>
        <label>Pending:</label>
        <br>
            <c:forEach var="b" items="${requestScope.listB}">
                <c:forEach var="c" items="${requestScope.listC}">
                    <c:if test="${not b.is_confirm}">
                        <c:if test="${b.car_id eq c.car_id}">
                        <div class="container">    
                            <div class="row book-window">
                                <div class="col-md-3">    
                                    <img class="img-window" src="data:image/jpeg;base64,${c.encodedImg}">
                                </div><!-- comment -->
                                <div class="col-md-4">
                                    <h6>Model: ${c.model}<h6>
                                    <h6>Plate: ${c.plate}<h6> 
                                    <h6>Contact info:<h6>
                                            <c:forEach var="cus" items="${requestScope.listCus}">
                                                <c:if test="${cus.customer_id eq c.customer_id}">
                                                    <h6>Name: ${cus.name}</h6>
                                                    <h6>Tel: ${cus.phone_number}<h6>  
                                                    <h6>Email: ${cus.email}<h6>
                                                </c:if>
                                            </c:forEach> 
                                </div>
                                <div class="col-md-4">
                                    <h6>Pick Location: ${b.pick_location}<h6>
                                    <h6>Drop Location: ${b.drop_location}<h6>    
                                    <h6>Pick Time: ${b.pick_time}<h6>
                                    <h6>Price:<b style="color: #EE4D2D"> ${b.price}</b></h6>
                                    <h6>Status:<b style="color: #EE4D2D"> Pending</b></h6>
                                </div>
                            </div>
                        </div><br>        
                        </c:if>
                    </c:if>    
                </c:forEach>
            </c:forEach>
    </div>
</body>
</html>
