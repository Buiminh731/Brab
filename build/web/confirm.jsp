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
                            <a href="#"><img src="img/header_logo.png" alt=""></a>
                        </div>
                    </div>
                </div>
                <div class="canvas__open"><i class="fa fa-bars"></i></div>
            </div>
        <!-- Header section ends -->                            
        
        <c:set var="car" value="${requestScope.car}"/>
        <form action="addwaitlist" method="post">
            <div class="col-6 container login-window">
                <input type="hidden" id="car_id" name="car_id" value="${car.car_id}">
                <label for="carName">Car Model:</label>
                <input type="text" id="carName" name="carName" placeholder="${car.model}" disabled>
                <br>
                <label for="carPlate">Car Plate:</label>
                <input type="text" id="carPlate" name="carPlate" placeholder="${car.plate}" disabled>
                <br>
                <label for="driver">Driver:</label>
                <input type="text" id="driver" name="driver" placeholder="${car.owner}" disabled>
                <br>
                <label for="pickLocation">Pick Location:</label>
                <input type="text" id="pickLocation" name="pickLocation" placeholder=" Enter Pick Location" required>
                <br>
                <label for="dropLocation">Drop Location:</label>
                <input type="text" id="dropLocation" name="dropLocation" placeholder="Enter Drop location" required>
                <br>
                <label for="pickTime">Pick-up Time:</label>
                <input type="datetime-local" id="pickTime" name="pickTime" placeholder="Enter Pick-up Time" required>
                <br>
                <label for="desiredPrice">Desired Price:</label>
                <input type="number" id="desiredPrice" name="desiredPrice" min="0" step="0.01" placeholder="Enter desired price..."><!-- comment -->
                <br><br>
                <button type="submit">Submit</button><br>
                <div class="right-link">
                    <a  href="<%=request.getContextPath()%>/homepage">Choose a different car &nbsp;</a>
                </div>
            </div>
        </form>
    </body>
</html>
