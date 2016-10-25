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
<spring:url value="/students" var="listStudents" />
<spring:url value="/groups" var="listGroups" />

<nav class="navbar navbar-light bg-faded">
	<ul class="nav navbar-nav">
		<li class="nav-item active">
			<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="#">Features</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="#">Pricing</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="#">About</a>
		</li>
	</ul>
</nav>

		<%--<div class="navbar-header">--%>
			<%--<button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".js-navbar">--%>
				<%--<span class="sr-only">Toggle navigation</span>--%>
				<%--<span class="icon-bar"></span>--%>
				<%--<span class="icon-bar"></span>--%>
				<%--<span class="icon-bar"></span>--%>
			<%--</button>--%>
			<%--<a class="navbar-brand" href="${urlHome}" style="padding:15px 15px;">Test</a>--%>
		<%--</div>--%>
		<%--<div class="collapse navbar-collapse js-navbar">--%>
			<%--<ul class="nav navbar-nav">--%>
				<%--<li><a href="${listStudents}">Список студентов</a></li>--%>
				<%--<li><a href="${listGroups}">Список групп</a></li>--%>
			<%--</ul>--%>
		<%--</div>--%>

</nav>
</html>