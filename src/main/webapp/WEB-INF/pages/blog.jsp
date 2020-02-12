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
              <p class="breadcrumbs"><span class="mr-2"><a href=""><fmt:message key="home"/></a></span> <span><fmt:message key="blog"/></span></p>
              <h1 class="mb-3"><fmt:message key="blog"/></h1>
            </div>
          </div>
        </div>
      </div>
    </section>
    
    <section class="ftco-section bg-light">
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-lg-3 ftco-animate">
            <div class="blog-entry">
              <a href="blog-single" class="block-20" style="background-image: url('static/images/image_1.jpg');">
              </a>
              <div class="text p-4">
                <div class="meta">
                  <div><a href="#"><fmt:message key="july"/></a></div>
                  <div><a href="#"><fmt:message key="admin"/></a></div>
                </div>
                <h3 class="heading"><a href="blog-single"><fmt:message key="even"/></a></h3>
                <p class="clearfix">
                  <a href="#" class="float-left read"><fmt:message key="more"/></a>
                  <a href="#" class="float-right meta-chat"><span class="icon-chat"></span> 3</a>
                </p>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 ftco-animate">
            <div class="blog-entry">
              <a href="blog-single" class="block-20" style="background-image: url('static/images/image_2.jpg');">
              </a>
              <div class="text p-4">
                <div class="meta">
                  <div><a href="#"><fmt:message key="july"/></a></div>
                  <div><a href="#"><fmt:message key="admin"/></a></div>
                </div>
                <h3 class="heading"><a href="blog-single"><fmt:message key="even"/></a></h3>
                <p class="clearfix">
                  <a href="#" class="float-left read"><fmt:message key="more"/></a>
                  <a href="#" class="float-right meta-chat"><span class="icon-chat"></span> 3</a>
                </p>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 ftco-animate">
            <div class="blog-entry" data-aos-delay="200">
              <a href="blog-single" class="block-20" style="background-image: url('static/images/image_3.jpg');">
              </a>
              <div class="text p-4">
                <div class="meta">
                  <div><a href="#"><fmt:message key="july"/>/a></div>
                  <div><a href="#"><fmt:message key="admin"/></a></div>
                </div>
                <h3 class="heading"><a href="blog-single"><fmt:message key="even"/></a></h3>
                <p class="clearfix">
                  <a href="#" class="float-left read"><fmt:message key="more"/></a>
                  <a href="#" class="float-right meta-chat"><span class="icon-chat"></span> 3</a>
                </p>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 ftco-animate">
            <div class="blog-entry" data-aos-delay="200">
              <a href="blog-single" class="block-20" style="background-image: url('static/images/image_4.jpg');">
              </a>
              <div class="text p-4">
                <div class="meta">
                  <div><a href="#"><fmt:message key="july"/></a></div>
                  <div><a href="#"><fmt:message key="admin"/></a></div>
                </div>
                <h3 class="heading"><a href="blog-single"><fmt:message key="even"/></a></h3>
                <p class="clearfix">
                  <a href="#" class="float-left read"><fmt:message key="more"/></a>
                  <a href="#" class="float-right meta-chat"><span class="icon-chat"></span> 3</a>
                </p>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 ftco-animate">
            <div class="blog-entry" data-aos-delay="200">
              <a href="blog-single" class="block-20" style="background-image: url('static/images/image_5.jpg');">
              </a>
              <div class="text p-4">
                <div class="meta">
                  <div><a href="#"><fmt:message key="july"/></a></div>
                  <div><a href="#"><fmt:message key="admin"/></a></div>
                </div>
                <h3 class="heading"><a href="blog-single"><fmt:message key="even"/></a></h3>
                <p class="clearfix">
                  <a href="#" class="float-left read"><fmt:message key="more"/></a>
                  <a href="#" class="float-right meta-chat"><span class="icon-chat"></span> 3</a>
                </p>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 ftco-animate">
            <div class="blog-entry" data-aos-delay="200">
              <a href="blog-single" class="block-20" style="background-image: url('static/images/image_6.jpg');">
              </a>
              <div class="text p-4">
                <div class="meta">
                  <div><a href="#"><fmt:message key="july"/></a></div>
                  <div><a href="#"><fmt:message key="admin"/></a></div>
                </div>
                <h3 class="heading"><a href="blog-single"><fmt:message key="even"/></a></h3>
                <p class="clearfix">
                  <a href="#" class="float-left read"><fmt:message key="more"/></a>
                  <a href="#" class="float-right meta-chat"><span class="icon-chat"></span> 3</a>
                </p>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 ftco-animate">
            <div class="blog-entry" data-aos-delay="200">
              <a href="blog-single" class="block-20" style="background-image: url('static/images/image_7.jpg');">
              </a>
              <div class="text p-4">
                <div class="meta">
                  <div><a href="#"><fmt:message key="july"/></a></div>
                  <div><a href="#"><fmt:message key="admin"/></a></div>
                </div>
                <h3 class="heading"><a href="blog-single"><fmt:message key="even"/></a></h3>
                <p class="clearfix">
                  <a href="#" class="float-left read"><fmt:message key="more"/></a>
                  <a href="#" class="float-right meta-chat"><span class="icon-chat"></span> 3</a>
                </p>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-lg-3 ftco-animate">
            <div class="blog-entry" data-aos-delay="200">
              <a href="blog-single" class="block-20" style="background-image: url('static/images/image_8.jpg');">
              </a>
              <div class="text p-4">
                <div class="meta">
                  <div><a href="#"><fmt:message key="july"/></a></div>
                  <div><a href="#"><fmt:message key="admin"/></a></div>
                </div>
                <h3 class="heading"><a href="blog-single"><fmt:message key="even"/></a></h3>
                <p class="clearfix">
                  <a href="#" class="float-left read"><fmt:message key="more"/></a>
                  <a href="#" class="float-right meta-chat"><span class="icon-chat"></span> 3</a>
                </p>
              </div>
            </div>
          </div>
        </div>

        <div class="row mt-5">
          <div class="col text-center">
            <div class="block-27">
              <ul>
                <li><a href="#">&lt;</a></li>
                <li class="active"><span>1</span></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">&gt;</a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </section>

    <c:import url="templ/footer-part.jsp"/>
    <c:import url="templ/loader.jsp"/>
</body>
</html>