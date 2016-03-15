<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="/style/stylesheet.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <script type="text/javascript" src="/scripts/autoSearch.js"></script>
    </head>
    <body onload="init()">
        <div class="background_friends">
            <form name="autofillform" action="autocomplete">
                <table border="0" cellpadding="5">
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><p><input id="search" maxlength="50" placeholder="Поиск..." type="search" onkeyup="doCompletion();">
                            <a href=""><img class="icon" id="loupe" src="/picture/search.png" title="Найти" ></a>
                        </p></td>
                    </tr>
                    <tr>
                        <td id="auto-row" colspan="2">
                            <table id="complete-table" />
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
            <a href="conversation.html" target="workplace">
                <div class="friends">
                    <img class="icon" src="/picture/avatar.jpeg">
                    <div class="status"></div>
                    <p>Иванов Иван Иванович</p>
                    <a href="user_info.html" target="workplace"><img class="icon" id="info" src="/picture/info.png"></a>
                </div>
            </a>
            <a href="conversation.html" target="workplace">
                <div class="friends">
                    <img class="icon" src="/picture/avatar.jpeg">
                    <div class="status"></div>
                    <p>Иванов Иван Иванович</p>
                    <a href="user_info.html" target="workplace"><img class="icon" id="info" src="/picture/info.png"></a>
                </div>
            </a>
        </div>
    </body>
</html>