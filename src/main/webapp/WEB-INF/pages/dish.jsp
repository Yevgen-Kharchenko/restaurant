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
			
              <div class="login-contect py-5">
		<div class="container py-xl-5 py-3">
			<div class="login-body">
				<div class="login p-4 mx-auto">

					<c:choose>
					<c:when test="${not empty dish}">
					<h1 class="mb-3"><fmt:message key="edit.dish"/></h1>
					</c:when>
					<c:otherwise>
						<h1 class="mb-3"><fmt:message key="add.dish"/></h1>
					</c:otherwise>
					</c:choose>

					<div class="container" >
						<div class="col-md-12 dish-menu">
							<form method="post" action="dish"  class="col-lg-12">
							<div class="tab-pane fade show active" >
								<div class="row">

						<div class="col-lg-6">
							<label><fmt:message key="nameUK"/></label>
							<input type="text" name="nameUK" value="${dish.nameUK}" class="form-control"  >
						</div>
						<div class="col-lg-6">
							<label><fmt:message key="nameEN"/></label>
							<input type="text" name="nameEN" value="${dish.nameEN}" class="form-control"  >
						</div>
						<div class="col-lg-6">
							<label><fmt:message key="ingredientsUK"/></label>
							<input type="text" name="ingredientsUK" value="${dish.ingredientsUK}" class="form-control"  >
						</div>
						<div class="col-lg-6">
							<label><fmt:message key="ingredientsEN"/></label>
							<input type="text" name="ingredientsEN" value="${dish.ingredientsEN}" class="form-control" >
						</div>
						<div class="col-lg-6">
							<label ><fmt:message key="dishType"/></label>
							<select  name="dishType" value="${dish.dishType}"   class="form-control">
								<option value="MAIN">MAIN</option>
								<option value="DESSERT">DESSERT</option>
								<option value="DRINKS">DRINKS</option>

							</select>
						</div>
						<div class="col-lg-6">
							<label class="mb-2"><fmt:message key="price"/></label>
							<input type="text" name="price" value="${dish.price}"class="form-control"  >
						</div>
						<div class="col-lg-6">
							<label class="mb-2"><fmt:message key="images"/></label>
							<input type="text" name="images" value="${dish.imageName}" class="form-control"  >
						</div>

									<div class="col-lg-4">
										<c:choose>
										<c:when test="${not empty dish}">
											<fmt:message key="edit.delete"/>
											<input type="hidden" name="dishId" value="${dish.id}" />
											<button type="submit" class="btn btn-primary btn-outline-primary p-3"><fmt:message key="edit"/></button>
											<span><a href="dish-delete?id=${dish.id}" class="btn btn-primary btn-outline-primary p-3"><fmt:message key="delete"/></a></span>
										</c:when>
										<c:otherwise>
											<fmt:message key="add.dish"/>
											<input type="hidden" name="dishId" value="0" />
											<button type="submit" class="btn btn-primary btn-outline-primary p-3"><fmt:message key="add.dish"/></button>
										</c:otherwise>
										</c:choose>

									</div>

									<div class="col-lg-3">
										<div class="custom-img">
										<img src="static/images/${dish.imageName}"  width="100" height="100">
										</img>
										</div>
									</div>
							</form>
								</div>
							</div>




						</div>
					</div>
				</div>
			</div>
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