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
        <c:set var="s" value="${requestScope.searchInput}"/>
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
                        <a class="active" href="#" class="search-switch"><img src="img/icon/search.png" alt=""></a>
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


    <!-- Shop Section Begin -->
    <section class="shop spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="shop__sidebar">
                        <div class="shop__sidebar__search">
                            <form class="search-model-form" action="search" method="post">
                                <input type="text" id="search-input" name="search-input" placeholder="Search here.....">
                            </form>
                        </div>
                        <div class="shop__sidebar__accordion">
                            <div class="accordion" id="accordionExample">
                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseOne">Brand</a>
                                    </div>
                                    <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="shop__sidebar__categories">
                                                <ul class="nice-scroll">
                                                    <li><a href="<%=request.getContextPath()%>/search?search-input=Toyota">Toyota</a></li>
                                                    <li><a href="<%=request.getContextPath()%>/search?search-input=Hyundai">Hyundai</a></li>
                                                    <li><a href="<%=request.getContextPath()%>/search?search-input=Mercedes Benz">Mercedes Benz</a></li>
                                                    <li><a href="<%=request.getContextPath()%>/search?search-input=Mitsubishi">Mitsubishi</a></li>
                                                    <li><a href="<%=request.getContextPath()%>/search?search-input=KIA">KIA</a></li>
                                                    <li><a href="<%=request.getContextPath()%>/search?search-input=Honda">Honda</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>




                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9">
                    <c:if test="${empty s}">
                        <label><b style="color: #EE4D2D">Enter value to search</b></label>
                    </c:if>
                    <c:if test="${not empty s}">
                        <label>Result for "<b style="color: #EE4D2D">${s}</b>"</label>
                    </c:if>
                    <div class="row">
                        <c:forEach items="${requestScope.data}" var="c">
                            <div class="col-lg-4 col-md-6 col-sm-6">
                                <div class="product__item">
                                    <div class="product__item__pic set-bg" data-setbg="data:image/jpeg;base64,${c.encodedImg}">
                                        <ul class="product__hover">
                                            <li><a href="#"><img src="img/icon/heart.png" alt=""></a></li>
                                            <li><a href="#"><img src="img/icon/compare.png" alt=""> <span>Compare</span></a></li>
                                            <li><a href="#"><img src="img/icon/search.png" alt=""></a></li>
                                        </ul>
                                    </div>
                                    <div class="product__item__text">
                                        <a href="<%=request.getContextPath()%>/addwaitlist?car_id=${c.car_id}" class="add-cart">+ Book now</a>
                                        <br>
                                        <h5>${c.model}</h5>
                                        <h6>${c.plate}</h6>
                                        <h6>${c.owner}</h5>
                                            <div class="rating">
                                                <i class="fa fa-star-o"></i>
                                                <i class="fa fa-star-o"></i>
                                                <i class="fa fa-star-o"></i>
                                                <i class="fa fa-star-o"></i>
                                                <i class="fa fa-star-o"></i>
                                            </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>   
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="product__pagination">
                                <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                    <a class="${i==page?"active":""}" href="search?page=${i}&search-input=${s}">${i}&nbsp;</a> 
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shop Section End -->

    <!-- Js Plugins -->

    <script src="js/myjs.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery.nicescroll.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/jquery.countdown.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>

</body>
</html>
