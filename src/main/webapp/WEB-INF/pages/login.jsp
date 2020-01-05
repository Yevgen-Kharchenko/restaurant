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
					<h1 class="mb-3"><fmt:message key="login.now"/></h5>
					<form action="login" method="post">
						<div class="form-group">
							<label><fmt:message key="your.name"/></label>
							<input type="text" class="form-control" name="login" placeholder="" required="">
						</div>
						<div class="form-group">
							<label class="mb-2"><fmt:message key="password"/></label>
							<input type="password" class="form-control" name="password" placeholder="" required="">
						</div>
						<button type="submit" class="btn submit mb-4"><fmt:message key="login"/></button>
						<p class="forgot-w3ls text-center mb-3">
							<a href="login" class="text-da"><fmt:message key="forgot"/></a>
						</p>
						<p class="account-w3ls text-center text-da">
							<fmt:message key="don't"/>
							<a href="register"><fmt:message key="create"/></a>
						</p>
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