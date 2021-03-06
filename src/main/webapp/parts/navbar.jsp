<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>
<style>
    <%@include file="/WEB-INF/css/style.css"%>
</style>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/introductory/"><img
                        src="/resources/images/icons8-home-100.png" width="30" height="30" border="0"><i
                <%--class="fas fa-home"--%>
                ></i
                <%--class="fas fa-home"--%>> </a>
            </li>
            <li class="nav-item"><a class="nav-link"
                                    href="${pageContext.request.contextPath}/introductory/registration"><fmt:message
                    key="label.registration"/> </a>
            </li>
            <%--<li class="nav-item"><a class="nav-link"--%>
                                    <%--href="${pageContext.request.contextPath}/introductory/login"><fmt:message--%>
                    <%--key="label.login"/></a></li>--%>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/"><fmt:message
                        key="label.edit.profile"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/introductory/admin/userlist"><fmt:message
                        key="label.user.list"/></a>
            </li>

        </ul>

        <div class="navbar-text mr-3"> ${sessionScope.userEmail}</div>
        <ul class="hor_nav">
            <li><a href="?sessionLocale=en"<fmt:message key="label.lang.en"/>><img
                    src="/resources/images/united_kingdom_icon_64.png" width="50" height="30" border="0"></a></li>
            <li><a href="?sessionLocale=ua"<fmt:message key="label.lang.ua"/>><img
                    src="/resources/images/ukraine_icon_64.png" width="50" height="30" border="0"></a></li>
        </ul>

        <c:if test="${sessionScope.userEmail ne null}">
            <div class="mr-3">
                <form action="${pageContext.request.contextPath}/introductory/logout" method="post">
                    <button type="submit" class="btn btn-info"><fmt:message key="label.logout"/>
                        <i
                            <%--class="fas fa-sign-out-alt"--%>
                        ></i>
                    </button>
                </form>
            </div>
        </c:if>

        <c:if test="${sessionScope.userEmail == null}">
            <div class="mr-3">
                <form action="${pageContext.request.contextPath}/introductory/login" method="post">
                    <button type="submit" class="btn btn-info"><fmt:message key="label.login"/>
                        <i
                            <%--class="fas fa-sign-out-alt"--%>
                        ></i>
                    </button>
                </form>
            </div>
        </c:if>

    </div>
</nav>
