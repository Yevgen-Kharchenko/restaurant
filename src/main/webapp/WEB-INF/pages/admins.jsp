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
<div class="container">
<div id="page-wrapper" >
<div class="header">
    <h1 class="page-header">
        Tables Page
    </h1>
    <ol class="breadcrumb">
        <li><a href="#">Home</a></li>
        <li><a href="#">Tables</a></li>
        <li class="active">Data</li>
    </ol>

</div>

<div id="page-inner">

<div class="row">
<div class="col-md-12">
<!-- Advanced Tables -->
<div class="card">
    <div class="card-action">
        Advanced Tables
    </div>
    <div class="card-content">
        <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                <thead>
                <tr>
                    <th># id</th>
                    <th>date</th>
                    <th>name</th>
                    <th>total</th>
                    <th>edit</th>
                    <th>del</th>
                </tr>
                </thead>
                <tbody>
                <tr class="even gradeA">
                    <td>1</td>
                    <td>20.01.2020</td>
                    <td>Ivan Petrov</td>
                    <td>20</td>
                    <td class="center">V</td>
                    <td class="center">X</td>
                </tr>
                <tr class="even gradeA">
                    <td>2</td>
                    <td>20.01.2020</td>
                    <td>Ivan Petrov</td>
                    <td >69.69</td>
                    <td class="center">V</td>
                    <td class="center">X</td>
                </tr>
                <tr class="even gradeA">
                    <td>3</td>
                    <td>20.01.2020</td>
                    <td>Ivan Petrov</td>
                    <td>155.5</td>
                    <td class="center">V</td>
                    <td class="center">X</td>
                </tr>
                <tr class="even gradeA">
                    <td>4</td>
                    <td>20.01.2020</td>
                    <td>Ivan Petrov</td>
                    <td>6</td>
                    <td class="center">V</td>
                    <td class="center">X</td>
                </tr>

                <tr class="even gradeA">
                    <td>4</td>
                    <td>20.01.2020</td>
                    <td>Ivan Petrov</td>
                    <td>58</td>
                    <td class="center">V</td>
                    <td class="center">X</td>
                </tr>

                </tbody>
            </table>
        </div>

    </div>
</div>
</div>
    <c:import url="templ/loader.jsp"/>
</body>
</html>