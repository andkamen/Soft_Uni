<main class="col-4 offset-4 text-center">
    <div class="container">
        <jsp:include page="error.jsp"/>
        <div class="row">
            <div class="col-12">
                <div class="text-center"><h1 class="display-3">Register</h1></div>
                <br/>
                <form method="POST" action="${pageContext.request.contextPath}/register">

                    <div class="form-group row">
                        <label class="sr-only">Email</label>
                        <input type="email" class="form-control" placeholder="somebody@example.com" name="email"/>
                    </div>

                    <div class="form-group row">
                        <label class="sr-only">Full Name</label>
                        <input type="text" pattern="^[a-zA-Z -.]+$" class="form-control" placeholder="Full Name" name="fullName"/>
                    </div>

                    <div class="form-group row">
                        <label class="sr-only">Password</label>
                        <input type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" class="form-control" placeholder="Password" name="password"/>
                    </div>

                    <div class="form-group row">
                        <label class="sr-only">Confirm Password</label>
                        <input type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" class="form-control" placeholder="Confirm Password" name="confirmPassword"/>
                    </div>

                    <input type="submit" class="btn btn-outline-warning btn-lg btn-block"
                           value="Register"/>
                </form>
                <br/>
            </div>
        </div>
    </div>
</main>


<%--<div class="container">--%>
    <%--<jsp:include page="error.jsp"/>--%>
    <%--<form method="POST" action="">--%>
        <%--<label>Username</label>--%>
        <%--<div class="form-group">--%>
            <%--<input type="text" class="form-control" placeholder="Enter email" name="email">--%>
        <%--</div>--%>
        <%--<label>Email</label>--%>
        <%--<div class="form-group">--%>
            <%--<input type="email" class="form-control" placeholder="Enter email" name="email">--%>
        <%--</div>--%>
        <%--<label>Password</label>--%>
        <%--<div class="form-group">--%>
            <%--<input type="password" class="form-control" placeholder="Enter password" name="password">--%>
        <%--</div>--%>
        <%--<label>Confirm Password</label>--%>
        <%--<div class="form-group">--%>
            <%--<input type="password" class="form-control" placeholder="Confirm password" name="confirmPassword">--%>
        <%--</div>--%>
        <%--<input type="reset" class="btn btn-danger" value="Clear"/>--%>
        <%--<input type="submit" class="btn btn-success" value="Register"/>--%>
    <%--</form>--%>
<%--</div>--%>