<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <div class="container body-content">
        <div class="row">
            <div class="col-md-12">
                <c:set var="article" value="${sessionScope.article}" scope="session"/>
                <article>
                    <header>
                        <h2>${article.title}</h2>
                    </header>

                    <p>${article.content}</p>

                    <small class="author">${article.author.name}</small>

                    <footer>
                        <div class="pull-right">
                            <c:set var="username" value="${sessionScope.LOGGED_IN_USER.getName()}" scope="session"/>
                            <c:if test="${username!=null}">
                                <a class="btn btn-success btn-xs" href="${pageContext.request.contextPath}/articles/edit/${article.id}">Edit</a>
                                <a class="btn btn-danger btn-xs" href="${pageContext.request.contextPath}/articles/delete/${article.id}">Delete</a>
                            </c:if>

                            <a class="btn btn-default btn-xs" href="${pageContext.request.contextPath}/">back &raquo;</a>
                        </div>
                    </footer>
                </article>
            </div>
        </div>
    </div>
</main>