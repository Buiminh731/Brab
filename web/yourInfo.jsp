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
        <link rel="stylesheet" href="css/book.css" type="text/css">
        <link rel="stylesheet" href="css/info.css.css" type="text/css">
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
                            <li><a href="<%=request.getContextPath()%>/homepage">Home</a></li>
                            <li><a href="<%=request.getContextPath()%>/booking">Booked</a></li>
                            <c:if test="${c.is_driver}"><li><a href="<%=request.getContextPath()%>/addcar">Add Car</a></li></c:if>
                            <c:if test="${c.is_driver}"><li><a href="<%=request.getContextPath()%>/drivercontrol">Order</a></li></c:if>
                            <li class="active"><a href="<%=request.getContextPath()%>/yourinfo">Your Info</a></li>
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


    <c:set var="err" value="${requestScope.msg}"/>

    <div class="col-md-6 container contai login-window">
        <br>
        <p style="color: #3BC070; font-size: 30px;font-weight: 900">My Profile</p>
        <br>
    </div>

    <c:if test="${c.is_driver}">


        <div class="col-md-6 container contai login-window">
            <p style="color: #3BC070; font-size: larger;font-weight: 700">Vehicle management:</p>
            <br>
            <c:forEach var="car" items="${requestScope.listC}">
                <c:if test="${c.customer_id eq car.customer_id}">
                    <div class="container">    
                        <div class="row book-window">
                            <div class="col-md-3">    
                                <img class="img-window" src="data:image/jpeg;base64,${car.encodedImg}">
                            </div>
                            <div class="col-md-4">
                                <h6>Model: ${car.model}<h6>
                                <h6>Plate: ${car.plate}<h6>
                            </div>
                            <div class="col-md-4">
                                <form action="delete" method="post">  
                                    <input type="hidden" name="car_id" value="${car.car_id}">
                                    <button>Delete vehicle</button>
                                </form>
                                <p style="color: #F94D30; font-size: small;font-weight: 500">*You can only delete if there weren't any reservation. </p>
                            </div>
                        </div>
                    </div><br>       
                </c:if>    
            </c:forEach>
            <c:if test="${not empty err}">
                <p style="color: #F94D30; font-size: small;font-weight: 500">${err}</p>
            </c:if>            
        </div>
    </c:if>
    <form action="yourinfo" method="post">
        <div class="col-md-6 container contai login-window">
            <p style="color: #3BC070; font-size: larger;font-weight: 700">Your Information</p>
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
            <p style="color: #F94D30; font-size: small;font-weight: 500">Please login again after changing info</p>
            <button class="commit" type="submit">Commit change</button><br>
            <br>
        </div>
    </form>

    <form action="changepass" method="post">
        <div class="col-md-6 container contai login-window">
            <p style="color: #3BC070; font-size: larger;font-weight: 700">Change password</p>
            <input type="hidden" id="customer_id" name="customer_id" value="${c.customer_id}">
            <label for="psw">Old password:</label>
            <input type="password" id="psw" name="psw" placeholder="">
            <br>
            <%
            String checkPass = (String)request.getAttribute("checkPass");
            if(checkPass!=null){
            %>
            <div style="color: #F94D30; font-size: small;font-weight: 500"><%=checkPass%></div>
            <%}
            %>
            <label for="npsw">New password</label>
            <input type="password" id="npsw" name="npsw" placeholder="">
            <br>
            <label for="email">Confirm password:</label>
            <input type="password" id="cnpsw" name="cnpsw" placeholder="">
            <br>
            <%
            String checkSimlarity = (String)request.getAttribute("checkSimlarity");
            if(checkSimlarity!=null){
            %>
            <div style="color: #F94D30; font-size: small;font-weight: 500"><%=checkSimlarity%></div>
            <%}
            %>
            <button class="commit" type="submit">Commit change</button><br>
            <br>
        </div>
    </form>
            <c:set var="summary" value="${requestScope.summary}"/>
            <c:if test="${c.is_driver}">
                <div class="col-md-6 container contai login-window">
                <br>
                    <p style="color: #3BC070; font-size: 30px;font-weight: 900">Statistic</p>
                <br>
                </div>
                
                <div class="col-md-6 container contai login-window">
                <br>
                    <p style="color: #3BC070; font-size: larger;font-weight: 700">Money made: ${summary}</p>
                <br>
                </div> 
                <div class="col-md-6 container contai login-window">
                <br>
                    <p style="color: #3BC070; font-size: larger;font-weight: 700">History: </p>
                <br>
                <table>
                    <table style="width: 100%" border="1">
                        <thead style="text-align: center; background-color:#3BC070">
                            <tr>
                                <th>Vehicle Name</th>
                                <th>Order Time</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="bookList" items="${requestScope.bookList}">
                                <c:forEach var="car" items="${requestScope.listC}">
                                    <c:if test="${bookList.car_id eq car.car_id}">
                                    <tr style="text-align: center">
                                        <td>${car.model}</td>
                                        <td>${bookList.pick_time}</td>
                                        <td>${bookList.price}</td>
                                    </tr>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br>

                </table>
                
                </div>
            </c:if>
            
             <div class="col-md-6 container contai login-window">
                <div id="chartContainer" style="height: 370px; width: 100%;"></div>
                <br>
            </div>
            
            <div class="col-md-6 container contai login-window">
                <br>
                    <p style="color: #3BC070; font-size: larger;font-weight: 700">Details: </p>
                <br>
                <table>
                    <table style="width: 100%" border="1">
                        <thead style="text-align: center; background-color:#3BC070">
                            <tr>
                                <th>Years</th>
                                <th>Number of Order </th>
                                <th>Revenue</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="chart" items="${requestScope.listChart}">
                                    <tr style="text-align: center">
                                        <td>${chart.customer_id}</td>
                                        <td>${chart.car_id}</td>
                                        <td>${chart.price}</td>
                                    </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br>

                </table>
                
                </div>
     
    <!-- Latest Blog Section End -->
    <%@include file="footer.jsp" %>

    <!-- Js Plugins -->
     <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script>
