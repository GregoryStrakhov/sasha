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
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css"/>
	<%--<link rel="stylesheet" href="${contextPath}/resources/css/bootstrap-theme.min.css"/>--%>
	<script src="resources/js/bootstrap.min.js"></script>
</head>
<title>VetClient</title>
<spring:url value="/" var="urlHome" />
<spring:url value="/user" var="listUsers" />


<nav class="navbar navbar-light bg-faded">
	<ul class="nav navbar-nav">
		<li class="nav-item active">
			<a class="nav-link" href="${listUsers}">Список пользователей <span class="sr-only">(current)</span></a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="#">Список задач</a>
		</li>
	</ul>
</nav>

</nav>
</html>