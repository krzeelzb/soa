<%--
  Created by IntelliJ IDEA.
  User: ela
  Date: 3/25/19
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Wiecej niż 18!</title>
</head>
<body>
<%
    String age = (String) session.getAttribute("age");
    String userAge = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies) {
            if (cookie.getName().equals("age")) userAge = cookie.getValue();
        }
    }
%>

<h3>Cześć. Masz wystarczającą ilość lat by być tutaj!</h3>

<form action="choiceBeerServlet" method="post">
    Podaj kolor piwa:
    kolor: <input type="text" name="beerColor">
    <input type="submit" value="Zatwierdz">
</form>
</body>
</html>
