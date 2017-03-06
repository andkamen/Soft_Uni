<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<main>
    <div class="container">
        <c:set var="game" value="${game}" scope="session"/>
        <div class="row">
            <div class="col-12 text-center">

                <h1 class="display-3">${game.title}</h1>
                <br/>

                <iframe width="560" height="315" src="https://www.youtube.com/embed/${game.trailer}" frameborder="0"
                        allowfullscreen></iframe>

                <br/>
                <br/>

                <p>${game.description}</p>

                <p><strong>Price</strong> - ${game.price}&euro;</p>
                <p><strong>Size</strong> - ${game.size} GB</p>
                <c:set var="date" value="${fn:split(game.releaseDate, ' ')}" scope="session"/>
                <p><strong>Release Date</strong> - ${date[0]}</p>


                <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/">Back</a>
                <c:set var="user" value="${sessionScope.currentUser}"/>
                <c:choose>
                    <c:when test="${user.getRole() == 'ADMIN'}">
                        <a class="btn btn-warning" href="${pageContext.request.contextPath}/admin/games/edit/${game.id}">Edit</a>
                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/games/delete/${game.id}">Delete</a>
                    </c:when>
                </c:choose>
                <a class="btn btn-primary" href="#">Buy</a>

                <br/>
                <br/>

            </div>
        </div>
    </div>
</main>