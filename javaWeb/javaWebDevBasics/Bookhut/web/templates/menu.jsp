<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bookhut.models.bindingModels.LoginModel" %>
<%@ page import="bookhut.config.Config" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/menu.css">
</head>
<body>
<ul>
    <li><a href="/">Home</a></li>
    <li><a href="/signup">Sign Up</a></li>
    <%
        LoginModel loginModel = (LoginModel) session.getAttribute(Config.LOGIN_MODEL);
        String username = null;
        if (loginModel != null) {
            username = loginModel.getUsername();
            request.setAttribute(Config.USERNAME, username);
        }
    %>
    <c:set var="username" value="${USERNAME}" scope="session"/>
    <c:choose>
        <c:when test="${username!=null}">
            <li><a href="/signout">Sign Out(${username})</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="/signin">Sing In</a></li>
        </c:otherwise>
    </c:choose>

    <li><a href="/add">Add</a></li>
    <li><a href="/shelves">Shelves</a></li>
</ul>
</body>
</html>
