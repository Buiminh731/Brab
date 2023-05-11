<%-- 
    Document   : login
    Created on : Feb 15, 2023, 8:45:11 AM
    Author     : Minh Bui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <title>Login</title>
        <link rel="icon" href="img/favicon.png">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/login_css.css" />
    </head>

    <body>
        <form action="login" method="post">
            <div class="col-3 container login-window">

                <label class="heading" for="uname"><b>Username</b></label>&nbsp;
                <input type="text" placeholder="Enter Username" name="uname" required>

                <label class="heading" for="psw"><b>Password</b>&nbsp;</label>
                <input type="password" placeholder="Enter Password" name="psw" required>
                <br>
                <%
                String err = (String)request.getAttribute("err");
                if(err!=null){
                %>
                    <div class="errr"><%=err%></div>
                <%}
                %>
                <button type="submit">Login</button>
                <br>
                <br>
                <div class="fpsw">
                    <span> <a href="#"> Forgot password?</a></span><br>
                    <a href="<%=request.getContextPath()%>/signup"> Create an account</a>
                </div>
            </div>
        </form>
    </body>
</html>