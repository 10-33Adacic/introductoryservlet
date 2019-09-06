<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/introductory/"><i
                        <%--class="fas fa-home"--%>
                ></i> </a>
            </li>
            <li class="nav-item"><a class="nav-link"
                                    href="${pageContext.request.contextPath}/introductory/registration">Registration </a>
            </li>
            <li class="nav-item"><a class="nav-link"
                                    href="${pageContext.request.contextPath}/introductory/login">Login</a></li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/">Edit profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/introductory/admin/userlist">User list </a>
            </li>

        </ul>

        <div class="navbar-text mr-3"> ${sessionScope.userEmail}</div>

        <c:if test="${sessionScope.userEmail ne null}">
            <div class="mr-3">
                <form action="${pageContext.request.contextPath}/introductory/logout" method="post">
                    <button type="submit" class="btn btn-info">Log out
                        <i
                                <%--class="fas fa-sign-out-alt"--%>
                        ></i>
                    </button>
                </form>
            </div>
        </c:if>
    </div>
</nav>
