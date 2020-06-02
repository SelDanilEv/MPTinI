<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Title</title>
    <link media="screen" type="text/css"
          rel="stylesheet" href="resources/css/style.css?<?php echo time(); ?>">
    <link href="https://s3-us-west-2.amazonaws.com/s.cdpn.io/67239/animate.min.css" rel="stylesheet"/>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
</head>
<body>
<div class="login-container" align="center">
    <section class="login" id="login">
        <header>
            <h2>SHOP</h2>
            <h4>Login</h4>
        </header>
        <%--    <div class = "login-page">--%>
        <div class="form">
            <p><font color="red">${errorMessage}</font></p>

            <form class="login-form" action="${pageContext.servletContext.contextPath}/controller?command=login"
                  method="POST">
                <p><input name="loginName" placeholder="Login" type="text"/>
                </p>
                <p><input name="password" placeholder="Password" type="password"/>
                </p>
                <input class="button-main-page" type="submit" value="Enter"/>
            </form>

            <div>
                <form action="${pageContext.servletContext.contextPath}/controller?command=registration_page"
                      method="post">
                    <input class="button-main-page" type="submit" value="Register"/>
                </form>
            </div>

        </div>
    </section>
</div>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

</body>

</html>

