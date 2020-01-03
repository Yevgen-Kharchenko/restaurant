<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html lang="en" class="wide wow-animation">
<head>
<title>Home</title>
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
            <h3>Our Website Is Under Construction</h3>
            <div class="offset-top-35 offset-sm-top-60">
              <div class="max-width-560">
                <div class="progress-variant-1 progress-variant-1-contrast">
                  <div class="progress">
                    <div role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;" class="progress-bar"></div>
                  </div>
                  <span class="caption">50%</span> </div>
              </div>
            </div>
            <div class="offset-top-40 offset-md-top-75">
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