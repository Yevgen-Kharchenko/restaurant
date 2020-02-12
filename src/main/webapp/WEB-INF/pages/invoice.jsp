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
          <p class="breadcrumbs"><span class="mr-2"><a href=""><fmt:message key="home"/></a></span> <span><fmt:message key="invoice2"/></span></p>
          <h1 class="mb-3"><fmt:message key="invoice2"/></h1>
        </div>
      </div>
    </div>
  </div>
</section>

<div class="container">
<div id="page-wrapper" >
<div class="header">


</div>

<div id="page-inner">

<div class="row">
<div class="col-md-12">
  <!-- Advanced Tables -->
  <div class="card">

    <div class="card-content">
      <div class="table-responsive">

          <c:forEach items="${invoice}" var="invoice">

<table class="table table-striped table-bordered table-hover">
 <thead>
 <tr>
 <th colspan="3">Invoice #${invoice.id}</th>
 <th>${invoice.date}</tr>
 <tr>
 <td colspan="2"> <strong>Pay to:</strong> <br> Tasty Co.<br> 123 Main St.<br> Cityville, NA 12345 </td>
 <td colspan="2"> <strong>Guest:</strong><br>  ${user.name}<br>  ${user.phone}</td>
 </tr>
 </thead>
 <tbody>
 <tr>
 <th>Dishes</th>
 <th>Qty.</th>
 <th>@</th>
 <th>Cost</th>
 </tr>

     <c:forEach items="${invoice.orderDTO.orderDish}" var="dishes">
         <tr>
         <td>${dishes.name}</td>
         <td>${dishes.quantity}</td>
         <td>${dishes.price}</td>
         <td>${dishes.cost}</td>
         </tr>
     </c:forEach>


 </tbody>
 <tfoot>


 <tr>
     <th colspan="3">Grand Total</th>
     <td>$ ${invoice.orderDTO.total}</td>
 </tr>

 <tr>
     <th colspan="3"></th>
     <td>
         <c:choose>
         <c:when test="${invoice.status=='NEW'}">
         <div class="center">
         <div class="form-group">
             <form method="post" action="invoice">
                 <input type="hidden" name="invoiceStatus" value="PAID" />
                 <input type="hidden" name="invoiceId" value="${invoice.id}" />
                 <input type="submit" value="<fmt:message key="pay"/>" class="btn btn-primary py-3 px-5"style="background-color:green">
             </form>
         </div>
         <div class="form-group">
             <form method="post" action="invoice">
                 <input type="hidden" name="invoiceStatus" value="CANCELED" />
                 <input type="hidden" name="invoiceId" value="${invoice.id}" />
                 <input type="submit" value="<fmt:message key="cancel"/>" class="btn btn-primary py-3 px-5"style="background-color:red">
             </form>
         </div>
     </div>
         </c:when>
         <c:when test="${invoice.status=='PAID'}">
                 <h2>Paid invoice</h2>
         </c:when>
             <c:otherwise>
                 <h2>Canceled invoice</h2>
             </c:otherwise>
         </c:choose>
     </td>
 </tr>
 </tfoot>
 </table>
          </c:forEach>

      </div>

    </div>
  </div>
</div>

<c:import url="templ/footer-part.jsp"/>
<c:import url="templ/loader.jsp"/>

</body>
</html>