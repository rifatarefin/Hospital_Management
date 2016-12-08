<%-- 
    Document   : Checkout.jsp
    Created on : Nov 19, 2016, 4:02:28 PM
    Author     : samsung
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="sukarna.models.CartItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Doctor's List</h1>
        <% 
        
            ArrayList<CartItem> cart = (ArrayList<CartItem>)session.getAttribute("cart");
            
            int counter = 1;
            out.print( String.format("&nbsp &nbsp &nbspName  &nbsp &nbspTime </br>"));
            for(CartItem item: cart)
            {
                out.print( String.format("%d. %s  &nbsp &nbsp %d </br>", counter,
                        item.getProduct(), item.getAmount()) );
                counter++;
            }
            
        
        %>

        <a href="Appoints.jsp">Get Appointment</a>
    </body>
</html>
