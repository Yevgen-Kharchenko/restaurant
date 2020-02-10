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
              <p class="breadcrumbs"><span class="mr-2"><a href=""><fmt:message key="home"/></a></span> <span><fmt:message key="menu"/></span></p>
              <h1 class="mb-3"><fmt:message key="discover"/></h1>
            </div>
          </div>
        </div>
      </div>
    </section>

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
                <input type="submit" class="search-submit btn btn-primary" value="<fmt:message key="book2"/>">
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section bg-light">
      <div class="container">
        <form action="menu" method="post">

        <div class="row justify-content-center mb-5 pb-5">
          <div class="col-md-7 text-center heading-section ftco-animate">
            <span class="subheading"><fmt:message key="our.menu"/></span>
            <h2><fmt:message key="discover"/></h2>
          </div>
        </div>
        <div class="row" id="checkboxes">

          <div class="col-md-12 dish-menu">

            <div class="nav nav-pills justify-content-center ftco-animate" id="v-pills-tab" role="tablist" aria-orientation="vertical">
              <a class="nav-link py-3 px-4 active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true"><span class="flaticon-meat"></span><fmt:message key="main"/></a>
              <a class="nav-link py-3 px-4" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false"><span class="flaticon-cutlery"></span><fmt:message key="dessert"/></a>
              <a class="nav-link py-3 px-4" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false"><span class="flaticon-cheers"></span><fmt:message key="drinks"/></a>
            </div>

            <div class="tab-content py-5" id="v-pills-tabContent">

              <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                <div class="row">
                  
                    <c:forEach items="${dishMainList}" var="dishMain">
					<div class="col-lg-6">
				     <input type="checkbox" id="dish_${dishMain.id}" onmousedown="this.form.dish${dishMain.id}.disabled=this.checked"/>
					<label for="dish_${dishMain.id}" class="menus d-flex ftco-animate" onmousedown="this.form.dish${dishMain.id}.disabled=this.checked">
                      <div class="menu-img" style="background-image: url(static/images/dish-${dishMain.id}.jpg);"></div>
						<div class="text d-flex">
							<div class="one-half">
								<h3>${dishMain.name}</h3>
                              <p><span>${dishMain.ingredients}</span></p>
							</div>
							<div class="one-forth">

									<p><input type="number" id="dish${dishMain.id}" name="${dishMain.id}" value="1" min="1" max="10" step="1" disabled/></p>

							</div>
							<div class="one-forth">
								<span class="price">$${dishMain.price}</span>
							</div>           
						</div>
					</label>
					</div>
                    </c:forEach>
										
                </div>
              </div>

              <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                <div class="row">
                  
                    <c:forEach items="${dishDessertList}" var="dishDessert">
					<div class="col-lg-6">
                        <input type="checkbox" id="dish_${dishDessert.id}" onmousedown="this.form.dish${dishDessert.id}.disabled=this.checked"/>
                        <label for="dish_${dishDessert.id}" class="menus d-flex ftco-animate" onmousedown="this.form.dish${dishDessert.id}.disabled=this.checked">
                          <div class="menu-img" style="background-image: url(static/images/dish-${dishDessert.id}.jpg);"></div>
                          <div class="text d-flex">
                            <div class="one-half">
                              <h3>${dishDessert.name}</h3>
                              <p><span>${dishDessert.ingredients}</span></p>
                            </div>
                            <div class="one-forth">

                                <p><input type="number" id="dish${dishDessert.id}" name="${dishDessert.id}" value="1" min="1" max="10" step="1" disabled/></p>

                            </div>
                            <div class="one-forth">
                              <span class="price">$${dishDessert.price}</span>
                            </div>
                          </div>
                        </label>
					</div>
                    </c:forEach>
					
                </div>
              </div>

              <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                <div class="row">
                  
                    <c:forEach items="${dishDrinksList}" var="dishDrinks">
					<div class="col-lg-6">
                        <input type="checkbox" id="dish_${dishDrinks.id}" onmousedown="this.form.dish${dishDrinks.id}.disabled=this.checked"/>
                        <label for="dish_${dishDrinks.id}" class="menus d-flex ftco-animate" onmousedown="this.form.dish${dishDrinks.id}.disabled=this.checked">
                          <div class="menu-img" style="background-image: url(static/images/dish-${dishDrinks.id}.jpg);"></div>
                          <div class="text d-flex">
                            <div class="one-half">
                              <h3>${dishDrinks.name}</h3>
                              <p><span>${dishDrinks.ingredients}</span></p>
                            </div>

                            <div class="one-forth">

                                <p><input type="number" id="dish${dishDrinks.id}" name="${dishDrinks.id}" value="1" min="1" max="10" step="1" disabled /></p>

                            </div>
                            <div class="one-forth">
                              <span class="price">$${dishDrinks.price}</span>
                            </div>
                          </div>
                        </label>
					</div>
                    </c:forEach>
                  
                </div>
              </div>

            </div>
          </div>
        </div>
      <div class="col-sm-12 pt-4 text-center ftco-animate">
                <p><fmt:message key="even"/></p>
        <button type="submit" class="btn btn-primary btn-outline-primary p-3">
          <fmt:message key="make.res"/></button>
              </div>
        </form>
      </div>
    </section>


    <c:import url="templ/footer-part.jsp"/>
    <c:import url="templ/loader.jsp"/>
</body>
</html>