<%@ page language="java" contentType="text/html;  charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css"/>


	<script src="resources/js/bootstrap.min.js"></script>

</head>
<title>Test</title>
<spring:url value="/" var="urlHome" />
<spring:url value="/students" var="listStudents" />
<spring:url value="/groups" var="listGroups" />

<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".js-navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${urlHome}" style="padding:15px 15px;">Test</a>
		</div>
		<div class="collapse navbar-collapse js-navbar">
			<ul class="nav navbar-nav">
				<li><a href="${listStudents}">Список студентов</a></li>
				<li><a href="${listGroups}">Список групп</a></li>
			</ul>
		</div>
	</div>
</nav>
</html>