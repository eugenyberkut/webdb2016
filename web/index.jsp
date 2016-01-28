<%--
  Created by IntelliJ IDEA.
  User: Yevhen
  Date: 19.01.2016
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h2>Поиск книг по автору</h2>
    <form action="main" method="get">
      Автор <input type="text" name="avtorname" /><input type="submit" value="Найти книги" />
      <input type="hidden" name="findbooks" value="1">
    </form>
  </body>
</html>
