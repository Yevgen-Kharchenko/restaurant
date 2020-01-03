<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html lang="en" class="wide wow-animation">
<head>
    <title>403</title>
    <c:import url="../templ/head-part.jsp"/>
</head>
<body>
<div class="page section-single bg-venice-blue">
    <header class="page-head">
        <section>
            <div class="shell text-center">
                <div class="brand-wrap"><a href="" class="brand"><img src="static/images/logo-white-250x40.png" alt="" width="250" height="40"/></a></div>
            </div>
        </section>
    </header>
    <main class="page-content text-center">
        <section>
            <div class="shell">
                <div class="range range-sm-center">
                    <div class="cell-md-10 cell-lg-8">
                        <h5 class="h5-variant-1"><fmt:message key="forbidden"/></h5>
                        <div class="text-extra-big">403</div>
                        <p class="text-style-2"><fmt:message key="don`t.access"/></p>
                        <div class="offset-top-35 offset-sm-top-50">
                            <div class="group-xl"><a href="" class="btn btn-primary-variant-1 btn-mod-1"><fmt:message key="back.home"/></a>
                                <a href="contacts" class="btn btn-white-outline btn-mod-2"><fmt:message key="contact.us"/></a></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
    <footer class="page-foot">
        <div class="shell text-center">
            <p class="rights">&#169;&nbsp;<span id="copyright-year"></span><fmt:message key="all.rights"/>
                <a href="privacy"><fmt:message key="privacy.policy.terms"/></a> </p>
        </div>
    </footer>
</div>
<c:import url="../templ/form-output-global.jsp"/>
</body>
<!-- End Google Tag Manager -->
</html>