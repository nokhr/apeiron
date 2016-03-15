<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="/style/stylesheet1.css"/>
    <meta charset="utf-8">
    <title>Авторизация</title>
</head>
<body>
<h1 class="font" id="head">Вход для пользователей</h1>
<a class="font" id="reg" href="/page/registration.jsp">Регистрация</a>
<img class="font" src="/picture/orig.jpg" id="logo" />
<form action="/AuthorizationServlet" class="font" id="log_in" method="post">
    <p><input class="auth_data" name="login" maxlength="30" placeholder="Электронная почта(Логин)" type="text"></p>
    <p><input class="auth_data" name="password" maxlength="30" placeholder="Пароль" type="password"></p>
    <p><button id="auth_but" type ="submit">Войти</button></p>
</form>
<a class="font" id="pass" href="">Забыли пароль?</a>
</body>
</html>