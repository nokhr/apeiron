<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="/style/fedya_style_registration.css"/>
    <meta charset="utf-8">
    <title>Регистрация</title>
</head>
<body>
<!--Подключаем javascript-->
<script type="text/javascript" src="/scripts/check_password.js"></script>
<h3 class="font" id="head"><i>Регистрация</i></h3></br>
<TABLE border=0 WIDTH=100%>
    <TR>
        <TD ALIGN=LEFT VALIGN=TOP width=50%>
            <form action="/RegistrationServlet" class="font" method="post" onsubmit="return checkPass()" name="form1">
                <p> <big><i>Электронная почта*:</i></big></br><input type="email"    required   maxlength="30"    name="email"></p>
                <p> <big><i>Фамилия*:</i></big></br><input type="text" required    maxlength="30"       name="lastname"></p>
                <p> <big><i>Имя*:</i></big></br><input type="text"  required  maxlength="20"       name="firstname"></p>
                <p> <big><i>Отчество:</i></big></br><input type="text"   maxlength="30"        name="middlename"></p>
                <p> <big><i>Пароль*:</i></big></br><input type="password" id="password1" required   maxlength="25"      name="password"></p>
                <p> <big><i>Подтверждение пароля*:</i></big></br><input type="password" id="password2" required  maxlength="25"    name="password1"></p>

        </TD>
        <TD ALIGN=LEFT VALIGN=TOP width=50%>
            <p class="font" id="log_in"> <big><i>Город*:</i></big></br><input type="text" required  maxlength="25"           name="city"></p>
            <p class="font" id="log_in"> <big><i>Место работы*:</i></big></br><input type="text"  required  maxlength="45"          name="job"></p>
            <p class="font" id="log_in"> <big><i>Промо-код:</i></big></br><input type="password"   maxlength="40"         name="promo"></p>
            <p class="font" id="log_in"> <big><i>Номер телефона:</i></big></br><input type="tel" maxlength="30"            name="phone"></p>
            <p class="font" id="log_in"> <big><i>Логин*:</i></big></br><input type="text" required maxlength="30"          name="login"></p>
            <p class="font" id="log_in"> <big><i>Дата рождения:</i></big></br><input type="date"   maxlength="30"         name="birthdate"></p>

            <p align="center"><button type ="submit"><i>Регистрация</i></button></p></TD>
            </form>
    </TR> </TABLE>
<p class="font"> <big><i>* - поля, обязательные для заполнения</i></big></p></br>
    </br></br>
</body>
</html>