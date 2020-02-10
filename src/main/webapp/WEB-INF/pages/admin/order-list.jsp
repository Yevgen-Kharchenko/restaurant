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
<c:import url="../templ/nav-admin-part.jsp"/>
<!-- /. NAV SIDE  -->

        <div id="page-wrapper">
		  <div class="header"> 
                        <h1 class="page-header">
                            Order List <small>Select an order to view.</small>
                        </h1>

									
		</div>
            <div id="page-inner"> 
			
			  <div class="row">
                    
                    <div class="col-md-12">
                    <div class="card">
                        <div class="card-action">
                         Status
                        </div>
                        <div class="card-content">
                            <ul class="collapsible" data-collapsible="accordion">
                                <li>
                                    <div class="collapsible-header"><i class="material-icons">input</i>NEW</div>
                                    <div class="collapsible-body">
                                        <div class="card">

                                            <div class="card-content">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Date</th>
                                                            <th>Name</th>
                                                            <th>Phone</th>
                                                            <th>Price</th>
                                                            <th>Edit</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${ordersNew}" var="ordersNew">
                                                            <tr>
                                                                <td>${ordersNew.id}</td>
                                                                <td>${ordersNew.date}</td>
                                                                <td>${ordersNew.customer.name}</td>
                                                                <td>${ordersNew.customer.phone}</td>
                                                                <td>${ordersNew.total}</td>
                                                                <td>
                                                                    <a href="admin/order?orderId=${ordersNew.id}"><i class="material-icons">mode_edit</i></a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>

                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="collapsible-header"><i class="material-icons">query_builder</i>IN_PROGRESS</div>
                                    <div class="collapsible-body">
                                        <div class="card">

                                            <div class="card-content">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Date</th>
                                                            <th>Name</th>
                                                            <th>Phone</th>
                                                            <th>Price</th>
                                                            <th>Edit</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${ordersInProgress}" var="ordersInProgress">
                                                            <tr>
                                                                <td>${ordersInProgress.id}</td>
                                                                <td>${ordersInProgress.date}</td>
                                                                <td>${ordersInProgress.customer.name}</td>
                                                                <td>${ordersInProgress.customer.phone}</td>
                                                                <td>${ordersInProgress.total}</td>
                                                                <td>
                                                                    <a href="admin/order?orderId=${ordersInProgress.id}"><i class="material-icons">mode_edit</i></a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="collapsible-header"><i class="material-icons">turned_in_not</i>COMPLETED</div>
                                    <div class="collapsible-body">
                                        <div class="card">

                                            <div class="card-content">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Date</th>
                                                            <th>Name</th>
                                                            <th>Phone</th>
                                                            <th>Price</th>
                                                            <th>Edit</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${ordersCompleted}" var="ordersCompleted">
                                                            <tr>
                                                                <td>${ordersCompleted.id}</td>
                                                                <td>${ordersCompleted.date}</td>
                                                                <td>${ordersCompleted.customer.name}</td>
                                                                <td>${ordersCompleted.customer.phone}</td>
                                                                <td>${ordersCompleted.total}</td>
                                                                <td>
                                                                    <a href="admin/order?orderId=${ordersCompleted.id}"><i class="material-icons">mode_edit</i></a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="collapsible-header"><i class="material-icons">credit_card</i>PAYMENT</div>
                                    <div class="collapsible-body">
                                        <div class="card">

                                            <div class="card-content">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Date</th>
                                                            <th>Name</th>
                                                            <th>Phone</th>
                                                            <th>Price</th>
                                                            <th>Edit</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${ordersPayment}" var="ordersPayment">
                                                            <tr>
                                                                <td>${ordersPayment.id}</td>
                                                                <td>${ordersPayment.date}</td>
                                                                <td>${ordersPayment.customer.name}</td>
                                                                <td>${ordersPayment.customer.phone}</td>
                                                                <td>${ordersPayment.total}</td>
                                                                <td>
                                                                    <a href="admin/order?orderId=${ordersPayment.id}"><i class="material-icons">mode_edit</i></a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="collapsible-header"><i class="material-icons">done</i>CLOSED</div>
                                    <div class="collapsible-body">
                                        <div class="card">

                                            <div class="card-content">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Date</th>
                                                            <th>Name</th>
                                                            <th>Phone</th>
                                                            <th>Price</th>
                                                            <th>Edit</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${ordersClosed}" var="ordersClosed">
                                                            <tr>
                                                                <td>${ordersClosed.id}</td>
                                                                <td>${ordersClosed.date}</td>
                                                                <td>${ordersClosed.customer.name}</td>
                                                                <td>${ordersClosed.customer.phone}</td>
                                                                <td>${ordersClosed.total}</td>
                                                                <td>
                                                                    <a href="admin/order?orderId=${ordersClosed.id}"><i class="material-icons">mode_edit</i></a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <div class="collapsible-header"><i class="material-icons">not_interested</i>CANCELED</div>
                                    <div class="collapsible-body">
                                        <div class="card">

                                            <div class="card-content">
                                                <div class="table-responsive">
                                                    <table class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>Date</th>
                                                            <th>Name</th>
                                                            <th>Phone</th>
                                                            <th>Price</th>
                                                            <th>Edit</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:forEach items="${ordersCanceled}" var="ordersCanceled">
                                                            <tr>
                                                                <td>${ordersCanceled.id}</td>
                                                                <td>${ordersCanceled.date}</td>
                                                                <td>${ordersCanceled.customer.name}</td>
                                                                <td>${ordersCanceled.customer.phone}</td>
                                                                <td>${ordersCanceled.total}</td>
                                                                <td>
                                                                    <a href="admin/order?orderId=${ordersCanceled.id}"><i class="material-icons">mode_edit</i></a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>

                        </div>
                    </div>


<c:import url="../templ/footer-admin-part.jsp"/>
</body>

</html>
