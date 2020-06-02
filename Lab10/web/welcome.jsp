<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="mytag" uri="http://mycompany.com//mytags1" %>
<%@ taglib uri="http://mycompany.com//mytags" prefix="MyTags" %>

<html>
<style>
    .res {
        border: dot-dash rebeccapurple 2px;
        color: indigo;
        background: deepskyblue;
    }

    .center {
        alignment: center;
        align-content: center;
        align-items: center;
        align-self: center;
        text-align: center;
        horiz-align: center;
        vert-align: middle;
    }
</style>
<body>
<jsp:include page="/Header.jsp"/>
<br>
<div align="center">
    <h3>
        <%--    <c:out value="${UserInfo}">--%>
        ${UserInfo}
        <br>
        ${CurrentDate}
    </h3>
</div>
<hr>
<h2>Test JSTL</h2>
<c:catch var="DefException">
    <% int num = 100 / 0; %>
</c:catch>
The Exception is : ${DefException}
<br>
<c:out value="      100/0 is ${100/0}"></c:out>
<br>
<c:import var="displayfile" url="rezult.jsp">
</c:import>
<c:out value="${displayfile}"/>
<br>
<c:set var="zero" value="0"/>
<c:forEach var="count" begin="${zero}" end="10">
    <c:if test="${count != 7}">
        <c:out value="..${count}.."/>
    </c:if>
    <c:if test="${count == 7}">
        <c:out value="..Now count is seven.."/>
    </c:if>
</c:forEach>
<br>
<c:set var="flag" value="0"/>
<c:out value="${flag}"/>
<c:if test="${flag != 0}">
    <c:redirect url="login.jsp"/>
</c:if>
<br>
<h2>Format Tag example</h2>
<c:set var="number" value="99.40"/>
<fmt:parseNumber var="n" integerOnly="true" type="number" value="${number}"/>
Parse Number is : <c:out value="${n}"/>
<br>
<c:set var="date" value="02-04-2018"/>
<fmt:parseDate value="${date}" var="pd" pattern="dd-MM-yyyy"/>
Parse Date is : <c:out value="${pd}"/>
<br>
<c:set var="Date" value="<%=new java.util.Date()%>"/>
Format Date is : <fmt:formatDate type="time" value="${Date}"/>
<hr>
<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/java10?useUnicode=true&serverTimezone=UTC&useSSL=false"
                   user="root" password="Фвьшт"/>
<sql:query dataSource="${myDS}" var="resources">
    SELECT * from resources where user_login = '${UserLogin}';
</sql:query>

<div style="display: flex;justify-content: center;flex-direction: row">
    <div style="order: -1">
        <form action="${pageContext.request.contextPath}/AddPage.jsp"
              method="POST">
            <table border="0">
                <tr>
                    <td><h2>Add</h2></td>
                </tr>
                <tr>
                    <td>* Enter Name:</td>
                    <td><input type="text" name="NameAdd"/>
                </tr>
                <tr>
                    <td>* Enter Cost:</td>
                    <td><input type="text" name="CostAdd"/>
                </tr>
                <tr>
                    <td><input type="hidden" name="UserLogin" value="${UserLogin}"></td>
                    <td><MyTags:SDESumbit label="Add"/></td>
                </tr>
            </table>
        </form>
    </div>
    <div style="order: 0">
        <form action="${pageContext.request.contextPath}/AddPage.jsp"
              method="POST">
            <table border="0">
                <tr>
                    <td><h2>Delete</h2></td>
                </tr>
                <tr>
                    <td>* Enter Name:</td>
                    <td><input type="text" name="NameDelete"/>
                </tr>
                <tr>
                    <td><input type="hidden" name="UserLogin" value="${UserLogin}"></td>
                    <td><MyTags:SDESumbit label="Delete"/></td>
                </tr>
            </table>
        </form>
    </div>
    <div style="order: 1;;padding: 10px;margin: 5px" class="res">
        <c:set var="MySum" value="0"/>
        <c:forEach var="row" items="${resources.rows}">
            <div class="center">
                <c:out value="${row.resource_name}"/>
                <c:out value="  "/>
                <c:out value="${row.resource_cost}"/>
                <fmt:parseNumber var="MySumFormatter" integerOnly="false" type="number"
                                 value="${MySum+row.resource_cost}"/>
                <c:set var="MySum" value="${MySumFormatter}"/>
            </div>
            <hr>
        </c:forEach>
        <div class="center">Sum: ${MySum}</div>
    </div>
</div>
<hr>
<div style="margin: 5% 30%;display: flex;flex-direction: row" class="res">
    <div>
        <c:forEach items="${list_res}" var="item">
            <div class="center">${item}</div>
            <hr>
        </c:forEach>
        <div class="center">Sum: ${sum}</div>
    </div>
    <div style="width: 300px"></div>
    <div>
        <MyTags:SDETable sum="${sum}" objects="${list_res}"/>
    </div>
</div>
<hr>
<h2>TLD</h2>
<br>
<h2>Number Formatting Example</h2>
<mytag:formatNumber number="100050.574" format="#,###.00"/><br>
<mytag:formatNumber number="1234.567" format="$# ###.00"/><br>
<br>
<c:set var="subj">
    <subject>
        <id>1</id>
        <name>OOP</name>
        <course>2</course>
    </subject>
</c:set>
<x:parse xml="${subj}" var="output"/>
<b>Name : </b>
<x:out select="$output/subject[1]/name" /><br>
<b>Course :</b>
<x:out select="$output/subject[1]/course" />
<br>
<c:import
        url="XML.xml"
        var="SubjectsXML"/>
<x:parse var="doc" xml="${SubjectsXML}" />
<x:out select="$doc/subjects[1]/subject[1]"/>
<br>
<x:out select="$doc/subjects[1]/subject[2]"/>
<br>

<div align="center" style="margin-top: 20px">
    <h6>запасной вариант если лабу не принимают</h6>
    <audio src="Angel.mp3" controls></audio>
    <form style="margin-top: 20px" method="post" action="login.jsp">
        <MyTags:SDESumbit label="Log out"/>
    </form>
</div>
<jsp:include page="/Footer.jsp"/>
</body>
</html>