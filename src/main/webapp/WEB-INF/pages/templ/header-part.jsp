<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
<div class="container">
    <a class="navbar-brand" href="">Tasty</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="oi oi-menu"></span> <fmt:message key="menu"/>
    </button>

    <div class="collapse navbar-collapse" id="ftco-nav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item active"><a href="" class="nav-link"><fmt:message key="home"/></a></li>
            <li class="nav-item"><a href="menu" class="nav-link"><fmt:message key="menu"/></a></li>
            <li class="nav-item"><a href="specialties" class="nav-link"><fmt:message key="specialties"/></a></li>
            <li class="nav-item"><a href="reservation" class="nav-link"><fmt:message key="reservation"/></a></li>
            <li class="nav-item"><a href="blog" class="nav-link"><fmt:message key="blog"/></a></li>
            <li class="nav-item"><a href="about" class="nav-link"><fmt:message key="about.us"/></a></li>
            <li class="nav-item"><a href="contact" class="nav-link"><fmt:message key="contact"/></a></li>
            <li class="nav-item">
                <c:choose>
                    <c:when test="${not empty user}">
                        <a href="logout" class="nav-link">
                            <fmt:message key="logout"/>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a href="login-register" class="nav-link">
                            <fmt:message key="login"/>
                        </a>
                    </c:otherwise>
                </c:choose>


            </li>
            <li class="nav-item">
                <c:choose>
                    <c:when test="${locale=='en'}">
                        <a href="language?locale=uk_UA" class="nav-link">UA</a>
                    </c:when>
                    <c:otherwise>
                        <a href="language?locale=en" class="nav-link">EN</a>
                    </c:otherwise>
                </c:choose>
            </li>
        </ul>
    </div>
</div>
</nav>
        <!-- END nav -->