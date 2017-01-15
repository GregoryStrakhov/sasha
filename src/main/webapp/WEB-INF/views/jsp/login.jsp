<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css"/>
    <title>VetClient</title>
</head>
<body>
<div class="container" style="width: 300px;">
    <spring:url value="/user" var="loginUrl"/>
    <form action="${loginUrl}" method="post">
        <br>
        <div style="text-align: center;"><h2 class="form-signin-heading">Test</h2></div>
        <br>
        <button class="btn btn-lg btn-danger btn-block" onclick="location.href='${loginUrl}'">Войти</button>
    </form>
</div>
</body>
</html>
