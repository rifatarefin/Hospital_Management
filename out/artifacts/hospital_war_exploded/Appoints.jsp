<%--
  Created by IntelliJ IDEA.
  User: Shusmoy
  Date: 12/7/2016
  Time: 9:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Appointment</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form method="post" action="appointment.do" >

    Enter your Doctor name:<br> <input type="text" name="dname" /> <br/>
    Enter your Patient Name:<br> <input type="text" name="pname" /> <br/>
    Enter your Date: <br><input type="text" name="date" /> <br/>
    Enter your Time: <br><input type="text" name="time" /> <br/>
    <input type="submit" value="Get Appoint" />
</form>
</body>
</html>
