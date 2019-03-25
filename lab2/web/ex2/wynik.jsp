<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ela
  Date: 3/11/19
  Time: 9:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Dorabca Piwny$</title>
</head>
<body>
Doradca Piwny mówi,że idealne dla Ciebie będzie:
<%
    //allow access only if session exists

    String beer = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("beerColor")) beer = cookie.getValue();
        }
    }
%>
<h3><%=beer %></h3>


</body>
</html>
@WebFilter(filterName = "AuthenticationFilter")