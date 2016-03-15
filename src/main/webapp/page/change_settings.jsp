<%--
  Created by IntelliJ IDEA.
  User: Krist
  Date: 05.04.2015
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="/style/stylesheet1.css"/>
    <meta charset="utf-8">
</head>
<body>
<img class="ava" src="/picture/avatar.jpeg"/>
<img id="status" src="/picture/on.png" />
<a href="" class="ch_ava">Сменить аватар</a>
<p class="name"><%=(session.getAttribute("firstname") + " " + session.getAttribute("middlename") + " " + session.getAttribute("lastname"))%></p>
<table id="profile">
    <tr>
        <form action="" method="post">
        <td align=left valign=top width=50%>
                <p>Электронная почта<input class="proinfo" type="text"></p>
                <p>Фамилия<input class="proinfo" type="text"></p>
                <p>Имя <input class="proinfo" type="text"></p>
                <p>Отчество<input class="proinfo" type="text"></p>
                <p>Город<input class="proinfo" type="text"></p>
        </td>
        <td align=left valign=top width=50%>
            <p>Дата рождения<input class="proinfo" name="bday" type="date"></p>
            <p>Место работы<input class="proinfo" type="text"></p>
            <p>Промо-код<input class="proinfo" type="text"></p>
            <p>Номер телефона<input class="proinfo" type="text"></p>
            <p>Логин<input class="proinfo" type="text"></p>
            <p><button id="save" type ="submit">Сохранить</button></p>

        </td>
        </form>
    </tr>
</table>
</body>
</html>