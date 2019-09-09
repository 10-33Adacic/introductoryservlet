<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
          crossorigin="anonymous">
</head>
<body>
<jsp:include page="parts/navbar.jsp" />

<div class="container mt-2 pl-0">

    <c:if test="${requestScope.error eq true}">
    <div class="alert alert-danger" align="center">
    <strong>${requestScope.message}</strong>
    </div>
    </c:if>

    <h5> <fmt:message key="label.welcome" /><c:if test="${sessionScope.userEmail ne null}">${sessionScope.userEmail}</c:if>
    <c:if test="${sessionScope.userEmail eq null}"><fmt:message key="label.guest" /></c:if>
    </h5>
    <br>
    <c:if test="${sessionScope.userEmail eq null}">
    <fmt:message key="label.register.or.login"/>
    </c:if>
    <br>

</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>

































<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>--%>
<%--<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ include file="parts/head.jsp" %>--%>

<%--&lt;%&ndash;<fmt:setLocale value="${param.lang}"/>&ndash;%&gt;--%>
<%--<fmt:setBundle basename="messages"/>--%>

<%--<ul>--%>
    <%--<li><a href="?sessionLocale=en"><fmt:message key="label.lang.en"/></a></li>--%>
    <%--<li><a href="?sessionLocale=ua"><fmt:message key="label.lang.ua"/></a></li>--%>
<%--</ul>--%>

<%--<c:if test="${requestScope.error eq true}">--%>
    <%--<div class="alert alert-danger" align="center">--%>
        <%--<strong>${requestScope.message}</strong>--%>
    <%--</div>--%>
<%--</c:if>--%>

<%--<h5> <fmt:message key="label.welcome" /><c:if test="${sessionScope.userEmail ne null}">${sessionScope.userEmail}</c:if>--%>
    <%--<c:if test="${sessionScope.userEmail eq null}"><fmt:message key="label.guest" /></c:if>--%>
<%--</h5>--%>
<%--<br>--%>
<%--<c:if test="${sessionScope.userEmail eq null}">--%>
    <%--Please, Register or Login--%>
    <%--&lt;%&ndash;<div class="mt-1">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<a class="btn btn-primary" href="${pageContext.request.contextPath}/introductory/login" role="button">Login</a>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<br>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<a class="btn btn-primary mt-1" href="${pageContext.request.contextPath}/introductory/registration" role="button">Registration</a>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<br>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<a class="btn btn-primary mt-1" href="${pageContext.request.contextPath}/welcome.jsp" role="button">Welcome&ndash;%&gt;--%>
            <%--&lt;%&ndash;page</a>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--</c:if>--%>
<%--<br>--%>
<%--&lt;%&ndash;<a href="${pageContext.request.contextPath}/introductory/exception">Exception</a>&ndash;%&gt;--%>


<%--<%@ include file="parts/tail.jsp" %>--%>
