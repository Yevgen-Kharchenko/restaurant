<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html lang="en">
<head>
  <title></title>
  <c:import url="templ/head-part.jsp"/>
</head>
<body>

<c:import url="templ/header-part.jsp"/>
    
    <section class="home-slider owl-carousel">
      <div class="slider-item" style="background-image: url('static/images/bg_1.jpg');" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
          <div class="row slider-text align-items-center justify-content-center">
            <div class="col-md-10 col-sm-12 ftco-animate text-center">
              <p class="breadcrumbs"><span class="mr-2"><a href=""><fmt:message key="home"/></a></span> <span><fmt:message key="specialties"/></span></p>
              <h1 class="mb-3"><fmt:message key="our.spe"/></h1>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section bg-light">
      <div class="container">
        <div class="row no-gutters justify-content-center mb-5 pb-5">
          <div class="col-md-7 text-center heading-section ftco-animate">
            <h2><fmt:message key="our.spe"/></h2>
          </div>
        </div>
        <div class="row d-flex no-gutters">
          <div class="col-lg-6">
            <div class="block-3 d-md-flex ftco-animate">
              <div class="image order-last" style="background-image: url(static/images/dish-3.jpg);"></div>
              <div class="text text-center order-first">
                <h2 class="heading"><fmt:message key="beef.steak"/></h2>
                <p><fmt:message key="far.away"/></p>
                <span class="price"><fmt:message key="from"/> $10.00</span>
              </div>
            </div>
            <div class="block-3 d-md-flex ftco-animate">
              <div class="image order-first" style="background-image: url(static/images/dish-4.jpg);"></div>
              <div class="text text-center order-first">
                <h2 class="heading"><fmt:message key="beef.ribs"/></h2>
                <p><fmt:message key="home"/><fmt:message key="far.away"/></p>
                <span class="price"><fmt:message key="from"/> $10.00</span>
              </div>
            </div>
          </div>
          <div class="col-lg-6">
            <div class="block-3 d-md-flex ftco-animate">
              <div class="image order-last" style="background-image: url(static/images/dish-5.jpg);"></div>
              <div class="text text-center order-first">
                <h2 class="heading"><fmt:message key="chopsuey"/></h2>
                <p><fmt:message key="far.away"/></p>
                <span class="price"><fmt:message key="from"/> $10.00</span>
              </div>
            </div>
            <div class="block-3 d-md-flex ftco-animate">
              <div class="image order-first" style="background-image: url(static/images/dish-6.jpg);"></div>
              <div class="text text-center order-first">
                <h2 class="heading"><fmt:message key="roasted.chicken"/></h2>
                <p><fmt:message key="far.away"/></p>
                <span class="price"><fmt:message key="from"/> $10.00</span>
              </div>
            </div>
          </div>

          <div class="col-lg-6">
            <div class="block-3 d-md-flex ftco-animate">
              <div class="image order-last" style="background-image: url(static/images/dish-7.jpg);"></div>
              <div class="text text-center order-first">
                <h2 class="heading"><fmt:message key="beef.steak"/></h2>
                <p><fmt:message key="far.away"/></p>
                <span class="price"><fmt:message key="from"/> $10.00</span>
              </div>
            </div>
            <div class="block-3 d-md-flex ftco-animate">
              <div class="image order-first" style="background-image: url(static/images/dish-8.jpg);"></div>
              <div class="text text-center order-first">
                <h2 class="heading"><fmt:message key="beef.ribs"/></h2>
                <p><fmt:message key="far.away"/></p>
                <span class="price"><fmt:message key="from"/> $10.00</span>
              </div>
            </div>
          </div>
          <div class="col-lg-6">
            <div class="block-3 d-md-flex ftco-animate">
              <div class="image order-last" style="background-image: url(static/images/dish-9.jpg);"></div>
              <div class="text text-center order-first">
                <h2 class="heading"><fmt:message key="chopsuey"/></h2>
                <p><fmt:message key="far.away"/></p>
                <span class="price"><fmt:message key="from"/> $10.00</span>
              </div>
            </div>
            <div class="block-3 d-md-flex ftco-animate">
              <div class="image order-first" style="background-image: url(static/images/dish-10.jpg);"></div>
              <div class="text text-center order-first">
                <h2 class="heading"><fmt:message key="roasted.chicken"/></h2>
                <p><fmt:message key="far.away"/></p>
                <span class="price"><fmt:message key="from"/> $10.00</span>
              </div>
            </div>
          </div>

          <div class="col-lg-6">
            <div class="block-3 d-md-flex ftco-animate">
              <div class="image order-last" style="background-image: url(static/images/dish-11.jpg);"></div>
              <div class="text text-center order-first">
                <h2 class="heading"><fmt:message key="beef.steak"/></h2>
                <p><fmt:message key="far.away"/></p>
                <span class="price"><fmt:message key="from"/> $10.00</span>
              </div>
            </div>
          </div>

          <div class="col-lg-6">
            <div class="block-3 d-md-flex ftco-animate">
              <div class="image order-last" style="background-image: url(static/images/dish-3.jpg);"></div>
              <div class="text text-center order-first">
                <h2 class="heading"><fmt:message key="beef.steak"/></h2>
                <p><fmt:message key="far.away"/></p>
                <span class="price"><fmt:message key="from"/> $10.00</span>
              </div>
            </div>
          </div>

        </div>
      </div>
    </section>

    <c:import url="templ/footer-part.jsp"/>
    <c:import url="templ/loader.jsp"/>
</body>
</html>