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
              <p class="breadcrumbs"><span class="mr-2"><a href=""><fmt:message key="home"/></a></span> <span><fmt:message key="about.us"/></span></p>
              <h1 class="mb-3"><fmt:message key="about.us"/></h1>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    <section class="ftco-section-2">
      <div class="container d-flex">
        <div class="section-2-blocks-wrapper row">
          <div class="img col-sm-12 col-lg-6" style="background-image: url('static/images/about-2.jpg');">
          </div>
          <div class="text col-lg-6 ftco-animate">
            <div class="text-inner align-self-start">
              <span class="subheading"><fmt:message key="about.t"/></span>
              <h3 class="heading"><fmt:message key="our.chef"/></h3>
              <p><fmt:message key="far"/></p>

              <p><fmt:message key="small.river"/></p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <div class="ftco-section">
      <div class="container">
        <div class="row justify-content-center mb-5 pb-5">
          <div class="col-md-7 text-center heading-section ftco-animate">
            <span class="subheading"><fmt:message key="our.chef"/></span>
            <h2><fmt:message key="our.master"/></h2>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4 ftco-animate">
            <div class="block-10">
              <div class="person-info">
                <span class="name"><fmt:message key="thomas.smith"/></span>
                <span class="position"><fmt:message key="head.chef"/></span>
              </div>
              <div class="chef-img" style="background-image: url(static/images/chef-1.jpg)"></div>
            </div>
          </div>
          <div class="col-md-4 ftco-animate">
            <div class="block-10">
              <div class="person-info">
                <span class="name"><fmt:message key="francis.gibson"/></span>
                <span class="position"><fmt:message key="assistant.chef"/></span>
              </div>
              <div class="chef-img" style="background-image: url(static/images/chef-2.jpg)"></div>
            </div>
          </div>
          <div class="col-md-4 ftco-animate">
            <div class="block-10">
              <div class="person-info">
                <span class="name"><fmt:message key="angelo.maestro"/></span>
                <span class="position"><fmt:message key="assistant.chef"/></span>
              </div>
              <div class="chef-img" style="background-image: url(static/images/chef-3.jpg)"></div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <c:import url="templ/footer-part.jsp"/>
    <c:import url="templ/loader.jsp"/>
</body>
</html>