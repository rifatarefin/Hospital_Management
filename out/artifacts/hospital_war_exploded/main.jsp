<%--
  Created by IntelliJ IDEA.
  User: Shusmoy
  Date: 12/6/2016
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home </title>

</head>
<body>
<%
    String username = (String) session.getAttribute("username");
    System.out.println(username);
    if(username==null)
    {
        RequestDispatcher rd = request.getRequestDispatcher("index.html");
        rd.forward(request, response);
    }
%>
<h1>Main Menu</h1>
<form method="post" action="AddToCart.do" >



    <input  type="submit" value="Appointment" ><br>
</form>
<form method="post" action="Appoints.do" >
    <input  type="submit" value="Admit" ><br>
</form>
<form method="post" action="AddToCart.do" >
    <input  type="submit" value="Medicine" ><br>
</form>
<form method="post" action="AddToCart.do" >
    <input  type="submit" value="Total Bill" ><br>
</form>
</br>
</body>
</html>
