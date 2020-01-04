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
              <p class="breadcrumbs"><span class="mr-2"><a href=""><fmt:message key="home"/></a></span> <span><fmt:message key="reservation"/></span></p>
              <h1 class="mb-3"><fmt:message key="make.res"/></h1>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section">
      <div class="container">
        <div class="row no-gutters justify-content-center mb-5 pb-5">
          <div class="col-md-7 text-center heading-section ftco-animate">
            <h2><fmt:message key="make.res"/></h2>
          </div>
        </div>
        <div class="row d-flex">
          <div class="col-md-4 ftco-animate img" style="background-image: url(static/images/bg_1.jpg);"></div>
          <div class="col-md-8 ftco-animate makereservation p-5 bg-light">
            <form action="#">
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label for=""><fmt:message key="name"/></label>
                    <input type="text" class="form-control" placeholder="<fmt:message key="your.name"/>">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for=""><fmt:message key="email2"/></label>
                    <input type="text" class="form-control" placeholder="<fmt:message key="your.email"/>">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for=""><fmt:message key="phone2"/></label>
                    <input type="text" class="form-control" placeholder="<fmt:message key="phone2"/>">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for=""><fmt:message key="date"/></label>
                    <input type="text" class="form-control" id="book_date" placeholder="<fmt:message key="date"/>">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for=""><fmt:message key="time"/></label>
                    <input type="text" class="form-control" id="book_time" placeholder="<fmt:message key="time"/>">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label for=""><fmt:message key="person"/></label>
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
                </div>
                <div class="col-md-12 mt-3">
                  <div class="form-group">
                    <input type="submit" value="<fmt:message key="make.res"/>" class="btn btn-primary py-3 px-5">
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>

    <c:import url="templ/footer-part.jsp"/>
    <c:import url="templ/loader.jsp"/>
</body>
</html>