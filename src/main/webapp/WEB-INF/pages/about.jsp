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
      <div class="slider-item" style="background-image: url('images/bg_1.jpg');" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
          <div class="row slider-text align-items-center justify-content-center">
            <div class="col-md-10 col-sm-12 ftco-animate text-center">
              <p class="breadcrumbs"><span class="mr-2"><a href="index">Home</a></span> <span>About</span></p>
              <h1 class="mb-3">About Us</h1>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    <section class="ftco-section-2">
      <div class="container d-flex">
        <div class="section-2-blocks-wrapper row">
          <div class="img col-sm-12 col-lg-6" style="background-image: url('images/about-2.jpg');">
          </div>
          <div class="text col-lg-6 ftco-animate">
            <div class="text-inner align-self-start">
              <span class="subheading">About Tasty</span>
              <h3 class="heading">Our chef cooks the most delicious food for you</h3>
              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>

              <p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <div class="ftco-section">
      <div class="container">
        <div class="row justify-content-center mb-5 pb-5">
          <div class="col-md-7 text-center heading-section ftco-animate">
            <span class="subheading">Our Chef</span>
            <h2>Our Master Chef</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4 ftco-animate">
            <div class="block-10">
              <div class="person-info">
                <span class="name">Thomas Smith</span>
                <span class="position">Head Chef</span>
              </div>
              <div class="chef-img" style="background-image: url(static/images/chef-1.jpg)"></div>
            </div>
          </div>
          <div class="col-md-4 ftco-animate">
            <div class="block-10">
              <div class="person-info">
                <span class="name">Francis Gibson</span>
                <span class="position">Assistant Chef</span>
              </div>
              <div class="chef-img" style="background-image: url(static/images/chef-2.jpg)"></div>
            </div>
          </div>
          <div class="col-md-4 ftco-animate">
            <div class="block-10">
              <div class="person-info">
                <span class="name">Angelo Maestro</span>
                <span class="position">Assistant Chef</span>
              </div>
              <div class="chef-img" style="background-image: url(static/images/chef-3.jpg)"></div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <c:import url="templ/instagram-part.jsp"/>
    <c:import url="templ/footer-part.jsp"/>
    <c:import url="templ/loader.jsp"/>
</body>
</html>