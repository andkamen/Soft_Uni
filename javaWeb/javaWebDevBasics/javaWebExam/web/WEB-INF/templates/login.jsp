<main class="col-4 offset-4 text-center">
    <div class="container">
        <jsp:include page="error.jsp"/>
        <div class="row">
            <div class="col-12">
                <div class="text-center"><h1 class="display-3">Login</h1></div>
                <br/>
                <form method="POST" action="${pageContext.request.contextPath}/login">
                    <div class="form-group row">
                        <label class="sr-only">Email</label>
                        <input type="email" class="form-control" placeholder="somebody@example.com" name="email"/>
                    </div>
                    <div class="form-group row">
                        <label class="sr-only">Password</label>
                        <input type ="password" class="form-control" placeholder="Password" name = "password"/>
                    </div>

                    <input type="submit" class="btn btn-outline-warning btn-lg btn-block"
                           value="Login"/>
                </form>
                <br/>
            </div>
        </div>
    </div>
</main>




<%--<div class="container">--%>
    <%--<jsp:include page="error.jsp"/>--%>
    <%--<form method="POST" action="${pageContext.request.contextPath}/login">--%>
        <%--<label>Username</label>--%>
        <%--<div class="form-group">--%>
            <%--<input type="text" class="form-control" placeholder="Enter email or email" name = "email">--%>
        <%--</div>--%>
        <%--<label>Password</label>--%>
        <%--<div class="form-group">--%>
            <%--<input type="password" class="form-control" placeholder="Enter password" name = "password">--%>
        <%--</div>--%>
        <%--<a href="${pageContext.request.contextPath}/register" class="btn btn-primary">Register</a>--%>
        <%--<input type="submit" class="btn btn-success" value="Log In"/>--%>
    <%--</form>--%>
<%--</div>--%>