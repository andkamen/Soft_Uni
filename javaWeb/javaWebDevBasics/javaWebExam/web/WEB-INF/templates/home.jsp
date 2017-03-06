<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<main>
    <div class="container">
        <jsp:include page="error.jsp"/>
        <div class="row">
            <div class="col-12">
                <div class="text-center"><h1 class="display-3">SoftUni Store</h1></div>

                <form class="form-inline">
                    Filter:
                    <input type="submit" href="/" name="filter" class="btn btn-link" value="All"/>
                    <input type="submit" href= "games/owned" name="filter" class="btn btn-link" value="Owned"/>
                </form>

                <div class="card-group">
                    <c:forEach items="${games}" var="game">
                        <div class="card col-4 thumbnail">
                            <img class="card-image-top img-fluid img-thumbnail"
                                 onerror="this.src='https://i.ytimg.com/vi/BqJyluskTfM/maxresdefault.jpg';"
                                 src="${game.imageThumbnail}">

                            <div class="card-block">
                                <h4 class="card-title">${game.title}</h4>
                                <p class="card-text"><strong>Price</strong> - ${game.price}&euro;</p>
                                <p class="card-text"><strong>Size</strong> - ${game.size} GB</p>
                                <p class="card-text">${fn:substring(game.description, 0, 300)}</p>
                            </div>


                            <div class="card-footer">
                                <c:set var="user" value="${sessionScope.currentUser}"/>
                                <c:choose>
                                    <c:when test="${user.getRole() == 'ADMIN'}">
                                        <a class="card-button btn btn-warning" name="edit"
                                           href="/admin/games/edit/${game.id}">Edit</a>
                                        <a class="card-button btn-danger" name="delete"
                                           href="/admin/games/delete/${game.id}">Delete</a>
                                    </c:when>
                                </c:choose>
                                <a class="card-button btn btn-outline-primary" name="info"
                                   href="/games/info/${game.id}">Info</a>
                                <a class="card-button btn btn-primary" name="buy" href="/games/order/${game.id}">Buy</a>
                            </div>

                        </div>

                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    </div>
</main>