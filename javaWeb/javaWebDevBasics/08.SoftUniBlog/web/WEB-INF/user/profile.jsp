<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main>

    ${sessionScope.LOGGED_IN_USER.getName()}
    <br/>
    ${sessionScope.LOGGED_IN_USER.getEmail()}

</main>