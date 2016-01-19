<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yevhen
  Date: 19.01.2016
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
    <table border="1">
        <thead><th>id</th><th>Название</th><th>стр</th><th>автор</th></thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td><td>${book.nazvanie}</td><td>${book.pages}</td><td>${book.avtor.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
