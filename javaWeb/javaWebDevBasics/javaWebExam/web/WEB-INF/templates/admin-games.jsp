<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <div class="container">
        <div class="row">
            <h2 class="m-1">All Games &ndash;&nbsp;</h2> <a href="${pageContext.request.contextPath}/admin/games/add" class="btn btn-warning m-1"><strong>+</strong> Add
            Game</a>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Size</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <c:forEach items = "${games}" var="game">
                <tbody>
                <tr class="table-warning">
                    <th scope="row">${game.id}</th>
                    <td>${game.title}</td>
                    <td>${game.size} GB</td>
                    <td>${game.price} &euro;</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/games/edit/${game.id}" class="btn btn-warning btn-sm">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/games/delete/${game.id}" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
                </tbody>
                </c:forEach>
            </table>

        </div>
    </div>
</main>