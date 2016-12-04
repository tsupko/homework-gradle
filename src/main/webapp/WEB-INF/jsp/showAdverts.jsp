<%--
  Created by IntelliJ IDEA.
  User: Waylesange
  Date: 05.12.16
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show</title>
</head>
<body>
<c:if test="${not empty adverts}">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Text</th>
            <th>Author</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="advert" items="${adverts}">
            <tr class='clickable-row' data-href='view_result/${advert.id}'>
                <td>${advert.id}</td>
                <td>${advert.title}</td>
                <td>${advert.text}</td>
                <td>${advert.author}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</c:if>
</body>
</html>
