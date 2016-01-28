<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yevhen
  Date: 19.01.2016
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторы</title>
</head>
<body>
    <table border="1">
        <thead>
            <th>id</th><th>name</th><th>comment</th><th>Книги</th>
        </thead>
        <tbody>
            <c:forEach var="avtor" items="${avtors}">
                <tr>
                    <td>${avtor.id}</td><td>${avtor.name}</td><td>${avtor.comment}</td><td><a href="main?booksbyavtor=${avtor.id}">показать</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <form action="main" method="post">
        <table>
            <tr> <td>Имя</td><td><input type="text" name="avtorname" /></td> </tr>
            <tr> <td>Коммент</td><td><input type="text" name="avtorcomment" /></td> </tr>
            <tr> <td colspan="2"><input type="submit" value="Добавить" /></td></tr>
        </table>
        <input type="hidden" name="addavtor" value="1">
    </form>
</body>
</html>
