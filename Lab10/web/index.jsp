<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 19.04.2020
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab10_Servlets</title>
</head>
<style>
    .horizontal {
        margin: 0;
        padding: 0;
    }

    .horizontal li {
        display: inline-block;
        width: 100px;
        min-height: 20px;
        border: 1px solid #000;
        background: green;
    }

    .horizontal li form div {
        background: green;
        color: red;
    }
</style>
<body>
<div align="center">
    <form action="TimeServletTest" method="get">
        <input type="text" name="TextForUrl" placeholder="Enter some text">
        <input type="submit" value="Current time">
    </form>
</div>
<div style="height: 100px"></div>
<div align="center">
    <form action="UserServletTest" method="post">
        <input type="text" name="Login" placeholder="Enter login">
        <input style="margin-bottom: 10px" type="password" name="Password" placeholder="Enter password">
        <br>
        <input type="submit" value="Log in">
    </form>
</div>
<div style="height: 100px"></div>
<div align="center">
    <form action="UserRegistrateServletTest" method="post">
        <input type="text" name="Login" placeholder="Enter login">
        <input style="margin-bottom: 10px" type="password" name="Password" placeholder="Enter password">
        <br>
        <input type="submit" value="Registrate">
    </form>
</div>
<div style="height: 100px"></div>
<div align="center">
    <ul class="horizontal">
        <li>
            <form action="Task6AServletTest" method="get">
                <div>${mystr1}</div>
                <br>
                <input type="submit" value="Attribute">
            </form>
        </li>
        <li>
            <form action="Task6BServletTest" method="post">
                <div>${mystr2}</div>
                <br>
                <input type="submit" value="Servlet">
            </form>
        </li>
        <li>
            <form action="Task6CServletTest" method="post">
                <div>${mystr3}</div>
                <br>
                <input type="submit" value="Session">
            </form>
        </li>
    </ul>
</div>
</body>
</html>
