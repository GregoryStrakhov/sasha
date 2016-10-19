<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<c:url value="/j_spring_security_check" var="loginUrl" />
<form action="${loginUrl}" method="post">
    <div style="text-align: center;"><h2 class="form-signin-heading">VetClient</h2></div>
    <input type="text" class="form-control" name="j_username" placeholder="Логин"><br>
    <input type="password" class="form-control" name="j_password" placeholder="Пароль"><br>
    <button class="btn btn-lg btn-danger btn-block" type="submit">Войти</button>
</form>

</div>
</body>
</html>
