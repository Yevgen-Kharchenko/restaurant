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
                    <p class="breadcrumbs"><span class="mr-2"><a href=""><fmt:message key="home"/></a></span> <span><fmt:message key="orders"/></span></p>
                    <h1 class="mb-3"><fmt:message key="orders"/></h1>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="container">
<div id="page-wrapper" >
<div class="header">
    <h1 class="page-header">
        Orders List Page
    </h1>

</div>

<div id="page-inner">

<div class="row">
<div class="col-md-12">
    <!-- Advanced Tables -->
    <div class="card">
        <div class="card-action">
            Orders by ${user.name}
        </div>
        <div class="card-content">
            <div class="table-responsive">

                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                    <thead>
                    <tr>
                        <th># id</th>
                        <th>date</th>
                        <th>dishes</th>
                        <th>total $</th>
                        <th>status</th>
                        <th>action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${myOrders}" var="myOrders">
                    <tr class="even gradeA">
                        <td>${myOrders.id}</td>
                        <td>${myOrders.date}</td>
                        <td>
                        <c:forEach items="${myOrders.orderDish}" var="dishes">
                            <p>${dishes.name} - ${dishes.quantity} X ${dishes.price}$;</p>
                        </c:forEach>
                        </td>
                        <td>${myOrders.total}</td>
                        <td>${myOrders.status}</td>
                        <c:choose>
                        <c:when test="${myOrders.status=='COMPLETED'}">

                        <td class="center">
                            <div class="form-group">
                                <form method="post" action="status">
                                <input type="hidden" name="status" value="PAYMENT" />
                                <input type="hidden" name="orderId" value="${myOrders.id}" />
                                <input type="submit" value="<fmt:message key="invoice2"/>" class="btn btn-primary py-3 px-5" style="background-color:green">
                                </form>
                            </div>
                        </td>

                        </c:when>
                            <c:when test="${myOrders.status=='PAYMENT'}">
                                <td class="center">
                                <div class="form-group">
                                <div >
                                    <a href="invoice?orderId=${myOrders.id}" class="btn btn-primary py-3 px-5" style="background-color:green">
                                        <fmt:message key="invoice"/> </a>
                                </div>
                                </div>
                                </td>
                            </c:when>
                        <c:when test="${myOrders.status=='NEW'}">

                            <td class="center">
                                <div class="form-group">
                                    <form method="post" action="status">
                                    <input type="hidden" name="status" value="CANCELED" />
                                    <input type="hidden" name="orderId" value="${myOrders.id}" />
                                    <input type="submit" value="<fmt:message key="cancel"/>" class="btn btn-primary py-3 px-5"style="background-color:red">
                                    </form>
                                </div>
                            </td>

                        </c:when>
                        <c:otherwise>

                            <td class="center">
                                <div class="form-group">
                                    <form method="post" action="status">
                                    <input type="hidden" name="status" value="REPEAT" />
                                    <input type="hidden" name="orderId" value="${myOrders.id}" />
                                    <input type="submit" value="<fmt:message key="repeat"/>" class="btn btn-primary py-3 px-5">
                                    </form>
                                </div>
                            </td>

                        </c:otherwise>
                        </c:choose>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>

        </div>
    </div>
</div>

<c:import url="templ/footer-part.jsp"/>
<c:import url="templ/loader.jsp"/>

</body>
</html>