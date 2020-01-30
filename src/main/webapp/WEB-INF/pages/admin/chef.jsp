<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>Track Material Design Bootstrap Admin Template</title>
    <c:import url="../templ/head-admin-part.jsp"/>

</head>
<body>
<div id="wrapper">
<c:import url="../templ/nav-admin-part2.jsp"/>
<!-- /. NAV SIDE  -->

        <div id="page-wrapper" style="margin-left: 0px;">
		  <div class="header">
              <h1 class="page-header">
                  Cook It
              </h1>
          </div>

<div id="page-inner">

<div class="row">
    <c:forEach items="${ordersInProgress}" var="ordersInProgress">
    <div class="col-md-4 col-sm-4">
        <div class="card">
            <div class="card-content">
                <span class="card-title">Order # ${ordersInProgress.id}</span>

                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Dish</th>
                                <th>Qty</th>
                            </tr>
                            </thead>
                            <tbody>

                            <tr>
                                <td>
                                    <input type="checkbox" class="filled-in" id="filled-in-box ${ordersInProgress.id}"  />
                                    <label for="filled-in-box ${ordersInProgress.id}"></label>
                                </td>
                                <td>Яловичина на грилі з картоплею</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td>
                                        <input type="checkbox" class="filled-in" id="filled-in-box ${ordersInProgress.id}"  />
                                        <label for="filled-in-box ${ordersInProgress.id}"></label>
                                </td>
                                <td>Пряний смажений рис і бекон</td>
                                <td>2</td>
                            </tr>
                            <tr>
                                <td>
                                        <input type="checkbox" class="filled-in" id="filled-in-box ${ordersInProgress.id}"  />
                                        <label for="filled-in-box ${ordersInProgress.id}"></label>
                                </td>
                                <td>Восьминіг з овочами</td>
                                <td>10</td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
            </div>
            <div class="card-action">
                <form method="post" action="status">
                    <div class="pricing-table-footer">
                        <input type="hidden" name="status" value="COMPLETED" />
                        <input type="hidden" name="orderId" value="${order.id}" />
                        <button type="submit" class="waves-effect waves-light btn">
                            <i class="material-icons left">cloud</i>
                            <fmt:message key="complete"/></button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </c:forEach>


<c:import url="../templ/footer-admin-part.jsp"/>
</body>

</html>
