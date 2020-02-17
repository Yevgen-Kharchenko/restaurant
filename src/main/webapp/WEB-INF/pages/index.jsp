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
      <div class="slider-item" style="background-image: url('static/images/bg_1.jpg');">
        <div class="overlay"></div>
        <div class="container">
          <div class="row slider-text align-items-center justify-content-center text-center">
            <div class="col-md-10 col-sm-12 ftco-animate">
              <h1 class="mb-3"><fmt:message key="book"/></h1>
              <p><a href="reservation" class="btn btn-primary btn-outline-white px-5 py-3"><fmt:message key="book2"/></a></p>
            </div>
          </div>
        </div>
      </div>

      <div class="slider-item" style="background-image: url('static/images/bg_2.jpg');">
        <div class="overlay"></div>
        <div class="container">
          <div class="row slider-text align-items-center justify-content-center text-center">
            <div class="col-md-10 col-sm-12 ftco-animate">
              <h1 class="mb-3"><fmt:message key="tasty"/></h1>
              <p><a href="reservation" class="btn btn-primary btn-outline-white px-5 py-3"><fmt:message key="book2"/></a></p>
            </div>
          </div>
        </div>
      </div>

      <div class="slider-item" style="background-image: url('static/images/bg_3.jpg');">
        <div class="overlay"></div>
        <div class="container">
          <div class="row slider-text align-items-center justify-content-center text-center">
            <div class="col-md-10 col-sm-12 ftco-animate">
              <h1 class="mb-3"><fmt:message key="book"/></h1>
              <p><a href="reservation" class="btn btn-primary btn-outline-white px-5 py-3"><fmt:message key="book2"/></a></p>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- END slider -->

    <div class="ftco-section-reservation">
      <div class="container">
        <div class="row">
          <div class="col-md-12 reservation pt-5 px-5">
            <div class="block-17">
              <form action="" method="post" class="d-block d-lg-flex">
                <div class="fields d-block d-lg-flex">

                  <div class="textfield-name one-third"><input type="text" class="form-control" placeholder="<fmt:message key="name"/>"></div>

                  <div class="textfield-phone one-third"><input type="text" class="form-control" placeholder="<fmt:message key="phone"/>"></div>

                  <div class="book-date one-third"><input type="text" id="book_date" class="form-control" placeholder="M/D/YYYY"></div>

                  <div class="book-time one-third">
                    <input type="text" id="book_time" class="form-control" placeholder="<fmt:message key="time"/>">
                  </div>

                  <div class="select-wrap one-third">
                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                    <select name="" id="" class="form-control">
                      <option value=""><fmt:message key="person"/></option>
                      <option value="">1</option>
                      <option value="">2</option>
                      <option value="">3</option>
                      <option value="">4+</option>
                    </select>
                  </div>
                </div>
                <input type="submit" class="search-submit btn btn-primary" value="<fmt:message key="reservation"/>">
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

     <section class="ftco-section-2">
      <div class="container d-flex">
        <div class="section-2-blocks-wrapper row">
          <div class="img col-sm-12 col-lg-6" style="background-image: url('static/images/about-2.jpg');">
          </div>
          <div class="text col-lg-6 ftco-animate">
            <div class="text-inner align-self-start">
              <span class="subheading"><fmt:message key="about.t"/></span>
              <h3 class="heading"><fmt:message key="our.chef"/></h3>
              <p><fmt:message key="far.away"/> <fmt:message key="separated"/></p>

              <p><fmt:message key="small.river"/></p>
            </div>
          </div>
        </div>
      </div>
    </section>



    <section class="ftco-section parallax-img" style="background-image: url('static/images/bg_3.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row justify-content-center mb-5 pb-5">
          <div class="col-md-7 text-center heading-section heading-section-white ftco-animate">
            <h2><fmt:message key="our.spe"/></h2>
          </div>
        </div>
      </div>
    </section>
    <section class="ftco-section bg-light">
      <div class="container special-dish">
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
                <p><fmt:message key="far.away"/></p>
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
        </div>
      </div>
    </section>

    <section class="ftco-section testimony-section">
      <div class="container">
        <div class="row justify-content-center mb-5 pb-5">
          <div class="col-md-7 text-center heading-section ftco-animate">
            <span class="subheading"><fmt:message key="guests.says"/></span>
            <h2><fmt:message key="satisfied"/></h2>
          </div>
        </div>
        <div class="row ftco-animate">
          <div class="carousel owl-carousel ftco-owl">
            <div class="item text-center">
              <div class="testimony-wrap p-4 pb-5">
                <div class="user-img mb-4" style="background-image: url(static/images/person_1.jpg)" style="border: 1px solid red;"></div>
                <div class="text">
                  <p class="star-rate"><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star-half-full"></span></p>
                  <p class="mb-5"><fmt:message key="far.away"/>.</p>
                  <p class="name"><fmt:message key="dennis.green"/></p>
                  <span class="position"><fmt:message key="guests"/></span>
                </div>
              </div>
            </div>
            <div class="item text-center">
              <div class="testimony-wrap p-4 pb-5">
                <div class="user-img mb-4" style="background-image: url(static/images/person_2.jpg)" style="border: 1px solid red;"></div>
                <div class="text">
                  <p class="star-rate"><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star-half-full"></span></p>
                  <p class="mb-5"><fmt:message key="far.away"/>.</p>
                  <p class="name"><fmt:message key="dennis.green"/></p>
                  <span class="position"><fmt:message key="guests"/></span>
                </div>
              </div>
            </div>
            <div class="item text-center">
              <div class="testimony-wrap p-4 pb-5">
                <div class="user-img mb-4" style="background-image: url(static/images/person_3.jpg)" style="border: 1px solid red;"></div>
                <div class="text">
                  <p class="star-rate"><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star-half-full"></span></p>
                  <p class="mb-5"><fmt:message key="far.away"/>.</p>
                  <p class="name"><fmt:message key="dennis.green"/></p>
                  <span class="position"><fmt:message key="guests"/></span>
                </div>
              </div>
            </div>
            <div class="item text-center">
              <div class="testimony-wrap p-4 pb-5">
                <div class="user-img mb-4" style="background-image: url(static/images/person_1.jpg)" style="border: 1px solid red;"></div>
                <div class="text">
                  <p class="star-rate"><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star-half-full"></span></p>
                  <p class="mb-5"><fmt:message key="far.away"/>.</p>
                  <p class="name"><fmt:message key="dennis.green"/></p>
                  <span class="position"><fmt:message key="guests"/></span>
                </div>
              </div>
            </div>
            <div class="item text-center">
              <div class="testimony-wrap p-4 pb-5">
                <div class="user-img mb-4" style="background-image: url(static/images/person_1.jpg)" style="border: 1px solid red;"></div>
                <div class="text">
                  <p class="star-rate"><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star"></span><span class="icon-star-half-full"></span></p>
                  <p class="mb-5"><fmt:message key="far.away"/>.</p>
                  <p class="name"><fmt:message key="dennis.green"/></p>
                  <span class="position"><fmt:message key="guests"/></span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section bg-light">
      <div class="container">
        <div class="row justify-content-center mb-5 pb-5">
          <div class="col-md-7 text-center heading-section ftco-animate">
            <span class="subheading"><fmt:message key="blog"/></span>
            <h2><fmt:message key="recent.blog"/></h2>
          </div>
        </div>
        <div class="row ftco-animate">
          <div class="carousel1 owl-carousel ftco-owl">
            <div class="item">
              <div class="blog-entry">
                <a href="blog-single" class="block-20" style="background-image: url('static/images/image_5.jpg');">
                </a>
                <div class="text p-4">
                  <div class="meta">
                    <div><a href="#"><fmt:message key="july"/></a></div>
                    <div><a href="#"><fmt:message key="admin"/></a></div>
                  </div>
                  <h3 class="heading"><a href="#"><fmt:message key="even"/></a></h3>
                  <p class="clearfix">
                    <a href="#" class="float-left read"><fmt:message key="more"/></a>
                    <a href="#" class="float-right meta-chat"><span class="icon-chat"></span> 3</a>
                  </p>
                </div>
              </div>
            </div>
            <div class="item">
              <div class="blog-entry" data-aos-delay="100">
                <a href="blog-single" class="block-20" style="background-image: url('static/images/image_6.jpg');">
                </a>
                <div class="text p-4">
                  <div class="meta">
                    <div><a href="#"><fmt:message key="july"/></a></div>
                    <div><a href="#"><fmt:message key="admin"/></a></div>
                  </div>
                  <h3 class="heading"><a href="#"><fmt:message key="even"/></a></h3>
                  <p class="clearfix">
                    <a href="#" class="float-left read"><fmt:message key="more"/></a>
                    <a href="#" class="float-right meta-chat"><span class="icon-chat"></span> 3</a>
                  </p>
                </div>
              </div>
            </div>
            <div class="item">
              <div class="blog-entry" data-aos-delay="200">
                <a href="blog-single" class="block-20" style="background-image: url('static/images/image_7.jpg');">
                </a>
                <div class="text p-4">
                  <div class="meta">
                    <div><a href="#"><fmt:message key="july"/></a></div>
                    <div><a href="#"><fmt:message key="admin"/></a></div>
                  </div>
                  <h3 class="heading"><a href="#"><fmt:message key="even"/></a></h3>
                  <p class="clearfix">
                    <a href="#" class="float-left read"><fmt:message key="more"/></a>
                    <a href="#" class="float-right meta-chat"><span class="icon-chat"></span> 3</a>
                  </p>
                </div>
              </div>
            </div>
            <div class="item">
              <div class="blog-entry" data-aos-delay="200">
                <a href="blog-single" class="block-20" style="background-image: url('static/images/image_8.jpg');">
                </a>
                <div class="text p-4">
                  <div class="meta">
                    <div><a href="#"><fmt:message key="july"/></a></div>
                    <div><a href="#"><fmt:message key="admin"/></a></div>
                  </div>
                  <h3 class="heading"><a href="#"><fmt:message key="even"/></a></h3>
                  <p class="clearfix">
                    <a href="#" class="float-left read"><fmt:message key="more"/></a>
                    <a href="#" class="float-right meta-chat"><span class="icon-chat"></span> 3</a>
                  </p>
                </div>
              </div>
            </div>
            <div class="item">
              <div class="blog-entry" data-aos-delay="200">
                <a href="blog-single" class="block-20" style="background-image: url('static/images/image_9.jpg');">
                </a>
                <div class="text p-4">
                  <div class="meta">
                    <div><a href="#"><fmt:message key="july"/></a></div>
                    <div><a href="#"><fmt:message key="admin"/></a></div>
                  </div>
                  <h3 class="heading"><a href="#"><fmt:message key="even"/></a></h3>
                  <p class="clearfix">
                    <a href="#" class="float-left read"><fmt:message key="more"/></a>
                    <a href="#" class="float-right meta-chat"><span class="icon-chat"></span> 3</a>
                  </p>
                </div>
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