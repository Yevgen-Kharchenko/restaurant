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
              <c:choose>
                  <c:when test="${order.status=='NEW'}">
                      <h1 class="page-header">
                          Edit and approve order # ${order.id}
                      </h1>
                  </c:when>
                  <c:when test="${order.status=='IN_PROGRESS'}">
                      <h1 class="page-header">
                          Complete or cancel order # ${order.id}
                      </h1>
                  </c:when>
                  <c:when test="${order.status=='COMPLETED'}">
                      <h1 class="page-header">
                          Receive payment for order # ${order.id}
                      </h1>
                  </c:when>
                  <c:when test="${order.status=='PAYMENT'}">
                      <h1 class="page-header">
                          Get Invoice & Pay  # ${order.id}
                      </h1>
                  </c:when>
                  <c:when test="${order.status=='CLOSED'}">
                      <h1 class="page-header">
                          Closed order # ${order.id}
                      </h1>
                  </c:when>
                  <c:otherwise>
                      <h1 class="page-header">
                          Canceled order # ${order.id}
                      </h1>
                  </c:otherwise>
              </c:choose>

              <div class="col-md-12" style="margin:15px;">
              <h2>
                  Guest: ${order.customer.name}
                  <small>Phone: ${order.customer.phone}</small>
              </h2>
              </div>
		</div>
            <div id="page-inner"> 
			
			  <div class="row">
                    
                    <div class="col-md-12">
                    <div class="card">

                        <c:choose>
                        <c:when test="${order.status=='NEW'}">

                        <div class="card-content">

                            <h4>Add Dishes To The Order </h4>
                            <div style="margin-top: 10px;">

                                <div class="btn-group">
                                    <button data-toggle="dropdown" class="btn btn-primary dropdown-toggle">MAIN <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <c:forEach items="${main}" var="main">
                                        <li><a href="add-order-dish?dishId=${main.id}&orderId=${order.id}">${main.name}</a></li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <div style="margin-left:5px;" class="btn-group">
                                    <button data-toggle="dropdown" class="btn btn-success dropdown-toggle">DESSERT <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <c:forEach items="${dessert}" var="dessert">
                                            <li><a href="add-order-dish?dishId=${dessert.id}&orderId=${order.id}">${dessert.name}</a></li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <div style="margin-left:5px;" class="btn-group">
                                    <button data-toggle="dropdown" class="btn btn-warning dropdown-toggle">DRINKS <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <c:forEach items="${drinks}" var="drinks">
                                            <li><a href="add-order-dish?dishId=${drinks.id}&orderId=${order.id}">${drinks.name}</a></li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <div style="margin-left:50px;" class="btn-group">
                                    <h3>Total Price:  ${order.total} $</h3>
                                </div>

                            </div>

                        </div>
                        </c:when>
                            <c:otherwise>
                                <div class="card-content">
                                <div style="margin-top: 10px;">
                                <div style="margin-left:50px;" class="btn-group">
                                    <h3>Total Price:  ${order.total} $</h3>
                                </div>
                                </div>
                                </div>
                            </c:otherwise>
                        </c:choose>

                         <div class="card-content">
                             <div class="table-responsive">
                                 <table class="table table-striped table-bordered table-hover">
                                     <thead>
                                     <tr>
                                         <th>Dish</th>
                                         <th>Ingredients</th>
                                         <th>Quantity</th>
                                         <th>Price</th>
                                         <c:choose>
                                         <c:when test="${order.status=='NEW'}">
                                             <th>Delete</th>
                                         </c:when>
                                             <c:otherwise>
                                             </c:otherwise>
                                         </c:choose>

                                     </tr>
                                     </thead>
                                     <tbody>
                                     <c:forEach items="${order.orderDish}" var="dishes">
                                         <tr>
                                             <td>${dishes.name}</td>
                                             <td>${dishes.ingredients}</td>
                                             <c:choose>
                                             <c:when test="${order.status=='NEW'}">

                                             <td>
                                                 <form  action="update-order-dish-quantity">
                                                     <div class=" col s6">
                                                         <input type="number" name="qty" value="${dishes.quantity}" min="1" max="10" step="1"/>
                                                         <input type="hidden" name="orderDishId" value="${dishes.id}"/>
                                                         <input type="hidden" name="orderId" value="${order.id}" />
                                                     </div>
                                                         <div class=" col s4">
                                                     <button type="submit" class=" btn-link">
                                                         <i class="material-icons">loop</i>
                                                     </button>
                                                         </div>
                                                 </form>
                                             </td>
                                             </c:when>
                                             <c:otherwise>
                                                 <td>${dishes.quantity}</td>
                                             </c:otherwise>
                                             </c:choose>
                                             <td>${dishes.price}</td>
                                             <c:choose>
                                             <c:when test="${order.status=='NEW'}">
                                             <td><a href="order-dish-delete?orderDishId=${dishes.id}&orderId=${order.id}"><i class="material-icons dp48">delete</i></td>
                                             </c:when>
                                             <c:otherwise>
                                             </c:otherwise>
                                             </c:choose>
                                         </tr>
                                     </c:forEach>
                                     </tbody>
                                 </table>
                             </div>

                             <div class="card-action">

                                     <div class="pricing-table-footer">

                                         <c:choose>
                                             <c:when test="${order.status=='NEW'}">
                                                 <div style="margin-left:50px;" class="btn-group">
                                                     <form method="post" action="status">
                                                     <input type="hidden" name="status" value="IN_PROGRESS" />
                                                     <input type="hidden" name="orderId" value="${order.id}" />
                                                     <button type="submit" class="waves-effect waves-light btn">
                                                         <i class="material-icons left">cloud</i>
                                                         <fmt:message key="approve"/></button>
                                                     </form>
                                                 </div>
                                                 <div style="margin-left:50px;" class="btn-group">
                                                     <form method="post" action="status">
                                                     <input type="hidden" name="status" value="CANCELED" />
                                                     <input type="hidden" name="orderId" value="${order.id}" />
                                                     <button type="submit" class="waves-effect btn-danger btn">
                                                         <i class="material-icons left">delete</i>
                                                         <fmt:message key="cancel"/></button>
                                                     </form>
                                                 </div>
                                             </c:when>
                                             <c:when test="${order.status=='IN_PROGRESS'}">
                                                 <div style="margin-left:50px;" class="btn-group">
                                                     <form method="post" action="status">
                                                     <input type="hidden" name="status" value="COMPLETED" />
                                                     <input type="hidden" name="orderId" value="${order.id}" />
                                                     <button type="submit" class="waves-effect btn-success btn">
                                                         <i class="material-icons left">done</i>
                                                         <fmt:message key="complete"/></button>
                                                     </form>
                                                 </div>
                                                 <div style="margin-left:50px;" class="btn-group">
                                                     <form method="post" action="status">
                                                     <input type="hidden" name="status" value="CANCELED" />
                                                     <input type="hidden" name="orderId" value="${order.id}" />
                                                     <button type="submit" class="waves-effect btn-danger btn">
                                                         <i class="material-icons left">delete</i>
                                                         <fmt:message key="cancel"/></button>
                                                     </form>
                                                 </div>

                                             </c:when>
                                             <c:when test="${order.status=='COMPLETED'}">

                                                 <div style="margin-left:50px;" class="btn-group">
                                                     <form method="post" action="status">
                                                     <input type="hidden" name="status" value="PAYMENT" />
                                                     <input type="hidden" name="orderId" value="${order.id}" />
                                                     <button type="submit" class="waves-effect btn-success btn">
                                                         <i class="material-icons left">credit_card</i>
                                                         <fmt:message key="invoice2"/></button>
                                                     </form>
                                                 </div>

                                             </c:when>
                                             <c:when test="${order.status=='PAYMENT'}">

                                                 <div style="margin-left:50px;" class="btn-group">
                                                         <a href="invoice?orderId=${order.id}" class="waves-effect waves-light btn">
                                                             <fmt:message key="invoice"/> </a>
                                                 </div>

                                             </c:when>
                                             <c:otherwise>
                                             </c:otherwise>
                                         </c:choose>

                                     </div>


                             </div>

                           <div class="clearBoth"><br/></div>
						    
						 </div>
						 </div>


<c:import url="templ/footer-admin-part.jsp"/>
</body>

</html>
