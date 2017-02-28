<%--TODO: Fill the correct input types and names --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>
    <div class="container body-content span=8 offset=2">
        <jsp:include page="../error.jsp"/>
        <div class="well">

            <form class="form-horizontal" action="${pageContext.request.contextPath}/register" method="post">
                <fieldset>
                    <legend>Register</legend>
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="user-email">Email</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="email" id="user-email" placeholder="Email" name="email"
                                   required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="user-name">Full Name</label>
                        <div class="col-sm-4 ">
                            <input class="form-control" type="text" id="user-name" placeholder="Full Name" name="name"
                                   required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="user-password-first">Password</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="password" id="user-password-first" placeholder="Password"
                                   name="password" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label" for="user-password-second">Confirm Password</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="password" id="user-password-second" placeholder="Password"
                                   name="confirmPassword" required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4 col-sm-offset-4">
                            <a class="btn btn-default"
                               href="${pageContext.request.contextPath}/">Cancel</a>
                            <input type="submit" value="Submit" class="btn btn-primary"/>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</main>
