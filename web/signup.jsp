<%-- 
    Document   : signup
    Created on : Feb 15, 2023, 9:02:14 AM
    Author     : Minh Bui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>

    <head>
        <title>Sign Up</title>
        <link rel="icon" href="img/favicon.png">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/login_css.css" />
    </head>

    <body>
        <form action="signup" method="post"">
            <div class="col-3 container login-window">

                <label class="heading" for="uname"><b>Username</b></label>&nbsp;
                <input type="text" placeholder="Enter Username" name="uname" required>
                <%
                    String msg = (String)request.getAttribute("msg");
                    if(msg!=null){
                %>
                <div class="errr"><%=msg%></div>
                <%
                    }
                %>
                <label class="heading" for="fname"><b>Full name</b></label>&nbsp;
                <input type="text" placeholder="Enter Full name" name="fname" required>

                <label class="heading" for="psw"><b>Password</b>&nbsp;</label>
                <input type="password" placeholder="Enter Password" name="psw" required>

                <label class="heading" for="cpsw"><b>Confirm Password</b>&nbsp;</label>
                <input type="password" placeholder="Enter Password" name="cpsw" required><!-- comment -->
                <%
                    String msg2 = (String)request.getAttribute("msg2");
                    if(msg2!=null){
                %>
                <div class="errr"><%=msg2%></div>
                <%
                    }
                %>
                <label class="heading" for="phone_number"><b>Contact number</b>&nbsp;</label>
                <input type="tel" placeholder="(123) 456 7890" name="phone_number" pattern="\(?\+[0-9]{1,3}\)? ?-?[0-9]{1,3} ?-?[0-9]{3,5} ?-?[0-9]{4}( ?-?[0-9]{3})? ?([\w\,\@\^]{1,10}\s?\d{1,10})?" required>

                <label class="heading" for="email"><b>E-mail</b>&nbsp;</label>
                <input type="email" placeholder="username@abc.xyz" name="email"  required>
                <%
                    String msg1 = (String)request.getAttribute("msg1");
                    if(msg1!=null){
                %>
                <div class="errr"><%=msg1%></div>
                <%
                    }
                %>

                <label class="heading" for="driver"><b>Is Driver:</b></label></br>
                &nbsp;
                <input class="op" type="radio" id="yes" name="driver" value="true">
                <label class="lb" for="yes">Yes</label>
                &nbsp;
                <input class="op" type="radio" id="no" name="driver" value="false" checked>
                <label class="lb" for="no">No</label><br><br> 
                
                <button type ="submit">Sign up</button>

                <br>
                <br>
                <div class="fpsw">
                    <a href="<%=request.getContextPath()%>/login"> Already have an account?</a>
                </div>
            </div>
        </form>
        <script>
            var form = document.querySelector('form');
            var psw = document.getElementById('psw');
            var cpsw = document.getElementById('cpsw');

            form.addEventListener('submit', function (event) {
                if (passwordInput.value !== confirmPasswordInput.value) {
                    event.preventDefault();
                    alert('Passwords do not match.');
                }
            });
        </script>
    </body>
</html>
