<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="text-center"><h1 class="display-3">Your Cart</h1></div>
                <br/>
                <c:forEach items="${games}" var="game">
                    <div class="list-group">
                        <div class="list-group-item">
                            <a class="btn btn-outline-danger btn-lg" href="/games/remove/${game.id}">X</a>
                            <div class="media col-3">
                                <figure class="pull-left">
                                    <a href="/games/info/${game.id}">
                                        <img
                                                class="card-image-top img-fluid img-thumbnail"
                                                onerror="this.src='https://i.ytimg.com/vi/BqJyluskTfM/maxresdefault.jpg';"
                                                src="${game.imageThumbnail}"></a>
                                </figure>
                            </div>
                            <div class="col-md-6">
                                <a href="#"><h4 class="list-group-item-heading"> ${game.title} </h4></a>
                                <p class="list-group-item-text"> ${game.description}
                                </p>
                            </div>
                            <div class="col-md-2 text-center mr-auto">
                                <h2> ${game.price}&euro; </h2>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <br/>
                <div class="col-8 offset-2 my-3 text-center">
                    <h1><strong>Total Price - </strong> ${totalPrice} &euro;</h1>
                </div>
                <div class="col-8 offset-2 my-3">
                    <form method="post" action="${pageContext.request.contextPath}/games/orderAll">

                        <input type="submit" class="btn btn-success btn-lg btn-block"
                               value="Order"/>
                    </form>
                </div>
                <br/>
            </div>
        </div>
    </div>
</main>