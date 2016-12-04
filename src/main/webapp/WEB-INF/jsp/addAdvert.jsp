<%--
  Created by IntelliJ IDEA.
  User: Waylesange
  Date: 05.12.16
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/add">
        <input name="title"/>
        <textarea name="text"></textarea>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
