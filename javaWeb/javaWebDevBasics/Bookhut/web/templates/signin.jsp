<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signin</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<form method="post">
    <label>Username</label>
    <input type="text" name="username">
    <label>Password</label>
    <input type="password" name="password">
    <input type="submit" name="signin" value="SignIn">
</form>
</body>
</html>
