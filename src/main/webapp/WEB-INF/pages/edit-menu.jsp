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
                    <p class="breadcrumbs"><span class="mr-2"><a href=""><fmt:message key="home"/></a></span> <span><fmt:message key="edit.menu"/></span></p>
                    <h1 class="mb-3"><fmt:message key="edit.menu.text"/></h1>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="ftco-section bg-light" >
    <div class="container" >
        <div class="col-md-12 dish-menu">

            <div class="tab-pane fade show active" >
                <div class="row">

                    <c:forEach items="${dishList}" var="dish">

					<div class="col-lg-6">
                        <a href="dish?id=${dish.id}">
                        <div  class="menus d-flex ftco-animate">
                      <div class="menu-img" style="background-image: url(static/images/${dish.imageName});"></div>
						<div class="text d-flex">
							<div class="one-half">
                                <h3>${dish.dishType}</h3>
								<h3>${dish.name}</h3>
                              <p><span>${dish.ingredients}</span></p>
							</div>

							<div class="one-forth">
								<span class="price">$${dish.price}</span>
							</div>
						</div>
                        </div>
                        </a>
					</div>

                    </c:forEach>

                </div>
            </div>

        </div>
        <div class="col-sm-12 pt-4 text-center ftco-animate">
                <p><fmt:message key="select.dish"/></p>
                <span><a href="dish?id=0" class="btn btn-primary btn-outline-primary p-3"><fmt:message key="add.dish"/></a></span>
          </div>


  <div class="row mt-5">
      <div class="col text-center">
          <div class="block-27">
            <c:if test="${dishPages > 1}">
                <ul>
                    <c:choose>
                        <c:when test="${currentPage  > 1 }">
                            <li><a href="edit-menu?page=${currentPage-1}&size=6"><span>&lt;</span></a></li>
                        </c:when>
                        <c:otherwise>
                            <li><span>&lt;</span></li>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach var = "numberPage" begin = "1" end = "${dishPages}">
                        <c:choose>
                            <c:when test="${currentPage == numberPage }">
                                <li class="active"><a href="users?page=${numberPage}&size=6">${numberPage}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="edit-menu?page=${numberPage}&size=6" >${numberPage}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:choose>
                        <c:when test="${currentPage < dishPages }">
                            <li><a href="edit-menu?page=${currentPage+1}&size=6"><span>></span></a></li>
                        </c:when>
                        <c:otherwise>
                            <li><span>></span></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </c:if>
          </div>
      </div>
  </div>
</section>

    <c:import url="templ/footer-part.jsp"/>
    <c:import url="templ/loader.jsp"/>
</body>
</html>