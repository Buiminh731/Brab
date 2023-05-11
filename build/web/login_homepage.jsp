<%-- 
    Document   : index.jsp
    Created on : Feb 19, 2023, 3:46:42 PM
    Author     : Minh Bui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dal.CarDAO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Male_Fashion Template">
        <meta name="keywords" content="Male_Fashion, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge"> 
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
        <link rel="stylesheet" href="css/modal.css" type="text/css">
    </head>

    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>


        <!-- Header Section Begin -->
        <c:set var="c" value="${requestScope.current}"/>
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
                                <li class="active"><a href="<%=request.getContextPath()%>/homepage">Home</a></li>
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

        <!-- Hero Section Begin -->
        <section class="hero">

            <div class="hero__items set-bg" data-setbg="img/brab-hero.png">
              <  <div class="container">
                    <div class="row">
                        <div class="col-xl-5 col-lg-7 col-md-8">
                            <div class="hero__text">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

        <!-- Banner Section Begin -->
        
        <c:if test="${not c.is_driver}">
        <section class="instagram spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <h1 style="font-size: 50px; font-weight: 700; font-family: ">Trở thành Đối tác của Brab</h2>
                            <br>
                            <p>Trở thành Đối tác của Grab để làm chủ cuộc sống của mình và hơn thế nữa. Hãy cùng nhau bắt đầu hành trình ngay nào.</p>
                            <br>
                            <a href="<%=request.getContextPath()%>/becomepartner"><h3 style="font-weight: 700;color: #E53637">Bắt đầu ngay!</h3></a>
                    </div>
                    <div class="col-lg-4">

                    </div>
                </div>
            </div>
        </section>
        </c:if>       
        <!-- Banner Section End -->


        <!-- Product Section Begin -->
        <br><br>
        <section class="product spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <ul class="filter__controls">
                            <li class="active" data-filter=".all">All Car</li>
                            <li data-filter=".hot-sales">Hot Car</li>
                        </ul>
                    </div>
                </div>
                <div class="row product__filter">
                    <c:forEach items="${requestScope.listA}" var="c">
                        <div class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix all">
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
                    <c:forEach items="${requestScope.listTop}" var="c">
                        <div class="col-lg-3 col-md-6 col-sm-6 col-md-6 col-sm-6 mix hot-sales">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" data-setbg="data:image/jpeg;base64,${c.encodedImg}">
                                    <ul class="product__hover">
                                        <li><a href="#"><img src="img/icon/heart.png" alt=""></a></li>
                                        <li><a href="#"><img src="img/icon/compare.png" alt=""><span>Compare</span></a></li>
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
            </div>
        </section>
        <!-- Product Section End -->

        <!-- Latest Blog Section Begin -->
        <section class="latest spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <span>Latest News</span>
                            <h2>About Brab</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="blog__item">
                            <div class="blog__item__pic set-bg" data-setbg="img/favicon.png"></div>
                            <div class="blog__item__text">
                                <span><img src="img/icon/calendar.png" alt=""> 16 February 2020</span>
                                <h5>Brab is now on the stock market</h5>
                                <a href="#">Read More</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="blog__item">
                            <div class="blog__item__pic set-bg" data-setbg="img/favicon.png"></div>
                            <div class="blog__item__text">
                                <span><img src="img/icon/calendar.png" alt=""> 21 February 2020</span>
                                <h5>What makes Brab so special</h5>
                                <a href="#">Read More</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="blog__item">
                            <div class="blog__item__pic set-bg" data-setbg="img/favicon.png"></div>
                            <div class="blog__item__text">
                                <span><img src="img/icon/calendar.png" alt=""> 28 February 2020</span>
                                <h5>The founder of Brab. Who is he?</h5>
                                <a href="#">Read More</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <div class="col-md-6 container contai login-window">
        <br>
                    <p style="color: #3BC070; font-size: larger;font-weight: 700">Where are we: </p>
        <br>
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.485534575798!2d105.52487025064002!3d21.01324998593816!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31345b465a4e65fb%3A0xaae6040cfabe8fe!2zVHLGsOG7nW5nIMSQ4bqhaSBI4buNYyBGUFQ!5e0!3m2!1svi!2s!4v1679372030381!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </div>
        
        <!-- Latest Blog Section End -->
        <%@include file="footer.jsp" %>
        <!-- Search Begin -->
        <div class="search-model">
            <div class="h-100 d-flex align-items-center justify-content-center">
                <div class="search-close-switch">+</div>
                <form class="search-model-form" action="search" method="post">
                    <input type="text" id="search-input" name="search-input" placeholder="Search here.....">
                </form>
            </div>
        </div>
        <!-- Search End -->

        <!-- Js Plugins -->
        <script>
            var button = document.getElementById('send-data');
            button.addEventListener('click', function (event) {
                event.preventDefault(); // prevent form submission
                var xhr = new XMLHttpRequest();
                xhr.open('POST', 'addwaitlist', true);
                xhr.setRequestHeader('Content-Type', 'application/json');
                var data = {
                    model: ${c.model},
                    car_id: ${c.car_id},
                    plate: ${c.plate}
                };
                xhr.send(JSON.stringify(data));
            });
        </script>
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
