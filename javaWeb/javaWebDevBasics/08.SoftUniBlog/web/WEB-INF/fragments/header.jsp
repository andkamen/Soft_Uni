<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <a href="${pageContext.request.contextPath}/" <%--TODO: Your route here --%> class="navbar-brand">SOFTUNI
                    BLOG</a>

                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">

                    <c:set var="username" value="${sessionScope.LOGGED_IN_USER.getName()}" scope="session"/>
                    <c:choose>
                        <c:when test="${username!=null}">
                            <li>
                                <a href="${pageContext.request.contextPath}/articles/create">
                                    Create Article
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/profile">
                                    My Profile
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/signout">
                                    Sign Out
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <a href="${pageContext.request.contextPath}/register">
                                    REGISTER
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/login">
                                    LOGIN
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>

                </ul>
            </div>
        </div>
    </div>
</header>