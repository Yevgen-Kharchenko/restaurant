<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>Track Material Design Bootstrap Admin Template</title>
    <c:import url="templ/head-admin-part.jsp"/>

</head>
<body>
<div id="wrapper">
<c:import url="templ/nav-admin-part.jsp"/>
<!-- /. NAV SIDE  -->

        <div id="page-wrapper">
		  <div class="header"> 
                        <h1 class="page-header">
                            Empty Page <small>Create new page.</small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Home</a></li>
					  <li><a href="#">Empty</a></li>
					  <li class="active">Data</li>
					</ol> 
									
		</div>
            <div id="page-inner"> 
			
			  <div class="row">
                    
                    <div class="col-md-12">
                    <div class="card">
                        <div class="card-action">
                         Empty Page
                        </div>        
                         <div class="card-content"> 
						 <p>Consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
                           <div class="clearBoth"><br/></div>
						    
						 </div>
						 </div>


<c:import url="templ/footer-admin-part.jsp"/>
</body>

</html>
