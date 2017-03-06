<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<main class="col-4 offset-4 text-center">
    <div class="container">
        <jsp:include page="error.jsp"/>
        <c:set var="game" value="${game}" scope="session"/>
        <div class="row">
            <div class="col-12">
                <div class="text-center"><h1 class="display-3">Edit Game - ${game.title}</h1></div>
                <br/>
                <form method="post" action="${pageContext.request.contextPath}/admin/games/edit/${game.id}">
                    <div class="form-group row">
                        <label class="form-control-label">Title</label>
                        <input pattern="[A-Z].{3,100}" class="form-control"
                               placeholder="Enter Game Title" value="${game.title}" name="title"/>
                    </div>

                    <div class="form-group row">
                        <label class="form-control-label">Description</label>
                        <textarea class="form-control" placeholder="Enter Game Description" minlength="20" name = "description">${game.description}</textarea>
                    </div>

                    <div class="form-group row">
                        <label class="form-control-label">Thumbnail</label>
                        <input type="url" class="form-control" placeholder="Enter URL to Image" value="${game.imageThumbnail}" name = "imageThumbnail"/>
                    </div>

                    <div class="form-group row">
                        <label class="form-control-label">Price</label>
                        <div class="input-group">
                            <input step="0.01" min="0" class="form-control" placeholder="Enter Price" value="${game.price}" name = "price"/>
                            <span class="input-group-addon">&euro;</span>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="form-control-label">Size</label>
                        <div class="input-group">

                            <input step="0.1" min="0" class="form-control" placeholder="Enter Size" value="${game.size}" name = "size"/>
                            <span class="input-group-addon">GB</span>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="form-control-label">YouTube Video URL</label>
                        <div class="input-group">
                            <span class="input-group-addon">https://www.youtube.com/watch?v=</span>
                            <input class="form-control" minlength="11" maxlength="11" value="${game.trailer}" name = "trailer"/>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="form-control-label">Release Date</label>
                        <c:set var="date" value="${fn:split(game.releaseDate, ' ')}" scope="session"/>
                        <input type="date" class="form-control" placeholder="yyyy-MM-dd" value="${date[0]}" name = "releaseDate"/>
                    </div>

                    <input type="submit" class="btn btn-outline-warning btn-lg btn-block"
                           value="Edit Game"/>
                </form>
                <br/>
            </div>
        </div>
    </div>
</main>
