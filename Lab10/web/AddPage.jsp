<%--
  Created by IntelliJ IDEA.
  User.User: USER
  Date: 19.04.2020
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>Result Page</title>
</head>
<body>
<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/java10?useUnicode=true&serverTimezone=UTC&useSSL=false"
                   user="root" password="Фвьшт"/>

<c:choose>
    <c:when test="${not empty param.NameAdd
                                   && not empty param.CostAdd}">
        <sql:update dataSource="${myDS}">
            insert into resources (resource_name,resource_cost,user_login) values (?, ?,?)
            <sql:param value="${param.NameAdd}"/>
            <fmt:parseNumber var="Floatformatter" integerOnly="false" type="number"
                             value="${param.CostAdd}"/>
            <sql:param value="${Floatformatter}"/>
            <sql:param value="${param.UserLogin}"/>
        </sql:update>
        <c:out value="${param.NameAdd} added" ></c:out>
    </c:when>
    <c:when test="${not empty param.NameDelete}">
        <sql:update dataSource="${myDS}" >
            delete from resources where user_login = ? and resource_name = ?
            <sql:param value="${param.UserLogin}"/>
            <sql:param value="${param.NameDelete}"/>
        </sql:update>
        <c:out value="${param.NameDelete} deleted" ></c:out>
    </c:when>
</c:choose>
</body>
</html>
