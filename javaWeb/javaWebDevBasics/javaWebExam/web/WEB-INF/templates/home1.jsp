<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<main>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="text-center"><h1 class="display-3">SoftUni Store</h1></div>

                <form class="form-inline">
                    Filter:
                    <input type="submit" name="filter" class="btn btn-link" value="All"/>
                    <input type="submit" name="filter" class="btn btn-link" value="Owned"/>
                </form>

                <div class="card-group">
                    <c:set var="games" value="${games}" scope="session"/>
                    <c:forEach begin="0" end="${fn:length(games)}" step="3" varStatus="loop">
                        <%--<c:out value="${loop.count}"/>--%>
                        ${games.get(loop.count -1 ).id}
                        ${games.get(loop.count ).id}
                        ${games.get(loop.count +1).id}
                        <br/>

                    <%--<div class="card col-4 thumbnail">--%>
                        <%--<img    class="card-image-top img-fluid img-thumbnail"--%>
                                <%--onerror="this.src='https://i.ytimg.com/vi/BqJyluskTfM/maxresdefault.jpg';"--%>
                                <%--src="https://i.ytimg.com/vi/BqJyluskTfM/maxresdefault.jpg">--%>

                        <%--<div class="card-block">--%>
                            <%--<h4 class="card-title">Mass Effect Andromeda</h4>--%>
                            <%--<p class="card-text"><strong>Price</strong> - 60&euro;</p>--%>
                            <%--<p class="card-text"><strong>Size</strong> - 62.5 GB</p>--%>
                            <%--<p class="card-text">Mass Effect: Andromeda is an action role-playing game in which the--%>
                                <%--player takes control of either Scott or Sara Ryder from a third-person perspective.</p>--%>
                        <%--</div>--%>

                        <%--<div class="card-footer">--%>
                            <%--<a class="card-button btn btn-outline-primary" name="info" href="#">Info</a>--%>
                            <%--<a class="card-button btn btn-primary" name="buy" href="#">Buy</a>--%>
                        <%--</div>--%>

                    <%--</div>--%>
                    <%--<div class="card col-4 thumbnail">--%>

                        <%--<img--%>
                                <%--class="card-image-top img-fluid img-thumbnail"--%>
                                <%--onerror="this.src='https://i.ytimg.com/vi/BqJyluskTfM/maxresdefault.jpg';"--%>
                                <%--src="https://i.ytimg.com/vi/BqJyluskTfM/maxresdefault.jpg">--%>

                        <%--<div class="card-block">--%>
                            <%--<h4 class="card-title">Mass Effect Andromeda</h4>--%>
                            <%--<p class="card-text"><strong>Price</strong> - 60&euro;</p>--%>
                            <%--<p class="card-text"><strong>Size</strong> - 62.5 GB</p>--%>
                            <%--<p class="card-text">Mass Effect: Andromeda is an action role-playing game in which the--%>
                                <%--player takes control of either Scott or Sara Ryder from a third-person perspective.</p>--%>
                        <%--</div>--%>

                        <%--<div class="card-footer">--%>
                            <%--<a class="card-button btn btn-outline-primary" name="info" href="#">Info</a>--%>
                            <%--<a class="card-button btn btn-primary" name="buy" href="#">Buy</a>--%>
                        <%--</div>--%>

                    <%--</div>--%>
                    <%--<div class="card col-4 thumbnail">--%>

                        <%--<img--%>
                                <%--class="card-image-top img-fluid img-thumbnail"--%>
                                <%--onerror="this.src='https://i.ytimg.com/vi/BqJyluskTfM/maxresdefault.jpg';"--%>
                                <%--src="https://i.ytimg.com/vi/BqJyluskTfM/maxresdefault.jpg">--%>

                        <%--<div class="card-block">--%>
                            <%--<h4 class="card-title">Mass Effect Andromeda</h4>--%>
                            <%--<p class="card-text"><strong>Price</strong> - 60&euro;</p>--%>
                            <%--<p class="card-text"><strong>Size</strong> - 62.5 GB</p>--%>
                            <%--<p class="card-text">Mass Effect: Andromeda is an action role-playing game in which the--%>
                                <%--player takes control of either Scott or Sara Ryder from a third-person perspective.</p>--%>
                        <%--</div>--%>

                        <%--<div class="card-footer">--%>
                            <%--<a class="card-button btn btn-outline-primary" name="info" href="#">Info</a>--%>
                            <%--<a class="card-button btn btn-primary" name="buy" href="#">Buy</a>--%>
                        <%--</div>--%>

                    <%--</div>--%>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    </div>
</main>