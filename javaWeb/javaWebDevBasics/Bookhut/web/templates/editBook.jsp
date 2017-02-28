<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<c:set var="book" value="${book}"/>
<form method="post">

    <label>Title</label>
    <input type="text" name="title" value="${book.title}" readonly/>
    <label>Author</label>
    <input type="text" name="author" value="${book.author}"/>
    <label>Pages</label>
    <input type="text" name="pages" value="${book.pages}"/>
    <input type="submit" name="edit" value="Edit"/>
</form>

</body>
</html>
