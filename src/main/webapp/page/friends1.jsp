<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="/style/stylesheet.css"/>
    <meta charset="utf-8">
</head>
<body>
<div id="friends">
    <p><input id="search" maxlength="30" placeholder="Поиск..." type="text">
        <a href=""><img class="icon" id="loupe" src="/picture/loupe.jpg" title="Найти" ></a>
    </p>
    <a href="/page/messages.jsp" target="workplace"><div class="your_friend" id="friend1">
        <p>Петров Петр Ильич</p><img class="friend_ava" id="friend1" src="/picture/avatar.jpeg">
        <img class="friend_info" src="/picture/info.png">
    </div></a>
    <!--
    <a href=""><div class="your_friend" id="friend2">
        <img class="friend_ava" id="friend2" src="avatar.jpeg">Сидоров Павел Игоревич
    </div></a>
    <a href=""><div class="your_friend" id="friend3">
        <img class="friend_ava" id="friend3" src="avatar.jpeg">Дружинин Николай Олегович
    </div></a>
    <a href=""><div class="your_friend" id="friend4">
        <img class="friend_ava" id="friend4" src="avatar.jpeg">Логинов Александр Павлович
    </div></a>
    -->
</div>
</body>
</html>