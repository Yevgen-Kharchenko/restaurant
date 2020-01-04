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
            <div class="col-md-6 col-sm-12 ftco-animate text-center">
			
              <div class="login-contect py-5">
		<div class="container py-xl-5 py-3">
			<div class="login-body">
				<div class="login p-4 mx-auto">
					<h1 class="mb-3"><fmt:message key="register2"/></h5>
					<form action="#" method="post">
						<div class="form-group">
							<label><fmt:message key="your.name"/></label>
							<input type="text" class="form-control" name="name" placeholder="" required="">
						</div>
						<div class="form-group">
							<label><fmt:message key="email2"/></label>
							<input type="email" class="form-control" name="email" placeholder="" required="">
						</div>
						<div class="form-group">
							<label class="mb-2"><fmt:message key="password"/></label>
							<input type="password" class="form-control" name="password" id="password1" placeholder=""
								required="">
						</div>
						<div class="form-group">
							<label><fmt:message key="confirm"/></label>
							<input type="password" class="form-control" name="password" id="password2" placeholder=""
								required="">
						</div>
						<button type="submit" class="btn submit mb-4"><fmt:message key="register"/></button>

					</form>
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