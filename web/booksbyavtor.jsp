<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yevhen
  Date: 19.01.2016
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Книги по автору</title>
</head>
<body>
<h1>Автор: ${avtor.name}</h1>
<table border="1">
    <thead><th>id</th><th>Название</th><th>стр</th></thead>
    <tbody>
    <c:forEach var="book" items="${avtor.books}">
        <tr>
            <td>${book.id}</td><td>${book.nazvanie}</td><td>${book.pages}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
