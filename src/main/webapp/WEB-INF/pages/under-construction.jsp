<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html lang="en">
<head>
  <title>Under Construction</title>
  <c:import url="templ/head-part.jsp"/>
</head>
<body>

    <section class="home-slider owl-carousel">
      <div class="slider-item" style="background-image: url('static/images/bg_1.jpg');" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
          <div class="row slider-text align-items-center justify-content-center">
            <div class="col-md-10 col-sm-12 ftco-animate text-center">

              <h1 class="mb-3">Our Website Is Under Construction</h1>

                <div class="offset-top-35 offset-sm-top-50">
                    <div class="group-xl"><a href="" class="btn btn-primary-variant-1 btn-mod-1"><fmt:message key="back.home"/></a>
                        <a href="contact" class="btn btn-white-outline btn-mod-2"><fmt:message key="contact.us"/></a></div>
                </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <c:import url="templ/loader.jsp"/>
</body>
</html>