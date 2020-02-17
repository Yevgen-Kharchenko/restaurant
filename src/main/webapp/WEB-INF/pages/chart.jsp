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
        Charts
    </h1>
    <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li><a href="#">Charts</a></li>
        <li class="active">Data</li>
    </ol>

</div>
<div id="page-inner">

<div class="row">


    <div class="col-md-6 col-sm-12 col-xs-12">
        <div class="card">
            <div class="card-action">
                Bar Chart
            </div>
            <div class="card-content">
                <div id="morris-bar-chart"></div>
            </div>
        </div>
    </div>
    <div class="col-md-6 col-sm-12 col-xs-12">
        <div class="card">
            <div class="card-action">
                Area Chart
            </div>
            <div class="card-content">
                <div id="morris-area-chart"></div>
            </div>
        </div>
    </div>

</div>
<!-- /. ROW  -->
<div class="row">

    <div class="col-md-6 col-sm-12 col-xs-12">
        <div class="card">
            <div class="card-action">
                Line Chart
            </div>
            <div class="card-content">
                <div id="morris-line-chart"></div>
            </div>
        </div>
    </div>
    <div class="col-md-6 col-sm-12 col-xs-12">
        <div class="card">
            <div class="card-action">
                Donut Chart
            </div>
            <div class="card-content">
                <div id="morris-donut-chart"></div>
            </div>
        </div>
    </div>

</div>
<!-- /. ROW  -->

<c:import url="templ/footer-admin-part.jsp"/>
</body>

</html>
