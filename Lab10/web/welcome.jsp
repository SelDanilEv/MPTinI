<%--
  Created by IntelliJ IDEA.
  User.User: USER
  Date: 19.04.2020
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<style>
    .res {
        border: dot-dash rebeccapurple 2px;
        color: indigo;
        background: deepskyblue;
    }
</style>
<body>
<jsp:include page="/Header.jsp"/>
<br>
<div align="center">
    <h3>
        ${UserInfo}
        <br>
        ${CurrentDate}
    </h3>
</div>
<div style="margin: 5% 30%;" class="res">
    <div style="margin-left: 40%">
        <%--        <table style="border: solid green 1px">--%>
        <c:forEach items="${list_res}" var="item">
            <%--                <tr><td> ${item}</td></tr>--%>
            ${item}
        </c:forEach>
        <%--        </table>--%>
        <br>
        Sum: ${sum}
        <br>
    </div>
</div>

<div align="center" style="margin-top: 20px">
    <h6>запасной вариант если лабу не принимают</h6>
    <audio src="Angel.mp3" controls></audio>
    <form style="margin-top: 20px" method="post" action="login.jsp">
        <input type="submit" value="Log out">
    </form>
</div>
<jsp:include page="/Footer.jsp"/>
</body>
</html>
