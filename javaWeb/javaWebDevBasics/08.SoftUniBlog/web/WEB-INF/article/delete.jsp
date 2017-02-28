<main>
    <div class="container body-content span=8 offset=2">
        <jsp:include page="../error.jsp"/>
        <c:set var="article" value="${sessionScope.article}" scope="session"/>
        <div class="well">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/articles/delete/${article.id}"
                  method="POST">
                <fieldset>
                    <legend>Delete</legend>

                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="article_title">Article Title</label>
                        <div class="col-sm-4 ">
                            <input type="text" class="form-control" id="article_title" value="${article.title}"
                                   name="title" readonly/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="article_content">Content</label>
                        <div class="col-sm-6">
                            <textarea class="form-control" rows="6" id="article_content" name="content"
                                      readonly>${article.content}</textarea>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-4">
                            <a class="btn btn-default" href="${pageContext.request.contextPath}/">Cancel</a>
                            <input type="submit" class="btn btn-primary" value="Submit"/>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</main>