window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	zoomEnabled: true,
	theme: "light1",
	title: {
		text: "Statistic Chart"
	},
	axisX: {
		title: "Year",
		valueFormatString: "####",
		interval: 1
	},
	axisY: {
		logarithmic: true, //change it to false
		title: "Number of Order",
		titleFontColor: "#6D78AD",
		lineColor: "#6D78AD",
		gridThickness: 0,
		lineThickness: 1,
		labelFormatter: addSymbols
	},
	axisY2: {
		title: "Money made",
		titleFontColor: "#51CDA0",
		logarithmic: false, //change it to true
		lineColor: "#51CDA0",
		gridThickness: 0,
		lineThickness: 1,
		labelFormatter: addSymbols
	},
	legend: {
		verticalAlign: "top",
		fontSize: 16,
		dockInsidePlotArea: true
	},
	data: [{
		type: "line",
		xValueFormatString: "####",
		showInLegend: true,
		name: "Number of order",
		dataPoints: [
                    
                        <c:forEach var="chart" items="${requestScope.listChart}">
                        { x: ${chart.customer_id}, y: ${chart.car_id} },
                        </c:forEach>
		]
	},
	{
		type: "line",
		xValueFormatString: "####",
		axisYType: "secondary",
		showInLegend: true,
		name: "Money made",
		dataPoints: [
			<c:forEach var="chart" items="${requestScope.listChart}">
                        { x: ${chart.customer_id}, y: ${chart.price} },
                        </c:forEach>
		]
	}]
});
chart.render();

function addSymbols(e) {
	var suffixes = ["", "K", "M", "B", "T"];

	var order = Math.max(Math.floor(Math.log(Math.abs(e.value)) / Math.log(1000)), 0);
	if(order > suffixes.length - 1)
		order = suffixes.length - 1;

	var suffix = suffixes[order];
	return CanvasJS.formatNumber(e.value / Math.pow(1000, order), "#,##0.##") + suffix;
}

}
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
