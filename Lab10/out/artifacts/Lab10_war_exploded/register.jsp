<%--
  Created by IntelliJ IDEA.
  User.User: USER
  Date: 19.04.2020
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab10_Servlets</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<div align="center" style="margin-top: 100px">
    <div align="left" style="margin-left:15%;color: red"><h2>${ErrorMessage}</h2></div>
    <form action="UserRegistrateServletTest" method="post">
        <input type="text" name="Login" placeholder="Enter login">
        <input style="margin-bottom: 10px" type="password" name="Password" placeholder="Enter password">
        <br>
        <input type="submit" value="Registration">
    </form>
</div>
<jsp:include page="/Footer.jsp"/>
</body>
</html>
